package com.example.arknightsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.animation.TranslateAnimation;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.AlphaAnimation;

public class Loading_Page extends AppCompatActivity {



    VideoView videoView;
    Button Screentouch;
    ImageButton animationButton;
    AnimationSet animationSet;

    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);



        animationButton = findViewById(R.id.animatedButton);
        videoView = findViewById(R.id.BackgroundVideo);
        Screentouch = findViewById(R.id.ScreenButton);

        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.nianbackground);
        videoView.setVideoURI(uri);
        videoView.start();



        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                startAnimation();
                handler.postDelayed(this, 2000); // ให้ Animation เริ่มต้นทุก 2 วินาที
            }
        };

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        Screentouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent GotoPageMainMenuPage = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(GotoPageMainMenuPage);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });

        AnimationSet animationSet = new AnimationSet(true);

        // Animation for zooming in
        Animation zoomInAnimation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomInAnimation.setDuration(1000); // 1 second

        // Animation for fading out
        Animation fadeOutAnimation = new AlphaAnimation(1f, 0f);
        fadeOutAnimation.setDuration(1000); // 1 second
        fadeOutAnimation.setStartOffset(1000); // Start after zoom in animation

        // Add animations to AnimationSet
        animationSet.addAnimation(zoomInAnimation);
        animationSet.addAnimation(fadeOutAnimation);

        // Repeat the animation forever
        animationSet.setRepeatCount(Animation.INFINITE);

        // Start animation

        startContinuousAnimation();

        // Initialize animation set
        // Start animation when the activity starts
        //บรรทัดล่างนี้คือ animation
        // initializeAnimation();
        // animationButton.startAnimation(animationSet);




    }

    private void startAnimation() {
        Animation animation = new TranslateAnimation(0, 0, 0, 50);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);

        animationButton.startAnimation(animation);
    }

    private void startContinuousAnimation() {
        AnimationSet animationSet = new AnimationSet(true);

        // Animation for zooming in
        Animation zoomInAnimation = new ScaleAnimation(0.75f, 1.25f, 0.75f, 1.25f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomInAnimation.setDuration(1500); // 1.5 second

        // Animation for fading out
        Animation fadeOutAnimation = new AlphaAnimation(1f, 0f);
        fadeOutAnimation.setDuration(500); // 0.5 second
        fadeOutAnimation.setStartOffset(500); // Start after zoom in animation

        // Add animations to AnimationSet
        animationSet.addAnimation(zoomInAnimation);
        animationSet.addAnimation(fadeOutAnimation);

        // Set up animation listener to start animation again when it ends
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Start animation again when it ends
                animationButton.startAnimation(animationSet);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        // Start animation
        animationButton.startAnimation(animationSet);
    }

    @Override
    protected void onResume() {
        videoView.resume();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        videoView.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }



    //animation pack

    private void initializeAnimation() {
        // Animation for zooming in
        Animation zoomInAnimation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomInAnimation.setDuration(500); // 500 milliseconds

        // Animation for zooming out
        Animation zoomOutAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomOutAnimation.setDuration(500); // 500 milliseconds
        zoomOutAnimation.setStartOffset(500); // Start after zoom in animation

        // Animation for fading out
        Animation fadeOutAnimation = new AlphaAnimation(1f, 0f);
        fadeOutAnimation.setDuration(500); // 500 milliseconds
        fadeOutAnimation.setStartOffset(1000); // Start after zoom out animation

        // Combine all animations
        animationSet = new AnimationSet(true);
        animationSet.addAnimation(zoomInAnimation);
        animationSet.addAnimation(zoomOutAnimation);
        animationSet.addAnimation(fadeOutAnimation);

        // Set animation listener to restart animation when it ends
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation started
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation ended, restart animation
                animationButton.startAnimation(animationSet);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeated
            }
        });
    }
}