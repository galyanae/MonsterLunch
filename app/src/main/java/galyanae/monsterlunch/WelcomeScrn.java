package galyanae.monsterlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeScrn extends AppCompatActivity {

    Monster yoggy;
    Monster luxor;
    Monster sweety;

    ImageView monster;
    ImageView monsterOne;
    ImageView monsterThree;

    AdapterMonster adapterMonster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_scrn);

        monster = (ImageView) findViewById(R.id.yoggy);
        monsterOne = (ImageView) findViewById(R.id.luxor);
        monsterThree = (ImageView) findViewById(R.id.sweety);


    }

    public void tOPlayScrn(View view) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

    }


}
