package capitulo05.bloque06;

public class Ejercicio03_ValorMedio {
    public static void main(String[] args){
        sumarNumeros();
    }

    public static void sumarNumeros(){
        float media = 0;
        int suma = 0, cont = 0;
        while(media < 499.5 || media > 500.5){
            int num = (int)(Math.round(Math.random()*1000)+1);
            cont++;
            suma+=num;
            media=(float) suma/cont;
        }
        System.out.println(media + "\n" + cont + "numeros  numeros necesitados");
    }
}
