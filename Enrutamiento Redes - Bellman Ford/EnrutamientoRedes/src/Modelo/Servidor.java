/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author tic-asisweb01
 */
public class Servidor extends Conexion {
    
    private int puerto;
    private String direccionIP;
    
    public Servidor(float anchoDeBanda, float anchoDeBandaEfectivo, float constanteDeDensidadEspectral, int puerto, String direccionIP) {
        super(anchoDeBanda, anchoDeBandaEfectivo, constanteDeDensidadEspectral);
        this.puerto = puerto;
        this.direccionIP = direccionIP;
    }
    
    public void asignarPuerto(int puerto) {
        this.puerto = puerto;

    }
    
    public void asignarDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }
    
    public void iniciarServicio() {
        // Código para iniciar el servicio del servidor
        System.out.println("Servidor iniciado en " + direccionIP + ":" + puerto);
    }
    
    public void detenerServicio() {
        // Código para detener el servicio del servidor
        System.out.println("Servidor detenido");
    }
    
   
}
