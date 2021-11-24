package capitulo04.bloque01_PrimerosObjetos;

import javax.swing.*;

public class GestionCromoBaloncesto {
    public static void main(String[] args){
        CromoBaloncesto c1 = new CromoBaloncesto();
        CromoBaloncesto c2 = new CromoBaloncesto("jugador1",175,57,122);
        CromoBaloncesto c3 = new CromoBaloncesto("jugador2",167,75,215);
        CromoBaloncesto c4 = new CromoBaloncesto("jugador1",180,35,123);
        CromoBaloncesto c5 = new CromoBaloncesto("jugador1",198,64,55);


        CromoBaloncesto [] cromos = new CromoBaloncesto[2];
        for(int i = 0; i < cromos.length; i++){
            cromos[i] = new CromoBaloncesto();
            introducirDatos(cromos[i]);
            System.out.println(cromos[i]);
        }

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
    }

    public static void introducirDatos(CromoBaloncesto cromo){
        cromo.setNombrejugador(JOptionPane.showInputDialog("Introduce el nombre: "));
        cromo.setAlturacm(Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: ")));
        cromo.setPesokg(Float.parseFloat(JOptionPane.showInputDialog("Introduce el peso: ")));
        cromo.setPuntos(Float.parseFloat(JOptionPane.showInputDialog("Introduce los puntos: ")));
    }
}
