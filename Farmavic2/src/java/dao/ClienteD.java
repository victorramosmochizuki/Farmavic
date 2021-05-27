package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ClienteM;


public class ClienteD extends Conexion {

    public void registrar(ClienteM modelo) throws Exception {
        this.conectar();

        try {
            String sql = "insert into CLIENTE (Nombre, Apellido, Dni, Estcli)\n"
                    + "VALUES (?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getApellido());
            ps.setString(3, modelo.getDni());
            ps.setString(4, "A");
            

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error REGISTRAR clienteD" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
    }

    public void modificar(ClienteM modelo) throws Exception {
        this.conectar();
        String sql = "update CLIENTE set Nombre=?, Apellido=?, Dni=? WHERE Idcli=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            
            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getApellido());
            ps.setString(3, modelo.getDni());
            ps.setInt(4, modelo.getIde());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en MODIFICAR clienteD" + e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    public void eliminar(ClienteM modelo) throws Exception {
        this.conectar();
        String sql = "update CLIENTE set Estcli ='I' WHERE Idcli =? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, modelo.getIde());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en eliminar ClienteD" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
    }

    public List<ClienteM> listar() throws Exception {
        List<ClienteM> lista = null;
        ClienteM cliente;
        this.conectar();
        try {
            System.out.println("haciendo consulta");
            String sql = "SELECT * FROM CLIENTE where ESTCLI='A'";
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while (rs.next()) {
                cliente = new ClienteM();
                
                cliente.setIde(rs.getInt("Idcli"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setDni(rs.getString("Dni"));
                lista.add(cliente);
                System.out.println("Enviando cliente");
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("Error en ClienteD LISTA" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;
    }

    private Object getCn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}