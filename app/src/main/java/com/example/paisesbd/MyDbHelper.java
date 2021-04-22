package com.example.paisesbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "paises.db";

    public MyDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pais (Id INTEGER PRIMARY KEY, Nombre TEXT, Longitud INTEGER, Latitud INTEGER, Poblacion INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists pais");
        onCreate(db);
    }
    public void InsertPais(SQLiteDatabase db, Paises paises){
        ContentValues values= new ContentValues();
        values.put("Id", paises.getId());
        values.put("Nombre", paises.getNombre());
        values.put("Longitud", paises.getLongitud());
        values.put("Latitud", paises.getLatitud());
        values.put("Poblacion", paises.getPoblacion());
        db.insert("pais",null, values);
    }

    public ArrayList<Paises> selectPais(SQLiteDatabase db){
        ArrayList<Paises> paises = new ArrayList<Paises>();
        Cursor filas = db.rawQuery("Select * from pais", null);
        if (filas.moveToFirst()){
            do{
                Paises pais = new Paises(filas.getInt(0), filas.getString(1), filas.getDouble(2), filas.getDouble(3), filas.getInt(4));
                paises.add(pais);
            }while (filas.moveToNext());
        }
        return paises;
    }
}
