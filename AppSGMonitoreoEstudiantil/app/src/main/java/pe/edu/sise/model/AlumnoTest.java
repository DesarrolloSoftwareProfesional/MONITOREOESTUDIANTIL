package pe.edu.sise.model;

public class AlumnoTest {
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
    private int IdAlumno;
    private int trimestre;


    public AlumnoTest(String tipoAct, String curso, String profesor,
                      String fecha, String hora_ini, String hora_fin,int IdAlumno,int trimestre) {
        this.tipoAct = tipoAct;
        this.curso = curso;
        this.profesor = profesor;
        this.fecha = fecha;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
        this.IdAlumno = IdAlumno;
        this.trimestre = trimestre;
    }

    public AlumnoTest(String tipoAct, String curso, String profesor,
                      String fecha, String hora_ini, String hora_fin) {
        this.tipoAct = tipoAct;
        this.curso = curso;
        this.profesor = profesor;
        this.fecha = fecha;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
    }

    public AlumnoTest(String nombres, String apellidos, int codGrado, int codPeriodo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.codGrado = codGrado;
        this.codPeriodo = codPeriodo;
    }

    public AlumnoTest() {
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

    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        IdAlumno = idAlumno;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    @Override
    public String toString() {
        return "AlumnoTest{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", codGrado=" + codGrado +
                ", codPeriodo=" + codPeriodo +
                ", tipoAct='" + tipoAct + '\'' +
                ", curso='" + curso + '\'' +
                ", profesor='" + profesor + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora_ini='" + hora_ini + '\'' +
                ", hora_fin='" + hora_fin + '\'' +
                ", IdAlumno=" + IdAlumno +
                ", trimestre=" + trimestre +
                '}';
    }
}
