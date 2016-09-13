package galyanae.monsterlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeScrn extends AppCompatActivity {
    String playerName ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_scrn);

    }

    public void tOPlayScrn(View view) {
        playerName = String.valueOf((EditText) findViewById(R.id.playerNameText));

        if (playerName != null) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("pName", playerName);
           // i.putExtra("pName", "playerName");
            startActivity(i);
        } else {
            TextView MSGtextView = (TextView)findViewById(R.id.MSG);
            MSGtextView.setText("Please Enter Your Name");
        }

       // System.out.println(playerName);
    }
}
