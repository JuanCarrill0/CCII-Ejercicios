/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JPanel;

/**
 *
 * @author juanc
 * @param <T>
 */
// Definición de la clase ArbolBinario
// Definición de la clase ArbolBinario

public class arbolBinario<T> {
    // Clase interna para representar un nodo del árbol
    public class Nodo {
        T dato;
        Nodo izquierdo;
        Nodo derecho;

        // Constructor para un nodo
        Nodo(T dato) {
            this.dato = dato;
            izquierdo = null;
            derecho = null;
        }
        
        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public Nodo getIzq() {
            return izquierdo;
        }

        public void setIzq(Nodo izq) {
            this.izquierdo = izq;
        }
        
        public Nodo getDer() {
            return derecho;
        }

        public void setDer(Nodo der) {
            this.derecho = der;
        }
        
    }

    private Nodo raiz; // Raíz del árbol
    
    public Nodo getRaiz(){
        return raiz;
    }

    // Constructor de la clase ArbolBinario
    public arbolBinario() {
        raiz = null;
    }

    // Método para verificar si el árbol está vacío
    public boolean esVacio() {
        return raiz == null;
    }

    // Método para insertar un dato en el árbol
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    // Método auxiliar recursivo para la inserción de un dato
    private Nodo insertarRecursivo(Nodo nodo, T dato) {
        if (nodo == null) {
            nodo = new Nodo(dato);
        } else {
            if (dato.hashCode() < nodo.dato.hashCode()) {
                nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
            } else if (dato.hashCode() > nodo.dato.hashCode()) {
                nodo.derecho = insertarRecursivo(nodo.derecho, dato);
            }
        }
        return nodo;
    }

    // Método para buscar un dato en el árbol
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    // Método auxiliar recursivo para la búsqueda de un dato
    private boolean buscarRecursivo(Nodo nodo, T dato) {
        if (nodo == null) {
            return false;
        }
        if (dato.hashCode() == nodo.dato.hashCode()) {
            return true;
        }
        return dato.hashCode() < nodo.dato.hashCode()
                ? buscarRecursivo(nodo.izquierdo, dato)
                : buscarRecursivo(nodo.derecho, dato);
    }

    // Método para eliminar un dato del árbol
    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    // Método auxiliar recursivo para la eliminación de un dato
    private Nodo eliminarRecursivo(Nodo nodo, T dato) {
        if (nodo == null) {
            return nodo;
        }
        if (dato.hashCode() < nodo.dato.hashCode()) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
        } else if (dato.hashCode() > nodo.dato.hashCode()) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            // Nodo con dos hijos
            nodo.dato = encontrarMenorValor(nodo.derecho);
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.dato);
        }
        return nodo;
    }

    // Método auxiliar para encontrar el menor valor en un subárbol
    private T encontrarMenorValor(Nodo nodo) {
        T minValor = nodo.dato;
        while (nodo.izquierdo != null) {
            minValor = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return minValor;
    }

    // Método para recorrer el árbol en orden (izquierda, raíz, derecha)
    public void recorridoEnOrden() {
        recorridoEnOrdenRecursivo(raiz);
    }

    // Método auxiliar recursivo para recorrer en orden
    private void recorridoEnOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoEnOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            recorridoEnOrdenRecursivo(nodo.derecho);
        }
    }

    // Método para recorrer el árbol en preorden (raíz, izquierda, derecha)
    public void recorridoPreOrden() {
        recorridoPreOrdenRecursivo(raiz);
    }

    // Método auxiliar recursivo para recorrer en preorden
    private void recorridoPreOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            recorridoPreOrdenRecursivo(nodo.izquierdo);
            recorridoPreOrdenRecursivo(nodo.derecho);
        }
    }

    // Método para recorrer el árbol en postorden (izquierda, derecha, raíz)
    public void recorridoPostOrden() {
        recorridoPostOrdenRecursivo(raiz);
    }

    // Método auxiliar recursivo para recorrer en postorden
    private void recorridoPostOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoPostOrdenRecursivo(nodo.izquierdo);
            recorridoPostOrdenRecursivo(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    // Método para obtener la altura del árbol
    public int altura() {
        return alturaRecursivo(raiz);
    }

    // Método auxiliar recursivo para obtener la altura
    private int alturaRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int izquierdaAltura = alturaRecursivo(nodo.izquierdo);
            int derechaAltura = alturaRecursivo(nodo.derecho);

            return Math.max(izquierdaAltura, derechaAltura) + 1;
        }
    }
    
    public JPanel getDibujo(){
        return new arbolGrafico(this);
    }
}
