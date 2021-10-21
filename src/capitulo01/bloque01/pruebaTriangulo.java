package capitulo01.bloque01;

public class pruebaTriangulo {
    public static void main(String[] args) {
    int tam = 10;
    for (int i = 0; i < tam; i++) {
        System.out.println();
        for (int j = 0; j < tam; j++) {
            if (i == 0 || i == tam-1) System.out.print(" * ");
            else if (j == 0 || j == tam-1) System.out.print(" * ");
            else System.out.print("   ");

            }
    }

    int tam2 = 10;
    for (int i = 0; i < tam2; i++) {
        for (int j = tam2 - 1; j >= i; j--) {
            System.out.print("   ");
        }
        for (int k = 0; k < i; k++) {
            System.out.print("   *  ");
        }
        System.out.println();
    }

    int num = 452;

    int contador = 1;
    int digito;
    while (num != 0) {
        if(num < 10)
            digito = num;
        else
            digito = num % 10;

        System.out.println("Digito nº " + contador + ": " + digito);
        num = num / 10;
        contador++;
    }
    }
}

