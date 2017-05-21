package pe.edu.sise.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import pe.edu.sise.model.Apoderado;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.JsonManager;
import pe.edu.sise.utils.ServiceManager;

/**
 * Created by ASUS on 7/05/2017.
 */

public class ApoderadoController {

    protected static final String TAG = "ApoderadoController";

    public static Apoderado login(JSONObject jsonObject) {

        Apoderado apoderado = new Apoderado();

        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.APODERADO_URL_LOGEO,ServiceManager.POST,jsonObject);

            JSONArray jsonArray = new JSONArray(jsonString);

            if (jsonArray.length()>0){
                JSONObject jsonObjectOut = jsonArray.getJSONObject(0);

                apoderado.setId(jsonObjectOut.getString(Attributes.APOD_ID));
                apoderado.setApPaterno(jsonObjectOut.getString(Attributes.APOD_AP_PATERNO));
                apoderado.setApMaterno(jsonObjectOut.getString(Attributes.APOD_AP_MATERNO));
                apoderado.setNombres(jsonObjectOut.getString(Attributes.APOD_NOMBRES));
                apoderado.setNomCompleto(jsonObjectOut.getString(Attributes.APOD_NOM_COMPLETO));
                apoderado.setDni(jsonObjectOut.getString(Attributes.APOD_DNI));
                apoderado.setFechaNac(jsonObjectOut.getString(Attributes.APOD_FECHA_NAC));
                apoderado.setDireccion(jsonObjectOut.getString(Attributes.APOD_DIRECCION));
                apoderado.setEstadoRegistro((jsonObjectOut.getInt(Attributes.APOD_ESTADO_REG)!=0));
                apoderado.setUsuario(jsonObjectOut.getString(Attributes.APOD_USUARIO));


            }

        } catch (Exception e) {
            Log.d(TAG, "login: " + Log.getStackTraceString(e));
        }

        return apoderado ;
    }

}
