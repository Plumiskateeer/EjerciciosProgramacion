package capitulo07;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ejemplo03_ConnectionPoolOracle {

    public static void main(String[] args) {

        try {

            for (int i = 0; i < 10; i++) {

                Connection conn = ConnectionManagerV2.getConexion();

                Statement s = (Statement) conn.createStatement();

                ResultSet rs = s.executeQuery("select * from coche");

                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
                // Cierre de los elementos
                rs.close();
                s.close();
            }

        } catch (SQLException | ImposibleConectarException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
