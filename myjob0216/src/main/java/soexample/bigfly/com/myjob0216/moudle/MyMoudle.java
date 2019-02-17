package soexample.bigfly.com.myjob0216.moudle;

import java.util.Map;

import soexample.bigfly.com.myjob0216.callback.MyCallBack;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   12:04<p>
 * <p>更改时间：2019/2/16   12:04<p>
 * <p>版本号：1<p>
 */

public interface MyMoudle {
    void startRequest(String url, Map<String, String> map, Class clazz, MyCallBack myCallBack);

}
