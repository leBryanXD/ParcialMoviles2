package com.example.pianogrupo02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class PianoInstrumentos extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_instrumentos);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int itemId = item.getItemId();
        if (itemId == R.id.info) {
            Intent pantalla = new Intent(PianoInstrumentos.this,Info.class);
            finish();
            startActivity(pantalla);
        } else if (itemId == R.id.cerrar) {
            finish();
        } else if (itemId == R.id.pianoTradicional) {
            Intent pantalla = new Intent(PianoInstrumentos.this,MainActivity.class);
            finish();
            startActivity(pantalla);
        } else if (itemId == R.id.pianoSelvatico) {
            Intent pantalla = new Intent(PianoInstrumentos.this,PianoSelvatico.class);
            finish();
            startActivity(pantalla);
        } else if (itemId == R.id.pianoInstrumentos) {
            Snackbar.make(findViewById(android.R.id.content), "Ya te encuentras en piano de instrumentos.", Snackbar.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
    public void playAnimal(int soundResourceId) {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(PianoInstrumentos.this, soundResourceId);
        try {
            mediaPlayer.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
    public void serpiente(View v) {
        playAnimal(R.raw.tambores);
    }
    public void tigre(View v) {
        playAnimal(R.raw.trompeta);
    }
    public void mono(View v) {
        playAnimal(R.raw.maracas);
    }
    public void mapache(View v) {
        playAnimal(R.raw.violin);
    }
    public void cocodrilo(View v) {
        playAnimal(R.raw.guitarra);
    }
    public void oso(View v) {
        playAnimal(R.raw.pandereta);
    }
    public void elefante(View v) {
        playAnimal(R.raw.acordeon);
    }

}