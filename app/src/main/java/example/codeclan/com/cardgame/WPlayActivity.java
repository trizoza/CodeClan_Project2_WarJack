package example.codeclan.com.cardgame;

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

public class WPlayActivity extends AppCompatActivity{

    TextView gameView;
    Button nextTurnButton;
    Button goBackButton;
    WGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_w);
        Log.d(getClass().toString(), "Play war called");

        gameView = (TextView)findViewById(R.id.game_view);
        nextTurnButton = (Button)findViewById(R.id.next_button);
        goBackButton = (Button)findViewById(R.id.go_back_button);

        game = new WGame();
        game.play();
        gameView.setText(game.getGameReport());
        nextTurnButton.setVisibility(View.VISIBLE);
        goBackButton.setVisibility(View.INVISIBLE);
    }

    public void onNextButtonClicked(View button) {
        game.play();
        char t = game.getGameReport().charAt(0);
        char e = game.getGameReport().charAt(2);
        char s = game.getGameReport().charAt(8);
        char T = game.getGameReport().charAt(9);
        if (t == 'Y' && e == 'U' && s == 'A' && T == 'L') {
            gameView.setText(game.getGameReport());
            nextTurnButton.setVisibility(View.INVISIBLE);
            goBackButton.setVisibility(View.VISIBLE);

        }
        else if (t == 'A' && e == 'D' && s == 'W' && T == 'O') {
            gameView.setText(game.getGameReport());
            nextTurnButton.setVisibility(View.INVISIBLE);
            goBackButton.setVisibility(View.VISIBLE);
        }
        else {
            gameView.setText(game.getGameReport());
        }
        Log.d(getClass().toString(), "Next clicked");
    }

    public void onGoBackButtonClicked(View button) {
        Log.d(getClass().toString(), "Go back clicked");
        Intent wIntent;
        wIntent = new Intent(WPlayActivity.this, WActivity.class);
        startActivity(wIntent);
    }


}
