package com.example.bryan.estudihambre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class Tareas extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner1;
    EditText txtfechatarea;
    EditText txtnumtarea;
    String materia;
    public int versionBD=2;
    public String nombreBD="Escuela";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        txtnumtarea=(EditText) findViewById(R.id.txtnumtarea);
        txtfechatarea=(EditText) findViewById(R.id.txtfechatarea);
        spinner1=(Spinner) findViewById(R.id.spinnermat);
        spinner1.setOnItemSelectedListener(this);
        CargarSpinnerMat();
    }

    private void CargarSpinnerMat() {
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(this,
                nombreBD,null,versionBD);
        List<String> labels =admin.gettodaslasmaterias();
        ArrayAdapter<String> dataAdapter =new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,labels);
        dataAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (spinner1.isClickable()){
            materia=parent.getItemAtPosition(position).toString();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    public void nuevaTarea(View v){
        String clave_tarea=txtnumtarea.getText().toString();
        String fecha_tarea=txtfechatarea.getText().toString();
        Intent i =new Intent(this,DetalleTarea.class);
        i.putExtra("tarea",clave_tarea);
        i.putExtra("materia",materia);
        i.putExtra("fecha",fecha_tarea);
        startActivity(i);
        finish();
    }
    public void cerrar(View v){
        finish();
    }
    public void pendientes(View v){
        Intent i =new Intent(this,pendientes.class);
        startActivity(i);
    }

}
