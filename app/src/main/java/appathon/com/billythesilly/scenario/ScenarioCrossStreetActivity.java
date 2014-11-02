package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);

        Context context = getBaseContext();
        Option[] options = {new Option("A", true), new Option("B", false),
                new Option("C", true)};

        Slot[] slots = {new Slot(0, true, true), new Slot(1, false, true), new Slot(2, true,
                true), new Slot(3, false, true)};

        // For layout params
        LinearLayout temp = (LinearLayout) findViewById(R.id.optionLayout);
        SlotLayout optionLayout = new SlotLayout(context, new Slot(-1, false, false));
        optionLayout.setLayoutParams(temp.getLayoutParams());
        optionLayout.setMinimumHeight(70);
        ((ViewGroup) temp.getParent()).addView(optionLayout);
        ((ViewGroup) temp.getParent()).removeView(temp);

        LinearLayout slotLayout = new LinearLayout(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        slotLayout.setLayoutParams(lp);
        slotLayout.setWeightSum(0.0f);
        slotLayout.setOrientation(LinearLayout.HORIZONTAL);

        for (Option opt : options) {
            final OptionView optionView = new OptionView(context, opt);
            optionView.unselect();
            optionView.setText(opt.getOption());
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
            optionLayout.addView(optionView);
        }

        View optionView = optionLayout.getChildAt(0);
        optionView.measure(0, 0);
        int tempWidth = optionView.getMeasuredWidth();
        int tempHeight = optionView.getMeasuredHeight();

        optionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlotLayout slotLayout = (SlotLayout) view;
                if (_selectedView == null) {
                    return;
                }
                ((ViewGroup) _selectedView.getParent()).removeView(_selectedView);
                slotLayout.addView(_selectedView);
                _selectedView.unselect();
                _selectedView = null;
            }
        });

        for (Slot sl : slots) {
            SlotLayout slot = new SlotLayout(context, sl);
            slot.setLayoutParams(new ViewGroup.LayoutParams(tempWidth, tempHeight));
            slot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SlotLayout slotLayout = (SlotLayout) view;
                    if (_selectedView == null || (slotLayout.getChildCount() > 0 && slotLayout
                            .getSlot().getIsSingleSpace())) {
                        return;
                    }
                    ((ViewGroup) _selectedView.getParent()).removeView(_selectedView);
                    slotLayout.addView(_selectedView);
                    _selectedView.unselect();
                    _selectedView = null;
                }
            });
            slotLayout.addView(slot);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // TODO: Place a slot view in the top bar
//    private void placeViewOnBar(OptionView view, SlotLayout slot) {
//
//    }

    public void grade(View view) {
        int stars = 0;
        Log.e("ScenarioCrossStreetActivity", Integer.toString(stars));
    }
}
