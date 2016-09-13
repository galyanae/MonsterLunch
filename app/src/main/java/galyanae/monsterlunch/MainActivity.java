package galyanae.monsterlunch;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.sql.SQLOutput;
import java.util.Random;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private GoogleApiClient client;

    ImageView target;
    ImageView monster;
    ImageView food;

    int bonus;

    AdapterFood adapterFood;

    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bonus =0;

        target = (ImageView) findViewById(R.id.imageView2);
        food = (ImageView) findViewById(R.id.food);
        monster = (ImageView) findViewById(R.id.imageView);

        score = (TextView) findViewById(R.id.textView);
        score.setText(String.valueOf(bonus));

        adapterFood = new AdapterFood(getApplicationContext());

        final Animation fallingAnimation = AnimationUtils.loadAnimation(this,
                R.anim.monstermove);
        monster.startAnimation(fallingAnimation);
        monster.setOnDragListener(monst);

        target.setOnDragListener(dropListener);

        food.setOnTouchListener(touch);

        randomFood();

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
                    bonus = bonus+ randomFood().getBonus();
                    System.out.println(String.valueOf(bonus));
                    randomFood();
                    updateScore(score);
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
                    food.setVisibility(VISIBLE);
                default:
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


    public Food randomFood()
    {
        Random r = new Random();
        int index = r.nextInt(adapterFood.foods.size());
        Food randomFood = adapterFood.foods.get(index);
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

