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


    depositoabml dao;
    adaptador adapter;
    ArrayList<deposito> lista;
    deposito c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        dao= new depositoabml(this);
        lista = dao.listar();
        adapter= new adaptador(this,lista,dao);
        ListView list= findViewById(R.id.lista);
        Button agregar = findViewById(R.id.agregar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // dialogo para modificar o verificar

                /*final Dialog vista= new Dialog(MainActivity.this);
                vista.setTitle("Informacion");
                vista.setCancelable(false);
                vista.setContentView(R.layout.vista);
                TextView nombre= vista.findViewById(R.id.v_nombre);
                TextView cantidad= vista.findViewById(R.id.v_cantidad);
                TextView descripcion= vista.findViewById(R.id.v_descripcion);
                Button cerrar = vista.findViewById(R.id.volver);

                nombre.setText();
                cantidad.setText(""+);
                descripcion.setText(c.getDescripcion());

                vista.show();
                cerrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vista.dismiss();
                    }
                });*/
            }

        });
        //boton agregar

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dialogo de agregar
                final Dialog dialogo = new Dialog(Lista.this);
                dialogo.setTitle(getString(R.string.nuevoel));
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.dialogo);
                dialogo.show();
                final EditText nombre = dialogo.findViewById(R.id.nombre);
                final EditText cantidad = dialogo.findViewById(R.id.cantidad);
                final EditText descripcion = dialogo.findViewById(R.id.descripcion);

                Button guardar = dialogo.findViewById(R.id.d_agregar);
                guardar.setText(getString(R.string.agreg));
                Button cancelar = dialogo.findViewById(R.id.d_cancelar);

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try
                        {
                            c= new deposito(nombre.getText().toString(),Integer.parseInt(cantidad.getText().toString()),descripcion.getText().toString());
                            dao.insertar(c);
                            lista = dao.listar();
                            adapter.notifyDataSetChanged();
                            dialogo.dismiss();
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(getApplication(),"Debe llenar todos los campos!!",Toast.LENGTH_SHORT).show();
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
