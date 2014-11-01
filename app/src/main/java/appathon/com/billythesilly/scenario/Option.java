package appathon.com.billythesilly.scenario;

/* Created by kamen on 14-11-1. */

public class Option {
    private String _option;
    private Boolean _correct;

    public Option(String option, Boolean correct) {
        _option = option;
        _correct = correct;
    }

    public String getOption() {
        return _option;
    }

    public Boolean getCorrect() {
        return _correct;
    }
}
