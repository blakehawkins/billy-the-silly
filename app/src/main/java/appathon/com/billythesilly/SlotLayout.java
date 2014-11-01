package appathon.com.billythesilly;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by kamen on 14-11-1.
 */
public class SlotLayout extends LinearLayout {

    private Slot _slot;

    public SlotLayout(Context context, Slot slot) {
        super(context);
        this.setBackgroundResource(R.drawable.sparkle_box);
        _slot = slot;
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        _slot.addOption(((OptionView)child).getOption());
    }

    @Override
    public void removeView(View view) {
        super.removeView(view);
        _slot.removeOption(((OptionView)view).getOption());
    }

    public Slot getSlot() {
        return _slot;
    }
}
