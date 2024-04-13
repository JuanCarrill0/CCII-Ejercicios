/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author tic-asisweb01
 */
public class RouterDistribucion extends Conexion {
    
    private String direccionMAC;
    private String direccionIP;
    
    public RouterDistribucion(float anchoDeBanda, float anchoDeBandaEfectivo, float constanteDeDensidadEspectral, String direccionMAC, String direccionIP) {
        super(anchoDeBanda, anchoDeBandaEfectivo, constanteDeDensidadEspectral);
        this.direccionMAC = direccionMAC;
        this.direccionIP = direccionIP;
    }
    
    public void asignarDireccionMAC(String direccionMAC) {
        this.direccionMAC = direccionMAC;
    }
    
    public void asignarDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }
    
    public void configurarRouter() {
        // Código para configurar el router de distribución
        System.out.println("Router de distribución configurado con dirección MAC: " + direccionMAC + " y dirección IP: " + direccionIP);
    }
    
    public void reiniciarRouter() {
        // Código para reiniciar el router de distribución
        System.out.println("Router de distribución reiniciado");
    }

}

