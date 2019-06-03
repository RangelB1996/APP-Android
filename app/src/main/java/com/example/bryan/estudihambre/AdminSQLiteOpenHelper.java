package com.example.bryan.estudihambre;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryan on 2/05/18.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory
            factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table materias ( id int primary key,"+
                ""+ "nombre text not null, maestro text)");

        db.execSQL("Create table tarea ( clave_tarea integer primary key,"+
                ""+ "clave_mat int , fecha datetime)");

        db.execSQL("Create table detalle_tarea ( clave_det integer primary key autoincrement,"+
                "clave_tarea integer , detalle text ,"+
                "foreign key (clave_tarea) references tarea (clave_tarea))");

        db.execSQL("Create table usuarios ( num_control int primary key,"+
                ""+ "nombre text not null, apellidos text, correo text, pass text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists materias");
        db.execSQL("drop table if exists tarea");
        db.execSQL("drop table if exists detalle_tarea");
        db.execSQL("drop table if exists usuarios");
        onCreate(db);
    }

    public List<String> gettodaslasmaterias(){
        List<String> list=new ArrayList<String>();
        String selectQuery="select * from materias";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                list.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
    public List<String> gettodaslastareas(){
        List<String> list=new ArrayList<String>();
        String selectQuery="select * from tarea";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                list.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
