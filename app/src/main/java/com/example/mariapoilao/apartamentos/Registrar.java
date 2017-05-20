package com.example.mariapoilao.apartamentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {

    private EditText cajaNomenclatura;
    private EditText cajaTamaño;
    private EditText cajaPrecio;
    private CheckBox chkSombra;
    private CheckBox chkBalcon;
    private Spinner comboPiso;
    private String[] opciones;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        cajaNomenclatura = (EditText) findViewById(R.id.txtNomenclatura);
        cajaTamaño = (EditText) findViewById(R.id.txtTamano);
        cajaPrecio = (EditText) findViewById(R.id.txtPrecio);
        chkSombra = (CheckBox) findViewById(R.id.chkSombra);
        chkBalcon = (CheckBox) findViewById(R.id.chkBalcon);
        comboPiso = (Spinner) findViewById(R.id.spnPiso);

        opciones = this.getResources().getStringArray(R.array.opcionesPiso);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opciones);
        comboPiso.setAdapter(adapter);
    }


        public boolean validar(){
            boolean b;
            b = Datos.validar(getApplicationContext(), cajaNomenclatura.getText().toString());
            if(cajaNomenclatura.getText().toString().isEmpty() || b==false ){
                cajaNomenclatura.setError(this.getResources().getString(R.string.error_nomenclatura));
                cajaNomenclatura.requestFocus();
                return false;
            }
            if(cajaTamaño.getText().toString().isEmpty()){
                cajaTamaño.setError(this.getResources().getString(R.string.error_tamano));
                cajaTamaño.requestFocus();
                return false;
            }
            if(cajaPrecio.getText().toString().isEmpty()){
                cajaPrecio.setError(this.getResources().getString(R.string.error_precio));
                cajaPrecio.requestFocus();
                return false;
            }


            return true;
        }


    public void guardar(View v){
        String nomenclatura,tamaño,precio,piso="",caracterisitca="";
        int op;
        Apartamento a;

        if(validar()){

            nomenclatura = cajaNomenclatura.getText().toString();
            tamaño = cajaTamaño.getText().toString();
            precio = cajaPrecio.getText().toString();

            op = comboPiso.getSelectedItemPosition();
            switch (op){
                case 0:
                    piso = getResources().getString(R.string.piso1);
                    break;
                case 1:
                    piso = getResources().getString(R.string.piso2);
                    break;
                case 2:
                    piso = getResources().getString(R.string.piso3);
                    break;
                case 3:
                    piso = getResources().getString(R.string.piso4);
                    break;
            }


            if(chkBalcon.isChecked()){
                caracterisitca = getResources().getString(R.string.balcon)+", ";
            }
            if(chkSombra.isChecked()){
                caracterisitca = caracterisitca+getResources().getString(R.string.sombra);
            }


            caracterisitca = caracterisitca.substring(0,caracterisitca.length()-2);
            a = new Apartamento(nomenclatura,tamaño,precio,piso,caracterisitca);
            a.guardar(getApplicationContext());

            Toast.makeText(getApplicationContext(), "Apartamento Guardado Exitosamente",
                    Toast.LENGTH_SHORT).show();


        }
    }


}

