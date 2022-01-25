package capitulo04.SimulacroExamenSpaceInvaders;

import javax.swing.*;
import java.awt.*;

public class Guerra {
    public static void main(String[]args){
//        CampoBatalla campo = CampoBatalla.getInstance();
//        campo.pelea();
        JFrame ventana = new JFrame("Space Invaders");
        ventana.setBounds(0,0,800,600);
        
        ventana.getContentPane().setLayout(new BorderLayout());
        
        MiCanvas canvas = new MiCanvas(creaPersonajes());
        ventana.getContentPane().add(canvas,BorderLayout.CENTER);
        
        ventana.setVisible(true);
    }

}
