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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

        private View selected_item = null;
    private int offset_x = 0;
    private int offset_y = 0;
    Boolean touchFlag = false;
    boolean dropFlag = false;
    RelativeLayout.LayoutParams imageParams;
    ImageView imageDrop, food, imageView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
//    int eX, eY;
//    int topY, leftX, rightX, bottomY;
//    View.OnDragListener my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        final Animation fallingAnimation = AnimationUtils.loadAnimation(this,
                R.anim.monstermove);
        imageView.startAnimation(fallingAnimation);


        findViewById(R.id.imageView2).setOnDragListener(dropListener);

        findViewById(R.id.food).setOnTouchListener(touvh);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
//
//    @Override
//    public boolean onDrag(View view, DragEvent dragEvent) {
//        return false;
//    }

    View.OnTouchListener touvh = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    v);
            v.startDrag(data, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
       }
            //return false;
       // }
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
                    Log.i("Drag event","Dropped");
                    ImageView dragged = (ImageView) event.getLocalState();
                    ImageView target = (ImageView)view;
                    dragged.setVisibility(View.VISIBLE);
                    break;
            }

            return false;
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

//    @Override
//    public void onStart() {
//        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://galyanae.gameexample/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }

    //@Override
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
//                Uri.parse("android-app://galyanae.gameexample/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
}






      //  food.setOnTouchListener((View.OnTouchListener) this);

       // View root = findViewById(android.R.id.content).getRootView();
       // imageDrop = (ImageView) findViewById(R.id.imageView2);}


//        root.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View food, MotionEvent event) {
//
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            ClipData data = ClipData.newPlainText("", "");
//            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
//                    food);
//            food.startDrag(data, shadowBuilder, food, 0);
//            food.setVisibility(View.INVISIBLE);
//            return true;
//        } else {
//            return false;
//        }}
//
//    @Override
//    public boolean onDrag(View view, DragEvent event) {
//        Drawable enterShape = getResources().getDrawable(
//                R.drawable.noun_101609_cc);
//        Drawable normalShape = getResources().getDrawable(R.drawable.food);
//
//        @Override
//        public boolean onDrag(View view, DragEvent event) {
//            int action = event.getAction();
//            switch (event.getAction()) {
//                case DragEvent.ACTION_DRAG_STARTED:
//                    // do nothing
//                    break;
//                case DragEvent.ACTION_DRAG_ENTERED:
//                    v.setBackgroundDrawable(enterShape);
//                    break;
//                case DragEvent.ACTION_DRAG_EXITED:
//                    v.setBackgroundDrawable(normalShape);
//                    break;
//                case DragEvent.ACTION_DROP:
//                    // Dropped, reassign View to ViewGroup
//                    View view = (View) event.getLocalState();
//                    ViewGroup owner = (ViewGroup) view.getParent();
//                    owner.removeView(view);
//                    LinearLayout container = (LinearLayout) v;
//                    container.addView(view);
//                    view.setVisibility(View.VISIBLE);
//                    break;
//                case DragEvent.ACTION_DRAG_ENDED:
//                    v.setBackgroundDrawable(normalShape);
//                default:
//                    break;
//            }
//            return true;
//        }
//    }
//        return false;
//    }
//}









           // }
//                if (touchFlag) {
//                    System.err.println("Display If  Part ::->" + touchFlag);
//                    switch (event.getActionMasked()) {
//                        case MotionEvent.ACTION_DOWN:
//                            topY = imageDrop.getTop();
//                            leftX = imageDrop.getLeft();
//                            rightX = imageDrop.getRight();
//                            bottomY = imageDrop.getBottom();
//                            break;
//                        case MotionEvent.ACTION_MOVE:
//                            eX = (int) event.getX();
//                            eY = (int) event.getY();
//                            int x = (int) event.getX() - offset_x;
//                            int y = (int) event.getY() - offset_y;
//                            int w = getWindowManager().getDefaultDisplay().getWidth();
//                            int h = getWindowManager().getDefaultDisplay().getHeight();
//                            if (x > w) x = w;
//                            if (y > h) y = h;
//                            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(new ViewGroup.MarginLayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
//                            lp.setMargins(x, y, 0, 0);
//
//                            if (eX > leftX && eX < rightX && eY > topY && eY < bottomY) {
//                                imageDrop.setBackgroundColor(Color.RED);
//                                selected_item.bringToFront();
//                                dropFlag = true;
//                            } else {
//                                imageDrop.setBackgroundColor(Color.BLUE);
//                            }
//                            selected_item.setLayoutParams(lp);
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            touchFlag = false;
//                            if (dropFlag) {
//                                dropFlag = false;
//                            } else {
//                                selected_item.setLayoutParams(imageParams);
//                            }
//                            break;
//                        default:
//                            break;
//                    }
//                }
//                return true;
//            }
//        });
//    }
//
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getActionMasked()) {
//            case MotionEvent.ACTION_DOWN:
//                touchFlag = true;
//                offset_x = (int) event.getX();
//                offset_y = (int) event.getY();
//                selected_item = v;
//                imageParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
//                break;
//            case MotionEvent.ACTION_UP:
//                selected_item = null;
//                touchFlag = false;
//                break;
//            default:
//                break;
//        }
//        return false;
                //}
            //}}


