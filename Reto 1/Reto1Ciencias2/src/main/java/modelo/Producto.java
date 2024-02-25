
package modelo;

public class Producto {
    
    //Atributos:
    private int identificador;
    private double precio;
    private String nombre, descripcion;
    
    //Método constructor:
    
    public Producto(int identificador, double precio, String nombre, String descripcion){
        this.identificador = identificador;
        this.precio = precio;
        this.nombre= nombre;
        this.descripcion = descripcion;
    }
    
    //Getters:
    public int getIdentificador() {
        return identificador;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    //Atributos:
    public String getDescripcion() {
        return descripcion;
    }
   
}
