package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Map;
import java.util.TreeMap;

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
    private static final int MAP_TAG_LEFT = 1;
    private static final int MAP_TAG_RIGHT = 2;
    private static final int MAP_TAG_TOP = 3;

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

        // build actions
        TopBarAction[] options = {
                new LookAction(context, 0),
                new WalkAction(context, 0),
                new RunAction(context, 0)};

        // put them in the top bar
        for (TopBarAction opt : options) {

            // listen to clicks
            opt.setOnClickListener(this);

            // add to top bar
            topBarLayout.addView(opt);
        }
    }

    protected void initializeTargets(Context cxt) {
        RelativeLayout spriteRegion = (RelativeLayout) findViewById(R.id.spriteRegion);

        // left
        Target t = new Target(cxt, this, spriteRegion, 60, 175);
        t.setMapTag(MAP_TAG_LEFT);

        // right
        t = new Target(cxt, this, spriteRegion, 550, 175);
        t.setMapTag(MAP_TAG_RIGHT);

        // top
        t = new Target(cxt, this, spriteRegion, 295, 65);
        t.setMapTag(MAP_TAG_TOP);
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

    public int grade(View view) {

        // don't document this.
        TreeMap<Integer, Map.Entry<Target, TopBarAction>> sorter = new TreeMap<Integer,
                Map.Entry<Target, TopBarAction>>();
        for (Map.Entry<Target, TopBarAction> cursor : getAssociations().entrySet()) {
            sorter.put(cursor.getKey().getLamport(), cursor);
        }
        // just kidding, that sorts the pairs by lamport value

        int bits = 0; //0b00
        // parse the sorted types to check for success
        for (int i : sorter.keySet()) {
            Map.Entry<Target, TopBarAction> entry = sorter.get(i);
            switch (entry.getKey().getMapTag()) {
                case MAP_TAG_LEFT:
                    if(!(entry.getValue() instanceof LookAction)){
                        Log.v("ScenarioCrossStreetActivity", "You failed!");
                        goToResults(false);
                        return 0;
                    }
                    bits |= 1;
                    break;

                case MAP_TAG_RIGHT:
                    if(!(entry.getValue() instanceof LookAction)){
                        Log.v("ScenarioCrossStreetActivity", "You failed!");
                        goToResults(false);
                        return 0;
                    }
                    bits |= 2;
                    break;

                case MAP_TAG_TOP:
                    if(!(entry.getValue() instanceof WalkAction) || bits < 3){
                        Log.v("ScenarioCrossStreetActivity", "You failed!");
                        goToResults(false);
                        return 0;
                    }
                    Log.v("ScenarioCrossStreetActivity", "Success!");
                    goToResults(true);
                    break;

                default:
                    Log.e("ScenarioCrossStreetActivity", "Err! Unrecognized tag");
                    goToResults(false);
                    break;
            }
        }
        return 0;
    }

    public void goToResults(boolean n){
        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
        intent.putExtra("Key1",n);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        TopBarAction topBarAction = (TopBarAction) view;

        if (getSelectedView() != null) {
            getSelectedView().deselect();
        }

        if (topBarAction.useTarget()) {
            if (getSelectedView() == view) {
                setSelectedView(null);
                return;
            }
            topBarAction.select();
            setSelectedView(topBarAction);
        }
    }
}
