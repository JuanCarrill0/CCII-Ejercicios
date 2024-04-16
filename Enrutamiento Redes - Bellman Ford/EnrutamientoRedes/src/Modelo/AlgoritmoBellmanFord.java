package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AlgoritmoBellmanFord {
    private int[][] municipiosAdyacentes;
    private final int numMunicipios = 21;

    public AlgoritmoBellmanFord() {
    }
    
    public void setMatrizDeAdyacencias(int[][] municipiosAdyacentes){
        this.municipiosAdyacentes = municipiosAdyacentes;
    }

    public void imprimirMatrizDeAdyacencia() {
        if (municipiosAdyacentes == null) {
            System.out.println("La matriz de adyacencia no está inicializada.");
            return;
        }

        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numMunicipios; i++) {
            for (int j = 0; j < numMunicipios; j++) {
                System.out.print(municipiosAdyacentes[i][j] + " ");
            }
            System.out.println();
        }
    }


    public String calcularRutaMasCorta(int origen, int destino) {
        int[] distancia = new int[numMunicipios];
        int[] predecesor = new int[numMunicipios];

        // Inicializar distancias y predecesores
        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(predecesor, -1); // Inicializar los predecesores como -1

        distancia[origen] = 0;
        
        
        // Relajación de las aristas repetidamente
        for (int i = 0; i < numMunicipios; i++) {
            for (int u = 0; u < numMunicipios; u++) {
                for (int v = 0; v < numMunicipios; v++) {
                    if (municipiosAdyacentes[u][v] != 0 && distancia[u] != Integer.MAX_VALUE &&
                            distancia[u] + municipiosAdyacentes[u][v] < distancia[v]) {
                        distancia[v] = distancia[u] + municipiosAdyacentes[u][v];
                        predecesor[v] = u;
                    }
                }
            }
        }

        // Verificar ciclos de peso negativo
        for (int u = 0; u < numMunicipios; u++) {
            for (int v = 0; v < numMunicipios; v++) {
                if (municipiosAdyacentes[u][v] != 0 && distancia[u] != Integer.MAX_VALUE &&
                        distancia[u] + municipiosAdyacentes[u][v] < distancia[v]) {
                    return "El grafo contiene un ciclo de peso negativo";
                }
            }
        }

        // Construir la ruta más corta como un string
        StringBuilder ruta = new StringBuilder();
        int nodoActual = destino;
        while (nodoActual != origen) {
            ruta.insert(0, nodoActual + ",");
            if (predecesor[nodoActual] == -1) {
                // Manejar el caso donde no hay predecesor para el nodo actual
                return "No hay ruta disponible";
            }
            nodoActual = predecesor[nodoActual];
        }
        ruta.insert(0, origen + ",");
        ruta.append(distancia[destino]);
        
        System.out.println("Ruta mas corta");
        return ruta.toString();
    }


    private String imprimirRuta(int destino, int[] predecesor) {
        if (destino < 0)
            return " ";

        imprimirRuta(predecesor[destino], predecesor);
        return destino + " ";
    }
}
