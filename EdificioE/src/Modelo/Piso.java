package Modelo;

import java.util.ArrayList;

public class Piso{
    
    private String identificador;
    private ArrayList<Espacio> disposicion;
    
    public Piso(String identificador){
        this.identificador = identificador;
        disposicion = new ArrayList<Espacio>();
    }
    
    public void agregarEspacio(Espacio espacio){
        disposicion.add(espacio);
    }
    
    public ArrayList<Espacio> getDisposicion(){
        return disposicion;
    }
    
    public String getIdentificador(){
        return identificador;
    }
    
}
