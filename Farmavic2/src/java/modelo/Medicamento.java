
package modelo;

import java.util.Date;

public class Medicamento {
    
    private int Ide; 
    private String Presentacion;
    private String Generico;
    private String Comercial;
    private String Precio;
    private Date Vencimiento;
    private String Formula;
    private String Lote;
    private String Concentracion;
    private String Via;

    public int getIde() {
        return Ide;
    }

    public void setIde(int Ide) {
        this.Ide = Ide;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String Presentacion) {
        this.Presentacion = Presentacion;
    }

    public String getGenerico() {
        return Generico;
    }

    public void setGenerico(String Generico) {
        this.Generico = Generico;
    }

    public String getComercial() {
        return Comercial;
    }

    public void setComercial(String Comercial) {
        this.Comercial = Comercial;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public Date getVencimiento() {
        return Vencimiento;
    }

    public void setVencimiento(Date Vencimiento) {
        this.Vencimiento = Vencimiento;
    }

    public String getFormula() {
        return Formula;
    }

    public void setFormula(String Formula) {
        this.Formula = Formula;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String Lote) {
        this.Lote = Lote;
    }

    public String getConcentracion() {
        return Concentracion;
    }

    public void setConcentracion(String Concentracion) {
        this.Concentracion = Concentracion;
    }

    public String getVia() {
        return Via;
    }

    public void setVia(String Via) {
        this.Via = Via;
    }
    
}
