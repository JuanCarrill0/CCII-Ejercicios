package Modelo.ElementosEdificio;

import Modelo.ElementosEdificio.Fuente;

public class FuenteExterna extends Fuente{
    
    private String direccionDeProveniencia;

    public FuenteExterna(String identificador, int frecuencia, int duracion, String tipo, String direccionDeProveniencia){
        super(identificador,frecuencia,duracion,tipo);
        this.direccionDeProveniencia = direccionDeProveniencia;
    }
    
    
}

