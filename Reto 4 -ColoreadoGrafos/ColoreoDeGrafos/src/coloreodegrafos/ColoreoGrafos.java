/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coloreodegrafos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tic-asisweb01
 */
public class ColoreoGrafos {
    private int[][] grafo; // Matriz de adyacencia del grafo
    private int numNodos; // Número de nodos en el grafo
    private int[] colores; // Arreglo para almacenar los colores asignados a cada nodo
    private int numColores; // Número total de colores asignados
    private static final int DISTANCIA_MAX = 150; // Distancia máxima permitida entre nodos que comparten el mismo color

    public ColoreoGrafos(int[][] grafo) {
        this.grafo = grafo;
        this.numNodos = grafo.length;
        this.colores = new int[numNodos];
        this.numColores = 0;
    }

    public void colorearGrafo() {
        Arrays.fill(colores, -1); // Inicializamos todos los colores como no asignados (-1)
        
        // Recorremos cada nodo del grafo para colorearlo
        for (int nodo = 0; nodo < numNodos; nodo++) {
            // Si el nodo actual no ha sido coloreado, lo coloreamos
            if (colores[nodo] == -1) {
                colorearNodo(nodo);
            }
        }
    }

    private void colorearNodo(int nodo) {
        // Inicializamos el primer color
        int color = 1;
        
        // Recorremos todos los colores posibles
        while (true) {
            boolean colorValido = true;
            
            // Verificamos si algún nodo adyacente tiene el mismo color y la distancia es menor a 150
            for (int i = 0; i < numNodos; i++) {
                if (grafo[nodo][i] > 0 && colores[i] == color && grafo[nodo][i] < DISTANCIA_MAX) {
                    colorValido = false;
                    break;
                }
            }
            
            // Si encontramos un color válido, lo asignamos al nodo y salimos del bucle
            if (colorValido) {
                colores[nodo] = color;
                break;
            }
            
            // Si el color no es válido, probamos con el siguiente
            color++;
        }
        
        // Coloreamos los nodos adyacentes recursivamente
        for (int i = 0; i < numNodos; i++) {
            if (grafo[nodo][i] > 0 && colores[i] == -1) {
                colorearNodo(i);
            }
        }
    }
    
    public Map<Integer, Integer> obtenerAsignaciones() {
        Map<Integer, Integer> asignaciones = new HashMap<>();
        for (int i = 0; i < numNodos; i++) {
            asignaciones.put(i, colores[i]);
        }
        return asignaciones;
    }

    public void imprimirColores() {
        for (int i = 0; i < numNodos; i++) {
            System.out.println("Nodo " + i + " -> Color " + colores[i]);
        }
    }
}