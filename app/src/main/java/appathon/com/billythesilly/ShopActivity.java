package appathon.com.billythesilly;

import android.app.Activity;
import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ShopActivity extends Activity implements BuyDialogFragment.OnDialogInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop, menu);
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
    public void buyEyes (View view){
        DialogFragment dialogFragment = BuyDialogFragment.newInstance("Wow some eyes",0);
        dialogFragment.show(getFragmentManager(), "dialog");
    }
    public void buyMouth (View view){
        DialogFragment dialogFragment = BuyDialogFragment.newInstance("A lovely smile",1);
        dialogFragment.show(getFragmentManager(), "dialog");
    }

    @Override
    public void buyPressed(View view, int id) {
        Log.d("ShopActivity","Buy pressed");
    }
}
