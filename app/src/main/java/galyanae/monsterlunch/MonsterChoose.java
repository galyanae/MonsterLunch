package galyanae.monsterlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MonsterChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_choose);
        Intent intent = getIntent();
        String theName= intent.getStringExtra("pName");
        theName="LIA";
        TextView nametextView = (TextView)findViewById(R.id.name);
        nametextView.setTextSize(20);
        nametextView.setText(theName);
    }


}
