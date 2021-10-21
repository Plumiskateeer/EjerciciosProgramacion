package examenes.examen20211021;

public class Ejercicio01 {
    public static void main(String[] args) {
        int suma = 0;
        System.out.println("Los numeros son:\n");
        for (int i = 0; i < 100; i++) { // itero
            int num = (int) (Math.round(Math.random() * (100))); // aqui genero un numero aleatorio
            System.out.print(num + " ");
            if (num % 5 == 0) // si es multiplo lo sumo
                suma += num;
        }
        System.out.println("\nLa suma de los multiplos de 5 es: " + suma); // muestro la suma

    }
}
