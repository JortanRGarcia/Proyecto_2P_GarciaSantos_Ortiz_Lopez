/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author Cecy
 */
public class VentanaMapaController implements Initializable {


    @FXML
    private ImageView imgv;
    @FXML
    private Button regresar;
    @FXML
    private void regresarVentanaOpciones(ActionEvent event) throws IOException {
        App.setRoot("ventanaOpciones");
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        agregarMapa();
    }    

    
    public void agregarMapa(){
        try{
        FileInputStream f1=new FileInputStream(App.pathImg+"mapa.png");
        Image img1=new Image(f1);
        imgv.setImage(img1);
        
        }catch(FileNotFoundException e){
    
        }
    }
}
