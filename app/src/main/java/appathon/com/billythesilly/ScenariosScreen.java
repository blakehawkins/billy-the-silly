package appathon.com.billythesilly;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class ScenariosScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenarios_screen);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scenarios_screen, menu);
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

    public void goScissors(View view){
        Intent intent = new Intent(this,BaseGameActivity.class);
        startActivity(intent);
    }

    public void goRoad(View view){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);
    }

    public void goClassroom(View view){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);
    }

    public void goNextPage(View view){
        final Button next = (Button) findViewById(R.id.buttonRoad);
        next.setText("Testing Changes");
    }
}