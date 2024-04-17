/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controlador.*;
import Modelo.*;
import Vista.Vista;

/**
 *
 * @author tic-asisweb01
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista ventana = new Vista();
        Controlador miControlador = new Controlador(ventana);
        
        
        miControlador.iniciar();
    }
    
}