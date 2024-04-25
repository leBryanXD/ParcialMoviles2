package com.example.pianogrupo02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class PianoSelvatico extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_selvatico);
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
            Intent pantalla = new Intent(PianoSelvatico.this,Info.class);
            finish();
            startActivity(pantalla);
        } else if (itemId == R.id.cerrar) {
            finish();
        } else if (itemId == R.id.pianoTradicional) {
            Intent pantalla = new Intent(PianoSelvatico.this,MainActivity.class);
            finish();
            startActivity(pantalla);
        } else if (itemId == R.id.pianoSelvatico) {
            Snackbar.make(findViewById(android.R.id.content), "Ya te encuentras en el piano selvático.", Snackbar.LENGTH_SHORT).show();
        } else if (itemId == R.id.pianoInstrumentos) {
            Intent pantalla = new Intent(PianoSelvatico.this,PianoInstrumentos.class);
            finish();
            startActivity(pantalla);
        }
        return super.onOptionsItemSelected(item);
    }

    public void playAnimal(int soundResourceId) {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(PianoSelvatico.this, soundResourceId);
        try {
            mediaPlayer.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
    public void serpiente(View v) {
        playAnimal(R.raw.serpiente);
    }
    public void tigre(View v) {
        playAnimal(R.raw.tigre);
    }
    public void mono(View v) {
        playAnimal(R.raw.mono);
    }
    public void mapache(View v) {
        playAnimal(R.raw.mapache);
    }
    public void cocodrilo(View v) {
        playAnimal(R.raw.cocodrilo);
    }
    public void oso(View v) {
        playAnimal(R.raw.oso);
    }
    public void elefante(View v) {
        playAnimal(R.raw.elefante);
    }






}