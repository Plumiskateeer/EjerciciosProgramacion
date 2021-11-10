package capitulo02.bloque01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PruebaEjercicio01 {

    @Test
    public void testMetodo1() {
        int numero = Ejercicio01_MayordeDosNumeros.mayorde2(3, 5);
        int esperado = 5;

        assertEquals(numero, esperado);
    }
}