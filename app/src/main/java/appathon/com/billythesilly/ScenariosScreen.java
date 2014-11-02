package appathon.com.billythesilly;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import appathon.com.billythesilly.scenario.ReactionScenarioCookieActivity;
import appathon.com.billythesilly.scenario.ScenarioCrossStreetActivity;

public class ScenariosScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean [] check = checkComplete();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenarios_screen);
        for(int i=0; i<18; i++){
            if(check[i]){
                changeColor(i);
            }
        }
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
        Intent intent = new Intent(this, ReactionScenarioCookieActivity.class);
        startActivity(intent);
    }

    public void goButton3(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton4(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton5(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton6(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton7(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton8(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton9(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton10(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton11(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton12(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton13(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton14(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton15(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton16(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton17(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void goButton18(View view) {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public boolean [] checkComplete(){
        Storage info = new Storage();
        boolean [] check = info.levels;
        return check;
    }

       public void changeColor(int n){
        switch(n){
            case 0:
                Button hold1 = (Button) findViewById(R.id.button1);
                hold1.setTextColor(Color.GREEN);
                break;
            case 1:
                Button hold2 = (Button) findViewById(R.id.button2);
                hold2.setTextColor(Color.GREEN);
                break;
            case 2:
                Button hold3 = (Button) findViewById(R.id.button3);
                hold3.setTextColor(Color.GREEN);
                break;
            case 3:
                Button hold4 = (Button) findViewById(R.id.button4);
                hold4.setTextColor(Color.GREEN);
                break;
            case 4:
                Button hold5 = (Button) findViewById(R.id.button5);
                hold5.setTextColor(Color.GREEN);
                break;
            case 5:
                Button hold6 = (Button) findViewById(R.id.button6);
                hold6.setTextColor(Color.GREEN);
                break;
            case 6:
                Button hold7 = (Button) findViewById(R.id.button7);
                hold7.setTextColor(Color.GREEN);
                break;
            case 7:
                Button hold8 = (Button) findViewById(R.id.button8);
                hold8.setTextColor(Color.GREEN);
                break;
            case 8:
                Button hold9 = (Button) findViewById(R.id.button9);
                hold9.setTextColor(Color.GREEN);
                break;
            case 9:
                Button hold10 = (Button) findViewById(R.id.button10);
                hold10.setTextColor(Color.GREEN);
                break;
            case 10:
                Button hold11 = (Button) findViewById(R.id.button11);
                hold11.setTextColor(Color.GREEN);
                break;
            case 11:
                Button hold12 = (Button) findViewById(R.id.button12);
                hold12.setTextColor(Color.GREEN);
                break;
            case 12:
                Button hold13 = (Button) findViewById(R.id.button13);
                hold13.setTextColor(Color.GREEN);
                break;
            case 13:
                Button hold14 = (Button) findViewById(R.id.button14);
                hold14.setTextColor(Color.GREEN);
                break;
            case 14:
                Button hold15 = (Button) findViewById(R.id.button15);
                hold15.setTextColor(Color.GREEN);
                break;
            case 15:
                Button hold16 = (Button) findViewById(R.id.button16);
                hold16.setTextColor(Color.GREEN);
                break;
            case 16:
                Button hold17 = (Button) findViewById(R.id.button17);
                hold17.setTextColor(Color.GREEN);
                break;
            case 17:
                Button hold18 = (Button) findViewById(R.id.button18);
                hold18.setTextColor(Color.GREEN);
                break;
            default:
                break;
        }

    }
}
