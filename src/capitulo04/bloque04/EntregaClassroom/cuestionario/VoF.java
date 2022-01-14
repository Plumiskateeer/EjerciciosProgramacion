package capitulo04.bloque04.EntregaClassroom.cuestionario;

public class VoF extends Pregunta{
    private char correcta;
    private String[] opciones;

    public VoF(){
        super();
        this.correcta = '!';
        this.opciones = new String[4];
    }

    public VoF(String enunciado, String[] opciones, char correcta){
        super(enunciado);
        this.opciones = opciones;
        this.correcta = correcta;
    }

    @Override
    public boolean comprobarRespuesta(String respuesta) {
        return (respuesta.charAt(0) - 32) == (correcta - 32);
    }

    public char getCorrecta() {
        return correcta;
    }

    public void setCorrecta(char correcta) {
        this.correcta = correcta;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        return "La opcion correcta es " + correcta;
    }
}
