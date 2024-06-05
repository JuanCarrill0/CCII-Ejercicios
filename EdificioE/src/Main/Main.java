package Main;


import Controlador.Controlador3D;
import Vista.MenuCreacion;


/**
 * @author afsal villan
 * @version 1.0
 *
 * http://www.genuinecoder.com
 */
public class Main{

    public static void main(String[] args){

        //Inicialización de la interfaz grafica

        MenuCreacion ventana = new MenuCreacion();
        Controlador3D miControlador = new Controlador3D(ventana,args);

        miControlador.iniciar();  
    }
}












/*

*/