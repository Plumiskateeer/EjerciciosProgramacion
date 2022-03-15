package examenes.examen15032022;

public class Pasta extends Articulo{
    private String tipo;

    public Pasta(int id, int unidades, String nombre, float precioUnidad, String tipo) {
        super(id, unidades, nombre, precioUnidad);
        this.tipo = tipo;
    }

    public Pasta() {
        super();
    }

    @Override
    public String getDescripcion() {
        return "Pasta :" + this.getNombre() + " tipo: " + tipo + ", lleva usted " + this.getUnidades() + " unidades a " +
               this.getPrecioUnidad() + "e/unidad = " + this.getPrecioUnidad()*this.getUnidades();
    }

    @Override
    public String toString(){
        return getDescripcion();
    }
}
