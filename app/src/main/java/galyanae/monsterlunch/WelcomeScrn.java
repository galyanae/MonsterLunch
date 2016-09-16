package galyanae.monsterlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeScrn extends AppCompatActivity {

    Monster monsterObjone;
    Monster luxor;
    Monster sweety;

    ImageView monster;
    ImageView monsterOne;
    ImageView monsterThree;

    AdapterMonster adapterMonster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_scrn);

        monster = (ImageView) findViewById(R.id.yoggy);
        monsterOne = (ImageView) findViewById(R.id.luxor);
        monsterThree = (ImageView) findViewById(R.id.sweety);

//        monsterOne();
//        lux();
//        sw();



//        monsterMoveOne();
//        monsterMoveTwo();
//        monsterMoveThree();

    }

    public void tOPlayScrn(View view) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

    }

    public Monster monsterOne(){
        int index = 0;
        monsterObjone = adapterMonster.monsters.get(index);
        System.out.println(monsterObjone.getName());
        return monsterObjone;
    }

    public Monster lux (){
        int index = 1;
        monsterObjone = adapterMonster.monsters.get(index);
        System.out.println(luxor.getName());
        return luxor;
    }

    public Monster sw(){
        int index = 2;
        monsterObjone = adapterMonster.monsters.get(index);
        System.out.println(sweety.getName());
        return sweety;
    }


//    public void monsterMoveOne (){
//
//        new Timer().schedule(new TimerTask() {
//        @Override
//        public void run() {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    monster.setBackgroundResource(monsterObjone.getImageWink());
//                }
//            });
//            returnStateone();
//        }
//    },0, 4000);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        monster.setBackgroundResource(monsterObjone.getImageHappy());
//                    }
//                });
//                returnStateone();
//            }
//        },0, 5000);
//    }
//
//
//    public void monsterMoveTwo (){
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        monsterOne.setBackgroundResource(luxor.getImageWink());
//                    }
//                });
//                returnStatelux();
//            }
//        },0, 3000);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        monster.setBackgroundResource(luxor.getDead());
//                    }
//                });
//                returnStatelux();
//            }
//        },0,5000);
//    }
//
//    public void monsterMoveThree (){
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        monsterThree.setBackgroundResource(sweety.getImageWink());
//                    }
//                });
//                returnStatesw();
//            }
//        },0, 2300);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        monster.setBackgroundResource(sweety.getImageHappy());
//                    }
//                });
//                returnStatesw();
//            }
//        },0, 4500);
//    }
//
//
//    public void returnStateone (){
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
////                        if (monsterSound.isPlaying()) {
////                            monsterSound.release();
////                            monsterSound=null;
////                        }
////                        else{
////                            System.out.println("Sound is not playing");
////                        }
//                        monster.setBackgroundResource(monsterObjone.getImageStand());
//                    }
//                });
//
//            }
//        }, 500);
//
//    }
//
//    public void returnStatelux (){
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
////                        if (monsterSound.isPlaying()) {
////                            monsterSound.release();
////                            monsterSound=null;
////                        }
////                        else{
////                            System.out.println("Sound is not playing");
////                        }
//                        monsterOne.setBackgroundResource(luxor.getImageStand());
//                    }
//                });
//
//            }
//        }, 500);
//
//    }
//
//
//    public void returnStatesw(){
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
////                        if (monsterSound.isPlaying()) {
////                            monsterSound.release();
////                            monsterSound=null;
////                        }
////                        else{
////                            System.out.println("Sound is not playing");
////                        }
//                        monsterThree.setBackgroundResource(sweety.getImageStand());
//                    }
//                });
//
//            }
//        }, 500);
//
//    }
}
