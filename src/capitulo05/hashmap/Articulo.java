package capitulo05.hashmap;

public class Articulo {
    private String codigo;
    private int numEstante, cantidad;

    public Articulo(String codigo, int numEstante, int cantidad) {
        this.codigo = codigo;
        this.numEstante = numEstante;
        this.cantidad = cantidad;
    }

    public Articulo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumEstante() {
        return numEstante;
    }

    public void setNumEstante(int numEstante) {
        this.numEstante = numEstante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Articulo{" +
               "codigo='" + codigo + '\'' +
               ", numEstante=" + numEstante +
               ", cantidad=" + cantidad +
               '}';
    }
}
