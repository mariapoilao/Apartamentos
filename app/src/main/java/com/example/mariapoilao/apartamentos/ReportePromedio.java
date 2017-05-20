package com.example.mariapoilao.apartamentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ReportePromedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_promedio);


    }

    public void ReporteCuatro(View v){

        ArrayList<Apartamento> apartamentos;

        apartamentos=Datos.traerApartamentos(getApplicationContext());

        int promedio=0, cont=0, aux, tam, suma =0;
        aux=apartamentos.size();

        for (int i = 0; i < aux; i++) {
            tam=Integer.parseInt(apartamentos.get(i).getTamaño());


            if (apartamentos.get(i).getPiso().equals(this.getResources().getString(R.string.piso4))){

                suma = suma + tam;

            }
            promedio= suma/aux;

        }



    }
}
