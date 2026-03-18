package com.example.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Boolean isPlaying = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainActivity context = this;

        String imageUrl = "https://cdnphoto.dantri.com.vn/dKwEgIQxv3uy11cnK2u6MzeHakA=/thumb_w/1920/2024/02/08/truong-dinh-minh-1707392151116.jpeg";

        MyThread myThread = new MyThread(imageUrl, this);
        myThread.start();


        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {


            if (isPlaying) {

                if (MyService.mediaPlayer != null && MyService.mediaPlayer.isPlaying()) {

                    MyService.mediaPlayer.pause();

                    isPlaying = false;

                    button.setText("Play");

                }

            } else {

                startService(new Intent(this, MyService.class));

                isPlaying = true;

                button.setText("Pause");

                //updateSeekBar();

            }


        });



    }
}