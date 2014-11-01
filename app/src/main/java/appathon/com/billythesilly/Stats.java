package appathon.com.billythesilly;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Stats extends Activity {
    private int rewardsTotal,timesTotal,starsTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rewardsTotal = timesTotal = starsTotal = 0;
        setContentView(R.layout.activity_stats);
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setProgress(0);
        generateText();

    }

    public void generateText() {
        TextView stars = (TextView) this.findViewById(R.id.StarsEarned);
        TextView times = (TextView) this.findViewById(R.id.TimesHelped);
        TextView rewards = (TextView) this.findViewById(R.id.RewardsEarned);
        stars.setText("x " + String.valueOf(starsTotal));
        times.setText("x " + String.valueOf(timesTotal));
        rewards.setText("x " + String.valueOf(rewardsTotal));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stats, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
