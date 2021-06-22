package dao;

import java.util.List;
import modelo.Vendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorImpl extends Conexion implements ICRUD<Vendedor> {

    @Override
    public void registrar(Vendedor modelo) throws Exception {
        String sql = "INSERT INTO VENDEDOR (NOMVEN, APEVEN, DNIVEN, TELFVEN, DIRVEN, IDUBI, ESTVEN) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getNOMVEN());
            ps.setString(2, modelo.getAPEVEN());
            ps.setString(3, modelo.getDNIVEN());
            ps.setString(4, modelo.getTELFVEN());
            ps.setString(5, modelo.getDIRVEN());
            ps.setString(6, modelo.getIDUBI());
            ps.setString(7, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrar VendedorImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Vendedor modelo) throws Exception {
        String sql = "UPDATE VENDEDOR SET NOMVEN=?, APEVEN=?, DNIVEN=?, TELFVEN=?, DIRVEN=?, IDUBI=? WHERE IDVEN=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getNOMVEN());
            ps.setString(2, modelo.getAPEVEN());
            ps.setString(3, modelo.getDNIVEN());
            ps.setString(4, modelo.getTELFVEN());
            ps.setString(5, modelo.getDIRVEN());
            ps.setString(6, modelo.getIDUBI());
            ps.setString(7, modelo.getIDUBI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en modificar VendedorImpl" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Vendedor modelo) throws Exception {
        String sql = "UPDATE VENDEDOR SET ESTVEN=? WHERE IDVEN=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, modelo.getIDVEN());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminar VendedorImpl" + e.getMessage());
        }
    }

    @Override
    public List<Vendedor> listar() throws Exception {
        List<Vendedor> listado = null;
        Vendedor vend;
        String sql = "SELECT * FROM VENDEDOR where ESTVEN='A'";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                vend = new Vendedor();
                vend.setIDVEN(rs.getInt("IDVEN"));
                vend.setNOMVEN(rs.getString("NOMVEN"));
                vend.setAPEVEN(rs.getString("APEVEN"));
                vend.setDNIVEN(rs.getString("DNIVEN"));
                vend.setTELFVEN(rs.getString("TELFVEN"));
                vend.setDIRVEN(rs.getString("DIRVEN"));
                vend.setIDUBI(rs.getString("IDUBI"));
                listado.add(vend);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listaTodos VendedorImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    public List<String> autocompleteUbigeo(String consulta) throws SQLException, Exception {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT TOP 5 CONCAT(DISUBI, ', ', PROUBI, ', ',DEPUBI) AS UBIGEODESC FROM UBIGEO WHERE DISUBI LIKE ?";
        try {
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, "%" + consulta + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("UBIGEODESC"));
            }
        } catch (Exception e) {
            System.out.println("Error en autocompleteUbigeoDao" + e.getMessage());
        }
        return lista;
    }

    public String obtenerCodigoUbigeo(String cadenaUbi) throws SQLException, Exception {
        String sql = "SELECT IDUBI FROM UBIGEO WHERE CONCAT(DISUBI, ', ', PROUBI, ', ',DEPUBI) = ?";
        try {
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, cadenaUbi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("IDUBI");
            }
            return rs.getString("IDUBI");
        } catch (Exception e) {
            System.out.println("Error en obtenerCodigoUbigeo " + e.getMessage());
            throw e;
        }
    }

}
