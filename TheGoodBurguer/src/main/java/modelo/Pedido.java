/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jorgs
 */
public class Pedido {
    
    private String idPedido;
    private String nombreCliente;
    private double total;

    public Pedido(String idPedido, String nombreCliente, double total) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.total = total;
    }
    
    //setters y getters
    public String getIdPedido() {
        return idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
