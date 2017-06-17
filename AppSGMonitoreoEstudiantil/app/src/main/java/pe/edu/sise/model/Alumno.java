package pe.edu.sise.model;

/**
 * Created by Abel on 1/05/2017.
 */

public class Alumno {
    private String id;
    private String apPaterno;
    private String apMaterno;
    private String nombres;
    private String dni;
    private String fechaNac;
    private String direccion;
    private String nomCompleto;
    private boolean estadoRegistro;
    private String usuario;
    private boolean logged;
    private int trimestre;
    private int anio;
    private int codGracdo;
    private String codSeccion;
    private int cantAct;
    private int periodo;
    private int promedioTotal;


    public Alumno(String id, String apPaterno, String apMaterno, String nombres, String dni, String fechaNac, String direccion, String nomCompleto, boolean estadoRegistro) {
        this.id = id;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nombres = nombres;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.nomCompleto = nomCompleto;
        this.estadoRegistro = estadoRegistro;
    }

    public Alumno() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNomCompleto() {
        //return nomCompleto;
        return nombres + " " + apPaterno + " " + apMaterno;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public boolean isEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(boolean estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCodGracdo() {
        return codGracdo;
    }

    public void setCodGracdo(int codGracdo) {
        this.codGracdo = codGracdo;
    }

    public String getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(String codSeccion) {
        this.codSeccion = codSeccion;
    }

    public int getCantAct() {
        return cantAct;
    }

    public void setCantAct(int cantAct) {
        this.cantAct = cantAct;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getPromedioTotal() {
        return promedioTotal;
    }

    public void setPromedioTotal(int promedioTotal) {
        this.promedioTotal = promedioTotal;
    }
}
