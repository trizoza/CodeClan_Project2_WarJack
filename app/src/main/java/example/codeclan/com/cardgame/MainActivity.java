package example.codeclan.com.cardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by user on 23/01/2017.
 */

public class MainActivity extends AppCompatActivity {

    Button wButton;
    Button bjButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wButton = (Button)findViewById(R.id.w_button);
        bjButton = (Button)findViewById(R.id.bj_button);


    }


}
