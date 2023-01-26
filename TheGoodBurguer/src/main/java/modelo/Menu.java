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
public class Menu {
    
    private String descripcion;
    private double precio;
    private TipoComida tipo;

    public Menu(String descripcion, double precio, TipoComida tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    
    
    
    
    //setters y getters

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoComida getTipo() {
        return tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipo(TipoComida tipo) {
        this.tipo = tipo;
    }
    
}
