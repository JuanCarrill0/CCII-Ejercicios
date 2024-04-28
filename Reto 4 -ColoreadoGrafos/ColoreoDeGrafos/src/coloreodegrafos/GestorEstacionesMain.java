/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coloreodegrafos;

/**
 *
 * @author tic-asisweb01
 */
import java.util.*;

public class GestorEstacionesMain {
    private int[][] grafo; // Matriz de adyacencia del grafo
    private int numNodos; // Número de nodos en el grafo
    private Map<Integer, Integer> asignaciones; // Mapa para almacenar las asignaciones de frecuencia por estación

    public GestorEstacionesMain() {
        this.grafo = new int[0][0];
        this.numNodos = 0;
        this.asignaciones = new HashMap<>();
    }

    public void agregarEstacion(int[] distancias) {
        int nuevaLongitud = grafo.length + 1;
        int[][] nuevoGrafo = new int[nuevaLongitud][nuevaLongitud];
        
        // Copiamos el grafo existente al nuevo grafo con una fila y columna adicionales
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                nuevoGrafo[i][j] = grafo[i][j];
            }
        }
        
        // Añadimos la nueva fila y columna con las distancias proporcionadas
        for (int i = 0; i < nuevaLongitud - 1; i++) {
            nuevoGrafo[i][nuevaLongitud - 1] = distancias[i];
            nuevoGrafo[nuevaLongitud - 1][i] = distancias[i];
        }
        
        // Actualizamos la matriz de adyacencia y el número de nodos
        this.grafo = nuevoGrafo;
        this.numNodos = nuevaLongitud;
    }

    public void gestionarEstaciones() {
        ColoreoGrafos coloreador = new ColoreoGrafos(grafo);
        coloreador.colorearGrafo();
        asignaciones = coloreador.obtenerAsignaciones();
    }

    public void mostrarAsignacionesFrecuencias() {
        System.out.println("Estaciones con su correspondiente frecuencia:");
        for (Map.Entry<Integer, Integer> entry : asignaciones.entrySet()) {
            System.out.println("Estacion " + entry.getKey() + " -> Frecuencia " + entry.getValue());
        }
    }
    
    public int[][] getGrafo(){
        return grafo;
    }

    public static void main(String[] args) {
        GestorEstacionesMain gestor = new GestorEstacionesMain();
        AsignacionFrecuencias frecuencias = new AsignacionFrecuencias();
        
        // Agregamos las distancias para cada nueva estación
        int[] distanciasEstacion1 = {0, 85, 175, 200, 50, 100};
        int[] distanciasEstacion2 = {85, 0, 125, 175, 100, 160};
        int[] distanciasEstacion3 = {175, 125, 0, 100, 200, 250};
        int[] distanciasEstacion4 = {200, 175, 100, 0, 210, 220};
        int[] distanciasEstacion5 = {50, 100, 200, 210, 0, 100};
        int[] distanciasEstacion6 = {100, 160, 250, 220, 100, 0};
        
        gestor.agregarEstacion(distanciasEstacion1);
        gestor.agregarEstacion(distanciasEstacion2);
        gestor.agregarEstacion(distanciasEstacion3);
        gestor.agregarEstacion(distanciasEstacion4);
        gestor.agregarEstacion(distanciasEstacion5);
        gestor.agregarEstacion(distanciasEstacion6);
        
        //Calculamos las frecuencias
        System.out.println(frecuencias.asignarFrecuencias(gestor.getGrafo()));
        
        
        // Calculamos la cantidad mínima de frecuencias y mostramos las asignaciones de frecuencia
        gestor.gestionarEstaciones();
        gestor.mostrarAsignacionesFrecuencias();
    }
}

