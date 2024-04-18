package Modelo;

import Controlador.GestorInterfaz;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class AlgoritmoBellmanFord {
    private int[][] municipiosAdyacentes;
    private final int numMunicipios = 21;
    
    private GestorInterfaz interfaz;
   

    public AlgoritmoBellmanFord(GestorInterfaz interfaz) {
        this.interfaz = interfaz;
    }
    
    public AlgoritmoBellmanFord() {
    }
    
    
    public final void setMatrizDeAdyacencias(int[][] municipiosAdyacentes){
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
        SwingWorker<String, Integer> worker = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                int[] distancia = new int[numMunicipios];
                int[] predecesor = new int[numMunicipios];
                Map<String, Integer> registroPredecesores = new LinkedHashMap<>();

                Arrays.fill(distancia, Integer.MAX_VALUE);
                Arrays.fill(predecesor, -1);
                distancia[origen] = 0;

                for (int i = 0; i < numMunicipios; i++) {
                    for (int u = 0; u < numMunicipios; u++) {
                        for (int v = 0; v < numMunicipios; v++) {
                            if (municipiosAdyacentes[u][v] != 0 && distancia[u] != Integer.MAX_VALUE &&
                                    distancia[u] + municipiosAdyacentes[u][v] < distancia[v]) {
                                distancia[v] = distancia[u] + municipiosAdyacentes[u][v];
                                predecesor[v] = u;
                                registroPredecesores.put(interfaz.obtenerSigla(u) + " -> " + interfaz.obtenerSigla(v), distancia[v]); // Guardar par de nodos y distancia en el registro
                                interfaz.escribirInforme(interfaz.obtenerSigla(u) + " -> " + interfaz.obtenerSigla(v), distancia[v]);
                                // Actualizar la interfaz después de cada predecesor encontrado
                                publish(u);
                                Thread.sleep(1000); // Ajusta el tiempo de espera según sea necesario
                            }
                        }
                    }
                }

                // Construir la ruta más corta como un string
                StringBuilder ruta = new StringBuilder();
                int nodoActual = destino;
                while (nodoActual != origen) {
                    ruta.insert(0, interfaz.obtenerSigla(nodoActual) + ",");
                    if (predecesor[nodoActual] == -1) {
                        // Manejar el caso donde no hay predecesor para el nodo actual
                        return "No hay ruta disponible";
                    }
                    nodoActual = predecesor[nodoActual];
                }
                ruta.insert(0, interfaz.obtenerSigla(origen)+ ",");
                ruta.append(distancia[destino]);

                System.out.println("Ruta mas corta");
                System.out.println("Registro de predecesores:");
                for (Map.Entry<String, Integer> entry : registroPredecesores.entrySet()) {
                    System.out.println("De " + entry.getKey() + ", Distancia: " + entry.getValue());
                }
                
                System.out.println(ruta.toString());
                interfaz.escribirInforme("Recorrido de la ruta mas corta = "+ruta.toString(), distancia[destino]);
                return ruta.toString();
            }


            @Override
            protected void process(java.util.List<Integer> chunks) {
                for (Integer nodo : chunks) {
                    interfaz.pintarRecorrido(nodo);
                }
            }

            @Override
            protected void done() {
                try {
                    String ruta = get();
                    interfaz.pintarRutaMasCorta(ruta);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AlgoritmoBellmanFord.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(AlgoritmoBellmanFord.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };

        worker.execute();
        return null;
    }

    private String imprimirRuta(int destino, int[] predecesor) {
        if (destino < 0)
            return " ";

        imprimirRuta(predecesor[destino], predecesor);
        return destino + " ";
    }
}
