package appathon.com.billythesilly.scenario;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    public int grade(View view) {
        return 0;
    }

    public void goDown(View v) {
        // Change Billy's stance
        ImageView billy = (ImageView) findViewById(R.id.BillyHangingCookie);
        billy.setImageResource(R.drawable.billy_sitting);
        billy.setOnTouchListener(new MyTouchListener());
        // Show Draggable Areas
        View background = findViewById(R.id.cookieScenario);
        background.setBackgroundResource(R.drawable.billycookiesparkles);
        if (count == 0) {
            count+=1;
        }
        ImageView rightArea = (ImageView) findViewById(R.id.ChairArea);
        ImageView wrongArea = (ImageView) findViewById(R.id.TableArea);
        rightArea.setOnDragListener(new MyDragListener());
        wrongArea.setOnDragListener(new MyDragListener());
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
        if (count == 1) {
            count-=1;
        }
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View v, MotionEvent motionEvent) {
            if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    private final class MyDragListener implements View.OnDragListener {
        Drawable finalShape = getResources().getDrawable(R.drawable.billy_sitting);
        Drawable standardShape = getResources().getDrawable(R.drawable.sparkle_box);

        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackground(standardShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackground(standardShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    RelativeLayout container = (RelativeLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackground(finalShape);
                default:
                    break;
            }
            return true;
        }
    }
}

