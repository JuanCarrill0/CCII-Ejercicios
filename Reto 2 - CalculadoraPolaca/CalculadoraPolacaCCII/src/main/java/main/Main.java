/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import Controlador.controlador;
import Vista.Ventana;

/**
 *
 * @author juanc
 */
public class Main {

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        controlador miControlador = new controlador(ventana);
        miControlador.iniciar();
    }
}
