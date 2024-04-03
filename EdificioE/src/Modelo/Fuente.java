package Modelo;

public abstract class Fuente{
    
    protected String identificador;
    protected int frecuencia;
    protected int duracion;
    protected String tipo;
    
    public Fuente(String identificador, int frecuencia, int duracion, String tipo){
        this.identificador = identificador;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.tipo = tipo;
    }
  
}
