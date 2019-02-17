package soexample.bigfly.com.myjob0216;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.sunfusheng.marqueeview.MarqueeView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import soexample.bigfly.com.myjob0216.adapter.MyAdapter;
import soexample.bigfly.com.myjob0216.api.Contents;
import soexample.bigfly.com.myjob0216.data.CommodityListBean;
import soexample.bigfly.com.myjob0216.data.MyBannerData;
import soexample.bigfly.com.myjob0216.data.MyContentData;
import soexample.bigfly.com.myjob0216.ipresenter.IPresenterImpl;
import soexample.bigfly.com.myjob0216.iview.IView;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.SYS)
    ImageView SYS;
    @BindView(R.id.MyBanner)
    XBanner MyBanner;
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    @BindView(R.id.MyRecy)
    RecyclerView MyRecy;
    List<String> info = new ArrayList<>();
    private IPresenterImpl iPresenter;
    private Map<String, String> map = new HashMap<>();
    private ArrayList<String> bannerurl = new ArrayList<>();
    //private ArrayList<MyContentData.ResultBean> myData = new ArrayList<>();
    private ArrayList<CommodityListBean> datas = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        MyRecy.setLayoutManager(manager);
        iPresenter = new IPresenterImpl(this);
        iPresenter.startRequest(Contents.BANNER_URL, map, MyBannerData.class);
        iPresenter.startRequest(Contents.COMMODITY_URL, map, MyContentData.class);
        MyRecy.setNestedScrollingEnabled(true);
        List<String> info = new ArrayList<>();
        info.add("八维商城,喜迎双十一");
        info.add("年终大促销,买到即赚到");
        info.add("两块钱,你买不了吃亏");
        info.add("两块钱,你买不了上当");
        info.add("两块钱,你啥都买不了");
        info.add("你个穷逼");
        marqueeView.startWithList(info);
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);

    }

    @Override
    public void success(Object data) {
        if (data instanceof MyBannerData) {
            MyBannerData bannerData = (MyBannerData) data;
            if (bannerData == null) {
                Toast.makeText(this, bannerData.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < bannerData.getResult().size(); i++) {
                    bannerurl.add(bannerData.getResult().get(i).getImageUrl());

                }
                MyBanner.setData(bannerurl, null);
                MyBanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(MainActivity.this).load(bannerurl.get(position)).into((ImageView) view);
                    }
                });
                //横向移动
                MyBanner.setPageTransformer(Transformer.Default);
            }
        } else if (data instanceof MyContentData) {
            MyContentData myContentData = (MyContentData) data;
            List<CommodityListBean> rxxp = myContentData.getResult().getRxxp().get(0).getCommodityList();
            List<CommodityListBean> mlss = myContentData.getResult().getMlss().get(0).getCommodityList();
            List<CommodityListBean> pzsh = myContentData.getResult().getPzsh().get(0).getCommodityList();
            datas.addAll(rxxp);
            datas.addAll(mlss);
            datas.addAll(pzsh);
            myAdapter = new MyAdapter(datas, this);
            MyRecy.setAdapter(myAdapter);

        }
    }

    @Override
    public void error(Object error) {
        Log.d("zzs", error + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyBanner.stopAutoPlay();
    }

    @OnClick(R.id.SYS)
    public void onViewClicked() {
        ZXingLibrary.initDisplayOpinion(this);
         startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            //处理扫描结果(在界面上显示)
            if (data != null) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}
