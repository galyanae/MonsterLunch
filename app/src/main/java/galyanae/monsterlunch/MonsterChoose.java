package galyanae.monsterlunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

public class MonsterChoose extends AppCompatActivity {

    ListView listView;
    AdapterMonster monsterChoise;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_choose);
        listView = (ListView) findViewById(R.id.listView);
        monsterChoise = new AdapterMonster (getApplicationContext());
        listView.setAdapter(monsterChoise);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                intent = new Intent(MonsterChoose.this, MainActivity.class);
                System.out.println("POSITION IS "+position);
                intent.putExtra("Position",position);
                startActivity(intent);
                finish();


            }
        });

    }

    }



