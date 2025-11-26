package com.example.sample;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_splash extends AppCompatActivity {

    Handler handler;

    TextView textView;

    MediaPlayer mediaPlayer;

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.start();

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(activity_splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },8000);

        textView=findViewById(R.id.textView);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.move_up);
        textView.setAnimation(animation);
    }
}