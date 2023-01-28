/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class VentanaInicioController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private TextField tf1;
    
    @FXML
    private TextField tf2;
    
    @FXML
    private ImageView imgv1;
    
    @FXML
    private ImageView imgv2;
    
    @FXML 
    private Button btnIngresar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarImagenes();
         
        
    }    
    public void cargarImagenes(){
        try{
            Image img = new Image(new FileInputStream(App.pathImg+"pantallaInicial.png"));
            imgv1.setImage(img);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            Image img = new Image(new FileInputStream(App.pathImg+"BurguerKawai.png"));
            imgv2.setImage(img);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
