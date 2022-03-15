package examenes.examen15032022;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Articulo> compra;

    public Cliente(String nombre){
        this.nombre = nombre;
        this.compra = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Articulo> getCompra() {
        return compra;
    }

    public void setCompra(List<Articulo> compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "El cliente " + this.nombre + " quiere comprar los articulos: " + this.compra.toString();
    }
}
