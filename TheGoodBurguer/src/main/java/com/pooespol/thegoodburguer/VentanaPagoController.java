/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.thegoodburguer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Fichero;

/**
 * FXML Controller class
 *
 * @author jorgs
 */
public class VentanaPagoController implements Initializable {

    @FXML
    private TextField tfdireccion;

    @FXML
    private RadioButton rbefectivo;
    @FXML
    private RadioButton rbtarjeta;
    @FXML
    private Button btnlimpiar;
    @FXML
    private Button btnContinuar;

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
        //if(!tfdireccion.getText().equals("")){
        /*
            Label warning=new Label();
            warning.setText("Debe ingresar una direccion para continuar!!!!");
            datostarjeta.getChildren().add(warning);
        }*/
    }

    @FXML
    private void detalleEfectivo(ActionEvent event) {
        if (rbefectivo.isSelected()) {
            datostarjeta.getChildren().clear();
            Label text = new Label();

            datostarjeta.getChildren().add(text);
            int idPago = generarNumFactura();
            ArrayList<String> pedido = Fichero.leer(App.pathFiles + "pedidos.txt");
            String[] datosPedido = (pedido.get(pedido.size()-1)).strip().split(",");
            text.setText("Su valor a pagar es de: " + datosPedido[2]);
            btnContinuar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    Fichero.escribir(App.pathFiles + "pagos.txt", datosPedido[0] + "," + idPago + "," + App.cliente.getNombre() + "," + datosPedido[2] + "," + "E");
                    try {
                        App.setRoot("ventanaGracias");
                    } catch (IOException ex) {
                    }
                }
            });
        }
    }

    @FXML
    private void detalleTarjeta(ActionEvent event) {
        if (rbtarjeta.isSelected()) {
            datostarjeta.getChildren().clear();

            HBox nombre = new HBox();
            HBox numero = new HBox();
            HBox caducidad = new HBox();
            HBox cvv = new HBox();
            nombre.setSpacing(45);
            numero.setSpacing(10);
            caducidad.setSpacing(5);
            cvv.setSpacing(70);

            Label name = new Label();
            TextField tfnombre = new TextField();
            name.setText("Nombre: ");
            nombre.getChildren().addAll(name, tfnombre);

            Label num = new Label();
            TextField tfnum = new TextField();
            num.setText("Numero tarjeta: ");
            numero.getChildren().addAll(num, tfnum);

            Label cad = new Label();
            TextField tfcad = new TextField();
            cad.setText("Fecha caducidad: ");
            caducidad.getChildren().addAll(cad, tfcad);

            Label c = new Label();
            TextField tfc = new TextField();
            c.setText("CVV: ");
            cvv.getChildren().addAll(c, tfc);

            Label text = new Label();
            ArrayList<String> pedido = Fichero.leer(App.pathFiles + "pedidos.txt");
            String[] datosPedido = (pedido.get(pedido.size()-1)).strip().split(",");
            text.setText("Su valor a pagar es de: " + datosPedido[2]);

            datostarjeta.getChildren().addAll(nombre, numero, caducidad, cvv, text);

            btnlimpiar.setOnMouseClicked((MouseEvent e) -> {
                tfnombre.clear();
                tfnum.clear();
                tfcad.clear();
                tfc.clear();
            });
            btnContinuar.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    String nombre = tfnombre.getText();
                    String nume = tfnum.getText();
                    String cad = tfcad.getText();
                    String cvv = tfc.getText();
                    int idPago = generarNumFactura();

                    if (!nombre.equals("") && !nume.equals("") && !cad.equals("") && !cvv.equals("")) {
                        Fichero.escribir(App.pathFiles + "pagos.txt", datosPedido[0] + "," + idPago + "," + App.cliente.getNombre() + "," + datosPedido[2] + "," + "C");
                        try {
                            App.setRoot("ventanaGracias");
                        } catch (IOException ex) {
                        }
                    }  else {
                        Label warning = new Label();
                        warning.setText("Datos incompletos, por favor complete");
                        datostarjeta.getChildren().add(warning);
                    }
                }
            });
        }
    }
    /**Genera un numero de factura aleatorio
    * @return un numero aleatorio entre 0 y 10
    */  
    private int generarNumFactura() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }
    
}
