package dao;

//import java.util.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Medicamento;

public class MedicamentoImpl extends Conexion implements ICRUD<Medicamento> {
    

    @Override
    public void registrar(Medicamento med) throws Exception {
      
        System.out.println("Enviando dato");
        String sql = "insert into medicamento (Presentacion, Generico, Comercial, Precio, Vencimiento, Formula, Lote, Concentracion, Via)"
                + " values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
//            ps.setInt(1, med.getIde());
            ps.setString(1, med.getPresentacion());
            ps.setString(2, med.getGenerico());
            ps.setString(3, med.getComercial());
            ps.setString(4, med.getPrecio());
            ps.setDate(5, new java.sql.Date(med.getVencimiento().getTime()));
//            ps.setDate(5, (java.sql.Date) med.getVencimiento());
            ps.setString(6, med.getFormula());
            ps.setString(7, med.getLote());
            ps.setString(8, med.getConcentracion());
            ps.setString(9, med.getVia());
            ps.executeUpdate();
            System.out.println("Enviando dato");
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Medicamento Dao" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

//    "insert into medicamento (Presentacion, Generico, Comercial, Precio, Vencimiento, Formula, Lote, Concentracion, Via)"
    @Override
    public void modificar(Medicamento med) throws Exception {
        String sql = "update Medicamento set Presentacion=?, Generico=?, Comercial=?, Precio=?, Vencimiento=?, Formula=?, Lote=?, Concentracion=?, Via=? where Ide=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, med.getPresentacion());
            ps.setString(2, med.getGenerico());
            ps.setString(3, med.getComercial());
            ps.setString(4, med.getPrecio());
            ps.setDate(5,(java.sql.Date) med.getVencimiento());
            ps.setString(6, med.getFormula());
            ps.setString(7, med.getLote());
            ps.setString(8, med.getConcentracion());
            ps.setString(9, med.getVia());
            ps.setInt(10, med.getIde());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Medicamento " + e.getMessage());
        }
    }

//    @Override
    
    
    
//    "insert into medicamento (Presentacion, Generico, Comercial, Precio, Vencimiento, Formula, Lote, Concentracion, Via)"

    @Override
    public List<Medicamento> listarTodos() throws Exception {
        List<Medicamento> listado = null;
        Medicamento medi;
        String sql = "Select * from Medicamento where Estmed='A'";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            
//            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                medi = new Medicamento();
                medi.setIde(rs.getInt("Ide"));
                medi.setPresentacion(rs.getString("Presentacion"));
                medi.setGenerico(rs.getString("Generico"));
                medi.setComercial(rs.getString("Comercial"));
                medi.setPrecio(rs.getString("Precio"));
                medi.setVencimiento(rs.getDate("Vencimiento"));
                medi.setFormula(rs.getString("Formula"));
                medi.setLote(rs.getString("Lote"));
                medi.setConcentracion(rs.getString("Concentracion"));
                medi.setVia(rs.getString("Via"));
                listado.add(medi);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodos Dao: " + e.getMessage());
        } finally {
            this.cerrar();
        }  
        return listado;          
    }

    public void eliminar(Medicamento med) throws Exception {
        this.conectar();
        String sql = "update Medicamento set Estmed = 'I' where Ide=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, med.getIde());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminar IdeDao" + e.getMessage());
            e.printStackTrace();
        }finally{
            this.cerrar();
        }
        
    }

}
