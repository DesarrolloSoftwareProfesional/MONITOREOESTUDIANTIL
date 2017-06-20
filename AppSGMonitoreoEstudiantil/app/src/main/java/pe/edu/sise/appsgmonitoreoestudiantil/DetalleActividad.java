package pe.edu.sise.appsgmonitoreoestudiantil;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

import pe.edu.sise.controller.ActividadController;
import pe.edu.sise.model.Actividad;
import pe.edu.sise.utils.Attributes;

public class DetalleActividad extends AppCompatActivity {

    public static final String TAG = "DetalleActividad";

    private TextView det_act_tvi_curso;
    private TextView det_act_tvi_actividad;
    private TextView det_act_tvi_detalle;
    private TextView det_act_tvi_fecha;
    private TextView det_act_tvi_inicia;
    private TextView det_act_tvi_termina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_detalle_actividad);

        det_act_tvi_curso = (TextView) findViewById(R.id.det_act_tvi_curso);
        det_act_tvi_actividad = (TextView) findViewById(R.id.det_act_tvi_actividad);
        det_act_tvi_detalle = (TextView) findViewById(R.id.det_act_tvi_detalle);
        det_act_tvi_fecha = (TextView) findViewById(R.id.det_act_tvi_fecha);
        det_act_tvi_inicia = (TextView) findViewById(R.id.det_act_tvi_inicia);
        det_act_tvi_termina = (TextView) findViewById(R.id.det_act_tvi_termina);

        if (getIntent().getExtras() != null) {
            String id = getIntent().getStringExtra(Attributes.MSG_ID);
            Log.d(TAG, id);

            new ActividadByIDAsyncTask().execute(Integer.valueOf(id));
        }

    }


    private void mostrarDetalleActividad(Actividad actividad) {
        try {
            det_act_tvi_curso.setText(actividad.getNomCurso());
            det_act_tvi_actividad.setText(actividad.getNomActividad());
            det_act_tvi_detalle.setText(actividad.getDescrActividad());
            det_act_tvi_fecha.setText(actividad.getFechaRealizacion());
            det_act_tvi_inicia.setText(actividad.getHoraInicio());
            det_act_tvi_termina.setText(actividad.getHoraFin());
        } catch (Exception e) {
            Log.d(TAG, "mostrarDetalleActividad: " + Log.getStackTraceString(e));
        }
    }

    private class ActividadByIDAsyncTask extends AsyncTask<Integer, Void, Actividad> {
        @Override
        protected Actividad doInBackground(Integer... params) {
            return ActividadController.getActividadById(params[0]);
        }

        @Override
        protected void onPostExecute(Actividad actividad) {
            super.onPostExecute(actividad);
            mostrarDetalleActividad(actividad);
        }
    }


}
