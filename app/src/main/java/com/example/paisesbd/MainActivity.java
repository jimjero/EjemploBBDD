package com.example.paisesbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtid, txtnombre, txtlongitud, txtlatitud, txtpoblacion;
    private TextView resultado;
    private Button btnguardar, btnlistar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtid = findViewById(R.id.txtid);
        txtnombre = findViewById(R.id.txtnombre);
        txtlongitud = findViewById(R.id.txtlongitud);
        txtlatitud = findViewById(R.id.txtlatitud);
        txtpoblacion = findViewById(R.id.txtpoblacion);
        btnguardar = findViewById(R.id.btnguardar);
        btnlistar = findViewById(R.id.btnlistar);
        resultado = findViewById(R.id.txtresultado);
        btnguardar.setOnClickListener(this);
        btnlistar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnguardar:
                MyDbHelper db = new MyDbHelper(this);
                ArrayList<Paises> pai = db.selectPais(db.getWritableDatabase());

                int edid= Integer.parseInt(txtid.getText().toString());
                String ednombre= txtnombre.getText().toString();
                double edlongitud= Double.parseDouble(txtlongitud.getText().toString());
                double edlatitud= Double.parseDouble(txtlatitud.getText().toString());
                int edpoblacion= Integer.parseInt(txtpoblacion.getText().toString());
                Paises paises = new Paises(edid, ednombre, edlongitud, edlatitud, edpoblacion);
                pai.add(paises);

                db.InsertPais(db.getWritableDatabase(), paises);
                limpiarCampos();
                resultado.setText(pai.toString());
               // for (Paises paislista : pai){
                    //System.out.println("El Id es: "+paislista.getId()+"\nEl Nombre es: "+paislista.getNombre());
                   // resultado.setText("El Id es: "+paislista.getId()+"\nEl Nombre es: "+paislista.getNombre());
               // }

                break;
                case R.id.btnlistar:
                //  Listar();

        }

    }

    private void agregarPaises(){

        int edid= Integer.parseInt(txtid.getText().toString());
        String ednombre= txtnombre.getText().toString();
        double edlongitud= Double.parseDouble(txtlongitud.getText().toString());
        double edlatitud= Double.parseDouble(txtlatitud.getText().toString());
        int edpoblacion= Integer.parseInt(txtpoblacion.getText().toString());
        Paises paises = new Paises(edid, ednombre, edlongitud, edlatitud, edpoblacion);



    }

  //  private void Listar(){
    //    ArrayList<Paises> pai = db.selectPais(db.getWritableDatabase());
      //  for (Paises paislista : pai){
        //    resultado.setText("Nombre: "+paislista.getNombre());
        //}


    //}


    private void limpiarCampos(){
        txtid.getText().clear();
        txtnombre.getText().clear();
        txtlongitud.getText().clear();
        txtlatitud.getText().clear();
        txtpoblacion.getText().clear();
    }
}