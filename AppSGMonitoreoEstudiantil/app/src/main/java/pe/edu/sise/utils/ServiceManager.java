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

    //DOMINIO - ABEL
    private static final String DOMAIN = "http://192.168.2.17/sise/sme/api/";

    //URL-ALUMNO
    public static final String ALUMNO_URL_LOGEO = DOMAIN + "alumno/logeo";

    //URL-Notas
    public static final String NOTA_URL_PROMEDIO_TRIMESTRE = DOMAIN + "nota/promedioalumnotrimestre";

    public static String nota_Url_Promedio_By_IDAlumno(Integer id) {
        return DOMAIN + "nota/promedioalumno/" + id;
    }
}