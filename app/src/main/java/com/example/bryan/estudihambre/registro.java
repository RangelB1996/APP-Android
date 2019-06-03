package com.example.bryan.estudihambre;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    public int versionBD=2;
    public String nombreBD="Escuela";
    EditText txtnum_control;
    EditText txtnombre;
    EditText txtapellidos;
    EditText txtcorreo;
    EditText txtpass;
    EditText txtpass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final Button botonSas =(Button) findViewById(R.id.btn_sas);
        txtnum_control=(EditText) findViewById(R.id.edit_text_control);
        txtnombre=(EditText) findViewById(R.id.edit_text_nombre);
        txtapellidos=(EditText) findViewById(R.id.edit_text_apellido);
        txtcorreo=(EditText) findViewById(R.id.edit_text_correo);
        txtpass=(EditText) findViewById(R.id.edit_text_contrasenia);
        txtpass2=(EditText) findViewById(R.id.edit_text_contrasenia2);

    }
    public void registrar(View view) {
        if(txtpass.getText().toString().equals(txtpass2.getText().toString())){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,nombreBD, null, versionBD);
            SQLiteDatabase bd = admin.getWritableDatabase();
            ContentValues registro= new ContentValues();
            registro.put("num_control", Integer.parseInt(txtnum_control.getText().toString()));
            registro.put("nombre", txtnombre.getText().toString());
            registro.put("apellidos", txtapellidos.getText().toString());
            registro.put("correo", txtcorreo.getText().toString());
            registro.put("pass", txtpass.getText().toString());
            bd.insert("usuarios", null, registro);
            bd.close();
            Toast.makeText(this, "USUARIO REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            finish();
            Intent inst=new Intent(registro.this,inicio.class);
            startActivity(inst);
        }else{
            Toast.makeText(this, "CONTRASEÑAS NO COINCIDEN"+txtpass.getText().toString()+" "+txtpass2.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}