package com.example.bryan.estudihambre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class juego extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_juego);
        }

    public void level1(View view){
        Intent intent = new Intent(juego.this, tablero.class);
        intent.putExtra("variable_nivel", 1);
        startActivity(intent);
    }
    public void level2(View view){
        Intent intent = new Intent(juego.this, tablero.class);
        intent.putExtra("variable_nivel", 2);
        startActivity(intent);
    }
    public void level3(View view){
        Intent intent = new Intent(juego.this, tablero.class);
        intent.putExtra("variable_nivel", 3);
        startActivity(intent);
    }
    public void level4(View view){
        Intent intent = new Intent(juego.this, tablero.class);
        intent.putExtra("variable_nivel", 4);
        startActivity(intent);
    }
    public void level5(View view){
        Intent intent = new Intent(juego.this, tablero.class);
        intent.putExtra("variable_nivel", 5);
        startActivity(intent);
    }
    }

