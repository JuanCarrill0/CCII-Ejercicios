
package main;

import controlador.Controlador;
import java.time.LocalDate;
import modelo.Busquedas;
import modelo.CreadorProductos;
import modelo.GestorTransacciones;
import modelo.Producto;
import modelo.Persona;
import modelo.Transaccion;

import vista.Vista;

public class main {
    
    public static void main(String[] args){ 
        
        Producto producto1 = new Producto(1,20.0, "Camiseta", "Camiseta Gucci Fachera");
        Producto producto2 = new Producto(2,25.0, "Pantalon", "Pantalon Gucci Fachero");

        Persona comprador = new Persona(1, "Juan");
        Persona vendedor = new Persona(2, "Pedro");

        LocalDate fecha1 = LocalDate.of(2024, 2, 25);
        LocalDate fecha2 = LocalDate.of(2024, 2, 24);

        Transaccion transaccion1 = new Transaccion(producto1, comprador, vendedor, fecha1);
        Transaccion transaccion2 = new Transaccion(producto2, comprador, vendedor, fecha2);

        GestorTransacciones gestor = new GestorTransacciones();
        gestor.agregarTransaccion(1, transaccion1);
        gestor.agregarTransaccion(2, transaccion2);

        Transaccion transaccionRecuperada = gestor.obtenerTransaccion(1);
        System.out.println("Transacción 1:");
        System.out.println("Producto: " + transaccionRecuperada.getProducto().getNombre());
        System.out.println("Comprador: " + transaccionRecuperada.getComprador().getNombre());
        System.out.println("Vendedor: " + transaccionRecuperada.getVendedor().getNombre());
        System.out.println("Fecha: " + transaccionRecuperada.getFecha());
        
        /*
        Vista vista = new Vista();
        CreadorProductos creadorProductos = new CreadorProductos();
        Busquedas busquedas = new Busquedas();
        Controlador controlador = new Controlador(vista, creadorProductos, busquedas);
        controlador.iniciar();
*/
    }
}