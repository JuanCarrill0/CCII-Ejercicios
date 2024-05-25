package Vista;

import Modelo.ElementosGrafo.Espacio;

import java.awt.*;
import java.util.List;
import javax.swing.JPanel;

public class MostrarHabitacionPanel extends JPanel {
    private Espacio habitacion;

    public MostrarHabitacionPanel(Espacio habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 5;
        int y = 10;
        int width = 100;
        int height = 30;
        int count = 0;
        
        for (int i =0 ; i<= habitacion.getEspacioHabitacion().size()- 1 ; i++) {
            g.drawRect(x, y, width, height);
            g.drawString(habitacion.getEspacioHabitacion().get(i).getFuentes().toString(), x + 5, y + 20);
            x += width + 10;
            count++;
            if (count % 5 == 0) {
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
