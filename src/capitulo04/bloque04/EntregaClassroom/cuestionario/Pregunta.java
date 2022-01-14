package capitulo04.bloque04.EntregaClassroom.cuestionario;

public abstract class Pregunta {
    private String enunciado;


    public Pregunta(){

    }
    public Pregunta(String enunciado){
        this.enunciado = enunciado;
    }

    public abstract void comprobarRespuesta();

}
