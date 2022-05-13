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
import capitulo07.centroEducativo.modelo.TipologiaSexo;

public class ControladorTipologiaSexo extends  ErrorBBDDException{
	public static List<TipologiaSexo> getAll() throws ErrorBBDDException {
        List<TipologiaSexo> tipologias = new ArrayList<TipologiaSexo>();

        Connection conn = null;

        
            try {
				conn = ConnectionManagerV2.getConexion();
	
	            Statement s = conn.createStatement();
	            ResultSet rs = s.executeQuery("Select * from tipologiasexo");
	
	            while (rs.next()) {
	            	TipologiaSexo t = new TipologiaSexo();
	                t.setId(rs.getInt("id"));
	                t.setDescripcion(rs.getString("descripcion"));
	                tipologias.add(t);
	            }
	
	            s.close();
            
            } catch (SQLException | ImposibleConectarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return tipologias;
    }

    public static TipologiaSexo getTipologiaSexo(String consulta) throws ErrorBBDDException {
        Connection conn = null;
        TipologiaSexo t = null;
        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            if (rs.next()) {
                t = new TipologiaSexo();
                t.setId(rs.getInt("id"));
                t.setDescripcion(rs.getString("descripcion"));
            }

            s.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }

        return t;
    }


    /**
     * @param
     * @return
     * @throws ErrorBBDDException
     */
    public static TipologiaSexo get(int id) throws ErrorBBDDException {
        Connection conn = null;
        TipologiaSexo t = null;

        try {
            conn = ConnectionManagerV2.getConexion();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from tipologiasexo where id = " + id);

            if (rs.next()) {
                t = new TipologiaSexo();
                t.setId(id);
                t.setDescripcion(rs.getString("descripcion"));
            }
            s.close();
        } catch (SQLException | ImposibleConectarException e1) {
            throw new ErrorBBDDException(e1);
        }
        return t;
    }


}
