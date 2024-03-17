/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALEJANDRO
 */
public class Municipio {
    
    private float latitud, longitud;
    private String nombre;
    
    
    public Municipio(String nombre){
        this.nombre = nombre;
    }
    
    public float getLatitud(){
        return latitud;
    }
    
    public float getLongitud(){
        return longitud;
    }
    
    public String getNombre(){
        return nombre;
    }
}
