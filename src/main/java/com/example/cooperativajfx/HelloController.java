package com.example.cooperativajfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<Agricultor> tblAgricultores;
    @FXML
    private TableView<Fruta> tblFrutas;
    @FXML
    private TableColumn clId;
    @FXML
    private TableColumn clNombre;
    @FXML
    private TableColumn clDni;
    @FXML
    private TableColumn clFecha;
    @FXML
    private TableColumn clDireccion;
    @FXML
    private TableColumn clIdFruta;
    @FXML
    private TableColumn clNombrefruta;
    @FXML
    private TableColumn clVariedad;
    @FXML
    private TableColumn clCalibre;
    @FXML
    private TextField txtAgricultor;
    @FXML
    private TextField txtFruta;
    @FXML
    private TextField txtVariedad;
    @FXML
    private TextField txtCalibre;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtDireccion;

    private ObservableList<Agricultor> agricultores;
    private ObservableList<Fruta> frutas;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //para que asocie los datos que queramos meter en los respectivas columnas

        agricultores = FXCollections.observableArrayList();
        frutas = FXCollections.observableArrayList();
        this.clId.setCellValueFactory(new PropertyValueFactory("id"));
        this.clNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.clDni.setCellValueFactory(new PropertyValueFactory("dni"));
        this.clFecha.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento"));
        this.clDireccion.setCellValueFactory(new PropertyValueFactory("direccion"));


        this.clIdFruta.setCellValueFactory(new PropertyValueFactory("id"));
        this.clNombrefruta.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.clVariedad.setCellValueFactory(new PropertyValueFactory("variedad"));
        this.clCalibre.setCellValueFactory(new PropertyValueFactory("calibre"));


    }

    @FXML
    private void onBtnAgregarAgricultor() {

        try {

            String nombre = this.txtAgricultor.getText();
            String dni = this.txtDni.getText();
            String fecha_nacimiento = this.txtFecha.getText();
            String direccion = this.txtDireccion.getText();

            if ( this.txtAgricultor.getText().isEmpty() || this.txtDni.getText().isEmpty() || this.txtFecha.getText().isEmpty() || this.txtDireccion.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debe rellenar todos los campos");
                alert.showAndWait();
            } else {

                Agricultor agr = new Agricultor(0, nombre, dni, fecha_nacimiento, direccion);

                if (!this.agricultores.contains(agr)) {
                    this.agricultores.add(agr);
                    this.tblAgricultores.setItems(agricultores);

                    txtAgricultor.setText("");
                    txtDni.setText("");
                    txtFecha.setText("");
                    txtDireccion.setText("");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Ya existe ese agricultor");
                    alert.showAndWait();
                }
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Error al capturar los datos de la fecha de nacimiento");
            alert.showAndWait();
        }
    }

    @FXML
    private void onBtnAgregarFruta() {


        try {
            String nombre = this.txtFruta.getText();
            String variedad = this.txtVariedad.getText();
            String calibre = this.txtCalibre.getText();

            if ( this.txtFruta.getText().isEmpty() || this.txtVariedad.getText().isEmpty() || this.txtCalibre.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debe rellenar todos los campos");
                alert.showAndWait();
            } else {

                Fruta ft = new Fruta(1, nombre, variedad, calibre);

                if (!this.frutas.contains(ft)) {
                    this.frutas.add(ft);
                    this.tblFrutas.setItems(frutas);

                    txtFruta.setText("");
                    txtVariedad.setText("");
                    txtCalibre.setText("");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Fruta registrada correctamente");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Ya existe esa fruta");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void seleccionarFruta() {

        Fruta fruta = this.tblFrutas.getSelectionModel().getSelectedItem();

        if (fruta != null) {
            this.txtFruta.setText(fruta.getNombre());
            this.txtVariedad.setText(fruta.getVariedad());
            this.txtCalibre.setText(fruta.getCalibre());
        }
    }

    @FXML
    private void seleccionarAgricultor() {

        Agricultor agricultor = this.tblAgricultores.getSelectionModel().getSelectedItem();

        if (agricultor != null) {
            this.txtAgricultor.setText(agricultor.getNombre());
            this.txtDni.setText(agricultor.getDni());
            this.txtFecha.setText(agricultor.getFechaNacimiento());
            this.txtDireccion.setText(agricultor.getDireccion());
        }
    }

    @FXML
    private void btnModificarFruta() {

        Fruta fruta = this.tblFrutas.getSelectionModel().getSelectedItem();

        if (fruta == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una fruta");
            alert.showAndWait();
        } else {

            try {

                String nombre = this.txtFruta.getText();
                String variedad = this.txtVariedad.getText();
                String calibre = this.txtCalibre.getText();

                Fruta aux = new Fruta(1, nombre, variedad, calibre);

                if (!this.frutas.contains(aux)) {

                    fruta.setNombre(aux.getNombre());
                    fruta.setVariedad(aux.getVariedad());
                    fruta.setCalibre(aux.getCalibre());
                    this.tblFrutas.refresh();

                    txtFruta.setText("");
                    txtVariedad.setText("");
                    txtCalibre.setText("");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Registro modificado correctamente");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Ya existe esa fruta");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void btnEliminarFruta() {

        Fruta fruta = this.tblFrutas.getSelectionModel().getSelectedItem();

        if (fruta == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una fruta");
            alert.showAndWait();
        } else {
            this.frutas.remove(fruta);
            this.tblFrutas.refresh();

            txtFruta.setText("");
            txtVariedad.setText("");
            txtCalibre.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Registro eliminado correctamente");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnModificarAgricultor() {

        Agricultor agricultor = this.tblAgricultores.getSelectionModel().getSelectedItem();

        if (agricultor == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una fruta");
            alert.showAndWait();
        } else {

            try {

                int id = 0;
                String nombre = this.txtAgricultor.getText();
                String dni = this.txtDni.getText();
                String fecha_nacimiento = this.txtFecha.getText();
                String direccion = this.txtDireccion.getText();

                Agricultor aux = new Agricultor(id, nombre, dni, fecha_nacimiento, direccion);

                if (!this.agricultores.contains(aux)) {

                    agricultor.setNombre(aux.getNombre());
                    agricultor.setDni(aux.getDni());
                    agricultor.setFechaNacimiento(aux.getFechaNacimiento());
                    agricultor.setDireccion(aux.getDireccion());
                    this.tblAgricultores.refresh();

                    txtAgricultor.setText("");
                    txtDni.setText("");
                    txtFecha.setText("");
                    txtDireccion.setText("");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Registro modificado correctamente");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Ya existe esa fruta");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void btnEliminarAgricultor() {

        Agricultor agricultor = this.tblAgricultores.getSelectionModel().getSelectedItem();

        if (agricultor == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una fruta");
            alert.showAndWait();
        } else {
            this.agricultores.remove(agricultor);
            this.tblAgricultores.refresh();

            txtAgricultor.setText("");
            txtDni.setText("");
            txtFecha.setText("");
            txtDireccion.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Registro eliminado correctamente");
            alert.showAndWait();
        }
    }
}