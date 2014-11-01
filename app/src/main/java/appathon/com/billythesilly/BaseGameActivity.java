package appathon.com.billythesilly;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class BaseGameActivity extends Activity {

    private BaseGame _baseGame;
    private OptionView _selectedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_game);

        Context context = getBaseContext();

        Option[] options = {new Option("A", null, true), new Option("B", null, false), new Option("C", null, true)};
        Slot[] slots = {new Slot(0, true, true), new Slot(1, false, true), new Slot(2, true, true), new Slot(3, false, true)};

        _baseGame = new BaseGame(options, slots);

        // For layout params
        LinearLayout temp = (LinearLayout) findViewById(R.id.buttonLayout);

        final LinearLayout slotLayout = (LinearLayout) findViewById(R.id.slotLayout);

        SlotLayout optionLayout = new SlotLayout(context, new Slot(-1, false, false));
        optionLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        optionLayout.setBackgroundColor(Color.BLUE);
        ((ViewGroup)temp.getParent()).addView(optionLayout);
        ((ViewGroup)temp.getParent()).removeView(temp);

        for (int i = 0; i < options.length; ++i) {
            final OptionView optionView = new OptionView(context, options[i]);
            optionView.unselect();
            optionView.setText(options[i].getOption());
            optionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OptionView optionView = (OptionView)view;
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

        optionLayout.setMinimumHeight(tempHeight);
        optionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlotLayout slotLayout = (SlotLayout)view;
                if(_selectedView == null) {
                    return;
                }
                ((ViewGroup)_selectedView.getParent()).removeView(_selectedView);
                slotLayout.addView(_selectedView);
                _selectedView.unselect();
                _selectedView = null;
            }
        });

        for (int i = 0; i < slots.length; ++i) {
            SlotLayout slot = new SlotLayout(context, slots[i]);
            slot.setLayoutParams(new ViewGroup.LayoutParams(tempWidth, tempHeight));
            slot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SlotLayout slotLayout = (SlotLayout)view;
                    if(_selectedView == null || (slotLayout.getChildCount() > 0 && slotLayout.getSlot().getIsSingleSpace())) {
                        return;
                    }
                    ((ViewGroup)_selectedView.getParent()).removeView(_selectedView);
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
        _baseGame.end();
        super.onDestroy();
    }

    // Places a view into the top bar implemented with Linear Layout
    private void placeViewOnBar(OptionView view, SlotLayout slot) {

    }

    public void Grade(View view) {
        Log.e("", "" + _baseGame.grade());
    }
}
