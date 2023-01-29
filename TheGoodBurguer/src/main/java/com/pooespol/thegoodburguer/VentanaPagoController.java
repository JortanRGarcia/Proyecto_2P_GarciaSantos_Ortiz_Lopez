/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.thegoodburguer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author jorgs
 */
public class VentanaPagoController implements Initializable {

    @FXML
    private TextField tfdireccion;
    @FXML
    private Button btnContinuarGracias;
    @FXML
    private RadioButton rbefectivo;
    @FXML
    private RadioButton rbtarjeta;
    @FXML
    private Button btnlimpiar;
    @FXML
    private VBox datostarjeta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final ToggleGroup group = new ToggleGroup();
        rbefectivo.setToggleGroup(group);
        rbtarjeta.setToggleGroup(group);
        
        
    }    

    @FXML
    private void continuarGracias(ActionEvent event) throws Exception {
        App.setRoot("ventanaGracias");
    }
    
    @FXML
    private void detalleEfectivo(ActionEvent event) {
        if(rbefectivo.isSelected()){
            datostarjeta.getChildren().clear();
            Label text=new Label();
            text.setText("Hola");
            datostarjeta.getChildren().add(text);
        }
    }
    
    @FXML
    private void detalleTarjeta(ActionEvent event) {
        if(rbtarjeta.isSelected()){
            datostarjeta.getChildren().clear();
            
            HBox nombre=new HBox();
            HBox numero=new HBox();
            HBox caducidad=new HBox();
            HBox cvv=new HBox();
            nombre.setSpacing(45);
            numero.setSpacing(10);
            caducidad.setSpacing(5);
            cvv.setSpacing(70);
            
            Label name=new Label();
            TextField tfnombre=new TextField();
            name.setText("Nombre: ");
            nombre.getChildren().addAll(name,tfnombre);
            
            Label num=new Label();
            TextField tfnum=new TextField();
            num.setText("Numero tarjeta: ");
            numero.getChildren().addAll(num,tfnum);
            
            Label cad=new Label();
            TextField tfcad=new TextField();
            cad.setText("Fecha caducidad: ");
            caducidad.getChildren().addAll(cad,tfcad);
            
            Label c=new Label();
            TextField tfc=new TextField();
            c.setText("CVV: ");
            cvv.getChildren().addAll(c,tfc);
            
            Label text=new Label();
            text.setText("Hola");
            
            datostarjeta.getChildren().addAll(nombre,numero,caducidad,cvv,text);
            
            btnlimpiar.setOnMouseClicked((MouseEvent e) -> {
                tfnombre.clear();
                tfnum.clear();
                tfcad.clear();
                tfc.clear();   
            });
            
            
        }
        
    }
   
}