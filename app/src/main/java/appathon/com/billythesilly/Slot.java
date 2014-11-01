package appathon.com.billythesilly;

import android.util.Log;

/**
 * Created by kamen on 14-11-1.
 */
public class Slot {
    private int _id;
    private boolean _correct;
    private boolean _isSingleSpace;
    private Option[] _options;
    private int N;

    public Slot(int id, boolean correct, boolean isSingleSpace) {
        N = 0;
        _id = id;
        _correct = correct;
        _isSingleSpace = isSingleSpace;
        if(_isSingleSpace) {
            _options = new Option[1];
        } else {
            _options = new Option[256];
        }
    }

    public void addOption(Option option) {
        _options[N++] = option;
    }

    public void removeOption(Option option) {
        for (int i = 0; i < N; i++) {
            if (option == _options[i]) {
                _options[i] = _options[--N];
                _options[N] = null;
                return;
            }
        }
    }

    public int getId() {
        return _id;
    }

    public boolean getCorrect() {
        return _correct;
    }

    public boolean getIsSingleSpace() {
        return _isSingleSpace;
    }

    public Option[] getOptions() {
        return _options;
    }
}
