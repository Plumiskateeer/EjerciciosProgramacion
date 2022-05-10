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
import capitulo07.centroEducativo.modelo.Estudiante;
import capitulo07.centroEducativo.modelo.Profesor;

public class ControladorProfesor extends ControladorBBDD{
	
	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Profesor findPrimero () throws ErrorBBDDException {
		return getProfesor("select * from profesor order by id limit 1");
	}

	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Profesor findUltimo () throws ErrorBBDDException {
		return getProfesor("select * from profesor order by id desc limit 1");
	}

	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Profesor findAnterior (int idActual) throws ErrorBBDDException {
		return getProfesor("select * from profesor where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	public static Profesor findSiguiente (int idActual) throws ErrorBBDDException {
		return getProfesor("select * from profesor where id > " + idActual + " order by id limit 1");
	}
	
	public static List<Profesor> getAll() throws ErrorBBDDException {
        List<Profesor> profesores = new ArrayList<Profesor>();

        Connection conn = null;

        
            try {
				conn = ConnectionManagerV2.getConexion();
	
	            Statement s = conn.createStatement();
	            ResultSet rs = s.executeQuery("Select * from profesor");
	
	            while (rs.next()) {
	            	Profesor p = new Profesor();
	            	p.setId(rs.getInt("id"));
	                p.setNombre(rs.getString("nombre"));
	                p.setApellido1(rs.getString("apellido1"));
	                p.setApellido2(rs.getString("apellido2"));
	                p.setDni(rs.getString("dni"));
	                p.setDireccion(rs.getString("direccion"));
	                p.setEmail(rs.getString("email"));
	                p.setTelefono(rs.getString("telefono"));
	                p.setSexo(rs.getInt("tipologiaSexo_id"));
	                p.setImagen(rs.getBytes("imagen"));
	                profesores.add(p);
	            }
	
	            s.close();
	            conn.close();
            
            } catch (SQLException | ImposibleConectarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return profesores;
    }

    public static Profesor getProfesor(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        Profesor p = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
                p = new Profesor();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido1(rs.getString("apellido1"));
                p.setApellido2(rs.getString("apellido2"));
                p.setDni(rs.getString("dni"));
                p.setDireccion(rs.getString("direccion"));
                p.setEmail(rs.getString("email"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getInt("tipologiaSexo_id"));
                p.setImagen(rs.getBytes("imagen"));
            }

            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

        return p;
    }

    /**
     * @param
     * @throws ErrorBBDDException
     */
    public static void almacenar(Profesor profesor) throws ErrorBBDDException {
        if (get(profesor.getId()) != null) { // Solo modificar
            almacenarModificado(profesor);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(profesor);
        }
    }


    /**
     * @param
     * @return
     * @throws ErrorBBDDException
     */
    public static Profesor get(int id) throws ErrorBBDDException {
        Connection conn = null;
        Profesor p = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from profesor where id = " + id);

            if (rs.next()) {
                p = new Profesor();
                p.setId(id);
                p.setNombre(rs.getString("nombre"));
                p.setApellido1(rs.getString("apellido1"));
                p.setApellido2(rs.getString("apellido2"));
                p.setDni(rs.getString("dni"));
                p.setDireccion(rs.getString("direccion"));
                p.setEmail(rs.getString("email"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getInt("tipologiaSexo_id"));
                p.setImagen(rs.getBytes("imagen"));
            }
            s.close();
            conn.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }
        return p;
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
            		prepareStatement("INSERT INTO profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, tipologiaSexo_id, imagen) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            int registrosInsertados;

            ps.setInt(1, nextIdEnTabla(conn, "profesor"));
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido1());
            ps.setString(4, e.getApellido2());
            ps.setString(5, e.getDni());
            ps.setString(6, e.getDireccion());
            ps.setString(7, e.getEmail());
            ps.setString(8, e.getTelefono());
            ps.setInt(9, e.getSexo());
            ps.setBytes(10, e.getImagen());


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
    public static void almacenarModificado(Profesor p) throws ErrorBBDDException {

        Connection conn = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            PreparedStatement ps = (PreparedStatement) conn.
            		prepareStatement(
                            "update profesor set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ?, tipologiaSexo_id = ?, imagen = ? where id = ?");
            int registrosInsertados;

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido1());
            ps.setString(3, p.getApellido2());
            ps.setString(4, p.getDni());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getEmail());
            ps.setString(7, p.getTelefono());
            ps.setInt(8, p.getSexo());
            ps.setBytes(9, p.getImagen());
            ps.setInt(10, p.getId());

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
