package Modelo;

import java.util.ArrayList;

public class AlgoritmoA {
    
    private int matrizDeAdyacencia[][];
    private int matrizDistanciaTotal[][];
    private int recorridoTotal = 0;
    private ArrayList<Integer> nodosRecorridos = new ArrayList<Integer>();
    private ArrayList<Integer> nodosCandidatos = new ArrayList<Integer>();
    
    public AlgoritmoA(int cantidadMunicipios){
        inicializarCandidatos(cantidadMunicipios);
    }
    
    public int calcularRuta(int origen, int destino){
        
        int nodoActual = origen;
        
        while(nodoActual != destino){
            nodoActual = elegirMejorCandidato(nodoActual, destino);
        }
        
        return recorridoTotal;
    }
    
    private int elegirMejorCandidato(int nodoActual, int destino){
        
        int mejorResultado = Integer.MAX_VALUE;
        int nodoSeleccionado = nodoActual;
        
        for(int i=0; i<nodosCandidatos.size(); i++){
            if(verificarAdyacencia(nodoActual,nodosCandidatos.get(i))){
                if(recorridoTotal + matrizDeAdyacencia[nodoActual][i] + matrizDistanciaTotal[nodosCandidatos.get(i)][destino] < mejorResultado){
                    recorridoTotal = recorridoTotal + matrizDeAdyacencia[nodoActual][i];
                    nodoSeleccionado = i;
                }
            }
        }
        
        nodosRecorridos.add(nodoSeleccionado);
        nodosCandidatos.remove(nodoSeleccionado);
        
        return nodoSeleccionado;
    }
    
    private boolean verificarAdyacencia(int nodoActual, int nodoCandidato){
        if(matrizDeAdyacencia[nodoActual][nodoCandidato]!=0){
            return true;
        }else{
          return false;  
        }
    }
    
    private void inicializarCandidatos(int cantidadMunicipios){
        for(int i=0; i<cantidadMunicipios; i++){
            nodosCandidatos.add(i);
        }
    }
    
    public void setMatrizDeAdyacencias(int[][] matrizAdyacencias){
        this.matrizDeAdyacencia = matrizAdyacencias;
    }
    
    public void setMatrizDistanciaTotal(int[][] matrizDistanciaTotal){
        this.matrizDistanciaTotal = matrizDistanciaTotal;
    }
}
