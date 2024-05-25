/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

class GraphPanel extends JPanel {
    private List<Node> nodes;
    private List<Edge> edges;

    public GraphPanel(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar aristas
        g2d.setColor(Color.BLACK);
        for (Edge edge : edges) {
            g2d.drawLine(edge.from.x, edge.from.y, edge.to.x, edge.to.y);
        }

        // Dibujar nodos
        g2d.setColor(Color.RED);
        int radius = 10;
        for (Node node : nodes) {
            g2d.fillOval(node.x - radius, node.y - radius, 2 * radius, 2 * radius);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}