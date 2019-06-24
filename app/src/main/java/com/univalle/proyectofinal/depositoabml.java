package com.univalle.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class depositoabml {
    SQLiteDatabase cx;
    ArrayList<deposito> lista = new ArrayList<deposito>();
    deposito c;
    Context ct;
    String nombreDB = "BDDeposito";
    String tabla = "create table if not exists dep1(id integer primary key autoincrement, nombre text not null, cantidad integer not null, descripcion text not null)";
    String tabla2 = "create table if not exists dep2(id integer primary key autoincrement, nombre text, cantidad integer, descripcion text)";
    String tabla3 = "create table if not exists dep3(id integer primary key autoincrement, nombre text, cantidad integer, descripcion text)";
    String tabla4 = "create table if not exists dep4(id integer primary key autoincrement, nombre text, cantidad integer, descripcion text)";
    String tabla5 = "create table if not exists dep5(id integer primary key autoincrement, nombre text, cantidad integer, descripcion text)";
    String tabla6 = "create table if not exists dep6(id integer primary key autoincrement, nombre text, cantidad integer, descripcion text)";

    public depositoabml(Context c) {
        this.ct = c;
        cx = c.openOrCreateDatabase(nombreDB, Context.MODE_PRIVATE, null);
        cx.execSQL(tabla);
        cx.execSQL(tabla2);
        cx.execSQL(tabla3);
        cx.execSQL(tabla4);
        cx.execSQL(tabla5);
        cx.execSQL(tabla6);
    }

    //ABML
    //tabla1
    public boolean insertar(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());

        return (cx.insert("dep1",null,contenedor))>0;

    }

    public boolean modificar(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());


        return (cx.update("dep1",contenedor,"id="+c.getId(),null))>0;
    }

    public boolean eliminar(int id) {

        return (cx.delete("dep1","id="+id,null)>0);

    }

    //listar y buscar
    public ArrayList<deposito> listar() {
        lista.clear();
        Cursor curso= cx.rawQuery("select * from dep1",null);
        if(curso!=null&&curso.getCount()>0)
        {
            curso.moveToFirst();
            do {
                lista.add(new deposito(curso.getInt(0),curso.getString(1),curso.getInt(2), curso.getString(3)));

            }while (curso.moveToNext());
        }
        return lista;
    }

    public deposito buscar(int id)
    {
        Cursor curso= cx.rawQuery("select * from dep1",null);
        curso.moveToPosition(id);
        c=new deposito(curso.getInt(0),curso.getString(1),curso.getInt(2), curso.getString(3));
        return c;
    }


    //tabla 2
    public boolean insertar2(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());

        return (cx.insert("dep2",null,contenedor))>0;

    }

    public boolean modificar2(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());


        return (cx.update("dep2",contenedor,"id="+c.getId(),null))>0;
    }

    public boolean eliminar2(int id) {

        return (cx.delete("dep2","id="+id,null)>0);

    }

    //listar y buscar
    public ArrayList<deposito> listar2() {
        lista.clear();
        Cursor curso= cx.rawQuery("select * from dep2",null);
        if(curso!=null&&curso.getCount()>0)
        {
            curso.moveToFirst();
            do {
                lista.add(new deposito(curso.getInt(0),curso.getString(1),curso.getInt(2), curso.getString(3)));

            }while (curso.moveToNext());
        }
        return lista;
    }


    //tabla 3
    public boolean insertar3(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());

        return (cx.insert("dep3",null,contenedor))>0;

    }

    public boolean modificar3(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());


        return (cx.update("dep3",contenedor,"id="+c.getId(),null))>0;
    }

    public boolean eliminar3(int id) {

        return (cx.delete("dep3","id="+id,null)>0);

    }

    //listar y buscar
    public ArrayList<deposito> listar3() {
        lista.clear();
        Cursor curso= cx.rawQuery("select * from dep3",null);
        if(curso!=null&&curso.getCount()>0)
        {
            curso.moveToFirst();
            do {
                lista.add(new deposito(curso.getInt(0),curso.getString(1),curso.getInt(2), curso.getString(3)));

            }while (curso.moveToNext());
        }
        return lista;
    }

    //tabla 4
    public boolean insertar4(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());

        return (cx.insert("dep4",null,contenedor))>0;

    }

    public boolean modificar4(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());


        return (cx.update("dep4",contenedor,"id="+c.getId(),null))>0;
    }

    public boolean eliminar4(int id) {

        return (cx.delete("dep4","id="+id,null)>0);

    }

    //listar y buscar
    public ArrayList<deposito> listar4() {
        lista.clear();
        Cursor curso= cx.rawQuery("select * from dep4",null);
        if(curso!=null&&curso.getCount()>0)
        {
            curso.moveToFirst();
            do {
                lista.add(new deposito(curso.getInt(0),curso.getString(1),curso.getInt(2), curso.getString(3)));

            }while (curso.moveToNext());
        }
        return lista;
    }

    //tabla 5
    public boolean insertar5(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());

        return (cx.insert("dep5",null,contenedor))>0;

    }

    public boolean modificar5(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());


        return (cx.update("dep5",contenedor,"id="+c.getId(),null))>0;
    }

    public boolean eliminar5(int id) {

        return (cx.delete("dep5","id="+id,null)>0);

    }

    //listar y buscar
    public ArrayList<deposito> listar5() {
        lista.clear();
        Cursor curso= cx.rawQuery("select * from dep5",null);
        if(curso!=null&&curso.getCount()>0)
        {
            curso.moveToFirst();
            do {
                lista.add(new deposito(curso.getInt(0),curso.getString(1),curso.getInt(2), curso.getString(3)));

            }while (curso.moveToNext());
        }
        return lista;
    }
    //tabla 6
    public boolean insertar6(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());

        return (cx.insert("dep6",null,contenedor))>0;

    }

    public boolean modificar6(deposito c) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("cantidad", c.getCantidad());
        contenedor.put("descripcion", c.getDescripcion());


        return (cx.update("dep6",contenedor,"id="+c.getId(),null))>0;
    }

    public boolean eliminar6(int id) {

        return (cx.delete("dep6","id="+id,null)>0);

    }

    //listar y buscar
    public ArrayList<deposito> listar6() {
        lista.clear();
        Cursor curso= cx.rawQuery("select * from dep6",null);
        if(curso!=null&&curso.getCount()>0)
        {
            curso.moveToFirst();
            do {
                lista.add(new deposito(curso.getInt(0),curso.getString(1),curso.getInt(2), curso.getString(3)));

            }while (curso.moveToNext());
        }
        return lista;
    }
}
