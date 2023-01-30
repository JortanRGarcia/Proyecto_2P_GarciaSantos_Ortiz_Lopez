/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.Fichero;

/**
 * FXML Controller class
 *
 * @author jorgs
 */
public class VentanaGraciasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox vbox;
    @FXML
    private Label textoFinal;
    @FXML
    private ImageView imgv;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        // TODO
        agregarTexto();
        cargarImagen();
        try {
            agregarContador();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    public void agregarTexto(){
        ArrayList<String> pedido = Fichero.leer(App.pathFiles + "pedidos.txt");
            String[] datosPedido = (pedido.get(pedido.size()-1)).strip().split(",");
            textoFinal.setText("Su pedido Nro " + datosPedido[0]+" esta siendo procesado y llegará a su domicilio en 30 minutos o menos!/n"
                    + " Gracias por preferirnos. Bob esponja y Patricio harán su mejor esfuerzo <3");
    }
    
    public void cargarImagen(){
        try{
            Image img = new Image(new FileInputStream(App.pathImg+"delivery.png"));
            imgv.setImage(img);
        
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
    private void agregarContador() throws IOException{
        Label contador=new Label();
        mostrarContador(contador);
        vbox.getChildren().add(contador);
        if((contador.getText()).equals("Tiempo restante: 0 segundos.")){
            App.setRoot("VentanaInicio");
         } 
    }
    
    
    private void mostrarContador(Label texto) {
        Thread t = new Thread(() -> {
            for (int i = 5; i >= 0; i--) {
                int indice = i;
                Platform.runLater(() -> {
                    texto.setText("Tiempo restante " + indice + " segundos.");
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

        });
        t.start();
    }
    
}
