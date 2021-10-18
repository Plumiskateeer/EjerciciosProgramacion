package capitulo04.bloque04.Ejercicio04_Componentes;

public class Circuito {
    public static void main(String[]args){
        Componente bat1 = new Bateria(5,null,null);
        Componente res1 = new Resistencia(3,bat1,null);
        Componente raiz = new Componente();
    }
}
