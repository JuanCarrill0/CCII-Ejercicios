package Modelo.ElementosEdificio;

import Modelo.ElementosGrafo.Espacio;
import java.awt.Color;
import java.util.Random;

public class FachadaCreacionEdificio {
    
    private Edificio edificio;
    private static FachadaCreacionEdificio fachadaCreacionEdificio;
    
    private FachadaCreacionEdificio(){
        
    }
    
    public static FachadaCreacionEdificio getFachada(){
        if(fachadaCreacionEdificio == null){
            fachadaCreacionEdificio = new FachadaCreacionEdificio();
        }
        return fachadaCreacionEdificio;
    }
    
    public void crearEdificio(String identificadorEdificio, int cantidadPisos){
        
        this.edificio = new Edificio(identificadorEdificio);
        crearPisos(edificio,cantidadPisos);
        
    }
    
    //Por cada cantidad de pisos, inicializa el edificio con el piso indicado
    private void crearPisos(Edificio edificio, int cantidadPisos){
        
        for(int i=0; i<cantidadPisos; i++){
            Piso piso = new Piso("Piso "+String.valueOf(i+1));
            crearEspacios(piso);
            edificio.agregarPiso(piso);
        }
        
    }
    
    //Por casa piso, añade los nodos correspondientes
    private void crearEspacios(Piso piso){
        int fila = 0;
        int columna = 0;
        
        for(int i = 0; i < 12; i++){
            if (i % 4 == 0 && i != 0) {
                fila++;
                columna = 0;
            }
            
            Actividad actividadEspacio = elegirActividadAleatoria();
            actividadEspacio.inicializarActividad();
            Color colorEspacio = actividadEspacio.getColorPorDecibeles(actividadEspacio.calcularDecibelesTotales());
            Espacio espacio = new Espacio(100 + columna * 150, 50 + fila * 150, colorEspacio,actividadEspacio);
            System.out.println("Actividad = "+ actividadEspacio.getIdentificador()+ "- Decibeles de fuentes internas= "+actividadEspacio.calcularDecibelesTotales());
            crearMetroCuadrado(espacio, 5, 5);
            piso.agregarEspacio(espacio);

            columna++;
        }
        //Dados los nodos creados, añade las aristas correspondientes
        piso.agregarAristas();
    }
    
    public static Actividad elegirActividadAleatoria() {
        String[] actividades = {"Fiestas", "Oficina", "Cocina", "Dormitorio", "Gimnasio", "Biblioteca"}; // Todas las actividades disponibles
        Random random = new Random();
        int indice = random.nextInt(actividades.length);
        return new Actividad(actividades[indice]);
    }
   
    //Dada el espacio creado en un piso respectivo, genera los metros cuadrados para gestionar las fuentes de ruido
    private void crearMetroCuadrado(Espacio espacio, int metrosLargo, int metrosAncho){
        for(int i=0; i<metrosLargo; i++){
            for(int j=0; j<metrosAncho; j++){
                MetroCuadrado metroCuadrado = new MetroCuadrado(metrosLargo,metrosAncho);
                espacio.agregarMetro(metroCuadrado);
            }
        }
    }
    
    public Edificio getEdificio(){
        return edificio;
    }
    
}

