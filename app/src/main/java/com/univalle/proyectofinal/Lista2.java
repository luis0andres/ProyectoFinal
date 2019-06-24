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

public class Lista2 extends AppCompatActivity {

    depositoabml dao;
    adaptador2 adapter;
    ArrayList<deposito> lista;
    deposito c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        dao= new depositoabml(this);
        lista = dao.listar2();
        adapter= new adaptador2(this,lista,dao);
        ListView list= findViewById(R.id.lista);
        Button agregar = findViewById(R.id.agregar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // dialogo para modificar o verificar
            }

        });
        //boton agregar
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dialogo de agregar
                final Dialog dialogo = new Dialog(Lista2.this);
                dialogo.setTitle("Nuevo Elemento");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.dialogo);
                dialogo.show();
                final EditText nombre = dialogo.findViewById(R.id.nombre);
                final EditText cantidad = dialogo.findViewById(R.id.cantidad);
                final EditText descripcion = dialogo.findViewById(R.id.descripcion);

                Button guardar = dialogo.findViewById(R.id.d_agregar);
                guardar.setText("Agregar");
                Button cancelar = dialogo.findViewById(R.id.d_cancelar);

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try
                        {
                            c= new deposito(nombre.getText().toString(),Integer.parseInt(cantidad.getText().toString()),descripcion.getText().toString());
                            dao.insertar2(c);
                            lista = dao.listar2();
                            adapter.notifyDataSetChanged();
                            dialogo.dismiss();
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();
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
