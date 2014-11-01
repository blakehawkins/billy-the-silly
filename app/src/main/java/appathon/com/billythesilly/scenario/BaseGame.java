package appathon.com.billythesilly.scenario;


/*Created by kamen on 14-11-1. */

public class BaseGame {
    private Slot[] _slots;

    public BaseGame(Slot[] slots) {
        _slots = slots;
    }

    public int grade(boolean correctStance) {
        int stars = 0;
        for (Slot sl : _slots) {
            Option[] options = sl.getOptions();
            for (Option opt : options) {
                if (opt != null && sl.getCorrect() == opt.getCorrect() &&
                        correctStance) {
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
