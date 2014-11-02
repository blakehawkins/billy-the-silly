package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import appathon.com.billythesilly.R;

/* There are two types of games: React and Classify. Reaction games are the games which present
    a scenario and the user must select actions and subjects in a valid order to score points.
    Classification games are the ones where the user is given a scenario with actions happening,
    and the player identifies good and bad things.

    Cross Street is a Reaction game. We present the user with a road and a goal to cross the
    street. Only by looking left and right before crossing will a star be awarded.
 */
public class ScenarioCrossStreetActivity extends ReactionScenarioActivity implements View
        .OnClickListener {
    private OptionView _selectedView;

    protected void drawSprites(Context cxt) {
        RelativeLayout spriteRegion = (RelativeLayout) findViewById(R.id.spriteRegion);

        // street
        ImageView street = new ImageView(this);
        street.setImageResource(R.drawable.street);
        street.setPadding(120, 120, 0, 0);
        spriteRegion.addView(street);

        // billy
        ImageView billy = new ImageView(this);
        billy.setImageResource(R.drawable.billy);
        billy.setScaleX(0.5f);
        billy.setScaleY(0.5f);
        billy.setPadding(290, 300, 0, 0);
        spriteRegion.addView(billy);
    }

    protected void initializeTopBarMembers(Context context) {
        // get the top bar
        LinearLayout topBarLayout = (LinearLayout) findViewById(R.id.optionLayout);

        // apply the click listener for the top bar
        topBarLayout.setOnClickListener(this);

        // build actions
        TopBarAction[] options = {new TopBarAction(true, 0, null, "Look"),
                new TopBarAction(true,
                        0, null, "Walk"), new TopBarAction(true, 0, null, "Run")};

        // put them in the top bar
        for (TopBarAction opt : options) {
            final OptionView optionView = new OptionView(context, opt);
            optionView.unselect();
            optionView.setText(opt.getText());
            optionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OptionView optionView = (OptionView) view;
                    if (_selectedView != null) {
                        _selectedView.unselect();
                    }
                    if (_selectedView == view) {
                        _selectedView = null;
                        return;
                    }
                    optionView.select();
                    _selectedView = optionView;
                }
            });
            topBarLayout.addView(optionView);
        }
    }

    protected void initializeTargets(Context cxt) {
        RelativeLayout spriteRegion = (RelativeLayout) findViewById(R.id.spriteRegion);

        // Left side of Road
        ImageView sparkleLeft = new ImageView(this);
        sparkleLeft.setImageResource(R.drawable.sparkle_box);
        sparkleLeft.setPadding(60, 175, 0, 0);
        spriteRegion.addView(sparkleLeft);

        // Right side of Road
        ImageView sparkleRight = new ImageView(this);
        sparkleRight.setImageResource(R.drawable.sparkle_box);
        sparkleRight.setPadding(550, 175, 0, 0);
        spriteRegion.addView(sparkleRight);

        // Across the Road
        ImageView sparkleAcross = new ImageView(this);
        sparkleAcross.setImageResource(R.drawable.sparkle_box);
        sparkleAcross.setPadding(290, 65, 0, 0);
        spriteRegion.addView(sparkleAcross);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);

        Context context = getBaseContext();
        initializeTopBarMembers(context);
        drawSprites(context);
        initializeTargets(context);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void grade(View view) {
        int stars = 0;
        Log.e("ScenarioCrossStreetActivity", Integer.toString(stars));
    }

    @Override
    public void onClick(View view) {
        try {
            TopBarLayout topBarLayout = (TopBarLayout) view;
            if (_selectedView == null) {
                return;
            }

            ((ViewGroup) _selectedView.getParent()).removeView(_selectedView);

            if (topBarLayout != null) {
                topBarLayout.addView(_selectedView);
            }
            _selectedView.unselect();
            _selectedView = null;
        } catch (ClassCastException e) {
        }
    }
}
