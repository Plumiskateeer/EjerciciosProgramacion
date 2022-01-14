package capitulo04.bloque04.EntregaClassroom.coleccionAntiguedades;

public class ColeccionAntiguedades {
    public static void main(String[] args) {

        Joya j = new Joya();
        CocheAntiguo c = new CocheAntiguo();
        Libro l = new Libro();
        Jarron ja = new Jarron();
        j.introduceJoya();
        c.introduceCoche();
        l.introduceLibro();
        ja.introduceJarron();

        System.out.println(j);
        System.out.println(c);
        System.out.println(l);
        System.out.println(ja);


    }
}
