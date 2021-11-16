package capitulo05.bloque06;

public class Ejercicio04_PuntoEnMapa {
    public static void main(String[]args){
        char [][] mapa = new char[20][10];
        inicializarMapa(mapa);
        imprimirMapa(mapa);
    }
    public static void inicializarMapa(char [][] mapa){
        int posI = (int) (Math.round(Math.random()*mapa.length));
        int posJ = (int) (Math.round(Math.random()*mapa[0].length));
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                if(posI == i && posJ == j) mapa[i][j] = '0';
                else if (i == 0 || i == mapa.length-1) mapa[i][j] = '*';
                else if (j == 0 || j == mapa[0].length-1) mapa[i][j] = '*';
                else mapa[i][j] = ' ';
            }
        }
    }

    public static void imprimirMapa(char[][] mapa){
        for(char [] i: mapa){
            for(char j : i){
                System.out.print(j + "   ");
            }
            System.out.println();
        }
    }
}
