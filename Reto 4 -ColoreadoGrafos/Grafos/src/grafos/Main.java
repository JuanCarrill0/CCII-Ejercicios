/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafos;

/**
 *
 * @author tic-asisweb01
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Complete Graph 2D");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crear nodos
            int n = 5; // número de nodos
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = (int) (200 + 100 * Math.cos(2 * Math.PI * i / n));
                int y = (int) (200 + 100 * Math.sin(2 * Math.PI * i / n));
                nodes.add(new Node(x, y));
            }

            // Crear aristas
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    edges.add(new Edge(nodes.get(i), nodes.get(j)));
                }
            }

            // Crear el panel del grafo
            GraphPanel graphPanel = new GraphPanel(nodes, edges);

            // Añadir el panel al frame
            frame.add(graphPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}


