package capitulo04.bloque04.Ejercicio01_Tienda;

public class Producto {
    private int codigo, precio, id;
    private String nombre;

    /**
     * Constructor default
     */
    public Producto() {
        this.codigo = 0;
        this.precio = 0;
        this.nombre = null;
    }

    /**
     * Constructor general
     * @param codigo codigo producto
     * @param precio precio producto
     * @param nombre nombre producto
     * @param id     id producto
     */
    public Producto(int codigo, int precio, String nombre, int id) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.id = id;
    }

    /**
     *
     * @return codigo producto
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo introducir codigo producto
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return precio producto
     */
    public int getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio introducir precio producto
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     *
     * @return nombre producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre introducir nombre producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return id producto
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id introducir id producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return toString producto
     */
    public String toString() {
        return ("Producto: " + this.id + "\n" +
                "Codigo: " + this.nombre + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Precio: " + this.precio + "\n\n");
    }
}
