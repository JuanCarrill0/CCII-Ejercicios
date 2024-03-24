/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

import Modelo.Gestor;

/**
 *
 * @author juanc
 */
import java.util.ArrayList;

public class AlgoritmoDijkstra {
   
    private int [][] matrAdyacencias; // Matriz de adyacencias para representar el grafo

    // Método para calcular la ruta más corta entre dos nodos
    public String calcularRuta(int ori, int dest) {
        ArrayList<String> rutas = new ArrayList<>(); // Lista para almacenar las rutas
        ArrayList<Integer> distancias = new ArrayList<>(); // Lista para almacenar las distancias
        ArrayList<Integer> candidatos = new ArrayList<>(); // Lista para almacenar los nodos candidatos
        boolean destino = false; // Variable para indicar si se ha llegado al destino
        int nodo = 0; // Variable para contar el número de nodos visitados

        // Inicialización con el nodo origen
        rutas.add(String.valueOf(ori));

        // Bucle principal para buscar la ruta más corta
        while (!destino) {
            ArrayList<String> rutaux = new ArrayList<>(); // Lista auxiliar para generar nuevas rutas
            for (String ruta : rutas) {
                String[] nodos = ruta.split(","); // Obtener los nodos de la ruta actual
                int nodoActual = Integer.parseInt(nodos[nodos.length - 1]); // Obtener el nodo actual

                // Obtener los nodos adyacentes al nodo actual
                ArrayList<Integer> adyacente = adyacentes(nodoActual);

                // Generar nuevas rutas
                for (int adj : adyacente) {
                    if (!visitado(adj, ruta)) {
                        rutaux.add(ruta + "," + adj);

                        // Verificar si se ha llegado al destino
                        if (adj == dest) {
                            destino = true;
                            candidatos.add(nodo);
                        }
                        nodo++;
                    }
                }
            }
            rutas = rutaux; // Actualizar las rutas con las nuevas rutas generadas
            distancias = distancia(rutas); // Calcular las distancias para cada ruta
            nodo = 0; // Reiniciar el contador de nodos visitados
        }

        double dist = Double.POSITIVE_INFINITY;
        int mejorRuta = 0;

        // Encontrar la ruta más corta
        for (int i = 0; i < candidatos.size(); i++) {
            if (distancias.get(candidatos.get(i)) < dist) {
                dist = distancias.get(candidatos.get(i));
                mejorRuta = candidatos.get(i);
            }
        }

        // Devolver la ruta más corta y su distancia
        return rutas.get(mejorRuta) + "," + (int) dist;
    }

    // Método para calcular las distancias para cada ruta
    public ArrayList<Integer> distancia(ArrayList<String> rutas) {
        ArrayList<Integer> distancias = new ArrayList<>();
        for (String ruta : rutas) {
            int dist = 0;
            String[] nodos = ruta.split(",");
            for (int j = 0; j < nodos.length - 1; j++) {
                dist += matrAdyacencias[Integer.parseInt(nodos[j])][Integer.parseInt(nodos[j + 1])];
            }
            distancias.add(dist);
        }
        return distancias;
    }

    // Método para verificar si un nodo ha sido visitado en una ruta
    public boolean visitado(int dato, String ruta) {
        String[] nodos = ruta.split(",");
        for (String nodo : nodos) {
            if (dato == Integer.parseInt(nodo)) {
                return true;
            }
        }
        return false;
    }

    // Método para obtener los nodos adyacentes a un nodo dado
    public ArrayList<Integer> adyacentes(int nodo) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < matrAdyacencias.length; i++) {
            if (matrAdyacencias[nodo][i] != 0 && i != nodo) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }

    // Método para establecer la matriz de adyacencias del grafo
    public void setMatrizDeAdyacencias(int[][] matrizAdyacencias){
        this.matrAdyacencias = matrizAdyacencias;
    }
}

