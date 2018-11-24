package com.example.noname.ttnm12;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    Button btnExit;
    VideoView videoDrone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        btnExit = (Button) findViewById(R.id.button_exit_video);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        videoDrone = (VideoView) findViewById(R.id.video);
        videoDrone.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        videoDrone.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoDrone.start();
    }
}
