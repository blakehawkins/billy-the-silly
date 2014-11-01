package appathon.com.billythesilly;

import android.util.Log;

/**
 * Created by kamen on 14-11-1.
 */

public class BaseGame {
    private Option[] _options;
    private Slot[] _slots;

    public BaseGame(Option[] options, Slot[] slots) {
        _options = options;
        _slots = slots;
    }

    public int grade() {
        int stars = 0;
        for (int i = 0; i < _slots.length; ++i) {
            Option[] options = _slots[i].getOptions();
            for (int j = 0; j < options.length; ++j) {
                if (options[j] != null && _slots[i].getCorrect() == options[j].getCorrect()) {
                    ++stars;
                }
            }
        }
        return stars;
    }

    public int end() {
        return 0;
    }
}
