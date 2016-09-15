package galyanae.monsterlunch;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private GoogleApiClient client;

    ImageView target;
    ImageView monster;
    ImageView food;

    Food randomFood;
    Boolean result;
    int bonus;

    AdapterFood adapterFood;

    TextView score;
    int nCounter =0;
    TimerTask mTimerTask;
    TextView hTextView;
    Timer t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        t = new Timer();
        hTextView = (TextView)findViewById(R.id.timerTXT);
        doTimerTask();
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
                    bonus = bonus+ randomFood.getBonus();
                    System.out.println(String.valueOf(bonus));
                    updateScore(score);
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
                    randomFood.getBonus();
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

    public void doTimerTask(){

        mTimerTask = new TimerTask() {
            public void run() {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    public void run() {
                        nCounter++;
                        // update TextView
                        hTextView.setText("Timer: " + nCounter);

                        Log.d("TIMER", "TimerTask run");
                    }
                });
            }};

        // public void schedule (TimerTask task, long delay, long period)
        t.schedule(mTimerTask, 500, 3000);  //

    }
    public Food randomFood()
    {
        Random r = new Random();
        int index = r.nextInt(adapterFood.foods.size());
        randomFood = adapterFood.foods.get(index);
        int bonus = randomFood.getBonus();
        String name = randomFood.getName();
        System.out.println("Food is "+name);
        food = (ImageView) findViewById(R.id.food);
        food.setBackgroundResource(randomFood.getImage());
        return randomFood;

    }

public void updateScore (TextView score){
    score.setText(String.valueOf(bonus));
}
}

