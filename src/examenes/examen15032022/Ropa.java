package examenes.examen15032022;

public class Ropa extends Articulo{
    private String talla;

    public Ropa(int id, int unidades, String nombre, float precioUnidad, String talla) {
        super(id, unidades, nombre, precioUnidad);
        this.talla = talla;
    }

    public Ropa() {
        super();
    }

    @Override
    public String getDescripcion() {
        return "Ropa :" + this.getNombre() + " talla: " + talla + ", lleva usted " + this.getUnidades() + " unidades a " +
               this.getPrecioUnidad() + "e/unidad = " + this.getPrecioUnidad()*this.getUnidades();
    }

    @Override
    public String toString(){
        return getDescripcion();
    }
}
