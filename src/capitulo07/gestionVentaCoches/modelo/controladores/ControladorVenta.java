package capitulo07.gestionVentaCoches.modelo.controladores;

import capitulo07.gestionVentaCoches.modelo.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorVenta extends ControladorBBDD{

    public static List<Venta> getAll() throws ErrorBBDDException {
        List<Venta> ventas = new ArrayList<Venta>();

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from venta");

            while (rs.next()) {
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setIdCliente(rs.getInt("idCliente"));
                v.setIdConcesionario(rs.getInt("idConcesionario"));
                v.setIdCoche(rs.getInt("idCoche"));
                v.setFecha(rs.getDate("fecha"));
                v.setPrecioventa(rs.getFloat("precioVenta"));
                ventas.add(v);

            }

            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return ventas;
    }

    public static Venta getVenta(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Venta v = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
            	v = new Venta();
            	v.setId(rs.getInt("id"));
                v.setIdCliente(rs.getInt("idCliente"));
                v.setIdConcesionario(rs.getInt("idConcesionario"));
                v.setIdCoche(rs.getInt("idCoche"));
                v.setFecha(rs.getDate("fecha"));
                v.setPrecioventa(rs.getFloat("precioVenta"));
            }

            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

        return v;
    }

    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenar(Venta venta) throws ErrorBBDDException {
        if (get(venta.getId()) != null) { // Solo modificar
            almacenarModificado(venta);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(venta);
        }
    }


    /**
     * @param
     * @return
     * @throws ErrorBBDDException
     */
    public static Venta get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Venta v = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from venta where id = " + id);

            if (rs.next()) {
                v = new Venta();
                v.setId(id);
                v.setId(rs.getInt("id"));
                v.setIdCliente(rs.getInt("idCliente"));
                v.setIdConcesionario(rs.getInt("idConcesionario"));
                v.setIdCoche(rs.getInt("idCoche"));
                v.setFecha(rs.getDate("fecha"));
                v.setPrecioventa(rs.getFloat("precioVenta"));
            }
            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return v;
    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarNuevo(Venta v) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "INSERT INTO venta (id, idCliente, idConcesionario, idCoche, fecha, precioVenta) VALUES  (?, ?, ?, ?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "venta"));
            ps.setInt(2, v.getIdCliente());
            ps.setInt(3, v.getIdConcesionario());
            ps.setInt(4, v.getIdCoche());
            ps.setDate(5, new java.sql.Date(v.getFecha().getTime()));
            ps.setFloat(6, v.getPrecioventa());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la inserci�n del nuevo registro");
            }
            ps.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarModificado(Venta v) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update venta set idCliente = ?, idConcesionario = ?, idCoche = ?, fecha = ?, precioVenta = ? where id = ?");
            int registrosInsertados;

            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdConcesionario());
            ps.setInt(3, v.getIdCoche());
            ps.setDate(4, (Date) v.getFecha());
            ps.setFloat(5, v.getPrecioventa());
            ps.setInt(6, v.getId());


            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la modificaci�n del registro");
            }
            ps.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void eliminar(Venta v) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "delete from venta where id = ?");
            int registrosInsertados;

            ps.setInt(1, v.getId());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la eliminaci�n del registro");
            }
            ps.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }
}
