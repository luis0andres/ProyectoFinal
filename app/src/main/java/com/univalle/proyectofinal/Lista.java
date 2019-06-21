package com.univalle.proyectofinal;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    ABML dao;
    Adaptar adapter;
    ArrayList<InforDeposito> lista;

    InforDeposito c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        dao= new ABML(Lista.this);
        lista=dao.listar();
        //adaptando!!!!
        adapter= new Adaptar(Lista.this, lista, dao);
        ListView list= findViewById(R.id.lista);
        Button agregar= findViewById(R.id.agregar);
        list.setAdapter(adapter);

        //cuando haga click a un elemento de la lista
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // agregar la vista previa...

            }
        });

        // cuando hag click en el boton agregar
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // agregar dialogo para agregar nuevo
                final Dialog dialogo = new Dialog(Lista.this);
                dialogo.setTitle("Agregar Nuevo Elemento");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.dialogo);
                dialogo.show();
                final EditText nombre = dialogo.findViewById(R.id.name);
                final EditText descri = dialogo.findViewById(R.id.descripcion);
                final EditText cantidad = dialogo.findViewById(R.id.cantidad);
                Button guardar = dialogo.findViewById(R.id.d_agregar);
                Button cancelar = dialogo.findViewById(R.id.d_cancelar);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try
                        {
                            c= new InforDeposito(nombre.getText().toString(),descri.getText().toString(),cantidad.getText().toString());
                            dao.insertar(c);
                            adapter.notifyDataSetChanged();
                            dialogo.dismiss();
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(getApplication(),"ERROR!!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogo.dismiss();
                    }
                });
            }
        });
    }
}
