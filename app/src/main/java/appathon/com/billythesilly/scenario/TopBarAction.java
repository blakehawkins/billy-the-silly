package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import appathon.com.billythesilly.R;

/**
 * Created by kamen on 14-11-1.
 */
public class TopBarAction extends TopBarMember {
    boolean useTarget;
    int maxUses;
    Drawable icon;
    String text;

    /* unused constructor for android utilities */
    public TopBarAction(Context context) {
        super(context);
    }

    public TopBarAction(Context cxt, boolean useTarget, int maxUses, Drawable icon, String text) {
        super(cxt);
        this.useTarget = useTarget;
        this.maxUses = maxUses;
        this.icon = icon;
        this.text = text;
        setText(text);
    }

    public void deselect() {
        this.setBackgroundResource(R.drawable.rounded_button);
        this.setTextColor(Color.WHITE);
        this.setPadding(1, 0, 0, 0);
    }

    public void select() {
        this.setBackgroundColor(Color.WHITE);
        this.setTextColor(Color.BLACK);
    }
}
