/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Cecy
 */
public class Pago {
    private String idPago;
    private String idPedido;
    private String nombreCliente;
    private double totalPagar;
    private String tipo;

    public Pago(String idPago, String idPedido, String nombreCliente, double totalPagar, String tipo) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.totalPagar = totalPagar;
        this.tipo = tipo;
    }
    
    
    
    
    
    
    //setters y getters
    public String getIdPago() {
        return idPago;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
