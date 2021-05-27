package controlador;

import dao.ClienteD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.ClienteM;


@Named(value = "clienteC")
@SessionScoped
public class ClienteC implements Serializable {

    private ClienteD dao;
    private ClienteM cliente;
    private List<ClienteM> lstcliente;

    public ClienteC() {
        cliente = new ClienteM();
        dao = new ClienteD();
        lstcliente = new ArrayList();
    }

    public void listar() {
        try {
            lstcliente = dao.listar();
        } catch (Exception e) {
            System.out.println("Error ClienteC: " + e);
        }

    }

    @PostConstruct
    public void construir() {
        listar();
    }

    public void eliminar(ClienteM cli) {
        try {
            dao.eliminar(cli);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error ClienteC eliminar" + e.getMessage());
        }

    }

    public void registrar() {
        try {
            dao.registrar(cliente);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error en REGISTRAR clienteC" + e.getMessage());
        }

    }

    public void obtenerDatos(ClienteM cli) {
        this.cliente = cli;
    }

    public void modificar() {
        try {

            dao.modificar(cliente);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error en MODIFICAR clienteC" + e.getMessage());
        }
    }

    public void limpiar() {
        cliente = new ClienteM();
    }

    public ClienteD getDao() {
        return dao;
    }

    public void setDao(ClienteD dao) {
        this.dao = dao;
    }

    public ClienteM getCliente() {
        return cliente;
    }

    public void setCliente(ClienteM cliente) {
        this.cliente = cliente;
    }

    public List<ClienteM> getLstcliente() {
        return lstcliente;
    }

    public void setLstcliente(List<ClienteM> lstcliente) {
        this.lstcliente = lstcliente;
    }

}
