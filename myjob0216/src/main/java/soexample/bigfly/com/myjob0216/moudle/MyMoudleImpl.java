package soexample.bigfly.com.myjob0216.moudle;

import com.google.gson.Gson;

import java.util.Map;

import soexample.bigfly.com.myjob0216.callback.MyCallBack;
import soexample.bigfly.com.myjob0216.utils.RetrofitUtils;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   15:52<p>
 * <p>更改时间：2019/2/16   15:52<p>
 * <p>版本号：1<p>
 */

public class MyMoudleImpl implements MyMoudle {
    @Override
    public void startRequest(String url, Map<String, String> map, Class clazz, MyCallBack myCallBack) {
        RetrofitUtils.getInstance().get(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void success(Object data) {
                Gson gson = new Gson();
                Object o = gson.fromJson((String) data, clazz);
                myCallBack.setSuccess(o);
            }

            @Override
            public void error(Object error) {
                myCallBack.setError(error);
            }
        });
    }
}
