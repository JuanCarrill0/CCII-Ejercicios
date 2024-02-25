package modelo;

import java.time.LocalDate;

public class Transaccion {
    private Producto producto;
    private Persona comprador;
    private Persona vendedor;
    private LocalDate fecha;

    public Transaccion(Producto producto, Persona comprador, Persona vendedor, LocalDate fecha) {
        this.producto = producto;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public Persona getComprador() {
        return comprador;
    }

    public Persona getVendedor() {
        return vendedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
