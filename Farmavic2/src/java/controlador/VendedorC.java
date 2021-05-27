package controlador;

import dao.VendedorD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.VendedorM;


@Named(value = "vendedorC")
@SessionScoped
public class VendedorC implements Serializable {

    private VendedorD dao;
    private VendedorM vendedor;
    private List<VendedorM> lstvendedor;

    public VendedorC() {
        vendedor = new VendedorM();
        dao = new VendedorD();
        lstvendedor = new ArrayList();
    }

    public void listar() {
        try {
            lstvendedor = dao.listar();
        } catch (Exception e) {
            System.out.println("Error vendedorC: " + e);
        }

    }

    @PostConstruct
    public void construir() {
        listar();
    }

//    public void eliminar(VendedorM ven) {
//        try {
//            dao.eliminar(ven);
//            listar();
//            limpiar();
//        } catch (Exception e) {
//            System.out.println("error VendedorC eliminar" + e.getMessage());
//        }
//
//    }
    
    
    public void eliminar(VendedorM ven) {
        try {
            dao.eliminar(ven);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error VendedorC eliminar" + e.getMessage());
        }

    }
    
    

    public void registrar() {
        try {
            dao.registrar(vendedor);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error en REGISTRAR vendedorC" + e.getMessage());
        }

    }

    public void obtenerDatos(VendedorM ven) {
        this.vendedor = ven;
    }

    public void modificar() {
        try {

            dao.modificar(vendedor);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error en MODIFICAR vendedorC" + e.getMessage());
        }
    }

    public void limpiar() {
        vendedor = new VendedorM();
    }

    public VendedorD getDao() {
        return dao;
    }

    public void setDao(VendedorD dao) {
        this.dao = dao;
    }

    public VendedorM getVendedorM() {
        return vendedor;
    }

    public void setVendedorM(VendedorM vendedor) {
        this.vendedor = vendedor;
    }

    public List<VendedorM> getLstvendedor() {
        return lstvendedor;
    }

    public void setLstvendedor(List<VendedorM> lstvendedor) {
        this.lstvendedor = lstvendedor;
    }

}