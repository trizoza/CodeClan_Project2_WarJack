package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 23/01/2017.
 */

public class MainActivity extends AppCompatActivity {

    Button wButton;
    Button bjButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wButton = (Button)findViewById(R.id.w_button);
        bjButton = (Button)findViewById(R.id.bj_button);

        Log.d(getClass().toString(), "onCreate called");
    }

    public void onWarButtonClicked(View button) {
        Log.d(getClass().toString(), "Play War clicked");

        Intent wIntent;
        wIntent = new Intent(MainActivity.this, WActivity.class);

        startActivity(wIntent);
    }

    public void onBlackJackButtonClicked(View button) {
        Log.d(getClass().toString(), "Play Black Jack clicked");

        Intent bjIntent;
        bjIntent = new Intent(MainActivity.this, BJActivity.class);

        startActivity(bjIntent);
    }

}
