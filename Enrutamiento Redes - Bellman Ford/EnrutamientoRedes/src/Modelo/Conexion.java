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
    private float relacionSR;
    
    public Conexion(float anchoDeBanda, float anchoDeBandaEfectivo,float constanteDeDensidadEspectral){
        this.anchoDeBanda = anchoDeBanda;
        this.anchoDeBandaEfectivo = anchoDeBandaEfectivo;
        this.constanteDeDensidadEspectral = constanteDeDensidadEspectral;
    }
    
    protected void calcularPotencialDeSenal(){
        this.potenciaDeSenal = this.potenciaDeRuido * this.constanteDeDensidadEspectral;
    }
    
    protected void calcularPotenciaDeRuido(){
        this.potenciaDeRuido = this.anchoDeBanda * this.anchoDeBandaEfectivo;
    }
    
    protected double calcularRelacionSR(){
        return 10 * Math.log(this.potenciaDeSenal / this.potenciaDeRuido);
    }
    
}
