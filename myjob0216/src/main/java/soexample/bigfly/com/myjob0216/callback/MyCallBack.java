package soexample.bigfly.com.myjob0216.callback;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   12:01<p>
 * <p>更改时间：2019/2/16   12:01<p>
 * <p>版本号：1<p>
 */

public interface MyCallBack<T> {
    void setSuccess(T data);

    void setError(T error);
}
