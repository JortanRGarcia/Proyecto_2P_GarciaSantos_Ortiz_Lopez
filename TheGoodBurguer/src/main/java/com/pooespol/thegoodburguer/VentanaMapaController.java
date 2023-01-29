/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modelo.Cliente;
import modelo.Fichero;
import modelo.*;

/**
 * FXML Controller class
 *
 * @author Cecy
 */
public class VentanaMapaController implements Initializable {

    @FXML
    private Pane root;
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
        agregarLocales();
    }

    ArrayList<Local> locales = cargarLocales();

    public void agregarLocales() {

        Thread t = new Thread(() -> {
            for (Local l : locales) {

                //int indice = i;
                Platform.runLater(() -> {
                    //texto.setText("Tiempo para responder: "+indice+" puntos.");
                    ImageView imgv = new ImageView();
                    imgv.setFitHeight(100);
                    imgv.setFitWidth(100);
                    try {
                        FileInputStream f1 = new FileInputStream(App.pathImg + "kirBurguer.png");
                        Image img = new Image(f1);
                        imgv.setImage(img);
                        imgv.setLayoutX(l.getPosicionX());
                        imgv.setLayoutY(l.getPosicionY());
                        root.getChildren().add(imgv);
                    } catch (FileNotFoundException e) {
                    }

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

    public ArrayList<Local> cargarLocales() {

        ArrayList<Local> locales = new ArrayList<>();
        ArrayList<String> datos = Fichero.leer(App.pathFiles + "locales.txt");
        for (String dato : datos) {
            String[] line = dato.split(",");
            Local l = new Local(line[0], line[1], line[2], Double.valueOf(line[3]), Double.valueOf(line[4]));
            locales.add(l);
        }
        return locales;
    }

    public void agregarMapa() {
        try {
            FileInputStream f1 = new FileInputStream(App.pathImg + "mapa.png");
            Image img1 = new Image(f1);
            imgv.setImage(img1);

        } catch (FileNotFoundException e) {

        }
    }

    private void mostrarContador(Label texto) {
        Thread t = new Thread(() -> {
            for (int i = 5; i >= 0; i--) {
                int indice = i;
                Platform.runLater(() -> {
                    texto.setText("Tiempo para responder: " + indice + " puntos.");
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
