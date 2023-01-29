/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Jortan
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Menu;

/**
 * FXML Controller class
 *
 * @author jorgs
 */
public class VentanaPedidoController implements Initializable {

    @FXML
    private Button btnContinuar;
    @FXML
    private TreeTableView<Menu> tblPedido;
    @FXML
    private TreeTableColumn colDescripcion;
    @FXML
    private TreeTableColumn colCantidad;
    @FXML
    private TreeTableColumn colValor;
    @FXML
    private Label subtotal;
    @FXML
    private Label iva;
    @FXML
    private Label total;
    @FXML
    private Button btnLimpiar;

    private ObservableList<Menu> menus;
    @FXML
    private Button aHamburguesa;
    @FXML
    private Button aTiramisu;
    @FXML
    private Button aCoca;
    @FXML
    private Button aCheese;
    @FXML
    private Button aAlitas;
    
    @FXML
    private Label desc1;
    @FXML
    private Label p1;
    @FXML
    private TextField cant1;
    @FXML
    private Label desc2;
    @FXML
    private Label p2;
    @FXML
    private TextField cant2;
    @FXML
    private Label desc3;
    @FXML
    private Label p3;
    @FXML
    private TextField cant3;
    @FXML
    private Label desc4;
    @FXML
    private Label p4;
    @FXML
    private TextField cant4;
    @FXML
    private Label desc5;
    @FXML
    private Label p5;
    @FXML
    private TextField cant5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menus = FXCollections.observableArrayList();

        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colValor.setCellValueFactory(new PropertyValueFactory("precio"));

    }

    @FXML
    private void continuar(ActionEvent event) throws Exception {
        App.setRoot("ventanaPago");
    }

    @FXML
    private void limpiar(ActionEvent event) {

    }

    @FXML
    private void agregar1(ActionEvent event) {
        int cantidad = Integer.parseInt(this.cant1.getText());
    }

    @FXML
    private void agregar2(ActionEvent event) {
    }

    @FXML
    private void agregar3(ActionEvent event) {
    }

    @FXML
    private void agregar4(ActionEvent event) {
    }

    @FXML
    private void agregar5(ActionEvent event) {
    }

}
