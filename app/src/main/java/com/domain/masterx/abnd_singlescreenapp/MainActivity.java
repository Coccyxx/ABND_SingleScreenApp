package com.domain.masterx.abnd_singlescreenapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable pacmanAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView pacmanImage = (ImageView) findViewById(R.id.pacman_image);
        pacmanImage.setBackgroundResource(R.drawable.pacman_animation);
        pacmanAnimation = (AnimationDrawable) pacmanImage.getBackground();
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (pacmanAnimation.isRunning()) {
                pacmanAnimation.stop();
            }
            else {
                pacmanAnimation.start();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override      //For playing the animation immediately, without requiring interaction
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
            pacmanAnimation.start();

    }

}
