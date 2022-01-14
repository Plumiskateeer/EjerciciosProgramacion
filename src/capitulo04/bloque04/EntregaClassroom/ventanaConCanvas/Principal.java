package capitulo04.bloque04.EntregaClassroom.ventanaConCanvas;

import javax.swing.*;

public class Principal {
    public static void main(String[]args){
        Ventana v = new Ventana();
        JFrame jf = new JFrame();
        jf.add(v);
        jf.setVisible(true);
        jf.setSize(650,450);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
