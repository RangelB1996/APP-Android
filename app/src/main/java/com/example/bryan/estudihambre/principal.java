package com.example.bryan.estudihambre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class principal extends AppCompatActivity {
int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toast.makeText(this, "BIENVENIDO ESTUDIHAMBRE :)", Toast.LENGTH_SHORT).show();
        final Button buscar =(Button) findViewById(R.id.btn_busca);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(principal.this,busqueda.class);
                startActivity(inst);
            }
        });
        final Button libros =(Button) findViewById(R.id.btn_lib);
        libros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(principal.this,biblioteca.class);
                startActivity(inst);
            }
        });
        final Button tarea =(Button) findViewById(R.id.btn_tareas);
        tarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(principal.this,Tareas.class);
                startActivity(inst);
            }
        });
        final Button juego =(Button) findViewById(R.id.btn_juego);
        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador>=7){
                    Intent inst=new Intent(principal.this,juego.class);
                    startActivity(inst);
                }
                else{
                    contador++;
                }
            }
        });
        final Button materias =(Button) findViewById(R.id.btn_mat);
        materias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(principal.this,Materias.class);
                startActivity(inst);
            }
        });
        final Button videos =(Button) findViewById(R.id.btn_vid);
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(principal.this,videos.class);
                startActivity(inst);
            }
        });
        final Button calcular =(Button) findViewById(R.id.btn_calc);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(principal.this,calculadora.class);
                startActivity(inst);
            }
        });
    }
}