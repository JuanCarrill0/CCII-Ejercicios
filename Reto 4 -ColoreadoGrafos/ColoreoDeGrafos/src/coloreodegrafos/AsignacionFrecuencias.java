/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coloreodegrafos;

/**
 *
 * @author tic-asisweb01
 */
public class AsignacionFrecuencias {
    
    // Función para asignar frecuencias a las estaciones de televisión
    public int asignarFrecuencias(int [][] grafoArgumento) {
        int[][] grafo = grafoArgumento;
        int numEstaciones = grafo.length;
        int[] frecuencias = new int[numEstaciones]; // Arreglo para almacenar las frecuencias asignadas
        
        // Recorrer todas las estaciones de televisión
        for (int estacion = 0; estacion < numEstaciones; estacion++) {
            // Inicializar la frecuencia de la estación actual como 1
            frecuencias[estacion] = 1;
            
            // Recorrer las estaciones adyacentes
            for (int estacionAdyacente = 0; estacionAdyacente < numEstaciones; estacionAdyacente++) {
                // Verificar si la estación actual y la estación adyacente están conectadas y si tienen la misma frecuencia
                if (grafo[estacion][estacionAdyacente] != 0 && frecuencias[estacionAdyacente] == frecuencias[estacion] && grafo[estacion][estacionAdyacente] >= 150) {
                    // Si comparten la misma frecuencia y la distancia es mayor o igual a 150, incrementamos la frecuencia de la estación actual
                    frecuencias[estacion]++;
                }
            }
        }
        
        // Encontrar el máximo número de frecuencias asignadas
        int maxFrecuencia = 0;
        for (int frecuencia : frecuencias) {
            maxFrecuencia = Math.max(maxFrecuencia, frecuencia);
        }
        
        return maxFrecuencia;
    }
}
