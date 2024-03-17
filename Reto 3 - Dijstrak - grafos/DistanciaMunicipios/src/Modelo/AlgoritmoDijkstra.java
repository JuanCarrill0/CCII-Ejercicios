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
public class AlgoritmoDijkstra {
   
    private int [][] matrAdyacencias;
    
    public String calcularRuta(int ori, int dest) {
        ArrayList<Integer> distancias = new ArrayList<>();
        ArrayList<String> rutas = new ArrayList<>();
        ArrayList<Integer> candidatos = new ArrayList<>();
        boolean destino = false;
        ArrayList<Integer> adyacente = adyacentes(ori);
        rutas.add(String.valueOf(ori));
        int nodo = 0;
        while (!destino) {
            ArrayList<String> rutaux = new ArrayList<>();
            for (int i = 0; i < rutas.size(); i++) {
                int tam = rutas.get(i).split(",").length;
                String dato = (rutas.get(i).split(","))[tam - 1];
                adyacente = adyacentes(Integer.parseInt(dato));
                for (int j = 0; j < adyacente.size(); j++) {
                    if (!this.visitado(adyacente.get(j), rutas.get(i))) {
                        rutaux.add(rutas.get(i) + "," + adyacente.get(j));

                        if (adyacente.get(j) == dest) {
                            destino = true;
                            candidatos.add(nodo);
                        }
                        nodo++;
                    }

                }

            }
            rutas = rutaux;
            distancias = this.distancia(rutas);
            nodo = 0;
        }
        double dist = Double.POSITIVE_INFINITY;
        for (int i = 0; i < candidatos.size(); i++) {

            if (distancias.get(candidatos.get(i)) < dist) {
                dist = distancias.get(candidatos.get(i));
                nodo = candidatos.get(i);
            }
        }
        return rutas.get(nodo) + "," + (int) dist;

    }

    public ArrayList distancia(ArrayList<String> rutas) {
        ArrayList<Integer> distancias = new ArrayList<>();
        int dist = 0;
        String[] ruta;
        for (int i = 0; i < rutas.size(); i++) {
            ruta = rutas.get(i).split(",");
            for (int j = 0; j < ruta.length - 1; j++) {
                dist = matrAdyacencias[Integer.parseInt(ruta[j])][Integer.parseInt(ruta[j + 1])] + dist;
            }
            distancias.add(dist);
            dist = 0;

        }
        return distancias;
    }

    public boolean visitado(int dato, String ruta) {
        boolean vist = false;
        String aux[] = ruta.split(",");

        int n = 0;
        if (aux.length > 1) {
            for (String aux1 : aux) {
                if (dato == Integer.parseInt(aux1)) {
                    vist = true;
                }
            }
        }
        return vist;

    }

    public ArrayList adyacentes(int nodo) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < matrAdyacencias.length; i++) {
            if (matrAdyacencias[nodo][i] != -1 && i != nodo) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }

    public void setMatrizDeAdyacencias(int[][] matrizAdyacencias){
        this.matrAdyacencias = matrizAdyacencias;
    }
}
