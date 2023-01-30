package modelo;

public class Comida {

    private String descripcion;
    private int cantidad;
    private double valor;

    public Comida(String descripcion, int cantidad,double valor) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor=valor;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setMenu(Menu menu) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
