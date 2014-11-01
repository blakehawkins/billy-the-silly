package appathon.com.billythesilly;

import android.content.Context;
import android.graphics.Color;
import android.widget.RadioButton;

/**
 * Created by kamen on 14-11-1.
 */
public class StanceRadioButton extends RadioButton {

    private Stance _stance;

    public StanceRadioButton(Context context, Stance stance) {
        super(context);
        _stance = stance;
        this.setText(_stance.getName());
    }

    public Stance getStance() {
        return _stance;
    }
}
