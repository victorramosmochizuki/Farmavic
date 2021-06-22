package dao;

import java.util.List;
import modelo.Cliente;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    @Override
    public void registrar(Cliente modelo) throws Exception {
        String sql = "INSERT INTO CLIENTE (NOMCLI, APECLI, DNICLI, ESTCLI) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getNOMCLI());
            ps.setString(2, modelo.getAPECLI());
            ps.setString(3, modelo.getDNICLI());
            ps.setString(4, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrar ClienteImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Cliente modelo) throws Exception {
        String sql = "UPDATE CLIENTE SET NOMCLI=?, APECLI=?, DNICLI=? WHERE IDCLI=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getNOMCLI());
            ps.setString(2, modelo.getAPECLI());
            ps.setString(3, modelo.getDNICLI());
            ps.setInt(4, modelo.getIDCLI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en modificar ClienteImpl" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Cliente modelo) throws Exception {

        String sql = "UPDATE CLIENTE SET ESTCLI=? WHERE IDCLI=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, modelo.getIDCLI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en ELIMINAR ClienteImpl" + e.getMessage());
        } 
    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> listado = null;
        Cliente cliente;
        String sql = "SELECT * FROM CLIENTE where ESTCLI='A'";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIDCLI(rs.getInt("IDCLI"));
                cliente.setNOMCLI(rs.getString("NOMCLI"));
                cliente.setAPECLI(rs.getString("APECLI"));
                cliente.setDNICLI(rs.getString("DNICLI"));
                listado.add(cliente);
                System.out.println("enviando clientes ");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listar ClienteImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

}
