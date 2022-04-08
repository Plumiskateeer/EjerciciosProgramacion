package capitulo07.gestionVentaCoches.modelo.controladores;

import capitulo07.gestionVentaCoches.modelo.Concesionario;
import capitulo07.gestionVentaCoches.modelo.Fabricante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorConcesionario extends ControladorBBDD{

        public static List<Concesionario> getAll() throws ErrorBBDDException {
        List<Concesionario> concesionarios = new ArrayList<>();

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from concesionario");

            while (rs.next()) {
                Concesionario c = new Concesionario();
                c.setId(rs.getInt("id"));
                c.setCif(rs.getString("cif"));
                c.setNombre(rs.getString("nombre"));
                c.setLocalidad(rs.getString("localidad"));
                concesionarios.add(c);
            }

            s.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return concesionarios;
    }


        public static Concesionario getConcesionario(String consulta) throws ErrorBBDDException {
            Connection conn = null;
            Concesionario c = null;
            try {
                conn = ConnectionManagerV2.getConexion();

                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery(consulta);

                if (rs.next()) {
                    c = new Concesionario();
                    c.setId(rs.getInt("id"));
                    c.setCif(rs.getString("cif"));
                    c.setNombre(rs.getString("nombre"));
                    c.setLocalidad(rs.getString("localidad"));
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
        public static void almacenar(Concesionario concesionario) throws ErrorBBDDException {
        if (get(concesionario.getId()) != null) { // Solo modificar
            almacenarModificado(concesionario);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(concesionario);
        }
    }


        /**
         * @param
         * @return
         * @throws ErrorBBDDException
         */
        public static Concesionario get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Concesionario c = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from concesionario where id = " + id);

            if (rs.next()) {
                c = new Concesionario();
                c.setId(id);
                c.setCif(rs.getString("cif"));
                c.setNombre(rs.getString("nombre"));
                c.setLocalidad(rs.getString("localidad"));
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
        public static void almacenarNuevo(Concesionario c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps =  conn.
                    prepareStatement(
                            "INSERT INTO concesionario (id, cif, nombre, localidad) VALUES  (?, ?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "concesionario"));
            ps.setString(2, c.getCif());
            ps.setString(3, c.getNombre());
            ps.setString(4,c.getLocalidad());

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
        public static void almacenarModificado(Concesionario c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update concesionario set cif = ?, nombre = ?, localidad = ? where id = ?");
            int registrosInsertados;

            ps.setString(1, c.getCif());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getLocalidad());
            ps.setInt(4, c.getId());

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
        public static void eliminar(Concesionario c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "delete from concesionario where id = ?");
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
