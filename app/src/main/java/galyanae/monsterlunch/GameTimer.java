package galyanae.monsterlunch;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by Lia_2 on 15/09/2016.
 */
public class GameTimer  extends CountDownTimer {
    private TextView timeLeft;
    Context context;
    public void onTick(long millisUntilFinished) {

        timeLeft.setText("seconds remaining: " + millisUntilFinished / 1000);
    }





    public GameTimer(long millisInFuture, long countDownInterval,TextView timeLeft) {
        super(millisInFuture, countDownInterval);
        this.timeLeft = timeLeft;

    }

    public void onFinish() {
        timeLeft.setText("done!");
//        MainActivity.tableScore(context);
//        Intent i = new Intent(context, ScoreTable.class);
//        context.startActivity(i);
       }


}
