
package Main;

import Modelo.*;

import Controlador.Controlador;
import Vista.Ventana;

public class main {

    
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        Controlador miControlador = new Controlador(ventana);
        
        miControlador.iniciar();
    }
    
}
