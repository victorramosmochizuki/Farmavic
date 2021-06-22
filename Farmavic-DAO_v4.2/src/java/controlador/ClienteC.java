package controlador;

import dao.ClienteImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Cliente;

@Named(value = "clienteC")
@SessionScoped
public class ClienteC implements Serializable {

    private Cliente cli;
    private ClienteImpl dao;
    private List<Cliente> listadoCli;

    public ClienteC() {
        cli = new Cliente();
        dao = new ClienteImpl();
        listadoCli = new ArrayList<>();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en REGISTRAR ClienteC" + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {

            dao.modificar(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en MODIFICAR ClienteC" + e.getMessage());
        }
    }

    public void eliminar(Cliente clis) throws Exception {
        try {
            dao.eliminar(clis);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Eliminado con éxito"));
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en ELIMINAR ClienteC" + e.getMessage());
        }

    }
    
    public void listar() {
        try {
            listadoCli = dao.listar();
        } catch (Exception e) {
            System.out.println("Error en LISTAR ClienteC: " + e.getMessage());
        }
    }
    
    public void limpiar() {
        cli = new Cliente();
    }

    
    @PostConstruct
    public void construir() {
        listar();
    }


    // métodos generados
    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    public List<Cliente> getListadoCli() {
        return listadoCli;
    }

    public void setListadoCli(List<Cliente> listadoCli) {
        this.listadoCli = listadoCli;
    }

}
