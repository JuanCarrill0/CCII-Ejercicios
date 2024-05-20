package Vista;

import Modelo.Espacio;

import java.awt.*;
import java.util.List;
import javax.swing.JPanel;

public class MostrarHabitacionesPanel extends JPanel {
    private List<Espacio> disposicion;

    public MostrarHabitacionesPanel(List<Espacio> disposicion) {
        this.disposicion = disposicion;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 5;
        int y = 10;
        int width = 100;
        int height = 30;
        int count = 0;
        
        for (int i =0 ; i<= disposicion.size() -1 ; i++) {
            g.drawRect(x, y, width, height);
            g.drawString(disposicion.get(i).getIdentificador(), x + 5, y + 20);
            x += width + 10;
            count++;
            if (count % 7 == 0) {
                x = 10;
                y += height + 20;
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(541, 304); // Ajusta el tamaño según sea necesario
    }
}
