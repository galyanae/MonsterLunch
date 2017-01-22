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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_scrn);


    }

    public void tOPlayScrn(View view) {
            Intent i = new Intent(getApplicationContext(), MonsterChoose.class);
            startActivity(i);

    }


}
