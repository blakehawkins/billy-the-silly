package appathon.com.billythesilly.scenario;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import appathon.com.billythesilly.R;

/**
 * Created by kamen on 14-11-1.
 */
public class TopBarLayout extends LinearLayout {
    private boolean _correct;
    private boolean _isSingleSpace;
    private TopBarMember[] _options;
    private int N;

    public TopBarLayout(Context context) {
        super(context);
        this.setBackgroundResource(R.drawable.sparkle_box);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        _options[N++] = ((OptionView) child).getOption();
    }

    @Override
    public void removeView(View view) {
        super.removeView(view);
        TopBarMember option = ((OptionView) view).getOption();
        for (int i = 0; i < N; i++) {
            if (option == _options[i]) {
                _options[i] = _options[--N];
                _options[N] = null;
                return;
            }
        }
    }
}
