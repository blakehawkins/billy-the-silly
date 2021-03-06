package appathon.com.billythesilly;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ShopActivity extends Activity implements BuyDialogFragment.OnDialogInteractionListener{

    private static final int views[] = {R.id.imageButton,R.id.imageButton2,R.id.imageButton3,
            R.id.imageButton4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Storage.prices.put(R.id.imageButton, "5");
        Storage.prices.put(R.id.imageButton2, "6");
        Storage.prices.put(R.id.imageButton3, "2");
        Storage.prices.put(R.id.imageButton4, "1");
        setContentView(R.layout.activity_shop);
    }

    @Override
    public void onResume(){
        super.onResume();
        checkRewards();
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
    public void buyItem (View view){
        ImageView iView = (ImageView) view;
        int id = iView.getId();
        if (!Storage.rewards.containsKey(id)){
            DialogFragment dialogFragment = BuyDialogFragment.newInstance((String)iView.getContentDescription(),id);
            dialogFragment.show(getFragmentManager(), "dialog");
        }
    }

    public void checkRewards(){
        for (int i:views){
            if (Storage.rewards.containsKey(i)){
                ImageView imageView = (ImageView)findViewById(i);
                imageView.setColorFilter(0xbb0e922a);
            }
        }
        ((TextView)findViewById(R.id.numStars)).setText(Integer.toString(Storage.stars));
    }
    @Override
    public void buyPressed(View view, int id) {
        Storage.rewards.put(id, ((ImageView) findViewById(id)).getDrawable());
        checkRewards();
        Log.d("ShopActivity", "Buy pressed");
    }
}
