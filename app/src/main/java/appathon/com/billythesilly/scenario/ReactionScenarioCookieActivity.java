package appathon.com.billythesilly.scenario;

import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import appathon.com.billythesilly.R;

/**
 * Created by lisaxie on 02/11/2014.
 */
abstract public class ReactionScenarioCookieActivity extends ReactionScenarioActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_scenario_cookie);

    }

    public void goDown(View v) {
        // Change Billy's stance
    }

    public void take(View v) {
        // give Billy cookies
        ImageView billy = (ImageView) findViewById(R.id.BillyHangingCookie);
        ImageView cookies = (ImageView) findViewById(R.id.MovableCookies);
        cookies.setImageResource(android.R.color.transparent);
        billy.setImageResource(R.drawable.billycookie);

    }
}
