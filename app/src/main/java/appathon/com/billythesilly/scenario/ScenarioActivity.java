package appathon.com.billythesilly.scenario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

import appathon.com.billythesilly.R;

/* There are two types of games: React and Classify. Reaction games are the games which present
    a scenario and the user must select actions and subjects in a valid order to score points.
    Classification games are the ones where the user is given a scenario with actions happening,
    and the player identifies good and bad things.
 */
abstract public class ScenarioActivity extends Activity {
    private ArrayList<Target> targets;
    private HashMap<Target, TopBarAction> associations = new HashMap<Target, TopBarAction>();
    private TopBarAction _selectedView;
    private int lamport = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);

        LinearLayout slotLayout = new LinearLayout(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        slotLayout.setLayoutParams(lp);
        slotLayout.setWeightSum(0.0f);
        slotLayout.setOrientation(LinearLayout.HORIZONTAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void addTarget(Target t) {
        targets.add(t);
    }

    abstract protected void initializeTopBarMembers(Context cxt);

    abstract protected void initializeTargets(Context cxt);

    abstract protected void drawSprites(Context cxt);

    abstract public void grade(View view);

    protected void associate(TopBarAction tba, Target t) {
        lamport++;
        t.setLamport(lamport);
        Log.v("ScenarioActivity", "Associating. Lamport: " + String.valueOf(t.getLamport()));
        associations.put(t, tba);
    }

    protected HashMap<Target, TopBarAction> getAssociations() {
        return associations;
    }

    protected TopBarAction getSelectedView() {
        return _selectedView;
    }

    protected void setSelectedView(TopBarAction tba) {
        _selectedView = tba;
    }
}
