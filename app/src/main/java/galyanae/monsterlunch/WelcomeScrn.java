package galyanae.monsterlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class WelcomeScrn extends AppCompatActivity {
    EditText playerName ;
    String  player;



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
