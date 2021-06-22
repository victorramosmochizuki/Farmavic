
package modelo;


public class Vendedor {

    private int IDVEN;
    private String NOMVEN, APEVEN, DNIVEN, TELFVEN, DIRVEN, ESTVEN,IDUBI;

    public Vendedor() {
    }

    public Vendedor(int IDVEN, String NOMVEN, String APEVEN, String DNIVEN, String TELFVEN, String DIRVEN, String ESTVEN, String IDUBI) {
        this.IDVEN = IDVEN;
        this.NOMVEN = NOMVEN;
        this.APEVEN = APEVEN;
        this.DNIVEN = DNIVEN;
        this.TELFVEN = TELFVEN;
        this.DIRVEN = DIRVEN;
        this.ESTVEN = ESTVEN;
        this.IDUBI = IDUBI;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "IDVEN=" + IDVEN + ", NOMVEN=" + NOMVEN + ", APEVEN=" + APEVEN + ", DNIVEN=" + DNIVEN + ", TELFVEN=" + TELFVEN + ", DIRVEN=" + DIRVEN + ", ESTVEN=" + ESTVEN + ", IDUBI=" + IDUBI + '}';
    }

    public String getIDUBI() {
        return IDUBI;
    }

    public void setIDUBI(String IDUBI) {
        this.IDUBI = IDUBI;
    }
   
    
    public int getIDVEN() {
        return IDVEN;
    }

    public void setIDVEN(int IDVEN) {
        this.IDVEN = IDVEN;
    }

    public String getNOMVEN() {
        return NOMVEN;
    }

    public void setNOMVEN(String NOMVEN) {
        this.NOMVEN = NOMVEN;
    }

    public String getAPEVEN() {
        return APEVEN;
    }

    public void setAPEVEN(String APEVEN) {
        this.APEVEN = APEVEN;
    }

    public String getDNIVEN() {
        return DNIVEN;
    }

    public void setDNIVEN(String DNIVEN) {
        this.DNIVEN = DNIVEN;
    }

    public String getTELFVEN() {
        return TELFVEN;
    }

    public void setTELFVEN(String TELFVEN) {
        this.TELFVEN = TELFVEN;
    }

    public String getDIRVEN() {
        return DIRVEN;
    }

    public void setDIRVEN(String DIRVEN) {
        this.DIRVEN = DIRVEN;
    }

    public String getESTVEN() {
        return ESTVEN;
    }

    public void setESTVEN(String ESTVEN) {
        this.ESTVEN = ESTVEN;
    }
    
    
}
