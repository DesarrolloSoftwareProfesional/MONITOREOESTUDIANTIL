package pe.edu.sise.utils;

/**
 * Created by Abel on 29/04/2017.
 */

public class ServiceManager {

    //METODOS
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";


    //DOMINIO
    //private static final String DOMAIN = "http://192.168.2.17/sme/api/";

    //    //DOMINIO - ABEL
    private static final String DOMAIN = "http://192.168.137.157/sise/sme/api/";

    //DOMINIO - JHONATAN
    //private static final String DOMAIN = "http://192.168.1.26/sise/sme/api/";

    //DOMINIO - RONALD
    // private static final String DOMAIN = "http://192.168.43.222/sise/sme/api/";

    //URL-ALUMNO
    public static final String ALUMNO_URL_LOGEO = DOMAIN + "alumno/logeo";
    public static final String ALUMNO_URL_FCM_TOKEN_UPDATE = DOMAIN + "alumno/updtoken";

    //URL-APODERADO
    public static final String APODERADO_URL_LOGEO = DOMAIN + "apoderado/logeo";
    public static String listaAlumnosByIDApoderado(Integer id) {
        return DOMAIN + "apoderado/alumnoidapoderado/" + id;
    }

    //URL-NOTAS
    public static final String NOTA_URL_PROMEDIO_TRIMESTRE = DOMAIN + "nota/promedioalumnotrimestre";

    public static String notaUrlPromedioByIDAlumno(Integer id) {
        return DOMAIN + "nota/promedioalumno/" + id;
    }

    public static String listarAlumnosByApoderado(Integer idApoderado) {
        return DOMAIN + "alumno/listarAlum_by_apod/" + idApoderado;
    }

    public static String listarAlumnoByID(Integer idAlumno) {
        return DOMAIN + "alumno/buscar/" + idAlumno;
    }

    // URL-CURSOS
    public static final String CURSO_URL_LIST_ALL = DOMAIN + "curso/listar";

    public static String cursoUrlGetByID(Integer id) {
        return DOMAIN + "curso/buscar/" + id;
    }

    //URL-ACTIVIDADES
    public static final String ACTIVIDAD_URL_LIST_ALL = DOMAIN + "actividad/listar";

    public static final String ACTIVIDAD_URL_BY_IDACTIVIDAD_IDALUMNO = DOMAIN + "actividad/idactividalumno";

    public static String actividadByID(Integer id) {
        return DOMAIN + "actividad/buscar/" + id;
    }

    public static String listarActividadesByApoderado(Integer idApoderado) {
        return DOMAIN + "actividad/apoderadoid/" + idApoderado;
    }

    public static String listarActividadesByGpoAcademico(String gpoAcademico) {
        return DOMAIN + "actividad/gpoacademico/" + gpoAcademico;
    }

}