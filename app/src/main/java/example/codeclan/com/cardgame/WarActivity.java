package example.codeclan.com.cardgame;

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

public class WarActivity extends AppCompatActivity {

    Button playButton;
    TextView statisticsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w);
        playButton = (Button) findViewById(R.id.play_button);

        Log.d(getClass().toString(), "onCreate called");


        //// WAR STATISTICS ////
        statisticsView = (TextView) findViewById(R.id.war_stats_view);
        statisticsView.setVisibility(View.INVISIBLE);

        String returnedWinners = WarSavedWinners.getStoredText(this);
        if (returnedWinners != null && !returnedWinners.isEmpty()) {
            //// search for player wins
            int players = 0;
            Pattern p = Pattern.compile("player");
            Matcher m = p.matcher(returnedWinners);
            while (m.find()) {
                players++;
            }
            //// search for android wins
            int androids = 0;
            Pattern q = Pattern.compile("android");
            Matcher n = q.matcher(returnedWinners);
            while (n.find()) {
                androids++;
            }
            String longestTurn = WarSavedLongestTurn.getStoredText(this);
            String shortestTurn = WarSavedShortestTurn.getStoredText(this);
            String stats = "     GAME STATISTICS\n" +
                    "\nPlayer: " + players +
                    "\nAndroid: " + androids +
                    "\nLongest game: " + longestTurn + " turns" +
                    "\nShortest game: " + shortestTurn + " turns";
            statisticsView.setText(stats);
            statisticsView.setVisibility(View.VISIBLE);
        }
    }

    public void onPlayWarButtonClicked(View button) {
        Log.d(getClass().toString(), "Play clicked");
        Intent wIntent;
        wIntent = new Intent(WarActivity.this, WarPlayActivity.class);
        startActivity(wIntent);
    }


}
