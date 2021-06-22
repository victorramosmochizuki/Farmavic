
package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Medicamento;
import servicios.UtilToSql;


public class MedicamentoImpl extends Conexion implements ICRUD<Medicamento> {

    @Override
    public void registrar(Medicamento modelo) throws Exception {
       String sql = "INSERT INTO MEDICAMENTO (PRESMED, GENMED, COMMED, PRECMED, FVMED, STOCMED, FORMED, "
               + "LOTMED, IDPROV, ESTMED) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getPRESMED());
            ps.setString(2, modelo.getGENMED());
            ps.setString(3, modelo.getCOMMED());
            ps.setDouble(4, modelo.getPRECMED());
            ps.setDate(5, UtilToSql.convertDate(modelo.getFVMED()));
            ps.setInt(6, modelo.getSTOCMED());
            ps.setString(7, modelo.getFORMED());
            ps.setString(8, modelo.getLOTMED());
            ps.setString(9, modelo.getIDPROV() );
            ps.setString(10, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrar MedicamentoImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Medicamento modelo) throws Exception {
        String sql = "UPDATE MEDICAMENTO SET PRESMED=?, GENMED=?, COMMED=?, PRECMED=?, FVMED=?, STOCMED=?, FORMED=?, LOTMED=?, IDPROV=? WHERE IDMED=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getPRESMED());
            ps.setString(2, modelo.getGENMED());
            ps.setString(3, modelo.getCOMMED());
            ps.setDouble(4, modelo.getPRECMED());
            ps.setDate(5, UtilToSql.convertDate(modelo.getFVMED()));
            ps.setInt(6, modelo.getSTOCMED());
            ps.setString(7, modelo.getFORMED());
            ps.setString(8, modelo.getLOTMED());
            ps.setString(9, modelo.getIDPROV());
            ps.setInt(10, modelo.getIDMED());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en modificar MedicamentoImpl" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Medicamento modelo) throws Exception {
       String sql = "UPDATE MEDICAMENTO SET ESTMED=? WHERE IDMED=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, modelo.getIDMED());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminar MedicamentoImpl" + e.getMessage());
        } 
    }

    @Override
    public List<Medicamento> listar() throws Exception {
        List<Medicamento> listado = null;
        Medicamento medi;
        String sql = "SELECT * FROM MEDICAMENTO where ESTMED='A'";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                medi = new Medicamento();
                medi.setIDMED(rs.getInt("IDMED"));
                medi.setPRESMED(rs.getString("PRESMED"));
                medi.setGENMED(rs.getString("GENMED"));
                medi.setCOMMED(rs.getString("COMMED"));
                medi.setPRECMED(rs.getDouble("PRECMED"));
                medi.setFVMED(rs.getDate("FVMED"));
                medi.setSTOCMED(rs.getInt("STOCMED"));
                medi.setFORMED(rs.getString("FORMED"));
                medi.setLOTMED(rs.getString("LOTMED"));
                medi.setIDPROV(rs.getString("IDPROV"));
                listado.add(medi);
                System.out.println("ENVIANDO MEDICAMENTOS");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listar MedicamentoImpl: " + e.getMessage());
        } finally {
            this.cerrar();
        }  
        return listado;          
    }
    
    public List<String> autocompleteProveedor(String consulta) throws SQLException, Exception {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT TOP 20 CONCAT(NOMPROV, ', ', RUCPROV, ', ',TIPPROV) AS PROVEEDORDESC FROM PROVEEDOR WHERE NOMPROV LIKE ?";
        try {
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, "%" + consulta + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("PROVEEDORDESC"));
            }
        } catch (Exception e) {
            System.out.println("Error en autocompleteProveedor" + e.getMessage());
        }
        return lista;
    }
    
    public String obtenerCodigoProveedor(String cadenaPro) throws SQLException, Exception {
        String sql = "SELECT IDPROV FROM PROVEEDOR WHERE CONCAT(NOMPROV, ', ', RUCPROV, ', ',TIPPROV) = ?";
        try {
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, cadenaPro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("IDPROV");
            }
            return rs.getString("IDPROV");
        } catch (Exception e) {
            System.out.println("Error en obtenerCodigoProveedor " + e.getMessage());
            throw e;
        }
    }

       
    
}
