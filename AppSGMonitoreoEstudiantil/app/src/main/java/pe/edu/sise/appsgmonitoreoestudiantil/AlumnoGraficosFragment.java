package pe.edu.sise.appsgmonitoreoestudiantil;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pe.edu.sise.adapter.CursoAdapter;
import pe.edu.sise.controller.CursoController;
import pe.edu.sise.controller.NotaController;
import pe.edu.sise.model.Curso;
import pe.edu.sise.model.Nota;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.Colors;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlumnoGraficosFragment extends Fragment {
    private static final String TAG = "AlumnoGraficosFragment";

    private BarChart alum_graf_chart_prom;
    ListView alum_lista_lstv;


    public AlumnoGraficosFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mview = inflater.inflate(R.layout.fragment_alumno_graficos, container, false);

        alum_lista_lstv = (ListView) mview.findViewById(R.id.alum_lista_lstv);
        alum_graf_chart_prom = (BarChart) mview.findViewById(R.id.alum_graf_chart_prom);
        alum_graf_chart_prom.animateY(2500);
        alum_graf_chart_prom.setDescription("Mis Cursos");
        alum_graf_chart_prom.setMaxVisibleValueCount(60);
        alum_graf_chart_prom.setPinchZoom(false);
        alum_graf_chart_prom.setDrawBarShadow(false);
        alum_graf_chart_prom.setDrawGridBackground(false);
        alum_graf_chart_prom.invalidate();

        consultarCursos();
        consultarNotaPromedio();
        return mview;
    }

    protected JSONObject getIdAlumnoTrimestreJsonObject(Integer idAlumno, Integer trimestre) {
        JSONObject jsonObject = null;

        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Attributes.NOTA_ID_ALUMNO, idAlumno.toString());
            hashMap.put(Attributes.NOTA_TIMESTRE, trimestre.toString());

            jsonObject = new JSONObject(hashMap);

        } catch (Exception e) {
            Log.d(TAG, "Error getIdAlumnoTrimestreJsonObject " + Log.getStackTraceString(e));
        }

        return jsonObject;
    }

    public void consultarNotaPromedio() {
        try {
            new NotaPromedioTrimestreAsyncTask().execute(getIdAlumnoTrimestreJsonObject(1, 1));
        } catch (Exception e) {
            Log.d(TAG, "consultarNotaPromedio: " + Log.getStackTraceString(e));
        }
    }

    public void consultarCursos() {
        try {
            new CursosListAsyncTask().execute();
        } catch (Exception e) {
            Log.d(TAG, "consultarCursos: " + Log.getStackTraceString(e));
        }
    }

    public void mostrarGragicosPromedioNota(List<Nota> notas) {
        try {

            int size = notas.size();

            ArrayList<BarEntry> entriesPromedioNotas = new ArrayList<>();
            ArrayList<String> labelsIdCursos = new ArrayList<String>();

            for (int i = 0; i < size; i++) {

                Nota nota = notas.get(i);

                entriesPromedioNotas.add(new BarEntry(nota.getPromedio(), i));
                labelsIdCursos.add(nota.getIdCurso().toString());
            }

            BarDataSet dataset = new BarDataSet(entriesPromedioNotas, "Cursos");

            dataset.setColors(Colors.CUSTOM_COLORS);

            BarData data = new BarData(labelsIdCursos, dataset);
            alum_graf_chart_prom.setData(data);

        } catch (Exception e) {
            Log.d(TAG, "mostrarGragicosPromedioNota: " + Log.getStackTraceString(e));
        }
    }

    private class NotaPromedioTrimestreAsyncTask extends AsyncTask<JSONObject, Void, List<Nota>> {
        @Override
        protected List<Nota> doInBackground(JSONObject... params) {
            return NotaController.getAllPromedioByIDAlumnoTrimestre(params[0]);
        }

        @Override
        protected void onPostExecute(List<Nota> notas) {
            super.onPostExecute(notas);
            mostrarGragicosPromedioNota(notas);
        }
    }

    public void mostrarCursos(List<Curso> cursos) {
        try {

            CursoAdapter adapter = new CursoAdapter(getContext(), cursos);
            alum_lista_lstv.setAdapter(adapter);

        } catch (Exception e) {
            Log.d(TAG, "mostrarCursos: " + Log.getStackTraceString(e));
        }
    }

    private class CursosListAsyncTask extends AsyncTask<Void, Void, List<Curso>> {
        @Override
        protected List<Curso> doInBackground(Void... params) {
            return CursoController.getAllCursos();
        }

        @Override
        protected void onPostExecute(List<Curso> cursos) {
            super.onPostExecute(cursos);
            mostrarCursos(cursos);
        }
    }

}
