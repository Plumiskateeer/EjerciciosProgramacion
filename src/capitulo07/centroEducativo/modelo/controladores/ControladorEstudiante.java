package capitulo07.centroEducativo.modelo.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import capitulo07.centroEducativo.ConnectionManagerV2;
import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.ImposibleConectarException;
import capitulo07.centroEducativo.modelo.Estudiante;

public class ControladorEstudiante extends ControladorBBDD{
	
	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Estudiante findPrimero () throws ErrorBBDDException {
		return getEstudiante("select * from estudiante order by id limit 1");
	}

	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Estudiante findUltimo () throws ErrorBBDDException {
		return getEstudiante("select * from estudiante order by id desc limit 1");
	}

	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Estudiante findAnterior (int idActual) throws ErrorBBDDException {
		return getEstudiante("select * from estudiante where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Estudiante findSiguiente (int idActual) throws ErrorBBDDException {
		return getEstudiante("select * from estudiante where id > " + idActual + " order by id limit 1");
	}
	
	public static List<Estudiante> getAll() throws ErrorBBDDException {
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();

        Connection conn = null;

        
            try {
				conn = ConnectionManagerV2.getConexion();
	
	            Statement s = conn.createStatement();
	            ResultSet rs = s.executeQuery("Select * from estudiante");
	
	            while (rs.next()) {
	            	Estudiante e = new Estudiante();
	                e.setId(rs.getInt("id"));
	                e.setNombre(rs.getString("nombre"));
	                e.setApellido1(rs.getString("apellido1"));
	                e.setApellido2(rs.getString("apellido2"));
	                e.setDni(rs.getString("dni"));
	                e.setDireccion(rs.getString("direccion"));
	                e.setEmail(rs.getString("email"));
	                e.setTelefono(rs.getString("telefono"));
	                e.setSexo(rs.getInt("tipologiaSexo_id"));
	                e.setImagen(rs.getBytes("imagen"));
	                e.setColorpreferido(rs.getString("colorpreferido"));
	                estudiantes.add(e);
	            }
	
	            s.close();
            
            } catch (SQLException | ImposibleConectarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return estudiantes;
    }

    public static Estudiante getEstudiante(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Estudiante e = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
                e = new Estudiante();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                e.setDni(rs.getString("dni"));
                e.setDireccion(rs.getString("direccion"));
                e.setEmail(rs.getString("email"));
                e.setTelefono(rs.getString("telefono"));
                e.setSexo(rs.getInt("tipologiaSexo_id"));
                e.setImagen(rs.getBytes("imagen"));
                e.setColorpreferido(rs.getString("colorpreferido"));
            }

            s.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

        return e;
    }

    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenar(Estudiante curso) throws ErrorBBDDException {
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
    public static Estudiante get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Estudiante e = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from estudiante where id = " + id);

            if (rs.next()) {
                e = new Estudiante();
                e.setId(id);
                e.setNombre(rs.getString("nombre"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                e.setDni(rs.getString("dni"));
                e.setDireccion(rs.getString("direccion"));
                e.setEmail(rs.getString("email"));
                e.setTelefono(rs.getString("telefono"));
                e.setSexo(rs.getInt("tipologiaSexo_id"));
                e.setImagen(rs.getBytes("imagen"));
                e.setColorpreferido(rs.getString("colorpreferido"));
               
            }
            s.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }
        return e;
    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarNuevo(Estudiante e) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("INSERT INTO estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, tipologiaSexo_id, imagen, colorpreferido) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla("estudiante"));
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido1());
            ps.setString(4, e.getApellido2());
            ps.setString(5, e.getDni());
            ps.setString(6, e.getDireccion());
            ps.setString(7, e.getEmail());
            ps.setString(8, e.getTelefono());
            ps.setInt(9, e.getSexo());
            ps.setBytes(10, e.getImagen());
            ps.setString(11, e.getColorpreferido());
            


            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la inserciï¿½n del nuevo registro");
            }
            ps.close();

        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenarModificado(Estudiante e) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement(
                            "update estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ?, tipologiaSexo_id = ?, imagen = ? ,colorpreferido=? where id = ?");
            int registrosInsertados;

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido1());
            ps.setString(3, e.getApellido2());
            ps.setString(4, e.getDni());
            ps.setString(5, e.getDireccion());
            ps.setString(6, e.getEmail());
            ps.setString(7, e.getTelefono());
            ps.setInt(8, e.getSexo());
            ps.setBytes(9, e.getImagen());
            ps.setString(10, e.getColorpreferido());
            ps.setInt(11, e.getId());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la modificaciï¿½n del registro");
            }
            ps.close();

        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

    }


    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void eliminar(Estudiante c) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
                    prepareStatement("delete from estudiante where id = ?");
            int registrosInsertados;

            ps.setInt(1, c.getId());

            registrosInsertados = ps.executeUpdate();
            if (registrosInsertados != 1) {
                throw new ErrorBBDDException("No ha sido posible la eliminaciÃ³n del registro");
            }
            ps.close();

        } catch (SQLException | ImposibleConectarException e) {
            throw new ErrorBBDDException(e);
        }

    }
    

}
