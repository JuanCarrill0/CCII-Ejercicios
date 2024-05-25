import grafos3d.Edge;
import grafos3d.Node;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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

            // Convertir el panel a una imagen
            BufferedImage image = new BufferedImage(graphPanel.getPreferredSize().width,
                    graphPanel.getPreferredSize().height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            graphPanel.paint(g2d);
            g2d.dispose();

            // Mostrar la imagen en un JLabel
            JLabel label = new JLabel(new ImageIcon(image));
            frame.add(label);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

