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

        int promedio1=0, promedio2=0, promedio3=0, promedio4=0, promedio5=0, cont=0, aux, tam, suma1 =0, suma2=0, suma3=0, suma4=0, suma5=0;
        aux=apartamentos.size();

        for (int i = 0; i < aux; i++) {
            tam=Integer.parseInt(apartamentos.get(i).getTamaño());


            if (apartamentos.get(i).getPiso().equals(this.getResources().getString(R.string.piso1))){

                suma1 = suma1 + tam;

            }

            if (apartamentos.get(i).getPiso().equals(this.getResources().getString(R.string.piso2))){

                suma2 = suma2 + tam;

            }

            if (apartamentos.get(i).getPiso().equals(this.getResources().getString(R.string.piso3))){

                suma3 = suma3 + tam;

            }

            if (apartamentos.get(i).getPiso().equals(this.getResources().getString(R.string.piso4))){

                suma4 = suma4 + tam;

            }

            if (apartamentos.get(i).getPiso().equals(this.getResources().getString(R.string.piso5))){

                suma5 = suma5 + tam;

            }

        }

        promedio1= suma1/aux;
        resul1.setText("" + promedio1);
        promedio2= suma2/aux;
        resul2.setText("" + promedio2);
        promedio3= suma3/aux;
        resul3.setText("" + promedio3);
        promedio4= suma4/aux;
        resul4.setText("" + promedio4);
        promedio5= suma5/aux;
        resul3.setText("" + promedio5);


    }
}
