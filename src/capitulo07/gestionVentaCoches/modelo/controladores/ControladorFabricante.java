package capitulo07.gestionVentaCoches.modelo.controladores;

import capitulo07.gestionVentaCoches.modelo.Fabricante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorFabricante extends ControladorBBDD {


    public static List<Fabricante> getAll() throws ErrorBBDDException {
        List<Fabricante> fabricantes = new ArrayList<Fabricante>();

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from fabricante");

            while (rs.next()) {
                Fabricante fab = new Fabricante();
                fab.setId(rs.getInt("id"));
                fab.setCif(rs.getString("cif"));
                fab.setNombre(rs.getString("nombre"));
                fabricantes.add(fab);
            }

            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return fabricantes;
    }

    public static Fabricante getFabricante(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Fabricante fab = new Fabricante();
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
                fab.setId(rs.getInt("id"));
                fab.setCif(rs.getString("cif"));
                fab.setNombre(rs.getString("nombre"));
            }

            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

        return fab;
    }

    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenar(Fabricante fabricante) throws ErrorBBDDException {
        if (get(fabricante.getId()) != null) { // Solo modificar
            almacenarModificado(fabricante);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(fabricante);
        }
    }


    /**
     * @param
     * @return
     * @throws ErrorBBDDException
     */
    public static Fabricante get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Fabricante fab = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from fabricante where id = " + id);

            if (rs.next()) {
                fab = new Fabricante();
                fab.setId(id);
                fab.setCif(rs.getString("cif"));
                fab.setNombre(rs.getString("nombre"));
            }
            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return fab;
    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    private static void almacenarNuevo(Fabricante fab) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "INSERT INTO fabricante (id, cif, nombre) VALUES  (?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "fabricante"));
            ps.setString(2, fab.getCif());
            ps.setString(3, fab.getNombre());

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
    private static void almacenarModificado(Fabricante fab) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update fabricante set cif = ?, nombre = ? where id = ?");
            int registrosInsertados;

            ps.setString(1, fab.getCif());
            ps.setString(2, fab.getNombre());
            ps.setInt(3, fab.getId());

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
    public static void eliminar(Fabricante fab) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "delete from fabricante where id = ?");
            int registrosInsertados;

            ps.setInt(1, fab.getId());

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
