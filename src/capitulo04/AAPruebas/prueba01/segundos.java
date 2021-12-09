package capitulo04.AAPruebas.prueba01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class segundos extends JPanel implements ActionListener {
    Timer t = new Timer(5,this);
    double x = 0, y = 0, velX = 3, velY= 3;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x,y,40,40);
        g2.fill(circle);
        t.start();
    }
    public void actionPerformed(ActionEvent e){
        if (x<0||x>560)
            velX-=velX;
        if (y<0||y>560)
            velY-=velY;
        x+=velX;
        y+=velY;
        repaint();
    }
}
