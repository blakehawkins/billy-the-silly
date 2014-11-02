package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by kamen on 14-11-1.
 */
public class OptionView extends Button {
    private TopBarMember _option;

    public OptionView(Context context, TopBarMember option) {
        super(context);
        _option = option;
    }

    public OptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TopBarMember getOption() {
        return _option;
    }

    public void unselect() {
        this.setBackgroundColor(Color.BLACK);
        this.setTextColor(Color.WHITE);
    }

    public void select() {
        this.setBackgroundColor(Color.WHITE);
        this.setTextColor(Color.BLACK);
    }
}
