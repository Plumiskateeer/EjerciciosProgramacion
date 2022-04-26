package capitulo07.centroEducativo.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import capitulo07.centroEducativo.ConnectionManagerV2;
import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.ImposibleConectarException;
import capitulo07.centroEducativo.modelo.Materia;

public class ControladorMateria extends ControladorBBDD{
	public static List<Materia> getAll() throws ErrorBBDDException {
        List<Materia> materias = new ArrayList<Materia>();

        Connection conn = null;

        
            try {
				conn = ConnectionManagerV2.getConexion();
	
	            Statement s = conn.createStatement();
	            ResultSet rs = s.executeQuery("Select * from materia");
	
	            while (rs.next()) {
	            	Materia m = new Materia();
	                m.setId(rs.getInt("id"));
	                m.setNombre(rs.getString("nombre"));
	                m.setAcronimo(rs.getString("acronimo"));
	                m.setCursoid(rs.getInt("curso_id"));
	                materias.add(m);
	            }
	
	            s.close();
	            conn.close();
            
            } catch (SQLException | ImposibleConectarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return materias;
    }

    public static Materia getMateria(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Materia m = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
                m = new Materia();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setAcronimo(rs.getString("acronimo"));
                m.setCursoid(rs.getInt("curso_id"));
            }

            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

        return m;
    }

    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenar(Materia curso) throws ErrorBBDDException {
        if (get(curso.getId()) != null) { // Solo modificar
            almacenarModificado(curso);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(curso);
        }
    }


    /**
     * @param
     * @return
     * @throws ErrorBBDDException
     */
    public static Materia get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Materia m = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from materia where id = " + id);

            if (rs.next()) {
                m = new Materia();
                m.setId(id);
                m.setNombre(rs.getString("nombre"));
                m.setAcronimo(rs.getString("acronimo"));
                m.setCursoid(rs.getInt("curso_id"));
            }
            s.close();
            conn.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }
        return m;
    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarNuevo(Materia m) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("INSERT INTO materia (id, nombre, acronimo, curso_id) VALUES  (?, ?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "materia"));
            ps.setString(2, m.getNombre());
            ps.setString(3, m.getAcronimo());
            ps.setInt(4, m.getCursoid());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la inserci�n del nuevo registro");
            }
            ps.close();
            conn.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarModificado(Materia m) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update materia set nombre = ?, acronimo = ?, curso_id = ? where id = ?");
            int registrosInsertados;

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getAcronimo());
            ps.setInt(3, m.getCursoid());
            ps.setInt(4, m.getId());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la modificaci�n del registro");
            }
            ps.close();
            conn.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void eliminar(Materia m) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("delete from materia where id = ?");
            int registrosInsertados;

            ps.setInt(1, m.getId());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la eliminación del registro");
            }
            ps.close();
            conn.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }

}
