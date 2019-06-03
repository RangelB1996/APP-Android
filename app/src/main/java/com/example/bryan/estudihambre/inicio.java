package com.example.bryan.estudihambre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        final Button boton =(Button) findViewById(R.id.btn_registro);
        final Button boton1 =(Button) findViewById(R.id.btn_ingreso);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(inicio.this,registro.class);
                startActivity(inst);
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inst=new Intent(inicio.this,login.class);
                startActivity(inst);
            }
        });
    }
}