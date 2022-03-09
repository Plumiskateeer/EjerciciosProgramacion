package capitulo07.gestionVentaCoches.modelo;

import java.util.Date;

public class Venta {
    private int id, idCliente, idConcesionario, idCoche;
    private Date fecha;
    private float precioventa;

    public Venta(int id, int idCliente, int idConcesionario, int idCoche, Date fecha, float precioventa) {
        this.id = id;
        this.idCliente = idCliente;
        this.idConcesionario = idConcesionario;
        this.idCoche = idCoche;
        this.fecha = fecha;
        this.precioventa = precioventa;
    }

    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(int idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    @Override
    public String toString() {
        return "id=" + id +
               ", idCliente=" + idCliente +
               ", idConcesionario=" + idConcesionario +
               ", idCoche=" + idCoche +
               ", fecha=" + fecha +
               ", precioventa=" + precioventa;
    }
}
