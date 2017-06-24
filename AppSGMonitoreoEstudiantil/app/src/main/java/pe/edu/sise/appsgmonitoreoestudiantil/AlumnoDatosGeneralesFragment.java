package pe.edu.sise.appsgmonitoreoestudiantil;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import pe.edu.sise.adapter.AlumnoAdapter;
import pe.edu.sise.controller.AlumnoController;
import pe.edu.sise.model.Alumno;
import pe.edu.sise.utils.Attributes;

/**
 * Created by ASUS on 26/03/2017.
 */

public class AlumnoDatosGeneralesFragment extends Fragment {
    private static final String TAG = "AlumnoDatosGeneralesFragment";
    private TextView frgmt_dtsGen_nomAlum;
    private TextView frgmt_dtsGen_dni;
    private TextView frgmt_dtsGen_grado;
    private TextView frgmt_dtsGen_seccion;
    private TextView frgmt_dtsGen_periodo;
    private TextView frgmt_dtsGen_apoder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(container.getContext()).inflate(R.layout.fragment_alumno_datosgenerales,container,false);
        frgmt_dtsGen_nomAlum =(TextView)view.findViewById(R.id.frgmt_dtsGen_nomAlum);
        frgmt_dtsGen_dni = (TextView)view.findViewById(R.id.frgmt_dtsGen_dni);
        frgmt_dtsGen_grado = (TextView)view.findViewById(R.id.frgmt_dtsGen_grado);
        frgmt_dtsGen_seccion = (TextView)view.findViewById(R.id.frgmt_dtsGen_seccion);
        frgmt_dtsGen_periodo = (TextView)view.findViewById(R.id.frgmt_dtsGen_periodo);
        frgmt_dtsGen_apoder = (TextView)view.findViewById(R.id.frgmt_dtsGen_apoder);

        consultarDatosAlumno();

        return view;
    }


    public void consultarDatosAlumno() {
        try {
            int idAlumno  = 0,trimestre = 0;
            idAlumno = getArguments().getInt(Attributes.KEY_IDALUMNO,0);
            trimestre = getArguments().getInt(Attributes.KEY_PROMEDIO,1);
            new DatosAlumnosByIDAsyncTask().execute(idAlumno);
        } catch (Exception e) {
            Log.d(TAG, "consultarDatosAlumno: " + Log.getStackTraceString(e));
        }
    }

    private class DatosAlumnosByIDAsyncTask extends AsyncTask<Integer, Void, List<Alumno>> {
        @Override
        protected List<Alumno> doInBackground(Integer... params) {
            return AlumnoController.getAlumnoByID(params[0]);
        }

        @Override
        protected void onPostExecute(List<Alumno> alumnos) {
            super.onPostExecute(alumnos);
            //alumnoAdapter = new AlumnoAdapter(alumnos,getFragmentManager());
            for (int i = 0; i < alumnos.size(); i++) {
                Alumno alumno = alumnos.get(i);
                frgmt_dtsGen_nomAlum.setText(alumno.getNombres());
                frgmt_dtsGen_dni.setText(alumno.getDni());
                frgmt_dtsGen_grado.setText(String.valueOf(alumno.getCodGracdo()));
                frgmt_dtsGen_seccion.setText(alumno.getCodSeccion());
                frgmt_dtsGen_periodo.setText(String.valueOf(alumno.getPeriodo()));
                frgmt_dtsGen_apoder.setText(alumno.getFechaNac());
            }


        }
    }
}
