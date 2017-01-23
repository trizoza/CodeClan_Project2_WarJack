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

public class BJPlayActivity extends AppCompatActivity{

    TextView playerTurn;
    Button hitButton;
    Button stickButton;
    BJGame game = new BJGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_bj);

        playerTurn = (TextView)findViewById(R.id.player_turn);
        hitButton = (Button)findViewById(R.id.hit_button);
        stickButton = (Button)findViewById(R.id.stick_button);

        hitButton.setVisibility(View.VISIBLE);
        stickButton.setVisibility(View.VISIBLE);

        String playersHand = game.playerTurn();
        String message = playersHand + "\nWant to hit or stick?";
        playerTurn.setText(message);

        Log.d(getClass().toString(), "onCreate called");
    }

    public void onHitButtonClicked(View button) {
        game.hit();
        if (game.getPlayers().get(0).getValueOfHand() <= 21) {
            String playersHand = game.playerTurn();
            String message = playersHand + "\nWant to hit or stick?";
            playerTurn.setText(message);
        }
        else {
            String playersHand = game.playerTurn();
            String message = "You have busted!\n" + "\n" + playersHand;
            playerTurn.setText(message);
            hitButton.setVisibility(View.INVISIBLE);
            stickButton.setVisibility(View.INVISIBLE);

        }
        Log.d(getClass().toString(), "Hit clicked");
    }

    public void onStickButtonClicked(View button) {

    }

}
