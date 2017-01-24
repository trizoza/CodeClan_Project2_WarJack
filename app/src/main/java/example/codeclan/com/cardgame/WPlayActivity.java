package example.codeclan.com.cardgame;

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
    Button nextTurn;
    WGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_w);
        Log.d(getClass().toString(), "Play war called");

        gameView = (TextView)findViewById(R.id.game_view);
        nextTurn = (Button)findViewById(R.id.next_button);

        game = new WGame();
        game.play();
        gameView.setText(game.getGameReport());
    }

    public void onNextButtonClicked(View button) {
        if (game.getGameReport().equals("PLAYER WON ALL 32 CARDS!")) {
            gameView.setText(game.getGameReport());
            nextTurn.setVisibility(View.INVISIBLE);

        }
        else if (game.getGameReport().equals("ANDROID WON ALL 32 CARDS!")){
            gameView.setText(game.getGameReport());
            nextTurn.setVisibility(View.INVISIBLE);
        }
        game.play();
        gameView.setText(game.getGameReport());
        Log.d(getClass().toString(), "Next clicked");
    }


}
