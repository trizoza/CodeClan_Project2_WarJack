package example.codeclan.com.cardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by user on 23/01/2017.
 */

public class BJPlayActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_bj);

        Log.d(getClass().toString(), "onCreate called");
    }

    public void onPlayButtonClicked() {

    }

}
