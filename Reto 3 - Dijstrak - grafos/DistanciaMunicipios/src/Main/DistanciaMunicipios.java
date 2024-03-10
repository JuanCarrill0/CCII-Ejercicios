/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Modelo.*;

public class DistanciaMunicipios {

    
    public static void main(String[] args) {
        
        Dijkstra algoritmoMenorDistancia = new Dijkstra();
        
        System.out.println(algoritmoMenorDistancia.calcularRuta(10, 14));
    }
    
}
