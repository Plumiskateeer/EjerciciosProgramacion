package capitulo04.bloque04.primero;

public class Producto {
    private int codigo, precio, id;
    private String nombre;

    public Producto(){
        this.codigo = 0;
        this.precio = 0;
        this.nombre = null;
    }
    public Producto(int codigo, int precio, String nombre, int id){
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return ("Producto: " + this.id + "\n" +
                "Codigo: " + this.nombre + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Precio: " + this.precio + "\n\n");
    }
}
