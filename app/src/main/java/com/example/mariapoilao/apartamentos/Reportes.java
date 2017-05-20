package com.example.mariapoilao.apartamentos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Reportes extends AppCompatActivity {

    private ListView opreportes;
    private String[] opc;
    private ArrayAdapter adapter;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        opreportes = (ListView)findViewById(R.id.lstReportes);
        opc = getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        opreportes.setAdapter(adapter);

        opreportes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Reportes.this,Registrar.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Reportes.this,Listado.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Reportes.this,Reportes.class);
                        startActivity(i);
                        break;

                }

            }
        });
    }
}
