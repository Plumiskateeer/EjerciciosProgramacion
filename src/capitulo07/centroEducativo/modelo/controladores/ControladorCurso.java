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
import capitulo07.centroEducativo.modelo.Curso;


public class ControladorCurso extends ControladorBBDD{
	public static List<Curso> getAll() throws ErrorBBDDException {
        List<Curso> cursos = new ArrayList<Curso>();

        Connection conn = null;

        
            try {
				conn = ConnectionManagerV2.getConexion();
	
	            Statement s = conn.createStatement();
	            ResultSet rs = s.executeQuery("Select * from curso");
	
	            while (rs.next()) {
	            	Curso c = new Curso();
	                c.setId(rs.getInt("id"));
	                c.setDescripcion(rs.getString("descripcion"));
	                cursos.add(c);
	            }
	
	            s.close();
	            
            
            } catch (SQLException | ImposibleConectarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return cursos;
    }

    public static Curso getCurso(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Curso c = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
                c = new Curso();
                c.setId(rs.getInt("id"));
                c.setDescripcion(rs.getString("descripcion"));
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
    public static void almacenar(Curso curso) throws ErrorBBDDException {
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
    public static Curso get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Curso c = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from curso where id = " + id);

            if (rs.next()) {
                c = new Curso();
                c.setId(id);
                c.setDescripcion(rs.getString("descripcion"));
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
    public static void almacenarNuevo(Curso c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("INSERT INTO curso (id, descripcion) VALUES  (?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla( "curso"));
            ps.setString(2, c.getDescripcion());

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
    public static void almacenarModificado(Curso c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update curso set descripcion = ? where id = ?");
            int registrosInsertados;

            ps.setString(1, c.getDescripcion());
            ps.setInt(2, c.getId());

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
    public static void eliminar(Curso c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("delete from curso where id = ?");
            int registrosInsertados;

            ps.setInt(1, c.getId());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la eliminación del registro");
            }
            ps.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }

}
