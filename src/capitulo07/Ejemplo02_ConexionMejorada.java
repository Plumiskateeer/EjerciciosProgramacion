package capitulo07;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Ejemplo02_ConexionMejorada {


    /**
     * @param conn
     * @param tabla
     * @throws SQLException
     */
    private static void consultarTabla(Connection conn, String tabla)
            throws SQLException {

        Statement s = (Statement) conn.createStatement();
        ResultSet rs = s.executeQuery("select * from " + tabla);

        // A trav�s del objeto ResultSetMetaData obtenemos informaci�n sobre las caracter�sticas de los campos que
        // posee el conjunto de registros que hemos obtenido con la consulta. Gracias a eso podemos hacer una visualizaci�n
        // enriquecida del contenido del objeto ResultSet
        ResultSetMetaData rsmd = rs.getMetaData();

        // Impresi�n en pantalla de los tipos de las columnas que forman el resultado del ResultSet
        System.out.println("\n-------------------------------------------------------------");
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnTypeName(i) + "\t");
        }
        System.out.println("\n-------------------------------------------------------------");

        // Impresi�n e pantalla de las etiquetas de nombre de las columnas del objeto ResultSet
        System.out.println("\n-------------------------------------------------------------");
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnLabel(i) + "\t");
        }
        System.out.println("\n-------------------------------------------------------------");

        // Recorrido del ResultSet, diferenciando entre los tipos de datos que pueden tener las columnas
        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (rsmd.getColumnTypeName(i).equalsIgnoreCase("INT")) {
                    System.out.print(rs.getInt(rsmd.getColumnLabel(i)) + "\t");
                }
                if (rsmd.getColumnTypeName(i).equalsIgnoreCase("VARCHAR")) {
                    System.out.print(rs.getString(rsmd.getColumnLabel(i)) + "\t");
                }
                if (rsmd.getColumnTypeName(i).equalsIgnoreCase("DATETIME")) {
                    System.out.print(rs.getDate(rsmd.getColumnLabel(i)) + "\t");
                }
                if (rsmd.getColumnTypeName(i).equalsIgnoreCase("TINYINT")) {
                    System.out.print(rs.getBoolean(rsmd.getColumnLabel(i)) + "\t");
                }
                if (rsmd.getColumnTypeName(i).equalsIgnoreCase("FLOAT")) {
                    System.out.print(rs.getFloat(rsmd.getColumnLabel(i)) + "\t");
                }

            }
            System.out.println("\n");
        }

        rs.close();
        s.close();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionManagerV1.getConexion();

            consultarTabla(conn, "coche");

        } catch (SQLException ex) {
            System.out.println("Error en la ejecuci�n SQL: " + ex.getMessage());
        }
    }

}
