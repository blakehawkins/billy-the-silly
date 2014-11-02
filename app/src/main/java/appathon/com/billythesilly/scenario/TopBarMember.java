package appathon.com.billythesilly.scenario;

/* Created by kamen on 14-11-1. */

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

abstract public class TopBarMember extends Button {
    TopBarMember(Context cxt) {
        super(cxt);
        LinearLayout.LayoutParams lm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                .WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lm.setMargins(0, 0, 10, 0);
        setLayoutParams(lm);
    }
}
