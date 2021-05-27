package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.VendedorM;


public class VendedorD extends Conexion {

    public void registrar(VendedorM modelo) throws Exception {
        this.conectar();

        try {
            String sql = "insert into VENDEDOR (Nombre, Apellido, Sexo, Dni, Caja, Turno, Ubigeo, Estven)\n"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getApellido());
            ps.setString(3, modelo.getSexo());
            ps.setString(4, modelo.getDni());
            ps.setString(5, modelo.getCaja());
            ps.setString(6, modelo.getTurno());
            ps.setString(7, modelo.getUbigeo());
            ps.setString(8, "A");

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error REGISTRAR vendedorD" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
    }

    public void modificar(VendedorM modelo) throws Exception {
        this.conectar();
        String sql = "update VENDEDOR set Nombre=?, Apellido=?, Sexo=?, Dni=?, Caja=?, Turno=?, Ubigeo=? WHERE Idven = ?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            
            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getApellido());
            ps.setString(3, modelo.getSexo());
            ps.setString(4, modelo.getDni());
            ps.setString(5, modelo.getCaja());
            ps.setString(6, modelo.getTurno());
            ps.setString(7, modelo.getUbigeo());
//            ps.setString(8, modelo.getEstado());
            ps.setInt(8, modelo.getIde());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en MODIFICAR vendedorD" + e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    public void eliminar(VendedorM modelo) throws Exception {
        this.conectar();
        String sql = "update VENDEDOR set Estven ='I' WHERE Idven =? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, modelo.getIde());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en eliminar VendedorD" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
    }

    public List<VendedorM> listar() throws Exception {
        List<VendedorM> lista = null;
        VendedorM vendedor;
        this.conectar();
        try {
            System.out.println("haciendo consulta");
            String sql = "SELECT * FROM VENDEDOR where Estven='A'";
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while (rs.next()) {
                vendedor = new VendedorM();
                vendedor.setIde(rs.getInt("Idven"));
                vendedor.setNombre(rs.getString("Nombre"));
                vendedor.setApellido(rs.getString("Apellido"));
                vendedor.setSexo(rs.getString("Sexo"));
                vendedor.setDni(rs.getString("Dni"));
                vendedor.setCaja(rs.getString("Caja"));
                vendedor.setTurno(rs.getString("Turno"));
                vendedor.setUbigeo(rs.getString("Ubigeo"));
                lista.add(vendedor);
                System.out.println("Enviando vendedor");
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("Error en VendedorD LISTA" + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
}