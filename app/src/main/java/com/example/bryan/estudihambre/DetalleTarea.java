package com.example.bryan.estudihambre;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class DetalleTarea extends AppCompatActivity{
    Spinner opciones;
    int clave_tarea;
    String materia;
    String fecha;
    String detalle;

    EditText txtfecha;
    EditText txtnumtarea;
    EditText txtmat;
    EditText txtdetalle;
    Button botoncancelar2;
    Button botonguardar;
    Button botonagregar;

    private Spinner spinner2;
    String prod;

    int clave_prod;
    int cantidad;

    EditText tCantidad,txtdetalle_tarea;
    double precio,sumatotal;
    EditText tdetalle;
    String descripcionprod;

    String [][] arreglo =new String[100][4];
    int i=0;
    public int versionBD=2;
    public String nombreBD="Escuela";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tarea);
        opciones=(Spinner) findViewById(R.id.spinnertrabajo);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.opciones,android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
        botonagregar=(Button) findViewById(R.id.botonAgregar);
        botoncancelar2=(Button) findViewById(R.id.botonCancelar2);
        botonguardar=(Button) findViewById(R.id.botonGuardar);
        txtnumtarea=(EditText) findViewById(R.id.txtnumtarea);
        txtfecha=(EditText) findViewById(R.id.txtfechatarea);
        txtmat=(EditText) findViewById(R.id.txtmateria);
        txtdetalle=(EditText) findViewById(R.id.txtdetalle);
        txtdetalle_tarea=(EditText) findViewById(R.id.txtdetalle_tarea);

        clave_tarea=Integer.parseInt(getIntent().getStringExtra("tarea"));
        materia=getIntent().getStringExtra("materia");
        fecha=getIntent().getStringExtra("fecha");

        txtnumtarea.setText(""+clave_tarea);
        txtfecha.setText(fecha);
        txtmat.setText(materia);

        tdetalle=(EditText) findViewById(R.id.txtdetalle);
        tdetalle.setText("");

    }
    public void cancelar(View v){finish();}

    public void guardarPedido(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,nombreBD, null, versionBD);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro= new ContentValues();
        registro.put("clave_tarea", clave_tarea);
        registro.put("clave_mat", materia);
        registro.put("fecha", fecha);
        bd.insert("tarea", null, registro);
        bd.close();

        AdminSQLiteOpenHelper admin2 = new AdminSQLiteOpenHelper(this,nombreBD,null, versionBD);
        SQLiteDatabase bd2= admin2.getWritableDatabase();

            ContentValues registro2= new ContentValues();
            String detalle = txtdetalle.getText().toString();
            registro2.put("clave_tarea", clave_tarea);
            registro2.put("detalle",detalle);
            bd2.insert("detalle_tarea", null, registro2);

        bd2.close();
        Toast.makeText(this, "Tarea Guardada guardado", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void AgregarProductosalPedido(View v){
        try {
            String tar=opciones.getSelectedItem().toString();
            tdetalle.setText("");
            for (int j = 0; j <= i; j++) {
                tdetalle.setText(tdetalle.getText() + tar + "             " + txtdetalle_tarea.getText().toString() +"\n");
            }
            i++;
            tCantidad.setText("");

        }catch(Exception e){
        }
    }
    public void cerrar(View v){
        finish();
    }

}
