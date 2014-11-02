package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import appathon.com.billythesilly.R;

/**
 * Created by lisaxie on 02/11/2014.
 */
public class ReactionScenarioCookieActivity extends ReactionScenarioActivity {
private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_scenario_cookie);

    }

    protected void initializeTopBarMembers(Context cxt) {

    }

    protected void initializeTargets(Context cxt) {
    }

    protected void drawSprites(Context cxt) {
    }

    public void grade(View view) {
    }

    public void goDown(View v) {
        // Change Billy's stance
        ImageView billy = (ImageView) findViewById(R.id.BillyHangingCookie);
        billy.setImageResource(R.drawable.billy_sitting);

        // Show Draggable Areas
        View background = findViewById(R.id.cookieScenario);
        background.setBackgroundResource(R.drawable.billycookiesparkles);
        if (count == 0) {

        }

    }

    public void take(View v) {
        // give Billy cookies
        ImageView billy = (ImageView) findViewById(R.id.BillyHangingCookie);
        ImageView cookies = (ImageView) findViewById(R.id.MovableCookies);
        cookies.setImageResource(android.R.color.transparent);
        billy.setImageResource(R.drawable.billy_hanging_flipped_cookies);

        // Unshow Draggable Areas
        View background = findViewById(R.id.cookieScenario);
        background.setBackgroundResource(R.drawable.billycookie);
    }
}
