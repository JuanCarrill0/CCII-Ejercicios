package Modelo;

import java.util.ArrayList;


public class Gestor {
    
    private AlgoritmoDijkstra algoritmoDijkstra = new AlgoritmoDijkstra();
    private AlgoritmoBellmanFord algoritmoBellmanFord = new AlgoritmoBellmanFord();
    private AlgoritmoA algoritmoA;
    
    private Municipio[] municipiosExistentes;
    
        int [][] municipiosAdyacentes = {
            
            {0, 770, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
            {0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {720, 0, 130, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0},
            {0, 0, 120, 0, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 120, 0, 0, 0, 0, 172, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 140, 160, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 370, 0, 0, 0, 0, 0, 0, 170, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 230, 0, 0, 0, 0, 110, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 0, 0, 252, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 330, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 0, 0, 0, 0, 196, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 285, 0, 120},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 175, 0, 0, 0, 78, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 327},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 137, 0, 0, 0, 0},
      };
    

    public Gestor(int cantidadMunicipios) {
        this.municipiosExistentes = new Municipio[cantidadMunicipios];
        this.algoritmoA = new AlgoritmoA(cantidadMunicipios);
    }
    
    public String calcularDijkstra(int origen, int destino){
        algoritmoDijkstra.setMatrizDeAdyacencias(municipiosAdyacentes);
        return algoritmoDijkstra.calcularRuta(origen, destino);
    }
    
    public String calcularKruskal(int origen, int destino){
        algoritmoBellmanFord.setMatrizDeAdyacencias(municipiosAdyacentes);
        return algoritmoBellmanFord.calcularRutaMasCorta(origen, destino);
    }
    
    public String[] crearMunicipios() {
        String nombresMunicipios[] = {"San Andres", "San Zenon", "Mompox", "Cienaga de Oro", "Guarandá", "Convencion",
                "Campamento", "Canas Gordas", "Caracoli", "Itsmina", "Nobsa", "Vergara", "San Jacinto",
                "Inirida", "El Totumo", "Caruru", "Calamar", "Saladoblanco", "Yacanquer", "Matapalo"};

        ArrayList<Municipio> listaMunicipios = new ArrayList<>();
        for (String nombreMunicipio : nombresMunicipios) {
            Municipio municipio = new Municipio(nombreMunicipio);
            listaMunicipios.add(municipio);
        }

        // Mostrar los municipios creados
        for (Municipio municipio : listaMunicipios) {
            System.out.println("Municipio: " + municipio.getNombre());
        }
        
        return nombresMunicipios;
    }
    
    public int[][] getMunicipiosAdyacentes(){
        return municipiosAdyacentes;
    }
}
