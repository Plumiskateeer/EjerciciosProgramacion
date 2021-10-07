package capitulo04.bloque04.primero;

public class Perecedero extends Producto{
    String dia, mes, anyo;
    int id;

    public Perecedero(int codigo, int precio, String nombre, int id){
        super(codigo,precio,nombre,id);
        this.dia = null;
        this.mes = null;
        this.anyo = null;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

}
