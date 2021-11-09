package capitulo05.bloque04;

import javax.swing.*;
import java.util.Arrays;

public class Ejercicio04_ArrayBidimensional {
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];
        inicializarMatriz(matriz);
        imprimirMatriz(matriz);
        esMatrizPositiva(matriz);
        esMatrizDiagonal(matriz);
        esTriangularSuperior(matriz);
        esMatrizDispersa(matriz);
        int[] matriz1D = convertirDimension(matriz);
        System.out.println(Arrays.toString(matriz1D));
        esMatrizSimetrica(matriz);
        int[][] traspuesta = calcularTraspuesta(matriz);
        imprimirMatriz(traspuesta);
        System.out.println();
        int[][] opuesta = calcularOpuesta(matriz);
        imprimirMatriz(opuesta);
        System.out.println();
        eliminarFilaMatriz(matriz);
        imprimirMatriz(matriz);
    }

    public static void inicializarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int) (Math.round(Math.random() * (12)) - 2);
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] i : matriz) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void esMatrizPositiva(int[][] matriz) {
        boolean esPositiva = true;

        for (int i = 0; i < matriz.length && esPositiva; i++) {
            for (int j = 0; j < matriz.length && esPositiva; j++) {
                if (matriz[i][j] < 0)
                    esPositiva = false;
            }
        }
        if (esPositiva) System.out.println("La matriz es positiva");
        else System.out.println("La matriz NO es positiva");
    }

    public static void esMatrizDiagonal(int[][] matriz) {
        boolean esDiagonal = true;

        for (int i = 0; i < matriz.length && esDiagonal; i++) {
            for (int j = 0; j < matriz.length && esDiagonal; j++) {
                if (i == j && matriz[i][j] == 0)
                    esDiagonal = false;
            }
        }
        if (esDiagonal) System.out.println("La matriz es diagonal");
        else System.out.println("La matriz NO es diagonal");
    }

    public static void esTriangularSuperior(int[][] matriz) {
        boolean esTriangularSuperior = true;

        for (int i = 0; i < matriz.length && esTriangularSuperior; i++) {
            for (int j = 0; j < matriz.length && esTriangularSuperior; j++) {
                if (j >= i && matriz[i][j] == 0)
                    esTriangularSuperior = false;
            }
        }
        if (esTriangularSuperior) System.out.println("La matriz es triangular superior");
        else System.out.println("La matriz NO es triangular superior");
    }

    public static void esMatrizDispersa(int[][] matriz) {
        boolean esDispersa = true;
        int contNulos = matriz.length;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length && esDispersa; j++) {
                if (matriz[i][j] == 0) {
                    esDispersa = false;
                    contNulos--;
                }
            }
        }
        if (contNulos == 0) System.out.println("La matriz es dispersa");
        else System.out.println("La matriz NO es dispersa");
    }

    public static int[] convertirDimension(int[][] matriz) {
        int[] unidimensional = new int[matriz.length * matriz.length];
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                unidimensional[cont] = matriz[i][j];
                cont++;
            }
        }
        return unidimensional;
    }

    public static void esMatrizSimetrica(int[][] matriz) {
        boolean iguales = true;
        for (int i = 0; i < matriz.length && iguales; i++) {
            for (int j = 0; j < matriz.length && iguales; j++) {
                if (matriz[i][j] != matriz[j][i])
                    iguales = false;
            }
        }
        if (iguales) System.out.println("La matriz es simetrica");
        else System.out.println("La matriz NO es simetrica");
    }

    public static int[][] calcularTraspuesta(int[][] matriz) {
        int[][] traspuesta = new int[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }
        return traspuesta;
    }

    public static int[][] calcularOpuesta(int[][] matriz) {
        int[][] opuesta = new int[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                opuesta[i][j] = matriz[i][j] * -1;
            }
        }
        return opuesta;
    }

    public static void eliminarFilaMatriz(int[][] matriz) {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de fila que quieres eliminar: "));

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == fila - 1)
                    matriz[i][j] = 0;
            }
        }
    }

}
