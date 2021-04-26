
package controlador;

import dao.ProveedorImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;


@Named(value = "proveedorC")
@SessionScoped
public class ProveedorC implements Serializable {

    private Proveedor pro;
    private ProveedorImpl dao;
    private List<Proveedor> listarpro;
    
    public ProveedorC() {
        pro = new Proveedor();
        dao = new ProveedorImpl();
        listarpro=new ArrayList();
    }
    
    
    public void registrar() throws Exception {
        try {
            dao.registrar(pro);
            listar();
            limpiar();
        } catch (Exception e) {
        }
        
    }
    
    public void obtenerDatos(Proveedor pro) {
        this.pro = pro;
    }

    public void modificar() {
        try {

            dao.modificar(pro);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error en MODIFICAR ProveedorC" + e.getMessage());
        }
    }

    public void eliminar(Proveedor pro){
        try {
            dao.eliminar(pro);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en ProveedorC eliminar" + e.getMessage());
            
        }
        }
            
    public void limpiar (){
        pro = new Proveedor();
        
    }
    
    public void listar (){
        try {
            listarpro = dao.listarTodos();
        } catch (Exception e) {
        }
        
    }
    
    
    //metodos generados
    
    
    

    public Proveedor getPro() {
        return pro;
    }

    public void setPro(Proveedor pro) {
        this.pro = pro;
    }

    public ProveedorImpl getDao() {
        return dao;
    }

    public void setDao(ProveedorImpl dao) {
        this.dao = dao;
    }

    public List<Proveedor> getListarpro() {
        return listarpro;
    }

    public void setListarpro(List<Proveedor> listarpro) {
        this.listarpro = listarpro;
    }
    
    
    
    
}
