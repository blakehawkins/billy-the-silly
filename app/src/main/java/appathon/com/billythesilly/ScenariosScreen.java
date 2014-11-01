package appathon.com.billythesilly;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import appathon.com.billythesilly.scenario.BaseGameActivity;
import appathon.com.billythesilly.scenario.ScenarioCrossStreetActivity;
// import android.widget.TextView;

// Commented Page Number feature

public class ScenariosScreen extends Activity {

    String[] arrayButtons = new String[18];

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

    public void goButton1(View view) {
        Intent intent = new Intent(this, ScenarioCrossStreetActivity.class);
        startActivity(intent);
    }

    public void goButton2(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton3(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goNextPage(View view) {
        generateButtonStrings();
        Button current1 = (Button) findViewById(R.id.button1);
        Button current2 = (Button) findViewById(R.id.button2);
        Button current3 = (Button) findViewById(R.id.button3);
        int position = findPosition(current1.getText().toString());
        current1.setText(arrayButtons[(position + 3) % 18]);
        current2.setText(arrayButtons[(position + 4) % 18]);
        current3.setText(arrayButtons[(position + 5) % 18]);
        //Line that changes color of text:     current1.setTextColor(Color.BLUE);
        //setPage(position);
    }

    public void goPreviousPage(View view) {
        generateButtonStrings();
        Button current1 = (Button) findViewById(R.id.button1);
        Button current2 = (Button) findViewById(R.id.button2);
        Button current3 = (Button) findViewById(R.id.button3);
        int position = findPosition(current1.getText().toString());
        current1.setText(arrayButtons[(position + 15) % 18]);
        current2.setText(arrayButtons[(position + 16) % 18]);
        current3.setText(arrayButtons[(position + 17) % 18]);
        //setPage(position);
    }

    /*public void setPage(int n){
        TextView page = (TextView) findViewById(R.id.textPage);
        String s = "Page "+ Integer.toString((n/3)+1);
        CharSequence num = s;
        page.setText(num);
    }*/

    public void generateButtonStrings() {
        for (int i = 0; i < 18; i++) {
            arrayButtons[i] = ("Testing Changes " + i);
        }
    }

    public int findPosition(String n) {
        int position = 0;
        for (int i = 0; i < 18; i++) {
            if (arrayButtons[i].equals(n))
                position = i;
        }
        return position;
    }
}
