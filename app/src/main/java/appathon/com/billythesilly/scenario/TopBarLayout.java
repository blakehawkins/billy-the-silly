package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import appathon.com.billythesilly.R;

/**
 * Created by kamen on 14-11-1.
 */
public class TopBarLayout extends LinearLayout {

    public TopBarLayout(Context context) {
        super(context);
        this.setBackgroundResource(R.drawable.sparkle_box);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
    }

    @Override
    public void removeView(View view) {
        super.removeView(view);
    }
}
