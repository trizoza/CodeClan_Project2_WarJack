package example.codeclan.com.cardgame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    ImageView pCard01;
    ImageView pCard02;
    ImageView pCard03;
    ImageView pCard04;
    ImageView pCard05;
    ImageView pCard06;
    ImageView pCard07;
    ImageView pCard08;
    ImageView pCard09;
    ImageView pCard10;
    ImageView pCard11;
    ImageView aCard01;
    ImageView aCard02;
    ImageView aCard03;
    ImageView aCard04;
    ImageView aCard05;
    ImageView aCard06;
    ImageView aCard07;
    ImageView aCard08;
    ImageView aCard09;
    ImageView aCard10;
    ImageView aCard11;

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
        pCard01 = (ImageView)findViewById(R.id.player_card_1);
        pCard02 = (ImageView)findViewById(R.id.player_card_2);
        pCard03 = (ImageView)findViewById(R.id.player_card_3);
        pCard04 = (ImageView)findViewById(R.id.player_card_4);
        pCard05 = (ImageView)findViewById(R.id.player_card_5);
        pCard06 = (ImageView)findViewById(R.id.player_card_6);
        pCard07 = (ImageView)findViewById(R.id.player_card_7);
        pCard08 = (ImageView)findViewById(R.id.player_card_8);
        pCard09 = (ImageView)findViewById(R.id.player_card_9);
        pCard10 = (ImageView)findViewById(R.id.player_card_10);
        pCard11 = (ImageView)findViewById(R.id.player_card_11);
        aCard01 = (ImageView)findViewById(R.id.android_card_1);
        aCard02 = (ImageView)findViewById(R.id.android_card_2);
        aCard03 = (ImageView)findViewById(R.id.android_card_3);
        aCard04 = (ImageView)findViewById(R.id.android_card_4);
        aCard05 = (ImageView)findViewById(R.id.android_card_5);
        aCard06 = (ImageView)findViewById(R.id.android_card_6);
        aCard07 = (ImageView)findViewById(R.id.android_card_7);
        aCard08 = (ImageView)findViewById(R.id.android_card_8);
        aCard09 = (ImageView)findViewById(R.id.android_card_9);
        aCard10 = (ImageView)findViewById(R.id.android_card_10);
        aCard11 = (ImageView)findViewById(R.id.android_card_11);

        hitButton.setVisibility(View.VISIBLE);
        stickButton.setVisibility(View.VISIBLE);
        androidTurn.setVisibility(View.INVISIBLE);
        resultText.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        goBackButton.setVisibility(View.INVISIBLE);
        aCard03.setVisibility(View.INVISIBLE);
        aCard04.setVisibility(View.INVISIBLE);
        aCard05.setVisibility(View.INVISIBLE);
        aCard06.setVisibility(View.INVISIBLE);
        aCard07.setVisibility(View.INVISIBLE);
        aCard08.setVisibility(View.INVISIBLE);
        aCard09.setVisibility(View.INVISIBLE);
        aCard10.setVisibility(View.INVISIBLE);
        aCard11.setVisibility(View.INVISIBLE);
        pCard03.setVisibility(View.INVISIBLE);
        pCard04.setVisibility(View.INVISIBLE);
        pCard05.setVisibility(View.INVISIBLE);
        pCard06.setVisibility(View.INVISIBLE);
        pCard07.setVisibility(View.INVISIBLE);
        pCard08.setVisibility(View.INVISIBLE);
        pCard09.setVisibility(View.INVISIBLE);
        pCard10.setVisibility(View.INVISIBLE);
        pCard11.setVisibility(View.INVISIBLE);


        hitButton.setOnClickListener(this);

        /// BJ GAME BEGINS
        game = new BJGame();

        /////// FIRST PLAYED CARDS ASSIGNMENT /////////////
        String identifier01 = game.getPlayers().get(0).getBJHand().get(0).toString().toLowerCase();
        int imageId01 = getResources().getIdentifier(identifier01, "drawable", this.getPackageName());
        pCard01.setImageResource(imageId01);
        String identifier02 = game.getPlayers().get(0).getBJHand().get(1).toString().toLowerCase();
        int imageId02 = getResources().getIdentifier(identifier02, "drawable", this.getPackageName());
        pCard02.setImageResource(imageId02);
        int imageId12 = getResources().getIdentifier("card_back", "drawable", this.getPackageName());
        aCard01.setImageResource(imageId12);
        int imageId13 = getResources().getIdentifier("card_back", "drawable", this.getPackageName());
        aCard02.setImageResource(imageId13);
        ////////////////////////////////////////////////////

        String playersHand = game.Turn(game.getPlayers().get(0));
        String message = "Your hand:          " + playersHand + "\nWant to hit or stick?";
        playerTurn.setText(message);

        Log.d(getClass().toString(), "onCreate called");
    }

    public void onHitButtonClicked(View button) {
        game.hit(game.getPlayers().get(0));
        String playersHand = game.Turn(game.getPlayers().get(0));
        if (game.getPlayers().get(0).getValueOfHand() <= 21) {
            String message = "Your hand:          " + playersHand + "\nWant to hit or stick?";
            playerTurn.setText(message);
        }
        else {
            String message = "Your hand:          " + playersHand;
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
        String playersHand = game.Turn(game.getPlayers().get(0));
        String message = "Your hand:          " + playersHand;
        playerTurn.setText(message);


        String androidsHand = "Android:              ";
        androidsHand += game.Turn(game.getPlayers().get(1));
        while (game.getPlayers().get(1).getValueOfHand() < 17) {
            game.hit(game.getPlayers().get(1));
            androidsHand = "Android:              " + game.Turn(game.getPlayers().get(1));
        }
        androidTurn.setText(androidsHand);

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
