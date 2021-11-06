package capitulo01.bloque01;

public class oaisjdioas {
    public static void main(String[]args){
        int []array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.round(Math.random()*100));
        }
        System.out.println("Matriz original");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        for (int i = 0; i < array.length/2; i++) {
            int aux = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = aux;
        }

        System.out.println("\nMatriz original");
        for (int i = 0; i < array.length; i++) {
           System.out.print(array[i] + " ");
        }
    }
}

