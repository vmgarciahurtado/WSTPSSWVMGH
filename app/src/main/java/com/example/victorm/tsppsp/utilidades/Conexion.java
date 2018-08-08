package com.example.victorm.tsppsp.utilidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {
    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Datos.CREAR_TABLA_TIMELOG);
        db.execSQL(Datos.CREAR_TABLA_DEFECTLOG);
        db.execSQL(Datos.CREAR_TABLA_PROYECTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Datos.TABLA_TIMELOG);
        db.execSQL("DROP TABLE IF EXISTS " + Datos.TABLA_DEFECTLOG);
        db.execSQL("DROP TABLE IF EXISTS " + Datos.TABLA_PROYECTOS);
        onCreate(db);
    }
}
