package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import appathon.com.billythesilly.R;

/* A target is one of the gold shiny things which you apply actions to */
public class Target extends RelativeLayout implements Button.OnClickListener {
    private int px, py;
    private RelativeLayout overlay;
    private Context cxt;
    private RelativeLayout spriteRegion;
    private ScenarioActivity owner;
    private int lamport = 0;
    private int tag;

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

        RelativeLayout sparkle = new RelativeLayout(cxt);
        ImageView sp = new ImageView(cxt);
        sp.setImageResource(R.drawable.sparkle_box);
        sparkle.addView(sp);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout
                .LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.setMargins(px, py, 0, 0);
        sparkle.setLayoutParams(lp);
        spriteRegion.addView(sparkle);

        sp.setOnClickListener(this);
    }

    public void setOverlay(int drawableId) {
        if (overlay != null) {
            spriteRegion.removeView(overlay);
        }
        overlay = new RelativeLayout(cxt);
        Button ol = new Button(cxt);
        ol.setBackgroundResource(drawableId);
        ol.setText(owner.getSelectedView().getText());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout
                .LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(px, py, 0, 0);
        spriteRegion.addView(overlay);
        overlay.setLayoutParams(lp);
        overlay.addView(ol);

        ol.setOnClickListener(this);
    }

    public void setLamport(int q) {
        lamport = q;
    }

    public int getLamport() {
        return lamport;
    }

    public void setMapTag(int q) {
        tag = q;
    }

    public int getMapTag() {
        return tag;
    }

    @Override
    public void onClick(View v) {
        if (owner.getSelectedView() != null) {
            setOverlay(R.drawable.rounded_button);
            owner.associate(owner.getSelectedView(), this);
            owner.getSelectedView().deselect();
            owner.setSelectedView(null);
        }
    }
}
