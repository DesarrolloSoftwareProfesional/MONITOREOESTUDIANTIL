package pe.edu.sise.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.model.Nota;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.JsonManager;
import pe.edu.sise.utils.ServiceManager;

/**
 * Created by Abel on 7/05/2017.
 */

public class NotaController {

    protected static final String TAG = "NotaController";

    public static List<Nota> getAllPromedioByIDAlumnoTrimestre(JSONObject jsonObjectIn) {
        List<Nota> promedios = new ArrayList<>();
        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.NOTA_URL_PROMEDIO_TRIMESTRE, ServiceManager.POST,jsonObjectIn);

            JSONArray jsonArray = new JSONArray(jsonString);

            JSONObject jsonObjectOut;

            int length = jsonArray.length();

            for (int i = 0; i < length; i++) {
                jsonObjectOut = jsonArray.getJSONObject(i);
                Nota nota = new Nota();

                nota.setIdCurso(jsonObjectOut.getInt(Attributes.NOTA_ID_CURSO));
                nota.setPromedio(jsonObjectOut.getInt(Attributes.NOTA_PROMEDIO));
                nota.setTrimestre(jsonObjectOut.getInt(Attributes.NOTA_TIMESTRE));

                promedios.add(nota);
            }


        } catch (Exception e) {
            Log.d(TAG, "getAllPromedioByIDAlumnoTrimestre: " + Log.getStackTraceString(e));
        }

        return promedios;
    }

}
