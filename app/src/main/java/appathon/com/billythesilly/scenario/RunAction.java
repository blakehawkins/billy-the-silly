package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by Blake on 11/1/2014.
 */
public class RunAction extends TopBarAction {
    private static final String DESCRIPTION = "Run";
    private static final Drawable ICON = null;
    private static final boolean USES_TARGET = true;

    public RunAction(Context cxt, int maxUses){
        super(cxt, USES_TARGET, maxUses, ICON, DESCRIPTION);
    }

    public String getType(){
        return "RunAction";
    }
}
