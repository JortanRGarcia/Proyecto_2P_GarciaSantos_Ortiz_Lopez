/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Jortan
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Comida;
import modelo.Fichero;
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
    private Label subtotal;
    @FXML
    private Label iva;
    @FXML
    private Label total;
    @FXML
    private Button btnLimpiar;
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
    @FXML
    private Button ag1;
    @FXML
    private Button ag2;
    @FXML
    private Button ag3;
    @FXML
    private Button ag4;
    @FXML
    private Button ag5;
    @FXML
    private TableView<Comida> tblPedido;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TableColumn colCantidad;
    @FXML
    private TableColumn colValor;
    
    private ObservableList<Comida> comidas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comidas = FXCollections.observableArrayList();

        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colValor.setCellValueFactory(new PropertyValueFactory("valor"));

        ArrayList<Menu> m = new ArrayList<Menu>();

        for (String linea : Fichero.leerSinCabecera("src/main/resources/files/menu.txt")) {
            String[] datos = linea.split(",");
            Menu menu;
            m.add(menu = new Menu(datos[0], Double.parseDouble(datos[1])));
        }
        //menu
        Menu m1 = m.get(0);
        desc1.setText(m1.getDescripcion());
        p1.setText(Double.toString(m1.getPrecio()));

        Menu m2 = m.get(1);
        desc2.setText(m2.getDescripcion());
        p2.setText(Double.toString(m2.getPrecio()));

        Menu m3 = m.get(2);
        desc3.setText(m3.getDescripcion());
        p3.setText(Double.toString(m3.getPrecio()));

        Menu m4 = m.get(3);
        desc4.setText(m4.getDescripcion());
        p4.setText(Double.toString(m4.getPrecio()));

        Menu m5 = m.get(4);
        desc5.setText(m5.getDescripcion());
        p5.setText(Double.toString(m5.getPrecio()));

    }

    @FXML
    private void continuar(ActionEvent event) throws Exception {
        generarPedido();
        App.setRoot("ventanaPago");
        
    }
    public void generarPedido(){
        int rd = (int)(Math.random()*10+333);
        Fichero.escribir(App.pathFiles+"pedidos.txt",rd+","+App.cliente.getNombre()+","+sumTotal*1.12);
    }

    @FXML
    private void limpiar(ActionEvent event) {

    }
    
    static double sumTotal =0;
//    double Vtotal = sumTotal*1.12;
//    double Viva= sumTotal*0.12;
    

    @FXML
    private void agregar1(ActionEvent event) {
        ArrayList<Menu> m = new ArrayList<Menu>();

        for (String linea : Fichero.leerSinCabecera("src/main/resources/files/menu.txt")) {
            String[] datos = linea.split(",");
            Menu menu;
            m.add(menu = new Menu(datos[0], Double.parseDouble(datos[1])));
        }
        //menu
        Menu m1 = m.get(0);
        
        String descripcion = m1.getDescripcion();
        int cantidad = Integer.parseInt(this.cant1.getText());
        double valor = ((m1.getPrecio() * cantidad));

        Comida c1 = new Comida(descripcion, cantidad, valor);

        this.comidas.add(c1);
        this.tblPedido.setItems(comidas);
        
        sumTotal+=valor;
        subtotal.setText(String.valueOf(sumTotal));
        total.setText(String.valueOf(sumTotal*1.12));
        iva.setText(String.valueOf(sumTotal*0.12));

    }

    @FXML
    private void agregar2(ActionEvent event) {
        ArrayList<Menu> m = new ArrayList<Menu>();

        for (String linea : Fichero.leerSinCabecera("src/main/resources/files/menu.txt")) {
            String[] datos = linea.split(",");
            Menu menu;
            m.add(menu = new Menu(datos[0], Double.parseDouble(datos[1])));
        }
        //menu
        Menu m2 = m.get(1);
        
        String descripcion = m2.getDescripcion();
        int cantidad = Integer.parseInt(this.cant2.getText());
        double valor = ((m2.getPrecio() * cantidad));

        Comida c2 = new Comida(descripcion, cantidad, valor);

        this.comidas.add(c2);
        this.tblPedido.setItems(comidas);
        sumTotal+=valor;
        subtotal.setText(String.valueOf(sumTotal));
        total.setText(String.valueOf(sumTotal*1.12));
        iva.setText(String.valueOf(sumTotal*0.12));

    }

    @FXML
    private void agregar3(ActionEvent event) {
        ArrayList<Menu> m = new ArrayList<Menu>();

        for (String linea : Fichero.leerSinCabecera("src/main/resources/files/menu.txt")) {
            String[] datos = linea.split(",");
            Menu menu;
            m.add(menu = new Menu(datos[0], Double.parseDouble(datos[1])));
        }
        //menu
        Menu m3 = m.get(2);
        
        String descripcion = m3.getDescripcion();
        int cantidad = Integer.parseInt(this.cant3.getText());
        double valor = ((m3.getPrecio() * cantidad));

        Comida c3 = new Comida(descripcion, cantidad, valor);

        this.comidas.add(c3);
        this.tblPedido.setItems(comidas);
        sumTotal+=valor;
        subtotal.setText(String.valueOf(sumTotal));
        total.setText(String.valueOf(sumTotal*1.12));
        iva.setText(String.valueOf(sumTotal*0.12));

    }

    @FXML
    private void agregar4(ActionEvent event) {
        ArrayList<Menu> m = new ArrayList<Menu>();

        for (String linea : Fichero.leerSinCabecera("src/main/resources/files/menu.txt")) {
            String[] datos = linea.split(",");
            Menu menu;
            m.add(menu = new Menu(datos[0], Double.parseDouble(datos[1])));
        }
        //menu
        Menu m4 = m.get(3);
        
        String descripcion = m4.getDescripcion();
        int cantidad = Integer.parseInt(this.cant4.getText());
        double valor = ((m4.getPrecio() * cantidad));

        Comida c4 = new Comida(descripcion, cantidad, valor);

        this.comidas.add(c4);
        this.tblPedido.setItems(comidas);
        sumTotal+=valor;
        subtotal.setText(String.valueOf(sumTotal));
        total.setText(String.valueOf(sumTotal*1.12));
        iva.setText(String.valueOf(sumTotal*0.12));

    }

    @FXML
    private void agregar5(ActionEvent event) {
        ArrayList<Menu> m = new ArrayList<Menu>();

        for (String linea : Fichero.leerSinCabecera("src/main/resources/files/menu.txt")) {
            String[] datos = linea.split(",");
            Menu menu;
            m.add(menu = new Menu(datos[0], Double.parseDouble(datos[1])));
        }
        //menu
        Menu m5 = m.get(4);
        
        String descripcion = m5.getDescripcion();
        int cantidad = Integer.parseInt(this.cant5.getText());
        double valor = ((m5.getPrecio() * cantidad));

        Comida c5 = new Comida(descripcion, cantidad, valor);

        this.comidas.add(c5);
        this.tblPedido.setItems(comidas);
        sumTotal+=valor;
        subtotal.setText(String.valueOf(sumTotal));
        total.setText(String.valueOf(sumTotal*1.12));
        iva.setText(String.valueOf(sumTotal*0.12));

    }
    
    

}
