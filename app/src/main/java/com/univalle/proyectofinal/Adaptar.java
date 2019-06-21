package com.univalle.proyectofinal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptar extends BaseAdapter {
    ArrayList<InforDeposito> lista;
    ABML dao;
    InforDeposito c;
    Activity a;
    public Adaptar( Activity a,ArrayList<InforDeposito> lista, ABML dao){
        this.lista=lista;
        this.a=a;
        this.dao=dao;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public InforDeposito getItem(int i) {
        c=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        c=lista.get(i);
        return c.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewgroup) {
        View v= view;
        if(v!= null)
        {
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v= li.inflate(R.layout.item, null);
        }
        c= lista.get(i);
        TextView nombre = v.findViewById(R.id.t_nombre);
        TextView cantidad = v.findViewById(R.id.t_cantidad);
        TextView descripcion = v.findViewById(R.id.t_descripcion);
        Button editar = v.findViewById(R.id.editar);
        Button eliminar = v.findViewById(R.id.eliminar);

        nombre.setText(c.getNombre());
        cantidad.setText(c.getCantidad());
        descripcion.setText(c.getDescripcion());

        editar.setTag(i);
        eliminar.setTag(i);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dialogo para confirmar
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dialogo para eliminar
            }
        });
        return v;
    }
}
