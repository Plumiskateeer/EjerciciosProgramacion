package capitulo04.bloque04.EntregaClassroom.cuestionario;

public class VoF extends Pregunta{
    private String correcta;

    public VoF(){
        super();
    }

    public VoF(String enunciado, String correcta){
        super(enunciado);
        this.correcta = correcta;
    }

    @Override
    public boolean comprobarRespuesta(String respuesta) {
        return respuesta.equalsIgnoreCase(correcta);
    }

    @Override
    public String toString() {
        return "La respuesta correcta es: " + correcta;
    }
}
