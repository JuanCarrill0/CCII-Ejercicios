package Modelo;

public class Gestor {
    
    private int[][] municipiosAdyacentes;

    public Gestor(int cantidadMunicipios) {
        this.municipiosAdyacentes = new int[cantidadMunicipios][cantidadMunicipios];
    }
    
    public int[][] getMunicipiosAdyacentes(){
        return municipiosAdyacentes;
    }
}
