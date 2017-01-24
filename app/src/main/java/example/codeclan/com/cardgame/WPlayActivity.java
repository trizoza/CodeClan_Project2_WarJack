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

public class WPlayActivity extends AppCompatActivity{

    TextView gameView;
    Button nextTurnButton;
    Button goBackButton;
    Button playAgainButton;
    WGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_w);
        Log.d(getClass().toString(), "Play war called");

        gameView = (TextView)findViewById(R.id.game_view);
        nextTurnButton = (Button)findViewById(R.id.next_button);
        goBackButton = (Button)findViewById(R.id.go_back_button);
        playAgainButton = (Button)findViewById(R.id.play_again_button);

        game = new WGame();
        game.play();
        gameView.setText(game.getGameReport());
        nextTurnButton.setVisibility(View.VISIBLE);
        goBackButton.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
    }

    public void onNextButtonClicked(View button) {
        /// NEXT TURN IN GAME ///
        game.play();
        /// WINNER EVALUATION ////
        char t = game.getGameReport().charAt(0);
        char e = game.getGameReport().charAt(2);
        char s = game.getGameReport().charAt(8);
        char T = game.getGameReport().charAt(9);
        /// YOU WINNER
        if (t == 'Y' && e == 'U' && s == 'A' && T == 'L') {
            gameView.setText(game.getGameReport());
            nextTurnButton.setVisibility(View.INVISIBLE);
            goBackButton.setVisibility(View.VISIBLE);
            playAgainButton.setVisibility(View.VISIBLE);

            //////// WINNER STATISTICS ///////////////////////
            String winnersReport = "player";
            String returnedText = WSavedWinners.getStoredText(this);
            String stringToSave = returnedText + " " + winnersReport;
            Context winContext = button.getContext();
            WSavedWinners.setStoredText(winContext, stringToSave);
            //////////////////////////////////////////////////

            ////////// LONGEST TURN STATISTICS //////////////////
            String longestTurn = WSavedLongestTurn.getStoredText(this);
            if (longestTurn == null){
                longestTurn = "0";
            }
            int lenghtOfTurn = Integer.parseInt(longestTurn);
            if (game.getTurnCount() > lenghtOfTurn) {
                String newLongestTurn = String.valueOf(game.getTurnCount());
                Context longContext = button.getContext();
                WSavedLongestTurn.setStoredText(longContext, newLongestTurn);
            }
            else if (lenghtOfTurn == 0) {
                String newLongestTurn = String.valueOf(game.getTurnCount());
                Context longContext = button.getContext();
                WSavedLongestTurn.setStoredText(longContext, newLongestTurn);
            }
            //////////////////////////////////////////////////////

            ////////// SHORTEST TURN STATISTICS //////////////////
            String shortestTurn = WSavedShortestTurn.getStoredText(this);
            if (shortestTurn == null){
                shortestTurn = "0";
            }
            int shortageOfTurn = Integer.parseInt(shortestTurn);
            if (game.getTurnCount() < shortageOfTurn) {
                String newShortestTurn = String.valueOf(game.getTurnCount());
                Context shortContext = button.getContext();
                WSavedShortestTurn.setStoredText(shortContext, newShortestTurn);
            }
            else if (shortageOfTurn == 0) {
                String newShortestTurn = String.valueOf(game.getTurnCount());
                Context shortContext = button.getContext();
                WSavedShortestTurn.setStoredText(shortContext, newShortestTurn);
            }
            //////////////////////////////////////////////////////

        }
        /// ANDROID WINNER
        else if (t == 'A' && e == 'D' && s == 'W' && T == 'O') {
            gameView.setText(game.getGameReport());
            nextTurnButton.setVisibility(View.INVISIBLE);
            goBackButton.setVisibility(View.VISIBLE);
            playAgainButton.setVisibility(View.VISIBLE);

            //////// WINNER STATISTICS ///////////////////////
            String winnersReport = "android";
            String returnedText = WSavedWinners.getStoredText(this);
            String stringToSave = returnedText + " " + winnersReport;
            Context context = button.getContext();
            WSavedWinners.setStoredText(context, stringToSave);
            //////////////////////////////////////////////////

            ////////// LONGEST TURN STATISTICS //////////////////
            String longestTurn = WSavedLongestTurn.getStoredText(this);
            if (longestTurn == null){
                longestTurn = "0";
            }
            int lenghtOfTurn = Integer.parseInt(longestTurn);
            if (game.getTurnCount() > lenghtOfTurn) {
                String newLongestTurn = String.valueOf(game.getTurnCount());
                Context longContext = button.getContext();
                WSavedLongestTurn.setStoredText(longContext, newLongestTurn);
            }
            else if (lenghtOfTurn == 0) {
                String newLongestTurn = String.valueOf(game.getTurnCount());
                Context longContext = button.getContext();
                WSavedLongestTurn.setStoredText(longContext, newLongestTurn);
            }
            //////////////////////////////////////////////////////

            ////////// SHORTEST TURN STATISTICS //////////////////
            String shortestTurn = WSavedShortestTurn.getStoredText(this);
            if (shortestTurn == null){
                shortestTurn = "0";
            }
            int shortageOfTurn = Integer.parseInt(shortestTurn);
            if (game.getTurnCount() < shortageOfTurn) {
                String newShortestTurn = String.valueOf(game.getTurnCount());
                Context shortContext = button.getContext();
                WSavedShortestTurn.setStoredText(shortContext, newShortestTurn);
            }
            else if (shortageOfTurn == 0) {
                String newShortestTurn = String.valueOf(game.getTurnCount());
                Context shortContext = button.getContext();
                WSavedShortestTurn.setStoredText(shortContext, newShortestTurn);
            }
            //////////////////////////////////////////////////////

        }
        /// NO ONE WON YET
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

    public void onPlayAgainButtonClicked(View button) {
        Intent wIntent;
        wIntent = new Intent(WPlayActivity.this, WPlayActivity.class);
        startActivity(wIntent);
        Log.d(getClass().toString(), "Play again clicked");
    }


}
