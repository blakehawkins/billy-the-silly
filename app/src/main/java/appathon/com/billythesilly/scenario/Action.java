package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Blake on 11/1/2014.
 */
abstract public class Action {
    protected String description = null;
    protected Drawable icon = null;

    public View getView(Context cxt){
        RelativeLayout rl = new RelativeLayout(cxt);
        if(description!=null){
            TextView tv = new TextView(cxt);
            rl.addView(tv);
        }
        if(icon!=null){
            ImageView iv = new ImageView(cxt);
            rl.addView(iv);
        }
        return rl;
    }
}
