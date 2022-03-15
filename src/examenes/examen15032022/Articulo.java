package examenes.examen15032022;

public abstract class Articulo {
    private int id, unidades;
    private String nombre;
    private float precioUnidad;

    public Articulo(int id, int unidades, String nombre, float precioUnidad) {
        this.id = id;
        this.unidades = unidades;
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
    }

    public Articulo() {
    }

    public abstract String getDescripcion();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

}
