
package modelo;

import java.util.Date;


public class Medicamento {

    private int IDMED,STOCMED;
    private String PRESMED, GENMED, COMMED,FORMED,LOTMED,ESTMED,IDPROV;
    private Double PRECMED;
    private Date FVMED;

    public Medicamento() {
    }
    
    public Medicamento(int IDMED, int STOCMED, String IDPROV, String PRESMED, String GENMED, String COMMED, String FORMED, String LOTMED, String ESTMED, Double PRECMED, Date FVMED) {
        this.IDMED = IDMED;
        this.STOCMED = STOCMED;
        this.IDPROV = IDPROV;
        this.PRESMED = PRESMED;
        this.GENMED = GENMED;
        this.COMMED = COMMED;
        this.FORMED = FORMED;
        this.LOTMED = LOTMED;
        this.ESTMED = ESTMED;
        this.PRECMED = PRECMED;
        this.FVMED = FVMED;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "IDMED=" + IDMED + ", STOCMED=" + STOCMED + ", IDPROV=" + IDPROV + ", PRESMED=" + PRESMED + ", GENMED=" + GENMED + ", COMMED=" + COMMED + ", FORMED=" + FORMED + ", LOTMED=" + LOTMED + ", ESTMED=" + ESTMED + ", PRECMED=" + PRECMED + ", FVMED=" + FVMED + '}';
    }

    public int getIDMED() {
        return IDMED;
    }

    public void setIDMED(int IDMED) {
        this.IDMED = IDMED;
    }

    public int getSTOCMED() {
        return STOCMED;
    }

    public void setSTOCMED(int STOCMED) {
        this.STOCMED = STOCMED;
    }

    public String getIDPROV() {
        return IDPROV;
    }

    public void setIDPROV(String IDPROV) {
        this.IDPROV = IDPROV;
    }

    public String getPRESMED() {
        return PRESMED;
    }

    public void setPRESMED(String PRESMED) {
        this.PRESMED = PRESMED;
    }

    public String getGENMED() {
        return GENMED;
    }

    public void setGENMED(String GENMED) {
        this.GENMED = GENMED;
    }

    public String getCOMMED() {
        return COMMED;
    }

    public void setCOMMED(String COMMED) {
        this.COMMED = COMMED;
    }

    public String getFORMED() {
        return FORMED;
    }

    public void setFORMED(String FORMED) {
        this.FORMED = FORMED;
    }

    public String getLOTMED() {
        return LOTMED;
    }

    public void setLOTMED(String LOTMED) {
        this.LOTMED = LOTMED;
    }

    public String getESTMED() {
        return ESTMED;
    }

    public void setESTMED(String ESTMED) {
        this.ESTMED = ESTMED;
    }

    public Double getPRECMED() {
        return PRECMED;
    }

    public void setPRECMED(Double PRECMED) {
        this.PRECMED = PRECMED;
    }

    public Date getFVMED() {
        return FVMED;
    }

    public void setFVMED(Date FVMED) {
        this.FVMED = FVMED;
    }
    
    
    
    
    
}
