package capitulo04.AAPruebas.prueba01;

import javax.swing.*;

public class principal {
    public static void main(String[] args){
        segundos s = new segundos();
        JFrame f = new JFrame();
        f.add(s);
        f.setVisible(true);
        f.setSize(650,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
