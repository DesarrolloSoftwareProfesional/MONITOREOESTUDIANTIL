package pe.edu.sise.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.model.Actividad;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.JsonManager;
import pe.edu.sise.utils.ServiceManager;

/**
 * Created by Abel on 17/06/2017.
 */

public class ActividadController {
    protected static final String TAG = "ActividadController";

    public static List<Actividad> getActividadesByApoderado(Integer idApoderado) {
        List<Actividad> lst = new ArrayList<>();


        try {

            //String jsonString = JsonManager.getJsonString(ServiceManager.listarActividadesByApoderado(idApoderado), ServiceManager.GET);
            String jsonString = JsonManager.getJsonString(ServiceManager.ACTIVIDAD_URL_LIST_ALL, ServiceManager.GET);
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObjectOut;

            int length = jsonArray.length();

            for (int i = 0; i < length; i++) {
                jsonObjectOut = jsonArray.getJSONObject(i);
                Actividad actividad = new Actividad();

                actividad.setIdActividad(jsonObjectOut.getString(Attributes.ACT_ID));
                actividad.setCodGrupoAcademico(jsonObjectOut.getString(Attributes.ACT_GPO_ACADEMICO));
                actividad.setNomActividad(jsonObjectOut.getString(Attributes.ACT_NOMBRE));
                actividad.setDescrActividad(jsonObjectOut.getString(Attributes.ACT_DESCRIPCION));
                actividad.setIdCurso(jsonObjectOut.getString(Attributes.ACT_ID_CURSO));
                actividad.setNomCurso(jsonObjectOut.getString(Attributes.ACT_NOMB_CURSO));
                actividad.setFechaRealizacion(jsonObjectOut.getString(Attributes.ACT_FECH_REALIZACION));
                actividad.setHoraInicio(jsonObjectOut.getString(Attributes.ACT_HORA_INICIO));
                actividad.setHoraFin(jsonObjectOut.getString(Attributes.ACT_HORA_FIN));
                actividad.setFrecuenciaAviso((jsonObjectOut.getInt(Attributes.ACT_FREC_AVISO)!=0));
                actividad.setFlag_Notificado((jsonObjectOut.getInt(Attributes.ACT_FLAG_NOTIFICADO)!=0));
                actividad.setIdEmpleado(jsonObjectOut.getString(Attributes.ACT_ID_EMPLEADO));

                lst.add(actividad);
            }

        } catch (Exception e) {
            Log.d(TAG, "getActividadesByApoderado: " + Log.getStackTraceString(e));
        }

        return lst;
    }
}
