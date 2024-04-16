/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author tic-asisweb01
 */
public class Conexion {
    
    private boolean estaHabilitado;
    private float probabilidadDeCaida;
    private float anchoDeBanda;
    private float anchoDeBandaEfectivo;
    private float constanteDeDensidadEspectral;
    private float potenciaDeSenal;
    private float potenciaDeRuido;
    private int relacionSR;
    
    public Conexion(float anchoDeBanda, float anchoDeBandaEfectivo, float constanteDeDensidadEspectral){
        this.anchoDeBanda = anchoDeBanda;
        this.anchoDeBandaEfectivo = anchoDeBandaEfectivo;
        this.constanteDeDensidadEspectral = constanteDeDensidadEspectral;
        
        // Inicializar potencia de señal y de ruido
        setPotenciaDeRuido();
        setPotencialDeSenal();
        setRelacionSR();
    }
    
    protected void setPotencialDeSenal(){
        this.potenciaDeSenal = this.potenciaDeRuido * this.constanteDeDensidadEspectral;
    }
    
    protected void setPotenciaDeRuido(){
        this.potenciaDeRuido = this.anchoDeBanda * this.anchoDeBandaEfectivo;
    }
    
    protected void setRelacionSR(){
        this.relacionSR = (int) (10 * Math.log(this.potenciaDeSenal / this.potenciaDeRuido));
    }
    
    protected double getPotencialDeSenal(){
        return this.potenciaDeSenal;
    }
    
    protected double getPotenciaDeRuido(){
        return this.potenciaDeRuido;
    }
    
    protected int getRelacionSR(){
        return this.relacionSR;
    }
    
}
