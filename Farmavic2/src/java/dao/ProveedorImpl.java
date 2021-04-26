package dao;

//import java.util.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;


public class ProveedorImpl extends Conexion implements ICRUD<Proveedor> {
    

    @Override
    public void registrar(Proveedor pro) throws Exception {
      
        System.out.println("Enviando dato");
        String sql = "insert into proveedor (Nombre, Telefono, Email, Direccion, Ruc, Tipo, Ncomercial, Abreviatura)"
                + " values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
//            ps.setInt(1, pro.getIdpro());
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getTelefono());
            ps.setString(3, pro.getEmail());
            ps.setString(4, pro.getDireccion());
            ps.setString(5, pro.getRuc());
            ps.setString(6, pro.getTipo());
            ps.setString(7, pro.getNcomercial());
            ps.setString(8, pro.getAbreviatura());          
            ps.executeUpdate();
            System.out.println("Enviando dato");
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Proveedor Dao" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

//    "insert into medicamento (Presentacion, Generico, Comercial, Precio, Vencimiento, Formula, Lote, Concentracion, Via)"
    @Override
    public void modificar(Proveedor pro) throws Exception {
        String sql = "update proveedor set Nombre=?, Telefono=?, Email=?, Direccion=?, Ruc=?, Tipo=?, Ncomercial=?, Abreviatura=? where Idpro=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getTelefono());
            ps.setString(3, pro.getEmail());
            ps.setString(4, pro.getDireccion());
//            ps.setDate(5,(java.sql.Date) med.getVencimiento());
            ps.setString(5, pro.getRuc());
            ps.setString(6, pro.getTipo());
            ps.setString(7, pro.getNcomercial());
            ps.setString(8, pro.getAbreviatura());
            ps.setInt(9, pro.getIdpro());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar ProveedorD " + e.getMessage());
        }
    }

//    @Override
    
    
    
//    "insert into medicamento (Presentacion, Generico, Comercial, Precio, Vencimiento, Formula, Lote, Concentracion, Via)"

    @Override
    public List<Proveedor> listarTodos() throws Exception {
        List<Proveedor> listado = null;
        Proveedor pro;
        String sql = "Select * from Proveedor where Estpro='A'";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            
//            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pro = new Proveedor();
                pro.setIdepro(rs.getInt("Idpro"));
                pro.setNombre(rs.getString("Nombre"));
                pro.setTelefono(rs.getString("Telefono"));
                pro.setEmail(rs.getString("Email"));
                pro.setDireccion(rs.getString("Direccion"));
                pro.setRuc(rs.getString("Ruc"));
                pro.setTipo(rs.getString("Tipo"));
                pro.setNcomercial(rs.getString("Ncomercial"));
                pro.setAbreviatura(rs.getString("Abreviatura"));                
                listado.add(pro);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodos ProveedorDao: " + e.getMessage());
        } finally {
            this.cerrar();
        }  
        return listado;          
    }

    public void eliminar(Proveedor pro) throws Exception {
        this.conectar();
        String sql = "update Proveedor set Estpro = 'I' where Ide=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, pro.getIdpro());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminar IdproDao" + e.getMessage());
            e.printStackTrace();
        }finally{
            this.cerrar();
        }
        
    }

//    public void registrar(Proveedor pro) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
