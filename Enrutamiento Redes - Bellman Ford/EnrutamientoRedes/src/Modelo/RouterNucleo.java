/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author tic-asisweb01
 */
public class RouterNucleo extends Conexion {
    
    private String nombre;
    private int numeroPuertos;
    
    public RouterNucleo(float anchoDeBanda, float anchoDeBandaEfectivo, float constanteDeDensidadEspectral, String nombre, int numeroPuertos) {
        super(anchoDeBanda, anchoDeBandaEfectivo, constanteDeDensidadEspectral);
        this.nombre = nombre;
        this.numeroPuertos = numeroPuertos;
    }
    
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void asignarNumeroPuertos(int numeroPuertos) {
        this.numeroPuertos = numeroPuertos;
    }
    
    public void configurarRouter() {
        // Código para configurar el router
        System.out.println("Router " + nombre + " configurado con " + numeroPuertos + " puertos");
    }
    
    public void reiniciarRouter() {
        // Código para reiniciar el router
        System.out.println("Router " + nombre + " reiniciado");
    }
    
}

