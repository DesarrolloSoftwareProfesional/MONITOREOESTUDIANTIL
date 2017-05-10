package pe.edu.sise.model;

/**
 * Created by Abel on 9/05/2017.
 */

public class Curso {
    private String idCurso;
    private String nomCurso;
    private String abrevCurso;
    private boolean estadoRegistro;

    public Curso(String idCurso, String nomCurso, String abrevCurso, boolean estadoRegistro) {
        this.idCurso = idCurso;
        this.nomCurso = nomCurso;
        this.abrevCurso = abrevCurso;
        this.estadoRegistro = estadoRegistro;
    }

    public Curso() {
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

    public String getAbrevCurso() {
        return abrevCurso;
    }

    public void setAbrevCurso(String abrevCurso) {
        this.abrevCurso = abrevCurso;
    }

    public boolean isEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(boolean estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
}
