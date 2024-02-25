/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juanc
 */
public class GestorTransacciones {
    private Hash<Integer, Transaccion> transacciones;

    public GestorTransacciones() {
        transacciones = new Hash<>();
    }

    public void agregarTransaccion(int idTransaccion, Transaccion transaccion) {
        transacciones.poner(idTransaccion, transaccion);
    }

    public Transaccion obtenerTransaccion(int idTransaccion) {
        return transacciones.obtener(idTransaccion);
    }

    public void eliminarTransaccion(int idTransaccion) {
        transacciones.eliminar(idTransaccion);
    }
}