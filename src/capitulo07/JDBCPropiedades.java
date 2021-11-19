package capitulo07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JDBCPropiedades {

	private static Properties propiedades = null;

	public JDBCPropiedades() {
		super();
	}

	/**
	 * @return
	 */
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();

			propiedades.setProperty("USUARIO","root");
			propiedades.setProperty("PASSWORD","5411");
			propiedades.setProperty("ID_USUARIO","1");
			propiedades.setProperty("JDBC_DRIVER_CLASS","com.mysql.jdbc.Driver");
			propiedades.setProperty("JDBC_USER","root");
			propiedades.setProperty("JDBC_PASSWORD","5411");
			propiedades.setProperty("JDBC_HOST","localhost");
			propiedades.setProperty("JDBC_SCHEMA_NAME","tutorialjavacoches");

		}
		return propiedades;
	}

	/**
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}


	/**
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty(String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}


	/**
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty(String nombrePropiedad) {
		return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
	}


	/**
	 * @param args
	 */
	public static void main(String args[]) {
		String usuario = JDBCPropiedades.getProperty("USUARIO");
		String password = JDBCPropiedades.getProperty("PASSWORD");
		int id = JDBCPropiedades.getIntProperty("ID_USUARIO");

		System.out.println("Usuario le�do del fichero de propiedades: " + usuario);
		System.out.println("Password le�do del fichero de propiedades: " + password);
		System.out.println("Id de usuario le�do del fichero de propiedades: " + id);
	}
}
