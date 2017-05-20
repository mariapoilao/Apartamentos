package com.example.mariapoilao.apartamentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportePromedio extends AppCompatActivity {

    private TextView resul1, resul2, resul3, resul4, resul5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_promedio);

        resul1=(TextView)findViewById(R.id.txtResul1);
        resul2=(TextView)findViewById(R.id.txtResul2);
        resul3=(TextView)findViewById(R.id.txtResul3);
        resul4=(TextView)findViewById(R.id.txtResul4);
        resul5=(TextView)findViewById(R.id.txtResul5);




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
