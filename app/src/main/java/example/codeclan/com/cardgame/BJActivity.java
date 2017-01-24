package example.codeclan.com.cardgame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 23/01/2017.
 */

public class BJActivity extends AppCompatActivity{

    Button playButton;
    TextView savedStats;
    Button resetStatsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bj);
        playButton = (Button)findViewById(R.id.play_button);
        resetStatsButton = (Button)findViewById((R.id.reset_stats_button));
        Log.d(getClass().toString(), "onCreate called");

        //// BLACK JACK STATISTICS ////
        savedStats = (TextView)findViewById(R.id.saved_stats);
        savedStats.setVisibility(View.INVISIBLE);
        resetStatsButton.setVisibility(View.INVISIBLE);
        String returnedText = BJSavedStatistics.getStoredText(this);

        if (returnedText != null && !returnedText.isEmpty()) {
            //// search for player wins
            int players = 0;
            Pattern p = Pattern.compile("player");
            Matcher m = p.matcher( returnedText );
            while (m.find()) {
                players++;
            }
            //// search for android wins
            int androids = 0;
            Pattern q = Pattern.compile("android");
            Matcher n = q.matcher( returnedText );
            while (n.find()) {
                androids++;
            }
            //// search for ties
            int ties = 0;
            Pattern r = Pattern.compile("tie");
            Matcher o = r.matcher( returnedText );
            while (o.find()) {
                ties++;
            }
            String stats = "GAME STATISTICS\n\nPlayer: " + players + "\nAndroid: " + androids + "\nTie: " + ties;
            savedStats.setText(stats);
            savedStats.setVisibility(View.VISIBLE);
            resetStatsButton.setVisibility(View.VISIBLE);
        }
    }

    public void onPlayBlackJackButtonClicked(View button) {
        Log.d(getClass().toString(), "Play clicked");
        Intent wIntent;
        wIntent = new Intent(BJActivity.this, BJPlayActivity.class);
        startActivity(wIntent);
    }

    public void onResetStatsButtonClicked(View button) {
        Log.d(getClass().toString(), "Reset statistics clicked");
        String stringToSave = " ";
        Context context = button.getContext();
        BJSavedStatistics.setStoredText(context, stringToSave);
        String stats = "GAME STATISTICS\n\nPlayer: 0\nAndroid: 0\nTie: 0";
        savedStats.setText(stats);
    }
}
