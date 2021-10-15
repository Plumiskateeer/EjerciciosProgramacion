package capitulo03.bloque04;

public class Ejercicio03_TablasMultiplicar15 {
    public static void main(String[]args){
        int i = 0;
        while(i<16){
            int tabla = 0;
            System.out.println("Tabla del " + i);
            do{
                System.out.print(i*tabla + " ");
                tabla++;
            }while(tabla < 11);
            System.out.println("\n");
            i++;
        }
    }
}
