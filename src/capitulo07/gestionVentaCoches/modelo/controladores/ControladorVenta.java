package capitulo07.gestionVentaCoches.modelo.controladores;

import capitulo07.gestionVentaCoches.modelo.Venta;
import capitulo07.gestionVentaCoches.modelo.Coche;

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
            ResultSet rs = s.executeQuery("Select * from coche where id = " + id);

            if (rs.next()) {
                v = new Venta();
                v.setId(id);
                v.setId(rs.getInt("id"));
                v.setIdCliente(rs.getInt("idCliente"));
                v.setIdConcesionario(rs.getInt("idConcesionario"));
                v.setIdCoche(rs.getInt("idCoche"));
                v.setFecha(rs.getDate("fecha"));
            }
            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return c;
    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    private static void almacenarNuevo(Coche c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "INSERT INTO coche (id, idfabricante, bastidor, modelo, color) VALUES  (?, ?, ?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "coche"));
            ps.setInt(2, c.getIdfabricante());
            ps.setString(3, c.getBastidor());
            ps.setString(4, c.getModelo());
            ps.setString(5, c.getColor());

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
    private static void almacenarModificado(Coche c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update coche set idfabricante = ?, bastidor = ?, modelo = ?, color = ? where id = ?");
            int registrosInsertados;

            ps.setInt(1, c.getIdfabricante());
            ps.setString(2, c.getBastidor());
            ps.setString(3, c.getModelo());
            ps.setString(4, c.getColor());
            ps.setInt(5,c.getId());


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
    public static void eliminar(Coche c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "delete from coche where id = ?");
            int registrosInsertados;

            ps.setInt(1, c.getId());

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
