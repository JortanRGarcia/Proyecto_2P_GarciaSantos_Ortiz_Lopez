/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author Cecy
 */
public class VentanaOpcionesController implements Initializable {


    @FXML
    private ImageView imavburguer;
    @FXML
    private Label bienvenido;
    @FXML
    private Button btnEncontrar;
    @FXML
    private Button btnPedir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarNombre();
        cargarImagenes();
    }    
    
    @FXML
    private void cambiarVentanaMapa(ActionEvent event) throws IOException {
        App.setRoot("VentanaMapa");
    }

    @FXML
    private void cambiarVentanaPedido(ActionEvent event) throws IOException {
        App.setRoot("VentanaPedido");
    }
    
    
    public void cargarNombre(){
        bienvenido.setText("Bienvenido "+App.cliente.getNombre());
    
    }

    public void cargarImagenes(){
        try{
            Image img = new Image(new FileInputStream(App.pathImg+"kirBurguer.png"));
            imavburguer.setImage(img);
        
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
