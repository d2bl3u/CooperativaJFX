package com.example.cooperativajfx;

import java.sql.Date;

public class Agricultor {

    private int id;
    private String nombre;
    private String dni;
    //private Date fechaNacimiento;
    private  String fechaNacimiento;
    private String direccion;

    public Agricultor(int id, String nombre, String dni, String fechaNacimiento, String direccion) {

        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public  Agricultor(String nombre, String dni, java.util.Date fecha_nacimiento, String direccion){

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    /*public Date getFechaNacimiento() {
        return fechaNacimiento;
    }*/
    public  String getFechaNacimiento(){return fechaNacimiento;}

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /*public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }*/
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
