package galyanae.monsterlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MonsterChoose extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_choose);
        intent = getIntent();
        String theName= intent.getStringExtra("pName");
        TextView nametextView = (TextView)findViewById(R.id.name);
        nametextView.setTextSize(20);
        nametextView.setText(theName);
    }


    public void toMainActivity(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
