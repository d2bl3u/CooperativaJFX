package com.example.cooperativajfx;

import java.sql.Date;

public class Fruta {

    private int id;
    private String nombre;
    private String variedad;
    private String calibre;

    public Fruta(int id, String nombre, String variedad, String calibre) {
        this.id = id;
        this.nombre = nombre;
        this.variedad = variedad;
        this.calibre = calibre;
    }

    public  Fruta(){

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVariedad() {
        return variedad;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }
}
