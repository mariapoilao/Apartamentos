package com.example.mariapoilao.apartamentos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Reportes extends AppCompatActivity {

    private ArrayList<Apartamento> apartamento;
    int cont=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);




    }

    public void reporteUno(View v){

        int a=0;

        a= Datos.caracteristica(getApplicationContext());
        if (a>=0){

            Toast.makeText(getApplicationContext(), this.getResources().getString(R.string.mensaje1)+a,
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void reporteDos(View v){

        String a="";

        a = Datos.mayor(getApplicationContext());

        if(a!=null){

            Toast.makeText(getApplicationContext(), this.getResources().getString(R.string.mensaje2)+a,
                    Toast.LENGTH_SHORT).show();

        }



    }

    public void ReporteTres(View v){

        String a;

        a = Datos.tamano(getApplicationContext());

        if(a!=null){

            Toast.makeText(getApplicationContext(), this.getResources().getString(R.string.mensaje3)+a,
                    Toast.LENGTH_SHORT).show();

        }

    }




}
