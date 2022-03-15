package examenes.examen15032022;

public class Fruta extends Articulo{
    private boolean deTemporada;

    public Fruta(int id, int unidades, String nombre, float precioUnidad, boolean deTemporada) {
        super(id, unidades, nombre, precioUnidad);
        this.deTemporada = deTemporada;
    }

    public Fruta() {
        super();
    }

    @Override
    public String getDescripcion() {
        return "Fruta :" + this.getNombre() + " de temporada: " + deTemporada + ", lleva usted " + this.getUnidades() + " unidades a " +
               this.getPrecioUnidad() + "e/unidad = " + this.getPrecioUnidad()*this.getUnidades();
    }

    @Override
    public String toString(){
        return getDescripcion();
    }
}
