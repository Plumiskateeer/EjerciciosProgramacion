package capitulo07.centroEducativo.modelo.controladores;


import java.sql.*;
import java.text.SimpleDateFormat;

import capitulo07.centroEducativo.ConnectionManagerV2;
import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.ImposibleConectarException;
import capitulo07.centroEducativo.JDBCPropiedades;

public class ControladorBBDD {

	protected static SimpleDateFormat sdfMySQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	protected static void iniciaConnectionPool() {
		Thread conexionUCP = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ConnectionManagerV2.getConexion();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ImposibleConectarException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		conexionUCP.start();
	}


	/**
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 * @throws ImposibleConectarException 
	 */
	protected static int nextIdEnTabla(String tabla) throws SQLException, ImposibleConectarException {
		return maxIdEnTabla(tabla) + 1;
	}


	/**
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 * @throws ImposibleConectarException 
	 */
	protected static int maxIdEnTabla(String tabla) throws SQLException, ImposibleConectarException {

		Connection conn = ConnectionManagerV2.getConexion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from " + tabla);

		int max = 1;
		if (ps != null) {
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				max = rs.getInt(1);
			}
			rs.close();
		}

		return max;
	}


	/**
	 * @throws capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException
	 */
	protected static int eliminarTodoEnTabla() throws ErrorBBDDException {
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			int registrosModificados = s.executeUpdate("delete from " + JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME") + ".actor");
			s.close();
			return registrosModificados;

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}

	}


}
