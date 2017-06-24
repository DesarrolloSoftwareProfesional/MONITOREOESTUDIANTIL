package pe.edu.sise.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.model.Alumno;
import pe.edu.sise.model.Response;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.JsonManager;
import pe.edu.sise.utils.ServiceManager;

/**
 * Created by Abel on 1/05/2017.
 */

public class AlumnoController {

    protected static final String TAG = "AlumnoController";

    public static Alumno login(JSONObject jsonObjectIn) {
        Alumno alumno = new Alumno();
        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.ALUMNO_URL_LOGEO, ServiceManager.POST, jsonObjectIn);

            JSONArray jsonArray = new JSONArray(jsonString);
            if (jsonArray.length() > 0) {
                JSONObject jsonObjectOut = jsonArray.getJSONObject(0);

                alumno.setId(jsonObjectOut.getString(Attributes.ALUM_ID));
                alumno.setApPaterno(jsonObjectOut.getString(Attributes.ALUM_AP_PATERNO));
                alumno.setApMaterno(jsonObjectOut.getString(Attributes.ALUM_AP_MATERNO));
                alumno.setNombres(jsonObjectOut.getString(Attributes.ALUM_NOMBRES));
                alumno.setNomCompleto(jsonObjectOut.getString(Attributes.ALUM_NOM_COMPLETO));
                alumno.setDni(jsonObjectOut.getString(Attributes.ALUM_DNI));
                alumno.setFechaNac(jsonObjectOut.getString(Attributes.ALUM_FECHA_NAC));
                alumno.setDireccion(jsonObjectOut.getString(Attributes.ALUM_DIRECCION));
                alumno.setEstadoRegistro((jsonObjectOut.getInt(Attributes.ALUM_ESTADO_REG) != 0));
                alumno.setUsuario(jsonObjectOut.getString(Attributes.ALUM_USUARIO));
            }
        } catch (Exception e) {
            Log.d(TAG, Log.getStackTraceString(e));
        }
        return alumno;

    }

    public static Response updateFcmToken(JSONObject jsonObjectIn) {
        Response response = null;
        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.ALUMNO_URL_FCM_TOKEN_UPDATE, ServiceManager.POST, jsonObjectIn);

            JSONObject jsonObjectOut = new JSONObject(jsonString);
            response = new Response();
            response.setState(jsonObjectOut.getBoolean(Attributes.RES_STATE));
            response.setMsg(jsonObjectOut.getString(Attributes.RES_MSG));
        } catch (Exception e) {
            Log.d(TAG, Log.getStackTraceString(e));
            response = new Response(false, "Ocurrio un error inesperado");
        }

        return response;
    }

    public static List<Alumno> getAlumnosByApoderado(Integer idApoderado) {
        List<Alumno> lst = new ArrayList<>();


        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.listarAlumnosByApoderado(idApoderado), ServiceManager.GET);
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObjectOut;

            int length = jsonArray.length();

            for (int i = 0; i < length; i++) {
                jsonObjectOut = jsonArray.getJSONObject(i);
                Alumno alumno = new Alumno();

                alumno.setId(jsonObjectOut.getString(Attributes.ALUM_ID));
                alumno.setNombres(jsonObjectOut.getString(Attributes.ALUM_NOMBRES));
                alumno.setApPaterno(jsonObjectOut.getString(Attributes.ALUM_AP_PATERNO));
                alumno.setApMaterno(jsonObjectOut.getString(Attributes.ALUM_AP_MATERNO));
                alumno.setTrimestre(jsonObjectOut.getInt(Attributes.ALUM_TRIMESTRE));
                alumno.setAnio(jsonObjectOut.getInt(Attributes.ALUM_ANIO));
                alumno.setCodGracdo(jsonObjectOut.getInt(Attributes.ALUM_GRADO));
                alumno.setCodSeccion(jsonObjectOut.getString(Attributes.ALUM_COD_SECCION));
                alumno.setCantAct(jsonObjectOut.getInt(Attributes.ALUM_CANT_ACTIVIDAD));
                alumno.setPeriodo(jsonObjectOut.getInt(Attributes.ALUM_ANIO));
                alumno.setPromedioTotal(jsonObjectOut.getInt(Attributes.ALUM_PROMEDIO_TOTAL));
                lst.add(alumno);
            }

        } catch (Exception e) {
            Log.d(TAG, "getAllCursos: " + Log.getStackTraceString(e));
        }

        return lst;
    }

    public static String getStringAlumnosByIDApoderado(int idApoderado) {
        String alumnosString = "";
        try {
            alumnosString = JsonManager.getJsonString(ServiceManager.listaAlumnosByIDApoderado(idApoderado), ServiceManager.GET);
        } catch (Exception e) {
            Log.d(TAG, "getStringAlumnosByIDApoderado " + Log.getStackTraceString(e));
        }

        return alumnosString;
    }


    public static List<Alumno> getAlumnoByID(Integer idAlumno) {
        List<Alumno> lst = new ArrayList<>();


        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.listarAlumnoByID(idAlumno), ServiceManager.GET);
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObjectOut;

            int length = jsonArray.length();

            for (int i = 0; i < length; i++) {
                jsonObjectOut = jsonArray.getJSONObject(i);
                Alumno alumno = new Alumno();

                alumno.setId(jsonObjectOut.getString(Attributes.ALUM_ID));
                alumno.setNombres(jsonObjectOut.getString(Attributes.ALUM_NOM_COMPLETO));
                alumno.setApPaterno(jsonObjectOut.getString(Attributes.ALUM_AP_PATERNO));
                alumno.setApMaterno(jsonObjectOut.getString(Attributes.ALUM_AP_MATERNO));
                alumno.setDni(jsonObjectOut.getString(Attributes.ALUM_DNI));
                alumno.setCodGracdo(jsonObjectOut.getInt(Attributes.ALUM_GRADO));
                alumno.setCodSeccion(jsonObjectOut.getString(Attributes.ALUM_COD_SECCION));
                alumno.setPeriodo(jsonObjectOut.getInt(Attributes.ALUM_ANIO));
                alumno.setFechaNac(jsonObjectOut.getString(Attributes.ALUM_FECHA_NAC));
                lst.add(alumno);
            }

        } catch (Exception e) {
            Log.d(TAG, "getAllCursos: " + Log.getStackTraceString(e));
        }

        return lst;
    }





}
