package com.example.mariapoilao.apartamentos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mariapoilao on 18/05/17.
 */

public class Apartamento {

    private String nomenclatura;
    private String tamaño;
    private String precio;
    private String piso;
    private String caracteristica;

    public Apartamento(String nomenclatura, String tamaño, String precio, String piso, String caracteristica) {
        this.nomenclatura = nomenclatura;
        this.tamaño = tamaño;
        this.precio = precio;
        this.piso = piso;
        this.caracteristica = caracteristica;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }


    public void guardar(Context contexto){

        SQLiteDatabase db;
        String sql;

        ApartamentosSQLiteOpenHelper  aux = new ApartamentosSQLiteOpenHelper(contexto,"DBApartamentos",null,2);
        db = aux.getWritableDatabase();

        sql = "INSERT INTO Apartamentos values('"
                +this.getNomenclatura()+"','"
                +this.getTamaño()+"','"
                +this.getPrecio()+"','"
                +this.getPiso()+"','"
                +this.getCaracteristica()+"')";

        db.execSQL(sql);

        db.close();

    }


    }
