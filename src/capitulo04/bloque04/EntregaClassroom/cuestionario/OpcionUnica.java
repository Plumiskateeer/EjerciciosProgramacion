package capitulo04.bloque04.EntregaClassroom.cuestionario;

import java.util.Locale;

public class OpcionUnica extends Pregunta{
    private String correcta;

    public OpcionUnica(){
        super();
    }

    public OpcionUnica(String enunciado, String correcta){
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
