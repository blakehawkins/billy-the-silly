package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
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
public class ScenarioCrossStreetActivity extends ReactionScenarioActivity {
    private OptionView _selectedView;

    protected void drawSprites(Context cxt){
        AbsoluteLayout spriteRegion = (AbsoluteLayout) findViewById(R.id.spriteRegion);
        ImageView street = new ImageView(this);
        street.setImageResource(R.drawable.street);
        spriteRegion.addView(street);
    }

    protected void initializeTopBarMembers(Context context) {
        // get the top bar
        LinearLayout topBarLayout = (LinearLayout) findViewById(R.id.optionLayout);

        // apply the click listener for the top bar
        topBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopBarLayout topBarLayout = (TopBarLayout) view;
                if (_selectedView == null) {
                    return;
                }
                ((ViewGroup) _selectedView.getParent()).removeView(_selectedView);
                topBarLayout.addView(_selectedView);
                _selectedView.unselect();
                _selectedView = null;
            }
        });

        // build actions
        TopBarAction[] options = {new TopBarAction(true, 0, null, "Look"), new TopBarAction(true,
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

    protected void initializeTargets(Context cxt){
        // TODO add targets using parent
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);

        Context context = getBaseContext();
        initializeTopBarMembers(context);
        initializeTargets(context);

        drawSprites(context);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void grade(View view) {
        int stars = 0;
        Log.e("ScenarioCrossStreetActivity", Integer.toString(stars));
    }
}
