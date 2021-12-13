package capitulo04.AAPruebas.prueba01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class segundos extends JPanel implements ActionListener {
    Timer t = new Timer(5, this);
    double x = 0, y = 0, velX = 1, velY = 1;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x, y, 50, 20);
        g2.fill(circle);
        Graphics2D g3 = (Graphics2D) g;
        Ellipse2D circle2 = new Ellipse2D.Double(x, y, 20, 50);
        g3.fill(circle2);
        Graphics2D g4 = (Graphics2D) g;
        Ellipse2D circle3 = new Ellipse2D.Double(x, y, 84, 2);
        g4.fill(circle3);
        Graphics2D g5 = (Graphics2D) g;
        Ellipse2D circle4 = new Ellipse2D.Double(x, y, 2, 84);
        g5.fill(circle4);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (x < 0 || x > 560) {
            velX = -velX;
        }
        if (y < 0 || y > 360) {
            velY = -velY;
        }
        x += velX;
        y += velY;
        repaint();

    }

}
