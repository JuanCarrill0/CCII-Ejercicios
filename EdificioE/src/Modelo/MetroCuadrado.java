package Modelo;

import java.util.ArrayList;

public class MetroCuadrado{
    
    private ArrayList<Fuente> fuentes;
    private int[] identificacionMetro = new int[2];
    
    public MetroCuadrado(int metrosLargo, int metrosAncho){
        identificacionMetro[0] = metrosLargo;
        identificacionMetro[1] = metrosAncho;
        fuentes = new ArrayList<>();
    }
    
    public void calcularRuido(ArrayList<Fuente> fuentesAdyacentes){
        
    }
    
    public int[] getIdentificacionMetro(){
        return identificacionMetro;
    }
    
    public ArrayList<Fuente> getFuentes(){
        return fuentes;
    }
}
