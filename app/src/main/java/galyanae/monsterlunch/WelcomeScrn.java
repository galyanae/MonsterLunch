package galyanae.monsterlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeScrn extends AppCompatActivity {
    EditText playerName ;
    String  player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_scrn);

    }

    public void tOPlayScrn(View view) {
        playerName = (EditText)findViewById(R.id.playerNameText);
        System.out.println( playerName.getText().toString());
        player = playerName.getText().toString();
        if (playerName != null) {

            Intent i = new Intent(getApplicationContext(), MonsterChoose.class);
            i.putExtra("pName", player);
            startActivity(i);
        } else {
            TextView MSGtextView = (TextView)findViewById(R.id.MSG);
            MSGtextView.setText("Please Enter Your Name");

        }


    }
}
