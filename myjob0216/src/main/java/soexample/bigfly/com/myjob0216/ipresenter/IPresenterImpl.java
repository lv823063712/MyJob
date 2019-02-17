package soexample.bigfly.com.myjob0216.ipresenter;

import java.util.Map;

import soexample.bigfly.com.myjob0216.callback.MyCallBack;
import soexample.bigfly.com.myjob0216.iview.IView;
import soexample.bigfly.com.myjob0216.moudle.MyMoudleImpl;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   16:10<p>
 * <p>更改时间：2019/2/16   16:10<p>
 * <p>版本号：1<p>
 */

public class IPresenterImpl implements IPresenter {
    private IView iView;
    private MyMoudleImpl myMoudle;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        myMoudle = new MyMoudleImpl();
    }

    @Override
    public void startRequest(String url, Map<String, String> map, Class clazz) {
        myMoudle.startRequest(url, map, clazz, new MyCallBack() {
            @Override
            public void setSuccess(Object data) {
                iView.success(data);
            }

            @Override
            public void setError(Object error) {
                iView.error(error);
            }
        });
    }

    //防止内存泄漏
    public void onDetch() {
        if (iView != null) {
            iView = null;
        }
        if (myMoudle != null) {
            myMoudle = null;
        }
    }
}
