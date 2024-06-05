package Vista;

public class TestSimulacion3D {

    public static void main(String[] args) {
        Simulacion3D simulacion = new Simulacion3D();
        
        // Crear nodos antes de iniciar la simulación JavaFX
        simulacion.crearNodo(1, 10, 10, 10);
        simulacion.crearNodo(2, 20, 20, 20);
        
        // Iniciar la simulación JavaFX
        simulacion.iniciarSimulacion3D(args);
    }
}

