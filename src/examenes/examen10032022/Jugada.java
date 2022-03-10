package examenes.examen10032022;

public class Jugada {
    private int id,numero, probabilidad;
    private String descripcion;

    public Jugada(int id,int numero) {
        this.id = id;
        this.numero = numero;
        this.probabilidad = (int) Math.round(Math.random()*80)+10;
        this.descripcion = "Jugada de " + numero + " puntos";
    }

    public Jugada() {
    }

    public void intentoDisparo(Jugador j) throws TiroFallidoException {
        int probTiro = (int) Math.round(Math.random()*100);
        if(probTiro <= this.probabilidad){
            j.sumarPuntuacion(this.numero);
            System.out.println(this);
        }else if(this.numero==100){
            throw new TiroFallidoException("Ha intentado tirar al numero " + this.numero + " y ha fallado");
        }else{
            System.out.println("Ha intentado tirar al numero " + this.numero + " y ha fallado");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }


    @Override
    public String toString() {
        return descripcion;
    }
}
