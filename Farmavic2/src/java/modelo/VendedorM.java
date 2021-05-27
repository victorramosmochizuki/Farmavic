package modelo;


public class VendedorM {
    private int Idven;
    private String nombre;
    private String apellido;
    private String sexo;
    private String dni;
    private String caja;
    private String turno;
    private String ubigeo;
    private String estado;
    
    public VendedorM(){
    }

    public VendedorM(int Idven, String nombre, String apellido, String sexo, String dni, String caja, String turno, String ubigeo, String estado) {
        this.Idven = Idven;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.caja = caja;
        this.turno = turno;
        this.ubigeo = ubigeo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "VendedorM{" + "Idven=" + Idven + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", dni=" + dni + ", caja=" + caja + ", turno=" + turno + ", ubigeo=" + ubigeo + ", estado=" + estado + '}';
    }
    
    public int getIde() {
        return Idven;
    }

    public void setIde(int Idven) {
        this.Idven = Idven;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}