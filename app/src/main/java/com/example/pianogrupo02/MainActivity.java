package com.example.pianogrupo02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.info) {
            startActivity(new Intent(MainActivity.this, Info.class));
            finish();
        } else if (itemId == R.id.cerrar) {
            finish();
        } else if (itemId == R.id.pianoTradicional) {
            Snackbar.make(findViewById(android.R.id.content), "Ya te encuentras en el piano tradicional.", Snackbar.LENGTH_SHORT).show();
        } else if (itemId == R.id.pianoSelvatico) {
            startActivity(new Intent(MainActivity.this, PianoSelvatico.class));
            finish();
        } else if (itemId == R.id.pianoInstrumentos) {
            startActivity(new Intent(MainActivity.this, PianoInstrumentos.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void playSound(int soundResourceId, String noteName) {
        Toast.makeText(getApplicationContext(), noteName, Toast.LENGTH_SHORT).show();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(MainActivity.this, soundResourceId);
        try {
            mediaPlayer.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void playDo(View v) {
        playSound(R.raw.notado, "DO");
    }

    public void playRe(View v) {
        playSound(R.raw.notare, "Re");
    }

    public void playMi(View v) {
        playSound(R.raw.notami, "Mi");
    }

    public void playFa(View v) {
        playSound(R.raw.notafa, "Fa");
    }

    public void playSol(View v) {
        playSound(R.raw.notasol, "Sol");
    }

    public void playLa(View v) {
        playSound(R.raw.notala, "La");
    }

    public void playSi(View v) {
        playSound(R.raw.notasi, "Si");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
