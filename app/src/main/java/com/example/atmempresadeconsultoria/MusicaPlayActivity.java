package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicaPlayActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica_play);
        play = findViewById(R.id.btPlay);
        mediaPlayer = MediaPlayer.create(MusicaPlayActivity.this, R.raw.drakestartedfromthebottomexplicit);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    pausarMusica();
                } else {
                    tocarMusica();
                }
            }
        });
    }

    public void tocarMusica(){
        if(mediaPlayer != null) {
            mediaPlayer.start();
            play.setText("Pausar");
        }
    }

    public void pausarMusica() {
        if(mediaPlayer != null) {
            mediaPlayer.pause();
            play.setText("Play");
        }
    }

    // sobre escrita para limpar o cache de memoria do celular
    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
