package capitulo07.gestionVentaCoches.modelo.controladores;

import capitulo07.gestionVentaCoches.modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorCliente extends ControladorBBDD{

    public static List<Cliente> getAll() throws ErrorBBDDException{

        List<Cliente> clientes = new ArrayList<>();

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from cliente");

            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setLocalidad(rs.getString("localidad"));
                cl.setDniNie(rs.getString("dniNie"));
                cl.setFechaNac(rs.getDate("fechaNac"));
                cl.setActivo(rs.getBoolean("activo"));
                clientes.add(cl);
            }

            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return clientes;
    }

    /**
     * @param actors
     * @throws ErrorBBDDException
     */
    public static void almacenar(Cliente cliente) throws ErrorBBDDException {
        if (get(cliente.getId()) != null) { // Solo modificar
            almacenarModificado(cliente);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(cliente);
        }
    }

    /**
     * @param cliente
     * @return
     * @throws ErrorBBDDException
     */
    public static Cliente get(int id) throws ErrorBBDDException {
        Connection conn;
        Cliente cl = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from cliente where id = " + id);

            if (rs.next()) {
                cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setLocalidad(rs.getString("localidad"));
                cl.setDniNie(rs.getString("dniNie"));
                cl.setFechaNac(rs.getDate("fechaNac"));
                cl.setActivo(rs.getBoolean("activo"));
            }
            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return cl;
    }

    /**
     * @param actors
     * @throws ErrorBBDDException
     */
    private static void almacenarNuevo(Cliente cl) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "INSERT INTO cliente (id, nombre, apellidos, localidad, dniNie, fechaNac, activo) VALUES  (?, ?, ?, ?, ?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "cliente"));
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApellidos());
            ps.setString(4, cl.getLocalidad());
            ps.setString(5, cl.getDniNie());
            ps.setDate(6, new java.sql.Date(cl.getFechaNac().getTime()));
            ps.setBoolean(7, cl.getActivo());

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
     * @param actors
     * @throws ErrorBBDDException
     */
    private static void almacenarModificado(Cliente cl) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update cliente set nombre = ?, apellidos = ?, localidad = ?, dniNie = ?, fechaNac = ?, activo = ? where id = ?");
            int registrosInsertados;

            ps.setInt(1, cl.getId());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApellidos());
            ps.setString(4, cl.getLocalidad());
            ps.setString(5, cl.getDniNie());
            ps.setDate(6, new java.sql.Date(cl.getFechaNac().getTime()));
            ps.setBoolean(7, cl.getActivo());

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
     * @param actors
     * @throws ErrorBBDDException
     */
    public static void eliminar(Cliente cl) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = conn.prepareStatement("delete from cliente where id = ?");
            int registrosInsertados;

            ps.setInt(1, cl.getId());

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

