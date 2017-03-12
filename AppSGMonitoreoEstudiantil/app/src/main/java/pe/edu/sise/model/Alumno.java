package pe.edu.sise.model;

public class Alumno {
    private String nombres;
    private String apellidos;
    private int codGrado;
    private int codPeriodo;

    public Alumno(String nombres, String apellidos, int codGrado, int codPeriodo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.codGrado = codGrado;
        this.codPeriodo = codPeriodo;
    }

    public Alumno() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCodGrado() {
        return codGrado;
    }

    public void setCodGrado(int codGrado) {
        this.codGrado = codGrado;
    }

    public int getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(int codPeriodo) {
        this.codPeriodo = codPeriodo;
    }
}
