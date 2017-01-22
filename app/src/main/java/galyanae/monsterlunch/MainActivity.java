package galyanae.monsterlunch;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private GoogleApiClient client;

    android.support.v7.app.AlertDialog show;

    ProgressBar progressBar;
    TextView timeLeft;
    long remainingTime;


    TextView name;

    MediaPlayer backGroundMusic;
    MediaPlayer monsterSound;
    MediaPlayer addingTime;

    GameTimer gameTimer;

    Monster monsterObj;

    ImageView target;
    ImageView secondTrash;
    ImageView monster;
    ImageView food;
    ImageView soundImg;

    TextView etTitle;
    TextView etInfo;
    ImageView imageViewNewImage;
    ImageView ivCancel;


    TextView timeTXT;

    RelativeLayout background;

    Food randomFood;

    int position;

    View v;

    Intent intent;
    int bonus;

    AdapterFood adapterFood;
    AdapterMonster adapterMonster;

    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = (RelativeLayout) findViewById(R.id.background);
        background.setOnDragListener(dropListener);

        adapterMonster = new AdapterMonster(getApplicationContext());

        position = getIntent().getIntExtra("Position",0);
        monsterObj = adapterMonster.monsters.get(position);
        System.out.println("Monster is "+adapterMonster.monsters.get(position).getName());

        bonus =0;
        target = (ImageView) findViewById(R.id.imageView2);
        secondTrash= (ImageView) findViewById(R.id.secondTrach);
        food = (ImageView) findViewById(R.id.food);
        monster = (ImageView) findViewById(R.id.imageView);
        monster.setBackgroundResource(monsterObj.getImageStand());

        backGroundMusic = MediaPlayer.create(this,monsterObj.getBackGroundMusic());
        backGroundMusic.setVolume(3,3);
        backGroundMusic.setLooping(true);

        addingTime = MediaPlayer.create(this,R.raw.addingtime);
        addingTime.setVolume(20,20);


        score = (TextView) findViewById(R.id.textView);
        score.setText(String.valueOf(bonus));
        adapterFood = new AdapterFood(getApplicationContext());

        final Animation fallingAnimation = AnimationUtils.loadAnimation(this,
                R.anim.steps);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(1000);

        timeTXT = (TextView) findViewById(R.id.timeTXT);
        gameTimer = new GameTimer(60000, 1000, timeTXT);

        name = (TextView) findViewById(R.id.name);
        name.setText(monsterObj.getName()+ " - "+monsterObj.getFoodType().toString());

        monster.setOnDragListener(dropListener);
        target.setOnDragListener(dropListener);
        secondTrash.setOnDragListener(dropListener);
        name.setOnDragListener(dropListener);
        score.setOnDragListener(dropListener);
        timeTXT.setOnDragListener(dropListener);
        progressBar.setOnDragListener(dropListener);

        food.setOnTouchListener(touch);
        food.setOnDragListener(dropListener);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        backGroundMusic.start();
        monster.startAnimation(fallingAnimation);
        randomFood();

        openDialog();
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
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                        food.setVisibility(View.VISIBLE);
            }
            return true;
    }

    };




    View.OnDragListener dropListener = new View.OnDragListener() {
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
                    if (view==target||view==secondTrash){
                        //OPEN GARBAGE CAN IMAGE
                    randomFood();
                    food.setVisibility(VISIBLE);
                    }
                    else if (view == monster) {
                        //CLOSED GARBAGE CAN IMAGE
                        if (monsterObj.getFoodType() == randomFood.getType()) {
                            winkles(MonsterAction.EATS);

                        } else {
                            winkles(MonsterAction.DEAD);

                        }
                        bonus = bonus+ monsterObj.eat(randomFood);
                        score.setText(String.valueOf(bonus));
                        System.out.println(String.valueOf(bonus));

                        if (bonus < 1000) {
                            progressBar.setProgress(bonus);
                        } else if (bonus%1000>0) {
                            progressBar.setProgress(bonus % 1000);
                        } else if(bonus%1000==0){
                                    addingTime.start();
                            progressBar.setProgress(0);
                            System.out.println("Progress bar is " + progressBar.getProgress());

                                    long left = remainingTime+15000;
                                    System.out.println("TIMER SHOULD BE"+left);
                                    gameTimer.cancel();
                                    gameTimer = new GameTimer(left, 1000, timeTXT);
                                    gameTimer.start();
                        }
                        randomFood();
                        food.setVisibility(VISIBLE);
                    }
                    else {
                        food.setVisibility(VISIBLE);
                    }
                    Log.i("Drag event","Dropped");
                    break;

                case DragEvent.ACTION_DRAG_LOCATION:
                    Log.i("Drag event","Location");
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.i("Drag event","Ended");
                    food.setVisibility(VISIBLE);
                    break;

                case DragEvent.ACTION_DRAG_STARTED:
                    Log.i("Drag event","Started");
                    food.setVisibility(View.INVISIBLE);
                    break;

                default:
                    Log.e("DragDrop Example","Unknown action type received by OnDragListener.");
                    return true;


            }
            return true;

        }

    };

    @Override
    public void onStart() {
        super.onStart();
    }

    boolean mute = false;
    public void playOrMute(View view) {
        soundImg = (ImageView) findViewById(R.id.sound);
       mute =! mute;
       //soundImg.setImageResource(R.drawable.mute);

        if (mute) {

                backGroundMusic.start();
                //soundImg.setImageResource(R.drawable.mute);

                Toast.makeText(MainActivity.this, "is playing", Toast.LENGTH_SHORT).show();


        }else {
            backGroundMusic.pause();
           // soundImg.setImageResource(R.drawable.play);

            Toast.makeText(MainActivity.this, "is mute", Toast.LENGTH_SHORT).show();

        }
    }


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



    private enum MonsterAction {
        WINKLES, EATS, HAPPY, DEAD, STAND
    }
    public void winkles(MonsterAction monsterAction) {
        switch (monsterAction) {
            case STAND:
                monster.setBackgroundResource(monsterObj.getImageStand());
                break;

            case WINKLES:
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                monster.setBackgroundResource(monsterObj.getImageWink());
                            }
                        });
                        returnState();
                    }
                },0, 4000);

                break;

            case EATS:
                monster.setBackgroundResource(monsterObj.getImageMounhClose());
                monsterSound = MediaPlayer.create(this,monsterObj.getEatSound());
                monsterSound.setVolume(22,22);
                monsterSound.start();
                returnState();
                break;

            case HAPPY:
                monster.setBackgroundResource(monsterObj.getImageHappy());
                returnState();
                break;

            case DEAD:
                monster.setBackgroundResource(monsterObj.getDead());
                monsterSound = MediaPlayer.create(this,monsterObj.getDislikeSound());
                monsterSound.setVolume(20,20);
                monsterSound.start();
                returnState();
                break;

            default:
                monster.setBackgroundResource(monsterObj.getImageStand());
                break;
        }
    }

    public void returnState (){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        if (monsterSound.isPlaying()) {
//                            monsterSound.release();
//                            monsterSound=null;
//                        }
//                        else{
//                            System.out.println("Sound is not playing");
//                        }
                        monster.setBackgroundResource(monsterObj.getImageStand());
                    }
                });

            }
        }, 500);

    }

    public void openDialog (){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        LayoutInflater li = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.instructions, null, false);

        etTitle = (TextView) view.findViewById(R.id.etTitle);
        etInfo = (TextView) view.findViewById(R.id.etInfo);
        imageViewNewImage = (ImageView) view.findViewById(R.id.imageViewNewImage);

        etTitle.setText(monsterObj.getName());
        etInfo.setText(monsterObj.getStory());
        imageViewNewImage.setBackgroundResource(monsterObj.getImageStand());
        ivCancel = (ImageView) view.findViewById(R.id.ivCancel);
