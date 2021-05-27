package modelo;

public class ClienteM {

    private int Idcli;
    private String nombre;
    private String apellido;
    private String dni;
    private String estado;

    public ClienteM() {
    }

    public ClienteM(int Idcli, String nombre, String apellido, String dni, String estado) {
        this.Idcli = Idcli;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;

    }

    @Override
    public String toString() {
        return "ClienteM{" + "Idcli=" + Idcli + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ",estado=" + estado + '}';
    }

    public int getIde() {
        return Idcli;
    }

    public void setIde(int Idcli) {
        this.Idcli = Idcli;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}