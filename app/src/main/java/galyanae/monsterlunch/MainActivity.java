package galyanae.monsterlunch;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private GoogleApiClient client;

    Monster monsterObj;

    ImageView target;
    ImageView monster;
    ImageView food;

    TextView one;
    TextView two;
    TextView three;
    TextView four;
    TextView five;

    TextView[]  scores;



    String foodType;
    Food randomFood;

    Boolean result;

    int bonus;

    AdapterFood adapterFood;
    AdapterMonster adapterMonster;

    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (TextView) findViewById(R.id.imageView4);
        two = (TextView) findViewById(R.id.imageView5);
        three =(TextView) findViewById(R.id.imageView6);
        four = (TextView) findViewById(R.id.imageView7);
        five = (TextView) findViewById(R.id.imageView8);

        scores = new TextView[5];
        scores[0] = one;
        scores[1] = two;
        scores[2] = three;
        scores[3] = four;
        scores[4] = five;




        Intent intent = getIntent();
        String theName= intent.getStringExtra("pName");
        //String theName="LIA";
//        TextView nametextView = (TextView)findViewById(R.id.name);
//        nametextView.setTextSize(20);
//        nametextView.setText(theName);

        adapterMonster = new AdapterMonster(getApplicationContext());
        randomMonster();

        result = false;
        bonus =0;
        target = (ImageView) findViewById(R.id.imageView2);
        food = (ImageView) findViewById(R.id.food);
        monster = (ImageView) findViewById(R.id.imageView);

        score = (TextView) findViewById(R.id.textView);
        score.setText(String.valueOf(bonus));

        adapterFood = new AdapterFood(getApplicationContext());

        final Animation fallingAnimation = AnimationUtils.loadAnimation(this,
                R.anim.steps);
        monster.startAnimation(fallingAnimation);
        monster.setOnDragListener(monst);

        target.setOnDragListener(dropListener);

        food.setOnTouchListener(touch);

        randomFood();
        updateScore();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    View.OnTouchListener touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View food, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    food);
            food.startDrag(data, shadowBuilder, food, 0);
            food.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;

        }
       }
            //return false;
       // }
    };



    View.OnDragListener monst = new View.OnDragListener(){
        @Override
        public boolean onDrag(View view, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag event","Entered");
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag event","Exited");
                    break;

                case DragEvent.ACTION_DROP:
                    Log.i("Drag event","Dropped");
                    bonus = bonus+ monsterObj.eat(randomFood);
                    System.out.println(String.valueOf(bonus));
                    updateScore();
                    randomFood();
                    food.setVisibility(VISIBLE);
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    food.setVisibility(VISIBLE);

                default:
                    break;

            }

            return true;
        }
    };




    View.OnDragListener dropListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View target, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag event","Entered");
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag event","Exited");
                    break;

                case DragEvent.ACTION_DROP:
                    Log.i("Drag event","Dropped");
                    randomFood();
                    food.setVisibility(VISIBLE);
                    break;


                case DragEvent.ACTION_DRAG_ENDED:
                    break;


                default:
                    Log.e("DragDrop Example","Unknown action type received by OnDragListener.");
                    break;

            }

            return true;
        }

    };

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://galyanae.monsterlunch/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://galyanae.monsterlunch/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }


    private class DragShadow extends View.DragShadowBuilder{

        public DragShadow(View view) {
            super(view);
        }

        @Override
        public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
            super.onProvideShadowMetrics(outShadowSize, outShadowTouchPoint);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            super.onDrawShadow(canvas);
        }
    }

public Monster randomMonster(){
    Random r = new Random();
    int index = r.nextInt(adapterMonster.monsters.size());
    monsterObj = adapterMonster.monsters.get(index);
    System.out.println(monsterObj.getName());
    return monsterObj;
}



    public Food randomFood()
    {
        Random r = new Random();
        int index = r.nextInt(adapterFood.foods.size());
        randomFood = adapterFood.foods.get(index);
        String name = randomFood.getName();
        System.out.println("Food is "+name);
        food = (ImageView) findViewById(R.id.food);
        food.setBackgroundResource(randomFood.getImage());
        return randomFood;

    }
public void updateScore (){
    score.setText(String.valueOf(bonus));
    updateBonusScale();
}

    public void updateBonusScale(){

        int cur;
        if(bonus <= -3000)
            cur = 0;
        else if(bonus <= -2000)
            cur = 1;
        else if(bonus <= -1000)
            cur = 2;
        else if(bonus <= 0)
            cur = 3;
        else if(bonus <= 1000)
            cur = 4;
        else
            cur = 5;

        System.out.println(cur);

        for (int i = 0; i <= cur - 1; i++) {
            scores[i].setVisibility(VISIBLE);
        }
        for (int i = cur; i <5 ; i++) {
            scores[i].setVisibility(View.INVISIBLE);

        }
    }
}



