package Modelo.ElementosEdificio;

import Modelo.ElementosGrafo.Arista;
import Modelo.ElementosGrafo.Espacio;
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
    
}
