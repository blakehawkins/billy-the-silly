package appathon.com.billythesilly;

/**
 * Created by kamen on 14-11-1.
 */
public class Stance {
    private String _name;
    private boolean _isCorrect;

    public Stance(String name, boolean isCorrect) {
        _isCorrect = isCorrect;
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public boolean getIsCorrect() {
        return _isCorrect;
    }
}
