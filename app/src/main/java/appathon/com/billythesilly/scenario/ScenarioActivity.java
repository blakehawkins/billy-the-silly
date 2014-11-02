package appathon.com.billythesilly.scenario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import appathon.com.billythesilly.R;

/* There are two types of games: React and Classify. Reaction games are the games which present
    a scenario and the user must select actions and subjects in a valid order to score points.
    Classification games are the ones where the user is given a scenario with actions happening,
    and the player identifies good and bad things.
 */
abstract public class ScenarioActivity extends Activity {
    private ArrayList<Target> targets;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void addTarget(Target t) {
        targets.add(t);
    }

    abstract protected void initializeTopBarMembers(Context cxt);

    abstract public void grade(View view);
}
