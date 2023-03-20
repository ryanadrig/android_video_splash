package com.example.splash_screen_vid_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.content.Intent
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

import android.widget.VideoView

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        VideoView videoView;

            setContentView(R.layout.activity_splash);
            videoView = (VideoView) findViewById(R.id.videoView);

            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hello);
            videoView.setVideoURI(video);

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    startNextActivity();
                }
            });

            videoView.start();


        private void startNextActivity() {
            if (isFinishing())
                return;
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000) // 3000 is the delayed time in milliseconds.
    }
}