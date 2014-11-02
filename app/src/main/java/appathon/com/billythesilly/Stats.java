package appathon.com.billythesilly;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Stats extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        generateContent();
        generateBilly();
    }

    public void generateContent() {
        // Create Progressbar
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        int progressStatus = 0;
        for (boolean b:  Storage.levels){
            if (b) {
                progressStatus +=1;
            }
        }
        progressBar.setProgress(progressStatus);
        // Fill TextFields
        TextView stars = (TextView) this.findViewById(R.id.StarsEarned);
        TextView times = (TextView) this.findViewById(R.id.TimesHelped);
        TextView rewards = (TextView) this.findViewById(R.id.RewardsEarned);
        stars.setText("x " + String.valueOf(Storage.stars));
        times.setText("x " + String.valueOf(progressStatus));
        rewards.setText("x " + String.valueOf(Storage.rewards.size()));

        TextView progress = (TextView) this.findViewById(R.id.Progress);
        progress.setText("Scenarios: " + progressStatus + "/" + progressBar.getMax());
    }

    public void generateBilly() {
        if (Storage.rewards.size() > 0) {
            ImageView currBilly = (ImageView) this.findViewById(R.id.CurrentBilly);
            currBilly.setImageResource(R.drawable.shopbilly);
            ImageView arrow = (ImageView) this.findViewById(R.id.Arrow);
            arrow.setImageResource(R.drawable.arrow);
        }
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
