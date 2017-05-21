package pe.edu.sise.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import pe.edu.sise.model.Alumno;
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
                alumno.setEstadoRegistro((jsonObjectOut.getInt(Attributes.ALUM_ESTADO_REG)!=0));
                alumno.setUsuario(jsonObjectOut.getString(Attributes.ALUM_USUARIO));
            }
        } catch (Exception e) {
            Log.d(TAG, Log.getStackTraceString(e));
        }
        return alumno;

    }
}
