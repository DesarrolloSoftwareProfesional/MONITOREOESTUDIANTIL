package pe.edu.sise.model;

/**
 * Created by Abel on 7/05/2017.
 */

public class Nota {

    private Integer idNota  ;
    private Integer idAlumno ;
    private Integer idCurso ;
    private Integer idPeriodo ;
    private Integer idEmpleado ;
    private Integer idTipoNota ;
    private Integer nota ;
    private Integer estadoRegistro   ;
    private Integer promedio;
    private Integer trimestre;

    public Nota(Integer idNota, Integer idAlumno, Integer idCurso, Integer idPeriodo, Integer idEmpleado, Integer idTipoNota, Integer nota, Integer estadoRegistro) {
        this.idNota = idNota;
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.idPeriodo = idPeriodo;
        this.idEmpleado = idEmpleado;
        this.idTipoNota = idTipoNota;
        this.nota = nota;
        this.estadoRegistro = estadoRegistro;
    }

    public Nota() {
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdTipoNota() {
        return idTipoNota;
    }

    public void setIdTipoNota(Integer idTipoNota) {
        this.idTipoNota = idTipoNota;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(Integer estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Integer getPromedio() {
        return promedio;
    }

    public void setPromedio(Integer promedio) {
        this.promedio = promedio;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }
}
