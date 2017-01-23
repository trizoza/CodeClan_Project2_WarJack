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

public class WActivity extends AppCompatActivity {

    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w);
        playButton = (Button)findViewById(R.id.play_button);
        Log.d(getClass().toString(), "onCreate called");
    }

    public void onPlayWarButtonClicked(View button) {
        Log.d(getClass().toString(), "Play clicked");
        Intent wIntent;
        wIntent = new Intent(WActivity.this, WPlayActivity.class);
        startActivity(wIntent);
    }

}
