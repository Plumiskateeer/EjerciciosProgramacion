package capitulo05.bloque06;

import capitulo04.bloque03.Ejercicio01y02_Semaforo.Semaforo;
import capitulo07.gestionVentaCoches.Main;
import com.mysql.cj.protocol.x.SyncMessageReader;
import com.mysql.cj.protocol.x.SyncMessageSender;

public class Ejercicio01_Primitiva {
    public static void main(String[] args) {

        int[] loteria = new int[7];

        inicializarMatriz(loteria);
        imprimirMatriz(loteria);


    }
    public static void imprimirMatriz(int[] matriz){
        for(int i : matriz)
            System.out.print(i + " ");
    }

    public static void inicializarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int num = (int)(Math.round(Math.random()*50)-1);
            if(!estaenMatriz(matriz, num)){
                matriz[i] = num;
            }else i--;
        }
    }

    public static boolean estaenMatriz(int[] matriz, int num){
        boolean esta = false;
        for (int i = 0; i < matriz.length && !esta; i++) {
            if(matriz[i] == num)
                esta = true;
        }
        return esta;
    }
}
