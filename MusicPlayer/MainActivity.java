package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start, stop;
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        start.setOnClickListener(v -> {
            music.start();
        });

        stop.setOnClickListener(v -> {
            music.stop();
        });
    }
}