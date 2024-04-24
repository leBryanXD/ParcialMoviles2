package com.example.pianogrupo02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;

public class PianoInstrumentos extends AppCompatActivity {

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
}