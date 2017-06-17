package pe.edu.sise.model;

/**
 * Created by Abel on 17/06/2017.
 */

public class Actividad {

    private String idActividad;
    private String idEmpleado;
    private String idCurso;
    private String nomCurso;
    private String codGrupoAcademico;
    private String nomActividad;
    private String descrActividad;
    private String fechaRealizacion;
    private String horaInicio;
    private String horaFin;
    private boolean frecuenciaAviso;
    private boolean flag_Notificado;

    public Actividad() {
    }

    public Actividad(String idActividad, String idEmpleado, String idCurso, String nomCurso, String codGrupoAcademico, String nomActividad, String descrActividad, String fechaRealizacion, String horaInicio, String horaFin, boolean frecuenciaAviso, boolean flag_Notificado) {
        this.idActividad = idActividad;
        this.idEmpleado = idEmpleado;
        this.idCurso = idCurso;
        this.nomCurso = nomCurso;
        this.codGrupoAcademico = codGrupoAcademico;
        this.nomActividad = nomActividad;
        this.descrActividad = descrActividad;
        this.fechaRealizacion = fechaRealizacion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.frecuenciaAviso = frecuenciaAviso;
        this.flag_Notificado = flag_Notificado;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public String getCodGrupoAcademico() {
        return codGrupoAcademico;
    }

    public void setCodGrupoAcademico(String codGrupoAcademico) {
        this.codGrupoAcademico = codGrupoAcademico;
    }

    public String getNomActividad() {
        return nomActividad;
    }

    public void setNomActividad(String nomActividad) {
        this.nomActividad = nomActividad;
    }

    public String getDescrActividad() {
        return descrActividad;
    }

    public void setDescrActividad(String descrActividad) {
        this.descrActividad = descrActividad;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isFrecuenciaAviso() {
        return frecuenciaAviso;
    }

    public void setFrecuenciaAviso(boolean frecuenciaAviso) {
        this.frecuenciaAviso = frecuenciaAviso;
    }

    public boolean isFlag_Notificado() {
        return flag_Notificado;
    }

    public void setFlag_Notificado(boolean flag_Notificado) {
        this.flag_Notificado = flag_Notificado;
    }

}