
package main;

import controlador.Controlador;
import modelo.Busquedas;
import modelo.CreadorProductos;
import modelo.Hash;
import vista.Vista;

public class Main {
    
    public static void main(String[] args){ 
        
        Hash hash = new Hash();
        
        System.out.println(hash.transformarFecha("22/1/2024 09:07"));
        
        /*
        Vista vista = new Vista();
        CreadorProductos creadorProductos = new CreadorProductos();
        Busquedas busquedas = new Busquedas();
        Controlador controlador = new Controlador(vista, creadorProductos, busquedas);
        controlador.iniciar();
*/
    }
}
