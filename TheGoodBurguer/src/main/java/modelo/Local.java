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
public class Local {
    private String nombre;
    private String direccion;
    private String horario;
    private double posicionX;
    private double posicionY;

    public Local(String nombre, String direccion, String horario, double posicionX, double posicionY) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    
    
    
    
    //setters y getters

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHorario() {
        return horario;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }
    
    
}
