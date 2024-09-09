package com.example.pooweb.dto;

public class Persona {
    private String nombre;

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    private Integer item;
    private String apellido;

    public Persona(String nombre, String apellido, Integer item) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.item = item;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
