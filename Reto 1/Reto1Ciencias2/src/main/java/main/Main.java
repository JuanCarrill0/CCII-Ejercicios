
package main;

import controlador.Controlador;
import modelo.Busquedas;
import modelo.CreadorProductos;
import vista.Vista;

public class Main {
    
    public static void main(String[] args){ 
            
        Vista vista = new Vista();
        CreadorProductos creadorProductos = new CreadorProductos();
        Busquedas busquedas = new Busquedas();
        Controlador controlador = new Controlador(vista, creadorProductos, busquedas);
        controlador.iniciar();
    }
}
