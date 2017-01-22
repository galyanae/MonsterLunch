package galyanae.monsterlunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreTable extends AppCompatActivity {

    Intent i;
    int score;
    TextView congrats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);

        score = getIntent().getExtras().getInt("Score",0);

        congrats = (TextView) findViewById(R.id.congrats);
        congrats.setText("Your score is "+score+ ". Monsters think that you can do better! Do you want to try right now?" );
    }

    public void playAgain(View view) {
        Intent i = new Intent(getApplicationContext(), MonsterChoose.class);
        startActivity(i);
        finish();
    }

    protected void onStop() {
        finish();
        super.onStop();
    }
}

