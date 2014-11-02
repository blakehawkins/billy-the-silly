package appathon.com.billythesilly.scenario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import appathon.com.billythesilly.R;
import appathon.com.billythesilly.StartScreen;
import appathon.com.billythesilly.Storage;


public class ResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = getIntent().getExtras();
        boolean numStr = extras.getBoolean("Key1");
        String ff = extras.getString("Key2");
        int sceNum = Integer.parseInt(ff);
        if(numStr){
            TextView current = (TextView) findViewById(R.id.textSuccess);
            current.setVisibility(View.VISIBLE);
            Storage hold = new Storage();
            if(!(hold.levels[sceNum-1]))
                hold.stars++;
            hold.levels[sceNum-1] = true;
        }
        else {
            TextView current = (TextView) findViewById(R.id.textFail);
            current.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goMenu (View view){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);
    }
}
