package appathon.com.billythesilly.scenario;

import android.graphics.drawable.Drawable;

/**
 * Created by Blake on 11/2/2014.
 */
public class TopBarAction extends TopBarMember {
    private boolean useTarget;
    private int maxUses;
    private Drawable icon = null;
    private String text = "";

    public TopBarAction(boolean useTarget, int maxUses, Drawable icon, String text) {
        this.useTarget = useTarget;
        this.maxUses = maxUses;
        this.icon = icon;
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
