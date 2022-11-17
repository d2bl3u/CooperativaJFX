package com.example.cooperativajfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class RepositorioFrutas {
    Connection conexion;
    public RepositorioFrutas(){
        setConexion();
    }
    public void setConexion() {
        try {
            //Conecto con MySQL
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cooperativa","root","");
            Statement st=conexion.createStatement();

            //Si no existe la tabla de Agricultores, la creo
            st.execute("CREATE TABLE IF NOT EXISTS frutas(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(255) UNIQUE, variedad VARCHAR(255), calibre VARCHAR(255));");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertarFruta(String nombre, String variedad, String calibre){
        PreparedStatement ps= null;
        try {
            ps = conexion.prepareStatement("INSERT INTO frutas (nombre, variedad, calibre)" +
                    " VALUES (?, ?, ?);");
            ps.setString(1, nombre);
            ps.setString(2, variedad);
            ps.setString(3, calibre);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertarFruta(Fruta f){
        PreparedStatement ps= null;
        try {
            ps = conexion.prepareStatement("INSERT INTO frutas (nombre, variedad, calibre)" +
                    " VALUES (?, ?, ?);");
            ps.setString(1, f.getNombre());
            ps.setString(2, f.getVariedad());
            ps.setString(3, f.getCalibre());
            ps.executeUpdate();

            ps=conexion.prepareStatement("SELECT id FROM frutas WHERE nombre=?");
            ps.setString(1, f.getNombre());
            ResultSet rs=ps.executeQuery();
            rs.next();
            f.setId(rs.getInt("id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Fruta> getTodasLasFrutas(){

        ObservableList<Fruta> frutas= FXCollections.observableArrayList();
        try {

            PreparedStatement st=conexion.prepareStatement("SELECT * FROM frutas ");
            ResultSet rs=st.executeQuery();

            while(rs.next()){

                Fruta f = new Fruta();
                f.setId(rs.getInt("id"));
                f.setNombre(rs.getString("nombre"));
                f.setVariedad(rs.getString("variedad"));
                f.setCalibre(rs.getString("calibre"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return frutas;
    }
}

