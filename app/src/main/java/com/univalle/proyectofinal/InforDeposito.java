package com.univalle.proyectofinal;

public class InforDeposito {
    int id;
    String nombre;
    String descripcion;
    String cantidad;
    //private String avatar;

    public InforDeposito(int id,String nombre,String descripcion, String cantidad)
    {
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
    }
    public InforDeposito(String nombre,String descripcion, String cantidad)
    {
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
    }
    public InforDeposito(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
