package example.codeclan.com.cardgame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 23/01/2017.
 */

public class BJActivity extends AppCompatActivity{

    Button playButton;
    TextView savedStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bj);
        playButton = (Button)findViewById(R.id.play_button);
        Log.d(getClass().toString(), "onCreate called");


        savedStats = (TextView)findViewById(R.id.saved_stats);
        savedStats.setVisibility(View.INVISIBLE);
        String returnedText = BJSavedStatistics.getStoredText(this);
        if (returnedText != null && !returnedText.isEmpty()) {
            savedStats.setText(returnedText);
            savedStats.setVisibility(View.VISIBLE);
        }
    }

    public void onPlayBlackJackButtonClicked(View button) {
        Log.d(getClass().toString(), "Play clicked");
        Intent wIntent;
        wIntent = new Intent(BJActivity.this, BJPlayActivity.class);
        startActivity(wIntent);
    }

}
