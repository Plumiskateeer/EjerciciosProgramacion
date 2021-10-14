package capitulo04.bloque04.Ejercicio01_Tienda;

public class Perecedero extends Producto {
    String dia, mes, anyo;

    /**
     * Constructor general perecedero
     * @param codigo codigo perecedero
     * @param precio precio perecedero
     * @param nombre precio perecedero
     * @param id id perecedero
     */
    public Perecedero(int codigo, int precio, String nombre, int id) {
        super(codigo, precio, nombre, id);
        this.dia = null;
        this.mes = null;
        this.anyo = null;
    }

    /**
     *
     * @return dia caducidad
     */
    public String getDia() {
        return dia;
    }

    /**
     *
     * @param dia introducir dia caducidad
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     *
     * @return mes caducidad
     */
    public String getMes() {
        return mes;
    }

    /**
     *
     * @param mes mes caducidad
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     *
     * @return año caducidad
     */
    public String getAnyo() {
        return anyo;
    }

    /**
     *
     * @param anyo introducir año caducidad
     */
    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    /**
     *
     * @return toString perecedero
     */
    public String toString() {
        return ("Producto: " + super.getId() + "\n" +
                "Codigo: " + super.getNombre() + "\n" +
                "Nombre: " + super.getNombre() + "\n" +
                "Precio: " + super.getPrecio() + "\n" +
                "Fecha perecedero: (" + this.dia + "/" + this.mes + "/" + this.anyo + ")" + "\n\n");
    }

}
