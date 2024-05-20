package Modelo;

public class FachadaCreacionEdificio {
    
    private Edificio edificio;
    private static FachadaCreacionEdificio fachadaCreacionEdificio;
    
    private FachadaCreacionEdificio(){
        
    }
    
    public static FachadaCreacionEdificio getFachada(){
        if(fachadaCreacionEdificio == null){
            fachadaCreacionEdificio = new FachadaCreacionEdificio();
        }
        return fachadaCreacionEdificio;
    }
    
    public void crearEdificio(String identificadorEdificio, int cantidadPisos){
        
        this.edificio = new Edificio(identificadorEdificio);
        crearPisos(edificio,cantidadPisos);
        
    }
    
    private void crearPisos(Edificio edificio, int cantidadPisos){
        
        for(int i=0; i<cantidadPisos; i++){
            Piso piso = new Piso("Piso "+String.valueOf(i+1));
            crearEspacios(piso,7);
            edificio.agregarPiso(piso);
        }
        
    }
    
    private void crearEspacios(Piso piso, int cantidadEspacios){
        for(int i=0; i<cantidadEspacios; i++){
            for(int j=0; j<cantidadEspacios;j++){
                if(i%2==0){
                    Espacio pasillo = new Pasillo("Pasillo " + String.valueOf(i),true,"norte");
                    crearMetroCuadrado(pasillo,5,5);
                    piso.agregarEspacio(pasillo);
                }else{
                    if(j==3){
                        Espacio pasillo = new Pasillo("Pasillo " + String.valueOf(i),false,"norte");
                        crearMetroCuadrado(pasillo,5,5);
                        piso.agregarEspacio(pasillo);
                    }else{
                        Espacio espacio = new Habitacion("Habitacion "+String.valueOf((i*10)+j),true,"norte");
                        crearMetroCuadrado(espacio,5,5);
                        piso.agregarEspacio(espacio);
                    }
                    
                }
            }
        }
    }
    
    private void crearMetroCuadrado(Espacio espacio, int metrosLargo, int metrosAncho){
        for(int i=0; i<metrosLargo; i++){
            for(int j=0; j<metrosAncho; j++){
                MetroCuadrado metroCuadrado = new MetroCuadrado(metrosLargo,metrosAncho);
                espacio.agregarMetro(metroCuadrado);
            }
        }
    }
    
    public Edificio getEdificio(){
        return edificio;
    }
    
}

