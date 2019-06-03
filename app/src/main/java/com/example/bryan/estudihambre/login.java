package com.example.bryan.estudihambre;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText editTextControl, editTextContrasenia;
    public static String PREFERENCIAS = "Preferencias";
    public static String CONTROL = "NombreControl";
    public static String CONTRASENIA = "ContraseniaClave";
    EditText txtcontrol;
    EditText txtpass;
    public int version = 2;
    public String nombre = "Escuela";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtcontrol=(EditText) findViewById(R.id.tx_control);
        txtpass=(EditText) findViewById(R.id.tx_contra);
        editTextControl=(EditText) findViewById(R.id.tx_control);
        editTextContrasenia=(EditText) findViewById(R.id.tx_contra);
        sharedPreferences = getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        leer();


    }

    private void leer() {
        String control = sharedPreferences.getString(CONTROL, "");
        editTextControl.setText(control);
        String contrasenia = sharedPreferences.getString(CONTRASENIA, "");
        editTextContrasenia.setText(contrasenia);


    }

    public void logeo(View v){
        AdminSQLiteOpenHelper sqLiteOpenHelper = new AdminSQLiteOpenHelper(this,nombre,null, version);
        SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from usuarios where num_control = "+txtcontrol.getText() +" AND pass = "+"'"+txtpass.getText().toString()+"'", null);
        if (cursor.moveToFirst()) {
            Intent inst=new Intent(login.this,principal.class);
            startActivity(inst);
        } else {
            Toast.makeText(this, "Error usuario y/o contraseña invalidos", Toast.LENGTH_SHORT).show();
        }
        sqLiteOpenHelper.close();
    }
    public void guardar(View v){

        String control = editTextControl.getText().toString();
        String contrasenia = editTextContrasenia.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CONTROL, control);
        editor.putString(CONTRASENIA, contrasenia);
        editor.commit();
    }
    public void limpiar(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(CONTROL);
        editor.remove(CONTRASENIA);
        editor.commit();
        editTextControl.setText("");
        editTextContrasenia.setText("");
        Toast.makeText(this, "Se eliminó la configuración.", Toast.LENGTH_SHORT).show();
    }
}
