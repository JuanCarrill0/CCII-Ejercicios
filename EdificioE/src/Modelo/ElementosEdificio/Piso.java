package Modelo.ElementosEdificio;

import Modelo.ElementosGrafo.Arista;
import Modelo.ElementosGrafo.Espacio;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Piso{
    
    private String identificador;
    private List<Espacio> Nodos;
    private List<Arista> aristas = new ArrayList<>();
    
    public Piso(String identificador){
        this.identificador = identificador;
        Nodos = new ArrayList<>();
    }
    
    public void agregarEspacio(Espacio espacio){
        Nodos.add(espacio);
    }
    
    public void agregarAristas(){
        // Crear aristas 
        aristas.add(new Arista(Nodos.get(0), Nodos.get(1)));
        aristas.add(new Arista(Nodos.get(0), Nodos.get(5)));
        aristas.add(new Arista(Nodos.get(0), Nodos.get(4)));
        
        aristas.add(new Arista(Nodos.get(1), Nodos.get(0)));
        aristas.add(new Arista(Nodos.get(1), Nodos.get(4)));
        aristas.add(new Arista(Nodos.get(1), Nodos.get(5)));
        aristas.add(new Arista(Nodos.get(1), Nodos.get(2)));
        aristas.add(new Arista(Nodos.get(1), Nodos.get(6)));
        
        aristas.add(new Arista(Nodos.get(2), Nodos.get(1)));
        aristas.add(new Arista(Nodos.get(2), Nodos.get(5)));
        aristas.add(new Arista(Nodos.get(2), Nodos.get(6)));
        aristas.add(new Arista(Nodos.get(2), Nodos.get(3)));
        aristas.add(new Arista(Nodos.get(2), Nodos.get(7)));
        
        aristas.add(new Arista(Nodos.get(3), Nodos.get(2)));
        aristas.add(new Arista(Nodos.get(3), Nodos.get(7)));
        aristas.add(new Arista(Nodos.get(3), Nodos.get(6)));
        
        aristas.add(new Arista(Nodos.get(4), Nodos.get(0)));
        aristas.add(new Arista(Nodos.get(4), Nodos.get(1)));
        aristas.add(new Arista(Nodos.get(4), Nodos.get(5)));
        aristas.add(new Arista(Nodos.get(4), Nodos.get(8)));
        aristas.add(new Arista(Nodos.get(4), Nodos.get(9)));
        
        aristas.add(new Arista(Nodos.get(5), Nodos.get(0)));
        aristas.add(new Arista(Nodos.get(5), Nodos.get(4)));
        aristas.add(new Arista(Nodos.get(5), Nodos.get(8)));
        aristas.add(new Arista(Nodos.get(5), Nodos.get(1)));
        aristas.add(new Arista(Nodos.get(5), Nodos.get(9)));
        aristas.add(new Arista(Nodos.get(5), Nodos.get(2)));
        aristas.add(new Arista(Nodos.get(5), Nodos.get(6)));
        aristas.add(new Arista(Nodos.get(5), Nodos.get(10)));
        
        aristas.add(new Arista(Nodos.get(6), Nodos.get(2)));
        aristas.add(new Arista(Nodos.get(6), Nodos.get(1)));
        aristas.add(new Arista(Nodos.get(6), Nodos.get(3)));
        aristas.add(new Arista(Nodos.get(6), Nodos.get(7)));
        aristas.add(new Arista(Nodos.get(6), Nodos.get(9)));
        aristas.add(new Arista(Nodos.get(6), Nodos.get(10)));
        aristas.add(new Arista(Nodos.get(6), Nodos.get(11)));
        
        
        aristas.add(new Arista(Nodos.get(7), Nodos.get(2)));
        aristas.add(new Arista(Nodos.get(7), Nodos.get(3)));
        aristas.add(new Arista(Nodos.get(7), Nodos.get(6)));
        aristas.add(new Arista(Nodos.get(7), Nodos.get(10)));
        aristas.add(new Arista(Nodos.get(7), Nodos.get(11)));
        
        aristas.add(new Arista(Nodos.get(8), Nodos.get(4)));
        aristas.add(new Arista(Nodos.get(8), Nodos.get(5)));
        aristas.add(new Arista(Nodos.get(8), Nodos.get(9)));
        
        aristas.add(new Arista(Nodos.get(9), Nodos.get(8)));
        aristas.add(new Arista(Nodos.get(9), Nodos.get(4)));
        aristas.add(new Arista(Nodos.get(9), Nodos.get(5)));
        aristas.add(new Arista(Nodos.get(9), Nodos.get(6)));
        aristas.add(new Arista(Nodos.get(9), Nodos.get(10)));
        
        aristas.add(new Arista(Nodos.get(10), Nodos.get(5)));
        aristas.add(new Arista(Nodos.get(10), Nodos.get(6)));
        aristas.add(new Arista(Nodos.get(10), Nodos.get(7)));
        aristas.add(new Arista(Nodos.get(10), Nodos.get(9)));
        aristas.add(new Arista(Nodos.get(10), Nodos.get(11)));
        
        aristas.add(new Arista(Nodos.get(11), Nodos.get(6)));
        aristas.add(new Arista(Nodos.get(11), Nodos.get(10)));
        aristas.add(new Arista(Nodos.get(11), Nodos.get(7)));
    }
    
    public List<Espacio> getNodos(){
        return Nodos;
    }
    
    public List<Arista> getAristas(){
        return aristas;
    }
    
    public String getIdentificador(){
        return identificador;
    }
    
    public List<String> conexionNodosRojosVerdes() {
        List<String> rojosVerdesConexion = new ArrayList<>();

        for (Arista arista : aristas) {
            Espacio nodo1 = arista.from;
            Espacio nodo2 = arista.to;

            // Solo agregar conexiones donde el nodo1 es rojo y el nodo2 es verde
            if (nodo1.getColor() == Color.RED && nodo2.getColor() == Color.GREEN) {
                rojosVerdesConexion.add("Nodo " + nodo1.getNumeroEspacio() + " está conectado con Nodo " + nodo2.getNumeroEspacio() + " generando conflicto de ruido");
            }
        }

        return rojosVerdesConexion;
    }

}
