package com.example.a41665767.tp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 41665767 on 12/7/2016.
 */
public class Base extends SQLiteOpenHelper {
    public Base (Context contexto, String nombre, SQLiteDatabase.CursorFactory fabrica, int version)
    {
        super(contexto, nombre, fabrica, version);

    }
    @Override
    public void onCreate(SQLiteDatabase basedatos) {
        Log.d("SQLite", "Crear tabla Jugadas");
        String sqlCrearTablaJugadas;
        sqlCrearTablaJugadas = "create table jugadas (nombre text, secuencia text, cantmov integer)";

        Log.d("SQLite", "Creador de tabla");
        basedatos.execSQL(sqlCrearTablaJugadas);

        Log.d("SQLite", "Fin de creacion");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
