
package controlador;

import dao.MedicamentoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Medicamento;


@Named(value = "medicamentoC2")
@SessionScoped
public class MedicamentoC implements Serializable {

    private Medicamento med;
    private MedicamentoImpl dao;
    private List<Medicamento> listarmed;
    
    public MedicamentoC() {
        med = new Medicamento();
        dao = new MedicamentoImpl();
        listarmed=new ArrayList();
    }
    
    
    public void registrar() throws Exception {
        try {
            dao.registrar(med);
            listar();
            limpiar();
        } catch (Exception e) {
        }
        
    }
    
    public void obtenerDatos(Medicamento med) {
        this.med = med;
    }

    public void modificar() {
        try {

            dao.modificar(med);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("error en MODIFICAR MedicamentoC" + e.getMessage());
        }
    }

    public void eliminar(Medicamento med){
        try {
            dao.eliminar(med);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en Medicamento Controlador eliminar" + e.getMessage());
            
        }
        }
            
    public void limpiar (){
        med = new Medicamento();
        
    }
    
    public void listar (){
        try {
            listarmed = dao.listarTodos();
        } catch (Exception e) {
        }
        
    }
    
    
    //metodos generados
    
    
    

    public Medicamento getMed() {
        return med;
    }

    public void setMed(Medicamento med) {
        this.med = med;
    }

    public MedicamentoImpl getDao() {
        return dao;
    }

    public void setDao(MedicamentoImpl dao) {
        this.dao = dao;
    }

    public List<Medicamento> getListarmed() {
        return listarmed;
    }

    public void setListarmed(List<Medicamento> listarmed) {
        this.listarmed = listarmed;
    }
    
    
    
    
}
