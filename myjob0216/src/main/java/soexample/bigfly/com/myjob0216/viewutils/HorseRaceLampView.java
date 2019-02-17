package soexample.bigfly.com.myjob0216.viewutils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   17:34<p>
 * <p>更改时间：2019/2/16   17:34<p>
 * <p>版本号：1<p>
 */

public class HorseRaceLampView extends AppCompatTextView {
    public HorseRaceLampView(Context context) {
        super(context);
    }

    public HorseRaceLampView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorseRaceLampView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 当前控件的焦点,第一次xml加载 的情况
     * */

    @Override
    public boolean isFocused() {
        return true;
    }
    /**
     * 在更改焦点时,有别的控件申请焦点的情况下
     * */

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if(focused){
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }

    /**
     * 弹出对话框的情况下
     * */

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if(hasWindowFocus){
            super.onWindowFocusChanged(hasWindowFocus);
        }
    }

}
