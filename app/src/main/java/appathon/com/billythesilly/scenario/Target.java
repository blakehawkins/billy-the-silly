package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import appathon.com.billythesilly.R;

/**
 * Created by Blake on 11/2/2014.
 */
public class Target extends RelativeLayout implements Button.OnClickListener {
    int px, py;
    RelativeLayout sparkle;
    RelativeLayout overlay;
    Context cxt;
    RelativeLayout spriteRegion;
    ScenarioActivity owner;

    public Target(Context cxt) {
        super(cxt);
    }

    public Target(Context cxt, ScenarioActivity owner, RelativeLayout spriteRegion, int px,
                  int py) {
        super(cxt);
        this.spriteRegion = spriteRegion;
        this.cxt = cxt;
        this.px = px;
        this.py = py;
        this.owner = owner;

        sparkle = new RelativeLayout(cxt);
        ImageView sp = new ImageView(cxt);
        sp.setImageResource(R.drawable.sparkle_box);
        //sparkle.setPadding(px, py, 0, 0);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(100, 100);
        lp.setMargins(px, py, 0, 0);
        sparkle.setLayoutParams(lp);
        spriteRegion.addView(sparkle);

        sparkle.setOnClickListener(this);
    }

    public void setOverlay(int drawableId) {
        if (overlay != null) {
            spriteRegion.removeView(overlay);
        }
        overlay = new RelativeLayout(cxt);
        ImageView ol = new ImageView(cxt);
        ol.setImageResource(drawableId);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ol.getWidth(),
                ol.getHeight());
        lp.setMargins(px, py, 0, 0);
        overlay.setLayoutParams(lp);
        overlay.addView(ol);
        //overlay.setPadding(px, py, 0, 0);
        spriteRegion.addView(overlay);
    }

    @Override
    public void onClick(View v) {
        Log.d("ScenarioCrossStreetActivity", "Click!");
        if (owner.getSelectedView() != null) {
            setOverlay(R.drawable.rounded_button);
            owner.associate(owner.getSelectedView(), this);
            owner.getSelectedView().deselect();
            owner.setSelectedView(null);
            return;
        }

    }
}
