package capitulo05.bloque06;

public class Ejercicio05_MapaUnosCeros {
    public static void main(String[]args){
        char [][] mapa = new char[20][10];
        inicializarMapa(mapa);
        imprimirMapa(mapa);
    }
    public static void inicializarMapa(char [][] mapa){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                int num = (int) (Math.round(Math.random()*1));
                char rndc = (char)(num +'0');
                if (i == 0 || i == mapa.length-1) mapa[i][j] = '*';
                else if (j == 0 || j == mapa[0].length-1) mapa[i][j] = '*';
                else mapa[i][j] = rndc;
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
