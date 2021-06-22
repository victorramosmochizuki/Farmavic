
package modelo;


public class Cliente {
   private int IDCLI;
   private String NOMCLI,APECLI,DNICLI,ESTCLI;

    public Cliente() {
    }

    public Cliente(int IDCLI, String NOMCLI, String APECLI, String DNICLI, String ESTCLI) {
        this.IDCLI = IDCLI;
        this.NOMCLI = NOMCLI;
        this.APECLI = APECLI;
        this.DNICLI = DNICLI;
        this.ESTCLI = ESTCLI;
    }

    @Override
    public String toString() {
        return "Cliente{" + "IDCLI=" + IDCLI + ", NOMCLI=" + NOMCLI + ", APECLI=" + APECLI + ", DNICLI=" + DNICLI + ", ESTCLI=" + ESTCLI + '}';
    }

    public int getIDCLI() {
        return IDCLI;
    }

    public void setIDCLI(int IDCLI) {
        this.IDCLI = IDCLI;
    }

    public String getNOMCLI() {
        return NOMCLI;
    }

    public void setNOMCLI(String NOMCLI) {
        this.NOMCLI = NOMCLI;
    }

    public String getAPECLI() {
        return APECLI;
    }

    public void setAPECLI(String APECLI) {
        this.APECLI = APECLI;
    }

    public String getDNICLI() {
        return DNICLI;
    }

    public void setDNICLI(String DNICLI) {
        this.DNICLI = DNICLI;
    }

    public String getESTCLI() {
        return ESTCLI;
    }

    public void setESTCLI(String ESTCLI) {
        this.ESTCLI = ESTCLI;
    }
   
   
   
   
   
   
}
