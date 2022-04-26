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
import capitulo07.centroEducativo.modelo.Profesor;

public class ControladorProfesor extends ControladorBBDD{
	public static List<Profesor> getAll() throws ErrorBBDDException {
        List<Profesor> estudiantes = new ArrayList<Profesor>();

        Connection conn = null;

        
            try {
				conn = ConnectionManagerV2.getConexion();
	
	            Statement s = conn.createStatement();
	            ResultSet rs = s.executeQuery("Select * from profesor");
	
	            while (rs.next()) {
	            	Profesor e = new Profesor();
	                e.setId(rs.getInt("id"));
	                e.setNombre(rs.getString("nombre"));
	                e.setApellido1(rs.getString("apellido1"));
	                e.setApellido2(rs.getString("apellido2"));
	                e.setDni(rs.getString("dni"));
	                e.setDireccion(rs.getString("direccion"));
	                e.setEmail(rs.getString("email"));
	                e.setTelefono(rs.getString("telefono"));
	                estudiantes.add(e);
	            }
	
	            s.close();
	            conn.close();
            
            } catch (SQLException | ImposibleConectarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return estudiantes;
    }

    public static Profesor getProfesor(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Profesor e = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
                e = new Profesor();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                e.setDni(rs.getString("dni"));
                e.setDireccion(rs.getString("direccion"));
                e.setEmail(rs.getString("email"));
                e.setTelefono(rs.getString("telefono"));
            }

            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

        return e;
    }

    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenar(Profesor curso) throws ErrorBBDDException {
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
    public static Profesor get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Profesor e = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from profesor where id = " + id);

            if (rs.next()) {
                e = new Profesor();
                e.setId(id);
                e.setNombre(rs.getString("nombre"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                e.setDni(rs.getString("dni"));
                e.setDireccion(rs.getString("direccion"));
                e.setEmail(rs.getString("email"));
                e.setTelefono(rs.getString("telefono"));
            }
            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }
        return e;
    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarNuevo(Profesor e) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("INSERT INTO profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) VALUES  (?, ?, ?, ?, ?, ?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "estudiante"));
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido2());
            ps.setString(4, e.getDni());
            ps.setString(5, e.getDireccion());
            ps.setString(6, e.getEmail());
            ps.setString(7, e.getTelefono());


            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la inserci�n del nuevo registro");
            }
            ps.close();
            conn.close();

        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarModificado(Profesor e) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update profesor set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ? where id = ?");
            int registrosInsertados;

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido2());
            ps.setString(3, e.getDni());
            ps.setString(4, e.getDireccion());
            ps.setString(5, e.getEmail());
            ps.setString(6, e.getTelefono());
            ps.setInt(7, e.getId());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la modificaci�n del registro");
            }
            ps.close();
            conn.close();

        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void eliminar(Profesor c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("delete from profesor where id = ?");
            int registrosInsertados;

            ps.setInt(1, c.getId());

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
