/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Modelo.arbolBinario.Nodo;
import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author ALEJANDRO
 */
public class arbolGrafico extends JPanel{
    
    private arbolBinario miArbol;
    private HashMap posicionNodos = null;
    private HashMap tamanoSubArboles = null;
    private boolean tableroSucio = true;
    private int distanciaPadreHijo = 20, distanciaHijoHijo = 30;
    private Dimension dimensionArbol = new Dimension(0,0);
    private FontMetrics metricasDelTexto = null;
    
    public arbolGrafico(arbolBinario miArbol){
        this.miArbol = miArbol;
        this.setBackground(Color.white);
        posicionNodos = new HashMap();
        tamanoSubArboles = new HashMap();
        tableroSucio = true;
        repaint();
    }
    
    private void calcularPosiciones(){
        posicionNodos.clear();
        tamanoSubArboles.clear();
        Nodo raizDelArbol = this.miArbol.getRaiz();
        
        if(raizDelArbol != null){
            calcularTamanoSubArbol(raizDelArbol);
            calcularPosicionDeNodos(raizDelArbol, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        } 
        
        System.out.println("Calculando posiciones...");
    }
    
    private Dimension calcularTamanoSubArbol(Nodo nodoRaizDelSubArbol){
        if(nodoRaizDelSubArbol == null){
            return new Dimension(0,0);
        }
        
        Dimension dimensionSubArbolIzquierdo = calcularTamanoSubArbol(nodoRaizDelSubArbol.getIzq());
        Dimension dimensionSubArbolDerecho = calcularTamanoSubArbol(nodoRaizDelSubArbol.getDer());
        
        int alturaArbol = metricasDelTexto.getHeight() + distanciaPadreHijo + Math.max(dimensionSubArbolIzquierdo.height, dimensionSubArbolDerecho.height);
        int anchoArbol = dimensionSubArbolIzquierdo.width + distanciaHijoHijo + dimensionSubArbolDerecho.width;
        
        Dimension dimensionDelArbol = new Dimension(anchoArbol, alturaArbol);
        tamanoSubArboles.put(nodoRaizDelSubArbol, dimensionDelArbol);
        
        return dimensionDelArbol;
    }
    
    private void calcularPosicionDeNodos(Nodo nodoRaizDelSubArbol, int izquierdo, int derecho, int superior){
        
        int centro = -75;
        
        if(nodoRaizDelSubArbol == null){
            return;
        }
        
        Dimension dimensionSubArbolIzquierdo = (Dimension) tamanoSubArboles.get(nodoRaizDelSubArbol.getIzq());
        if(dimensionSubArbolIzquierdo == null){
            dimensionSubArbolIzquierdo = dimensionArbol;
        }
        
        
        Dimension dimensionSubArbolDerecho = (Dimension) tamanoSubArboles.get(nodoRaizDelSubArbol.getDer());
        if(dimensionSubArbolDerecho == null){
            dimensionSubArbolDerecho = dimensionArbol;
        }
        
        if(derecho != Integer.MAX_VALUE){
            centro = derecho - dimensionSubArbolDerecho.width - distanciaHijoHijo / 2; 
        } else if (izquierdo != Integer.MAX_VALUE){
            centro = izquierdo + dimensionSubArbolIzquierdo.width + distanciaHijoHijo / 2;     
        }
        
        int anchura = metricasDelTexto.stringWidth(nodoRaizDelSubArbol.getDato() + "");
        
        posicionNodos.put(nodoRaizDelSubArbol, new Rectangle(centro - anchura / 2 - 3, superior, anchura + 6, metricasDelTexto.getHeight()));
        
        calcularPosicionDeNodos(nodoRaizDelSubArbol.getIzq(), Integer.MAX_VALUE, centro - distanciaHijoHijo / 2, superior + metricasDelTexto.getHeight() + distanciaPadreHijo);
        calcularPosicionDeNodos(nodoRaizDelSubArbol.getDer(), centro + distanciaHijoHijo / 2, Integer.MAX_VALUE, superior + metricasDelTexto.getHeight() + distanciaPadreHijo);  
    }
    
    
    private void dibujarArbol(Graphics2D graphics, Nodo nodoRaizDelSubArbol, int puntoEnX, int puntoEnY, int offsetY){
        if(nodoRaizDelSubArbol == null){
            return;
        }
        
        Rectangle rectanguloNodo = (Rectangle) posicionNodos.get(nodoRaizDelSubArbol);
        graphics.draw(rectanguloNodo);
        graphics.drawString(nodoRaizDelSubArbol.getDato()+"", rectanguloNodo.x + 3, rectanguloNodo.y + offsetY);
        
        if(puntoEnX != Integer.MAX_VALUE){
            graphics.drawLine(puntoEnX, puntoEnY, (int) (rectanguloNodo.x + rectanguloNodo.width / 2), rectanguloNodo.y);
        }
        
        dibujarArbol(graphics, nodoRaizDelSubArbol.getIzq(), (int) (rectanguloNodo.x + rectanguloNodo.width / 2), rectanguloNodo.y + rectanguloNodo.height, offsetY);
        dibujarArbol(graphics, nodoRaizDelSubArbol.getDer(), (int) (rectanguloNodo.x + rectanguloNodo.width / 2), rectanguloNodo.y + rectanguloNodo.height, offsetY);
    }
    
    
    
    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        metricasDelTexto = graphics.getFontMetrics();
        
        if(tableroSucio){
            calcularPosiciones();
            tableroSucio = false;
        }
        
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(getWidth()/2, distanciaPadreHijo);
        dibujarArbol(graphics2D, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, metricasDelTexto.getLeading() + metricasDelTexto.getAscent());
        metricasDelTexto = null;
    }
    
    
    @Override
    public Dimension getPreferredSize() {
    // Devuelve un tamaño preferido adecuado para tu árbol
    return new Dimension(500, 500);
    }
    
}
