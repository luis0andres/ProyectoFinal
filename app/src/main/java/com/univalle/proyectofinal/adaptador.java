package com.univalle.proyectofinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adaptador extends BaseAdapter {

    ArrayList<deposito> lista;
    depositoabml dao;
    deposito c;
    Activity a;
    int id=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public adaptador(Activity a, ArrayList<deposito> lista, depositoabml dao){
        this.a=a;
        this.lista=lista;
        this.dao=dao;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public deposito getItem(int i) {
        c=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        c= lista.get(i);
        return c.getId();
    }

    @Override
    public View getView(int position, final View view, ViewGroup viewgruop) {
        View v= view;
        if(v==null){
            LayoutInflater li= (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v= li.inflate(R.layout.item, null);
        }
        c=lista.get(position);
        TextView nombre= v.findViewById(R.id.i_nombre);
        TextView cantidad= v.findViewById(R.id.i_cantidad);
        TextView descripcion= v.findViewById(R.id.i_descripcion);

        Button editar= v.findViewById(R.id.i_editar);
        Button eliminar= v.findViewById(R.id.i_eliminar);

        nombre.setText(c.getNombre());
        cantidad.setText(""+c.getCantidad());
        descripcion.setText(c.getDescripcion());

        editar.setTag(position);
        eliminar.setTag(position);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dialogo para editar
                int pos= Integer.parseInt(v.getTag().toString());

                final Dialog dialogo = new Dialog(a);
                dialogo.setTitle("Editar Elemento");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.dialogo);
                dialogo.show();
                final EditText nombre = dialogo.findViewById(R.id.nombre);
                final EditText cantidad = dialogo.findViewById(R.id.cantidad);
                final EditText descripcion = dialogo.findViewById(R.id.descripcion);

                Button guardar = dialogo.findViewById(R.id.d_agregar);
                guardar.setText("Modificar");
                Button cancelar = dialogo.findViewById(R.id.d_cancelar);
                c= lista.get(pos);
                setId(c.getId());
                nombre.setText(c.getNombre());
                cantidad.setText(""+c.getCantidad());
                descripcion.setText(c.getDescripcion());

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try
                        {
                            c= new deposito(getId(),nombre.getText().toString(),Integer.parseInt(cantidad.getText().toString()),descripcion.getText().toString());
                            dao.modificar(c);
                            lista = dao.listar();
                            notifyDataSetChanged();
                            dialogo.dismiss();
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(a,"Error",Toast.LENGTH_SHORT).show();
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

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dialogo para eliminar
                int pos= Integer.parseInt(v.getTag().toString());
                c= lista.get(pos);
                setId(c.getId());
                AlertDialog.Builder del= new AlertDialog.Builder(a);
                del.setMessage("Esta seguro de eliminar dicho elemento");
                del.setCancelable(false);
                del.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.eliminar(getId());
                        lista=dao.listar();
                        notifyDataSetChanged();

                    }
                });
                del.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                del.show();
            }
        });

        return v;
    }
}
