package appathon.com.billythesilly;

import android.media.Image;

/**
 * Created by kamen on 14-11-1.
 */
public class Option {
    private String _option;
    private Image _image;
    private Boolean _correct;

    public Option(String option, Image image, Boolean correct) {
        _option = option;
        _image = image;
        _correct = correct;
    }

    public String getOption() {
        return _option;
    }

    public Image getImage() {
        return _image;
    }

    public Boolean getCorrect() {
        return _correct;
    }
}