//        ivSave = (ImageView) view.findViewById(R.id.ivSave);



        builder.setView(view);
        show = builder.show();
        show.setView(v);
        ivCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                cancel(arg0);
            }});}
    public void cancel(View v) {
        gameTimer.start();
        show.dismiss();
    }


    public class GameTimer  extends CountDownTimer {
        private TextView timeLeft;

        public void onTick(long millisUntilFinished) {

            timeLeft.setText("Time left: " + millisUntilFinished / 1000);
            remainingTime=millisUntilFinished;
        }


        public GameTimer(long millisInFuture, long countDownInterval,TextView timeLeft) {
            super(millisInFuture, countDownInterval);
            this.timeLeft = timeLeft;

        }

        public void onFinish() {
            if (backGroundMusic != null | monsterSound!= null) {
                try {
                    backGroundMusic.stop();
                    monsterSound.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            timeLeft.setText("done!");
            intent = new Intent(MainActivity.this, ScoreTable.class);
            intent.putExtra("Score",bonus);
            startActivity(intent);


        }
    }



    @Override
    protected void onStop() {
        if (backGroundMusic != null | monsterSound!= null) {
            try {
                backGroundMusic.stop();
                monsterSound.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }}
        gameTimer.cancel();
        finish();
        super.onStop();
    }

}









