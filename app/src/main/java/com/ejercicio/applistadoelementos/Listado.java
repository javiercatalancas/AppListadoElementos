package com.ejercicio.applistadoelementos;

public class Listado {

    private String nombre;
    private String tipo;

    public Listado(String nombre, String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
