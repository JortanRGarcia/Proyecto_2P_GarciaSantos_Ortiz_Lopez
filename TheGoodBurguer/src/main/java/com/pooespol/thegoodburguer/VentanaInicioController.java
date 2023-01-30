/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.thegoodburguer;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.*;

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
    private VBox root;
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
    @FXML
    private void ingresar(ActionEvent event) throws Exception {
        String user = tf1.getText();
        String code = tf2.getText();
        if (validarIngreso(user, code)) {
            App.cliente=abrirCliente(user);
            App.setRoot("ventanaOpciones");

        } else {
            Label l = new Label();
            l.setText("Usuario no encontrado, intente de nuevo");

            root.getChildren().add(l);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarImagenes();
           
    }    
    
    ArrayList<Cliente> clientes = cargarClientes();
    /**Comprueba que el ususrio esté registrado
    * @param usuario, recibe el usuario ingresado
    * @param clave, recibe la clave ingresada
    * @return boolean, si está registrado, retorna true
    */ 
    private boolean validarIngreso(String usuario, String clave) {
        for (Cliente c : clientes) {
            if (c.iniciarSesion(usuario, clave)) {
                return true;
            }
        }
        return false;
    }
    /**Asigna un cliente para toda la aplicacion
    * @param user, recibe el usuario registrado
    * @return un cliente que se asigna al programa
    */ 
    private Cliente abrirCliente(String user) {
        for (Cliente c : clientes) {
            if (user.equals(c.getUsuario())) {
                Cliente cliente = new Cliente(c.getUsuario(), c.getClave(), c.getNombre());
                return cliente;
            }
        }
        return null;
    }
    /**Lee los archivos de clientes.txt   
    * @return un ArrayList de tipo Cliente con todos los usuarios leídos
    */ 
    private ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<String> usuarios = Fichero.leer(App.pathFiles + "usuarios.txt");
        for (String dato : usuarios) {
            String[] line = dato.split(",");
            Cliente c = new Cliente(line[0], line[1], line[2]);
            clientes.add(c);
        }
        return clientes;
    }
    /**Carga las imagenes a la ventana
    * 
    */     
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
