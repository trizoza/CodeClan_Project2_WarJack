package example.codeclan.com.cardgame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 23/01/2017.
 */

public class BJPlayActivity extends AppCompatActivity implements View.OnClickListener{

    TextView playerTurn;
    TextView androidTurn;
    Button hitButton;
    Button stickButton;
    TextView resultText;
    Button playAgainButton;
    Button goBackButton;
    BJGame game;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_bj);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        playerTurn = (TextView)findViewById(R.id.player_turn);
        androidTurn = (TextView)findViewById(R.id.android_turn);
        hitButton = (Button)findViewById(R.id.hit_button);
        stickButton = (Button)findViewById(R.id.stick_button);
        resultText = (TextView)findViewById(R.id.result_text);
        playAgainButton = (Button)findViewById(R.id.play_again_button);
        goBackButton = (Button)findViewById(R.id.go_back_button);

        hitButton.setVisibility(View.VISIBLE);
        stickButton.setVisibility(View.VISIBLE);
        androidTurn.setVisibility(View.INVISIBLE);
        resultText.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        goBackButton.setVisibility(View.INVISIBLE);

        hitButton.setOnClickListener(this);

        /// BJ GAME BEGINS
        game = new BJGame();
        String playersHand = game.Turn(game.getPlayers().get(0));
        String message = playersHand + "\nWant to hit or stick?";
        playerTurn.setText(message);

        Log.d(getClass().toString(), "onCreate called");
    }

    public void onHitButtonClicked(View button) {
        game.hit(game.getPlayers().get(0));
        String playersHand = game.Turn(game.getPlayers().get(0));
        if (game.getPlayers().get(0).getValueOfHand() <= 21) {
            String message = playersHand + "\nWant to hit or stick?";
            playerTurn.setText(message);
        }
        else {
            String message = "You have busted!\n" + "\n" + playersHand;
            playerTurn.setText(message);
            hitButton.setVisibility(View.INVISIBLE);
            stickButton.setVisibility(View.INVISIBLE);

            /// RESULT EVALUATION
            String results = game.evaluation();
            resultText.setText(results);

            //////// DEVICE STATISTICS ///////////////////////
            String playReport = game.statsEvaluation() + " ";
            String returnedText = BJSavedStatistics.getStoredText(this);
            String stringToSave = returnedText + " " + playReport;
            Context context = button.getContext();
            BJSavedStatistics.setStoredText(context, stringToSave);
            //////////////////////////////////////////////////

            androidTurn.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.VISIBLE);
            playAgainButton.setVisibility(View.VISIBLE);
            goBackButton.setVisibility(View.VISIBLE);
        }
        Log.d(getClass().toString(), "Hit clicked");
    }

    public void onStickButtonClicked(View button) {
        /// ANDROID TURN
        hitButton.setVisibility(View.INVISIBLE);
        stickButton.setVisibility(View.INVISIBLE);
        String androidsHand = "";
        androidsHand = game.Turn(game.getPlayers().get(1));
        while (game.getPlayers().get(1).getValueOfHand() < 17) {
            game.hit(game.getPlayers().get(1));
            androidsHand = game.Turn(game.getPlayers().get(1));
        }
        if (game.getPlayers().get(1).getValueOfHand() <= 21) {
            androidTurn.setText(androidsHand);
        }
        else {
            String messageAndroid = "Android has busted!\n" + "\n" + androidsHand;
            androidTurn.setText(messageAndroid);
        }

        /// RESULT EVALUATION
        String results = game.evaluation();
        resultText.setText(results);

        //////// DEVICE STATISTICS ///////////////////////
        String playReport = game.statsEvaluation() + " ";
        String returnedText = BJSavedStatistics.getStoredText(this);
        String stringToSave = returnedText + " " + playReport;
        Context context = button.getContext();
        BJSavedStatistics.setStoredText(context, stringToSave);
        //////////////////////////////////////////////////

        androidTurn.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);
        goBackButton.setVisibility(View.VISIBLE);
        Log.d(getClass().toString(), "Stick clicked");
    }

    public void onPlayAgainButtonClicked(View button) {
        Intent bjIntent;
        bjIntent = new Intent(BJPlayActivity.this, BJPlayActivity.class);
        startActivity(bjIntent);
        Log.d(getClass().toString(), "Play again clicked");
    }

    public void onGoBackButtonClicked(View button) {
        Intent bjIntent;
        bjIntent = new Intent(BJPlayActivity.this, BJActivity.class);
        startActivity(bjIntent);
        Log.d(getClass().toString(), "Go back clicked");
    }

    /// VIBRATE
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.hit_button:
                vibrator.vibrate(100);
                onHitButtonClicked(hitButton);
        }
    }
}
