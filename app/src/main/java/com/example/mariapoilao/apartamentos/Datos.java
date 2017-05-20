package com.example.mariapoilao.apartamentos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by mariapoilao on 18/05/17.
 */

public class Datos {

    public static ArrayList<Apartamento> traerApartamentos(Context contexto){
        ArrayList<Apartamento> apartamentos = new ArrayList<>();

        SQLiteDatabase db;
        String sql, nomenclatura, tamaño, precio, piso, caracteristica;
        Apartamento a;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,2);
        db = aux.getReadableDatabase();

        sql ="select * from Apartamentos";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                nomenclatura = c.getString(0);
                tamaño = c.getString(1);
                precio =c.getString(2);
                piso = c.getString(3);
                caracteristica = c.getString(4);
                a = new Apartamento(nomenclatura,tamaño,precio,piso,caracteristica);
                apartamentos.add(a);

            }while (c.moveToNext());
        }

        db.close();

        return apartamentos;

    }


    public static boolean validar(Context contexto, String nome) {

        SQLiteDatabase db;
        String  sql;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,2);
        db = aux.getReadableDatabase();

        sql ="select * from Apartamentos where nomenclatura ='"+nome+"'";
        Cursor c = db.rawQuery(sql,null);
        if(c.moveToFirst()){

            return false;
        }

        db.close();
        return true;


    }


    public static  int caracteristica(Context contexto) {

        SQLiteDatabase db;
        String  sql;
        int cont=0;

        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,2);
        db = aux.getReadableDatabase();

        sql ="select * from Apartamentos where caracteristica = 'Balcon, Sombra'";
        Cursor c = db.rawQuery(sql,null);
        cont = c.getCount();
        db.close();
        return cont;

    }

    public static  String mayor(Context contexto) {

        SQLiteDatabase db;
        String  sql, piso;


        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,2);
        db = aux.getReadableDatabase();

        sql ="SELECT * FROM Apartamentos ORDER BY precio DESC LIMIT 1";
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        piso=c.getString(3);
        db.close();

        return piso;
    }

    public static  String tamano(Context contexto) {

        SQLiteDatabase db;
        String  sql, nome;


        ApartamentosSQLiteOpenHelper aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,2);
        db = aux.getReadableDatabase();

        sql ="SELECT * FROM Apartamentos ORDER BY tamaño DESC LIMIT 1";
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        nome=c.getString(0);
        db.close();
        return nome;
    }

}
