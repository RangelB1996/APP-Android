package com.example.bryan.estudihambre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class busqueda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        final Button programas =(Button) findViewById(R.id.btn_prog);
        programas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(busqueda.this,programacion.class);
                startActivity(inst);
            }
        });
        final Button sql =(Button) findViewById(R.id.btn_bd);
        sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(busqueda.this,sql.class);
                startActivity(inst);
            }
        });
        final Button sim =(Button) findViewById(R.id.bsim);
        sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(busqueda.this,simulacion.class);
                startActivity(inst);
            }
        });
        final Button mn =(Button) findViewById(R.id.bmn);
        mn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(busqueda.this,numericos.class);
                startActivity(inst);
            }
        });
        final Button mate =(Button) findViewById(R.id.btn_mat);
        mate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(busqueda.this,mate.class);
                startActivity(inst);
            }
        });
}
}
