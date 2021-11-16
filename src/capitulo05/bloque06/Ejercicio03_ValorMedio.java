package capitulo05.bloque06;

public class Ejercicio03_ValorMedio {
    public static void main(String[] args){
        int nNumeros;

        nNumeros = sumarNumeros();
        System.out.println(nNumeros + " numeros necesitados");
    }

    public static int sumarNumeros(){
        float media = 0;
        int indice = 0;
        int [] numerosIntroducidos = new int[1500000];
        while(media < 499.5 || media > 500.5){
            int num = (int)(Math.round(Math.random()*1000)+1);
            numerosIntroducidos[indice] = num;
            indice++;
            media = calcularMedia(indice, numerosIntroducidos);
        }
        System.out.println(media);
        return indice;
    }

    public static float calcularMedia(int tamanyo, int[] numeros){
        float media = 0;
        for(int i = 0; i < tamanyo; i++){
            media +=numeros[i];
        }
        return media / tamanyo;
    }
}
