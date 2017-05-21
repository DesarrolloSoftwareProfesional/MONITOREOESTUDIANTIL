package pe.edu.sise.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.model.Curso;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.JsonManager;
import pe.edu.sise.utils.ServiceManager;

/**
 * Created by Abel on 9/05/2017.
 */

public class CursoController {
    protected static final String TAG = "CursoController";

    public static List<Curso> getAllCursos() {
        List<Curso> data = new ArrayList<>();

        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.CURSO_URL_LIST_ALL, ServiceManager.GET);
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObjectOut;

            int length = jsonArray.length();

            for (int i = 0; i < length; i++) {
                jsonObjectOut = jsonArray.getJSONObject(i);
                Curso curso = new Curso();
                curso.setIdCurso(jsonObjectOut.getString(Attributes.CURSO_ID));
                curso.setNomCurso(jsonObjectOut.getString(Attributes.CURSO_NOMBRE));
                curso.setAbrevCurso(jsonObjectOut.getString(Attributes.CURSO_ABREV));
                curso.setEstadoRegistro((jsonObjectOut.getInt(Attributes.CURSO_ESTADO_REG) != 0));
                data.add(curso);
            }

        } catch (Exception e) {
            Log.d(TAG, "getAllCursos: " + Log.getStackTraceString(e));
        }

        return data;
    }


    public static Curso getCurso(Integer id) {
        Curso curso = new Curso();

        try {
            String jsonString = JsonManager.getJsonString(ServiceManager.cursoUrlGetByID(id), ServiceManager.GET);
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObjectOut;

            int length = jsonArray.length();

            if (length > 0) {
                jsonObjectOut = jsonArray.getJSONObject(0);
                curso.setIdCurso(jsonObjectOut.getString(Attributes.CURSO_ID));
                curso.setNomCurso(jsonObjectOut.getString(Attributes.CURSO_NOMBRE));
                curso.setAbrevCurso(jsonObjectOut.getString(Attributes.CURSO_ABREV));
                curso.setEstadoRegistro((jsonObjectOut.getInt(Attributes.CURSO_ESTADO_REG) != 0));
            }

        } catch (Exception e) {
            Log.d(TAG, "getAllCursos: " + Log.getStackTraceString(e));
        }

        return curso;
    }
}