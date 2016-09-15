package galyanae.monsterlunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MonsterChoose extends AppCompatActivity {


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_choose);
    }

    public void sweet(View view) {
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("name","Sweety");
        startActivity(intent);
    }


    public void lux(View view) {
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("name","Luxor");
        startActivity(intent);
    }

    public void health(View view) {
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("name","Joggy");
        startActivity(intent);
    }
}
