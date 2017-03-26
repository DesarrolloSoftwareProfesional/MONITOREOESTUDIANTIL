package pe.edu.sise.model;

public class Alumno {
    private String nombres;
    private String apellidos;
    private int codGrado;
    private int codPeriodo;
    private String tipoAct;
    private String curso;
    private String profesor;
    private String fecha;
    private String hora_ini;
    private String hora_fin;


    public Alumno(String tipoAct, String curso, String profesor, String fecha, String hora_ini, String hora_fin) {
        this.tipoAct = tipoAct;
        this.curso = curso;
        this.profesor = profesor;
        this.fecha = fecha;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
    }

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

    public String getTipoAct() {
        return tipoAct;
    }

    public void setTipoAct(String tipoAct) {
        this.tipoAct = tipoAct;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }
}
