package controlador;

import dao.ProveedorImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Proveedor;

@Named(value = "proveedorC")
@SessionScoped
public class ProveedorC implements Serializable {

    private Proveedor pro;
    private ProveedorImpl dao;
    private List<Proveedor> listadoPro;

    public ProveedorC() {
        pro = new Proveedor();
        dao = new ProveedorImpl();
    }

    public void registrar() throws Exception {
        try {
            pro.setUbigeo(dao.obtenerCodigoUbigeo(pro.getUbigeo()));
            dao.registrar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en REGISTRAR ProveedorC" + e.getMessage());
        }

    }

    public void modificar() {
        try {

            dao.modificar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en MODIFICAR ProveedorC" + e.getMessage());
        }
    }

    public void eliminar(Proveedor pro) {
        try {
            dao.eliminar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Eliminado con éxito"));
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en ELIMINAR ProveedorC" + e.getMessage());
        }
    }
    
    public List<String> completeTextUbigeo(String query) throws SQLException, Exception {
        ProveedorImpl daoUbi = new ProveedorImpl();
        return daoUbi.autocompleteUbigeo(query);
    }

    public void limpiar() {
        pro = new Proveedor();

    }

    public void listar() {
        try {
            listadoPro = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en LISTAR ProveedorC: " + e.getMessage());
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

    public List<Proveedor> getListadoPro() {
        return listadoPro;
    }

    public void setListadoPro(List<Proveedor> listadoPro) {
        this.listadoPro = listadoPro;
    }
    

}
