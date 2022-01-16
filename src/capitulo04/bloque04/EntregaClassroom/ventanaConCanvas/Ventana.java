package capitulo04.bloque04.EntregaClassroom.ventanaConCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ventana extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(100, 100, 100, 100);
        g2.setColor(Color.GREEN);
        g2.fill(circle);

        Rectangle rect = new Rectangle(200, 200, 160, 100);
        g2.setColor(Color.RED);
        g2.fill(rect);

        g2.setColor(Color.BLUE);
        int [] puntos1 = {50,0,50};
        int[] puntos2={100,0,50};
        Polygon p = new Polygon(puntos1,puntos2,3);
        g2.fill(p);
    }

}
