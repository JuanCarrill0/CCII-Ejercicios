package Modelo;

import java.util.ArrayList;


public class Gestor {
    
    private AlgoritmoDijkstra algoritmoDijkstra = new AlgoritmoDijkstra();
    private AlgoritmoA algoritmoA;
    private Municipio[] municipiosExistentes;
    
    int[][] municipiosAdyacentes = {
            // San Andrés, San Zenón, Mompox, Ciénaga de Oro, Guarandá, Convención, Campamento, Cañas Gordas, Caracolí, Itsmina, Nobsa, Vergara, San Jacinto, Inirida, El Totumo, Carurú, Calamar, Saladoblanco, Yacanquer, Matapalo
            {0, 770, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // San Andrés
            {-1, 0, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // San Zenón
            {-1, -1, 0, 50, -1, 120, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Mompox
            {720, -1, 130, 0, -1, -1, 120, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Ciénaga de Oro
            {-1, -1, -1, -1, 0, 85, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Guarandá
            {-1, -1, -1, -1, -1, 0, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Convención
            {-1, -1, -1, -1, -1, -1, 0, 98, -1, 172, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Campamento
            {-1, -1, -1, -1, -1, -1, -1, 0, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Cañas Gordas
            {-1, -1, -1, -1, -1, -1, -1, -1, 0, 140, 160, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Caracolí
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Itsmina
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // Nobsa
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1}, // Vergara
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1}, // San Jacinto
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1}, // Inirida
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1}, // El Totumo
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 80, -1, -1, -1}, // Carurú
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 196, -1, -1}, // Calamar
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 78, -1}, // Saladoblanco
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1}, // Yacanquer
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0}  // Matapalo
        };
    

    public Gestor(int cantidadMunicipios) {
        this.municipiosExistentes = new Municipio[cantidadMunicipios];
        this.algoritmoA = new AlgoritmoA(cantidadMunicipios);
    }
    
    public String calcularDijkstra(int origen, int destino){
        algoritmoDijkstra.setMatrizDeAdyacencias(municipiosAdyacentes);
        return algoritmoDijkstra.calcularRuta(origen, destino);
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
