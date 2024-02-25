package modelo;

import java.util.ArrayList;

class Hash<K, V> {
    private final ArrayList<ArrayList<Entrada<K, V>>> buckets; // Lista de listas para los "buckets"
    private static final int CAPACIDAD_POR_DEFECTO = 16; // Capacidad inicial por defecto

    public Hash() {
        buckets = new ArrayList<>(CAPACIDAD_POR_DEFECTO); // Inicializa el array de buckets con la capacidad por defecto
        for (int i = 0; i < CAPACIDAD_POR_DEFECTO; i++) {
            buckets.add(new ArrayList<>()); // Inicializa cada bucket con una lista vacía
        }
    }

    // Método para agregar una entrada al mapa
    public void poner(K clave, V valor) {
        int indice = obtenerIndice(clave); // Obtiene el índice del bucket
        for (Entrada<K, V> entrada : buckets.get(indice)) { // Recorre las entradas en el bucket
            if (entrada.obtenerClave().equals(clave)) { // Si la clave ya existe, actualiza el valor
                entrada.establecerValor(valor);
                return;
            }
        }
        buckets.get(indice).add(new Entrada<>(clave, valor)); // Si la clave no existe, agrega una nueva entrada al bucket
    }

    // Método para obtener el valor asociado a una clave
    public V obtener(K clave) {
        int indice = obtenerIndice(clave); // Obtiene el índice del bucket
        for (Entrada<K, V> entrada : buckets.get(indice)) { // Recorre las entradas en el bucket
            if (entrada.obtenerClave().equals(clave)) { // Si encuentra la clave, retorna el valor asociado
                return entrada.obtenerValor();
            }
        }
        return null; // Si la clave no existe, retorna null
    }

    // Método para eliminar una entrada del mapa
    public void eliminar(K clave) {
        int indice = obtenerIndice(clave); // Obtiene el índice del bucket
        buckets.get(indice).removeIf(entrada -> entrada.obtenerClave().equals(clave)); // Elimina la entrada con la clave dada
    }

    // Método para obtener el índice del bucket usando el hash de la clave
    private int obtenerIndice(K clave) {
        return Math.abs(clave.hashCode() % CAPACIDAD_POR_DEFECTO); // Utiliza el hash de la clave para calcular el índice
    }

    // Clase interna que representa una entrada en el mapa
    private static class Entrada<K, V> {
        private final K clave;
        private V valor;

        public Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public K obtenerClave() {
            return clave;
        }

        public V obtenerValor() {
            return valor;
        }

        public void establecerValor(V valor) {
            this.valor = valor;
        }
    }
}
