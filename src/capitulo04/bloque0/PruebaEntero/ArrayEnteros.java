package capitulo04.bloque0.PruebaEntero;

public class ArrayEnteros {
    private static NumeroEntero[] array;

    public ArrayEnteros(int size){
        array = new NumeroEntero[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new NumeroEntero((int)(Math.round(Math.random()*100)));
        }
    }

    public static void add(int num){
        NumeroEntero[] nuevo = new NumeroEntero[array.length+1];
        System.arraycopy(array, 0, nuevo,0, array.length);
        nuevo[nuevo.length-1].setNumero(num);
    }
    public static void remove(int num){
        NumeroEntero[] nuevo = new NumeroEntero[array.length+1];
        NumeroEntero[] aux = array;
        boolean eliminado = false;
        if(estaEnArray(num)) {
            for (int i = 0; i < array.length && eliminado; i++) {
               // if(array[i].getNumero()==num)

            }
        }
        System.arraycopy(array, 0, nuevo,0, array.length);
        nuevo[nuevo.length-1].setNumero(num);
    }

    public static void desplazar(){

    }

    public static boolean estaEnArray(int num){
        boolean esta = false;
        for(NumeroEntero i : array){
            if(i.getNumero() == num)
                esta = true;
        }
        return esta;
    }

    public static void imprimirArray(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].getNumero() + " ");
        }
    }
}
