package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Blake on 11/1/2014.
 */
abstract public class ReactionScenarioActivity extends ScenarioActivity {
    abstract public int grade(View v);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract protected void initializeTopBarMembers(Context cxt);

    abstract protected void initializeTargets(Context cxt);

    abstract protected void drawSprites(Context cxt);
}
