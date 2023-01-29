/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Cecy
 */
public class Cliente {
    private String usuario;
    private String clave;
    private String nombre;
   

    public Cliente(String usuario, String clave,String nombre) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre=nombre;
    }
    
    /**
     * Valida las credenciales de usuario
     *
     * @param usuario
     * @param contraseña
     * @return Devuelve {@code true} si las credenciales son correctas, caso
     * contrario retorna {@code false}
     */
    public boolean iniciarSesion(String usuario, String contraseña) {
        return usuario.equalsIgnoreCase(this.usuario) && contraseña.equals(this.clave);
    }
    
    
    //setters y getters
    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
    public String getNombre() {
        return nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
