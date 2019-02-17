package soexample.bigfly.com.myjob0216.applica;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/12   19:51<p>
 * <p>更改时间：2019/2/12   19:51<p>
 * <p>版本号：1<p>
 */

public class MyAppLi extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
