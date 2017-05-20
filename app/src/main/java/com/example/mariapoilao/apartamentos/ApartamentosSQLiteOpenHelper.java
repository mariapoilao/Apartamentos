package com.example.mariapoilao.apartamentos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mariapoilao on 18/05/17.
 */

public class ApartamentosSQLiteOpenHelper extends SQLiteOpenHelper {

    private String sql = "CREATE TABLE Apartamentos(nomenclatura text not null unique, tamaño text, precio text, piso text, caracteristica text)";

    public ApartamentosSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Apartamentos");
        db.execSQL(sql);
    }


}
