package capitulo04.bloque03;

public class Rectangulo {
    private int altura, base;

    public Rectangulo(int altura, int base){
        this.altura = altura;
        this.base = base;
    }
    public int getAltura(){return this.altura;}

    public void setAltura(int altura){
        this.altura = altura;
    }

    public int getBase(){return this.base;}

    public void setBase(int base){
        this.base = base;
    }

    public String toString(){
        StringBuilder rectangulo = new StringBuilder();

        for(int i = 0; i<base; i++){
            rectangulo.append("\n");
            for(int j = 0; j<altura; j++){
                rectangulo.append(" * ");
            }
        }
        return rectangulo.toString();
    }

}
