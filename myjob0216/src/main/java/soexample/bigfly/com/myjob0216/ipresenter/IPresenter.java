package soexample.bigfly.com.myjob0216.ipresenter;

import java.util.Map;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   16:09<p>
 * <p>更改时间：2019/2/16   16:09<p>
 * <p>版本号：1<p>
 */

public interface IPresenter {
    void startRequest(String url, Map<String, String> map, Class clazz);
}
