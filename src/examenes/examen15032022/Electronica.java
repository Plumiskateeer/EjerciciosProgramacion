package examenes.examen15032022;

public class Electronica extends Articulo{
    private int potencia;

    public Electronica(int id, int unidades, String nombre, float precioUnidad, int potencia) {
        super(id, unidades, nombre, precioUnidad);
        this.potencia = potencia;
    }

    public Electronica() {
        super();
    }

    @Override
    public String getDescripcion() {
        return "Electronica :" + this.getNombre() + " de: " + potencia + ", lleva usted " + this.getUnidades() + " unidades a " +
               this.getPrecioUnidad() + "e/unidad = " + this.getPrecioUnidad()*this.getUnidades();
    }

    @Override
    public String toString(){
        return getDescripcion();
    }
}
