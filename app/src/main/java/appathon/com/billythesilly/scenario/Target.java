package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import appathon.com.billythesilly.R;

/**
 * Created by Blake on 11/2/2014.
 */
public class Target extends RelativeLayout {
    int px, py;
    ImageView sparkle;

    public Target(Context cxt) {
        super(cxt);
    }

    public Target(Context cxt, RelativeLayout spriteRegion, int px, int py){
        super(cxt);
        this.px = px;
        this.py = py;



        sparkle = new ImageView(cxt);
        sparkle.setImageResource(R.drawable.sparkle_box);
        sparkle.setPadding(px, py, 0, 0);
        spriteRegion.addView(sparkle);
    }
}
