package com.example.bryan.estudihambre;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class pendientes extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public int version = 2;
    public String nombre = "Escuela",tarea;
    private TextView textViewClaveTarea;
    private TextView textViewClaveMateria;
    private TextView textViewFecha;
    private TextView textViewDetalle;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendientes);
        textViewClaveTarea = (TextView) findViewById(R.id.text_view_clave_Tarea);
        textViewClaveMateria = (TextView) findViewById(R.id.text_view_clave_mate);
        textViewFecha = (TextView) findViewById(R.id.text_view_fecha);
        textViewDetalle = (TextView) findViewById(R.id.text_view_detalle);
        spinner1=(Spinner) findViewById(R.id.spinnertarea);
        spinner1.setOnItemSelectedListener(this);
        CargarSpinnerTarea();
    }

    private void CargarSpinnerTarea() {
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(this,
                nombre,null,version);
        List<String> labels =admin.gettodaslastareas();
        ArrayAdapter<String> dataAdapter =new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,labels);
        dataAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public void buscarClaveTarea(View view){
        AdminSQLiteOpenHelper sqLiteOpenHelper = new AdminSQLiteOpenHelper(this,nombre,null, version);
        SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from tarea where clave_tarea = "+tarea, null);
        if (cursor.moveToFirst()) {
            textViewClaveTarea.setText(cursor.getString(0));
            textViewClaveMateria.setText(cursor.getString(1));
            textViewFecha.setText(cursor.getString(2));
            cursor = sqLiteDatabase.rawQuery("select detalle from detalle_tarea where clave_tarea = "+tarea, null);
            cursor.moveToFirst();
            textViewDetalle.setText("");
            do {
                textViewDetalle.setText(textViewDetalle.getText().toString() + "Detalle: " + cursor.getString(0) + "\n");
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(this, "No existe la tarea :)", Toast.LENGTH_SHORT).show();
            textViewClaveTarea.setText("");
            textViewClaveMateria.setText("");
            textViewFecha.setText("");
            textViewDetalle.setText("");
        }
        sqLiteOpenHelper.close();
    }

    public void salir(View view){
        Intent intent = new Intent(this, Tareas.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (spinner1.isClickable()){
            tarea=parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
