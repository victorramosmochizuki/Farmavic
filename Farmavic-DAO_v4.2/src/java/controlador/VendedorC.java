package controlador;

import dao.VendedorImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Vendedor;

@Named(value = "vendedorC")
@SessionScoped
public class VendedorC implements Serializable {

    private Vendedor ven;
    private VendedorImpl dao;
    private List<Vendedor> listadoVen;

    public VendedorC() {
        ven = new Vendedor();
        dao = new VendedorImpl();
        listadoVen = new ArrayList<>();
    }

    public void registrar() {
        try {
            ven.setIDUBI(dao.obtenerCodigoUbigeo(ven.getIDUBI()));
            dao.registrar(ven);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en REGISTRAR VendedorC" + e.getMessage());
        }

    }

    public void modificar() {
        try {
            dao.modificar(ven);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en MODIFICAR VendedorC" + e.getMessage());
        }
    }

    public void eliminar(Vendedor vend) {
        try {
            dao.eliminar(vend);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en ELIMINAR VendedorC" + e.getMessage());
        }
    }

    public List<String> completeTextUbigeo(String query) throws SQLException, Exception {
        VendedorImpl daoUbi = new VendedorImpl();
        return daoUbi.autocompleteUbigeo(query);
    }

    public void limpiar() {
        ven = new Vendedor();
    }

    public void listar() {
        try {
            listadoVen = dao.listar();
        } catch (Exception e) {
            System.out.println("Error en LISTAR VendedorC: " + e.getMessage());
        }
    }

    @PostConstruct
    public void construir() {
        listar();
    }

    // métodos generados
    public Vendedor getVen() {
        return ven;
    }

    public void setVen(Vendedor ven) {
        this.ven = ven;
    }

    public VendedorImpl getDao() {
        return dao;
    }

    public void setDao(VendedorImpl dao) {
        this.dao = dao;
    }

    public List<Vendedor> getListadoVen() {
        return listadoVen;
    }

    public void setListadoVen(List<Vendedor> listadoVen) {
        this.listadoVen = listadoVen;
    }

}
