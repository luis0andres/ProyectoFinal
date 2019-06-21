package com.univalle.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.univalle.proyectofinal.InforDeposito;

import java.util.ArrayList;

public class ABML {
    SQLiteDatabase cx;
    ArrayList<InforDeposito> lista;
    InforDeposito c;
    Context ct;

    String DBname = "Deposito";
    String tabla = "create table if not exists deposito(id integer primary key autoincrement, nombre text, descripcion text, cantidad text)";

    public ABML(Context c) {
        this.ct = c;
        cx = c.openOrCreateDatabase(DBname, Context.MODE_WORLD_WRITEABLE, null);
        cx.execSQL(tabla);
    }

    //insertar
    public boolean insertar(InforDeposito c) {
        ContentValues contenedor= new ContentValues();
        contenedor.put("nombre",c.getNombre());
        contenedor.put("descripcion",c.getDescripcion());
        contenedor.put("cantidad",c.getCantidad());
        return (cx.insert("deposito",null,contenedor))>0;
    }

    //eliminar
    public boolean eliminar(int id)
    {
        return true;
    }

    //modificar
    public boolean modificar(InforDeposito c)
    {
        return true;
    }

    //listar
    public ArrayList<InforDeposito> listar()
    {
        return lista;
    }
    public InforDeposito veruno(int id)
    {
        return c;
    }
}
