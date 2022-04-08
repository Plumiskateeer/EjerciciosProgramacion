package capitulo07.gestionVentaCoches.modelo.controladores;

import capitulo07.gestionVentaCoches.modelo.Coche;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorCoche  extends ControladorBBDD{
    public static List<Coche> getAll() throws ErrorBBDDException {
        List<Coche> coches = new ArrayList<Coche>();

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from coche");

            while (rs.next()) {
                Coche c = new Coche();
                c.setId(rs.getInt("id"));
                c.setIdfabricante(rs.getInt("idfabricante"));
                c.setBastidor(rs.getString("bastidor"));
                c.setModelo(rs.getString("modelo"));
                c.setColor(rs.getString("color"));
                coches.add(c);
            }

            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return coches;
    }

    public static Coche getCoche(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Coche c = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
            	c = new Coche();
                c.setId(rs.getInt("id"));
                c.setIdfabricante(rs.getInt("idfabricante"));
                c.setBastidor(rs.getString("bastidor"));
                c.setModelo(rs.getString("modelo"));
                c.setColor(rs.getString("color"));
            }

            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

        return c;
    }

    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenar(Coche coche) throws ErrorBBDDException {
        if (get(coche.getId()) != null) { // Solo modificar
            almacenarModificado(coche);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(coche);
        }
    }


    /**
     * @param
     * @return
     * @throws ErrorBBDDException
     */
    public static Coche get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Coche c = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from coche where id = " + id);

            if (rs.next()) {
                c = new Coche();
                c.setId(id);
                c.setIdfabricante(rs.getInt("idfabricante"));
                c.setBastidor(rs.getString("bastidor"));
                c.setModelo(rs.getString("modelo"));
                c.setColor(rs.getString("color"));
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
    public static void almacenarNuevo(Coche c) throws ErrorBBDDException {

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
    public static void almacenarModificado(Coche c) throws ErrorBBDDException {

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
