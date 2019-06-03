package com.example.bryan.estudihambre;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Materias extends AppCompatActivity {
    private EditText editTextid,editTextnombre,editTextmaestro;
    public int versionBD=2;
    public String nombreBD="Escuela";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);
        editTextid=(EditText) findViewById(R.id.txtid);
        editTextnombre=(EditText) findViewById(R.id.txtnombre);
        editTextmaestro=(EditText) findViewById(R.id.txtMaestro);
    }
    public void alta(View v){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper
                (this,nombreBD,null,versionBD);
        SQLiteDatabase bd=admin.getReadableDatabase();
        String id =editTextid.getText().toString();
        String nombre =editTextnombre.getText().toString();
        String maestro = editTextmaestro.getText().toString();
        Cursor fila=bd.rawQuery("select nombre, maestro " +
                "from materias where id = " + id,null);
        if (fila.moveToFirst()){Toast.makeText(this,"Error id de materia ya existente",Toast.LENGTH_SHORT).show();}
        else{
            if(id.length()>0&&nombre.length()>0&&maestro.length()>0){
                ContentValues registro = new ContentValues();
                registro.put("id",id);
                registro.put("nombre",nombre);
                registro.put("maestro",maestro);
                bd.insert("materias",null,registro);
                bd.close();
                editTextmaestro.setText("");
                editTextnombre.setText("");
                editTextid.setText("");
                Toast.makeText(this,"Materia Guardada",Toast.LENGTH_SHORT).show();
            }else{Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_SHORT).show();}
        }
    }

    public void eliminar(View v){
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper
                (this,nombreBD,null,versionBD);
        SQLiteDatabase bd =admin.getWritableDatabase();
        String id=editTextid.getText().toString();
        if(id.length()>0){
            int cantidad=bd.delete("materias","id ="
                    + id,null);
            if (cantidad==1)
                Toast.makeText(this,"Se ha eliminado la materia"
                        +id,Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"No existe la Materia con ese id"+id,Toast.LENGTH_SHORT).show();
            bd.close();
            editTextid.setText("");
            editTextnombre.setText("");
            editTextmaestro.setText("");
        }else{Toast.makeText(this,"Inserte id",Toast.LENGTH_SHORT).show();}

    }
    public void modificar (View v){
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper
                (this,nombreBD,null,versionBD);
        SQLiteDatabase bd =admin.getWritableDatabase();
        String id=editTextid.getText().toString();
        String nombre=editTextnombre.getText().toString();
        String maestro=editTextmaestro.getText().toString();
        if(id.length()>0){
            ContentValues registro =new ContentValues();
            registro.put("id",id);
            registro.put("nombre",nombre);
            registro.put("maestro",maestro);
            int cantidad= bd.update("materias",registro,"id = "
                    +id,null);
            if(cantidad==1)
                Toast.makeText(this,"Se ha modificado la materia "+id,Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"No existe la materia "+id,Toast.LENGTH_SHORT).show();
            bd.close();
            editTextmaestro.setText("");
            editTextnombre.setText("");
            editTextid.setText("");
        }else{Toast.makeText(this,"Inserte clave",Toast.LENGTH_SHORT).show();}


    }
    public void cerrar(View v){finish();}
}
