package pe.edu.sise.appsgmonitoreoestudiantil;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.adapter.AlumnoAdapter;
import pe.edu.sise.controller.AlumnoController;
import pe.edu.sise.model.Alumno;
import pe.edu.sise.model.AlumnoTest;
import pe.edu.sise.model.Apoderado;
import pe.edu.sise.utils.SessionManager;


public class AlumnoRecyclerViewFragment extends Fragment {

    private static final String TAG = "AlumnoRcVwFragment";

    // Variables - controles

    protected SessionManager sessionManager;
    protected SwipeRefreshLayout alum_recv_swref;
    protected RecyclerView alum_recv_alumos;

    //Variables
    protected AlumnoAdapter alumnoAdapter;
    protected List<AlumnoTest> alumnoList;


    public AlumnoRecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_alumno_recycler_view, container, false);
        alum_recv_swref=(SwipeRefreshLayout)view.findViewById(R.id.alum_recv_swref);
        alum_recv_alumos=(RecyclerView)view.findViewById(R.id.alum_recv_alumos);

        alum_recv_alumos.setHasFixedSize(true);
        alum_recv_alumos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        alum_recv_alumos.setItemAnimator(new DefaultItemAnimator());


        //Listener
//        alum_recv_swref.setOnRefreshListener(alum_recv_swrefSetOnRefreshListene());

        alum_recv_swref.setColorSchemeResources(R.color.colorPrimaryDark);
        this.sessionManager = new SessionManager(getContext());
        if (sessionManager.existsAlumno()) {
            //consume de la sesion
            Alumno alumno = this.sessionManager.getAlumnoSession();
            cargarAlumnoByApoderado(Integer.parseInt(alumno.getId()));
        }



        return view;
    }

//    private SwipeRefreshLayout.OnRefreshListener alum_recv_swrefSetOnRefreshListene(){
//
//        return new SwipeRefreshLayout.OnRefreshListener(){
//
//            @Override
//            public void onRefresh() {
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            alumnoAdapter = new AlumnoAdapter(cargarListaTest(),getFragmentManager());
//                            alum_recv_alumos.setAdapter(alumnoAdapter);
//                            alum_recv_swref.setRefreshing(false);
//                        }
//                    },1000);
//            }
//        };
//    }



    //metodos para test

    private List<AlumnoTest> cargarListaTest(){
        List<AlumnoTest> list =new ArrayList<>();

        list.add(new AlumnoTest("J. Abel","Palomino Rojas",2,2017));
        list.add(new AlumnoTest("Ronald","Fabian Garcia",6,2017));
        list.add(new AlumnoTest("Jhonatan","Aruhanca Vilca",3,2017));
        list.add(new AlumnoTest("Maria","Diaz Luna",5,2017));
        list.add(new AlumnoTest("Cristina","Fernandez Loayza",2,2017));
        list.add(new AlumnoTest("Fernanda","Lima Rojas",5,2017));

        return list;
    }

    private List<Alumno> cargarAlumnoByApoderado(int idApoderado){
        List<Alumno> lst = new ArrayList<>();

        try {
            //lst = new AlumnosByApoderadoListAsyncTask(idApoderado);

            new AlumnosByApoderadoListAsyncTask().execute(idApoderado);

        } catch (Exception e) {
            Log.i(TAG, "consultarCursos: " + Log.getStackTraceString(e).toString());
        }
        return lst;
    }

    private class AlumnosByApoderadoListAsyncTask extends AsyncTask<Integer, Void, List<Alumno>> {
        @Override
        protected List<Alumno> doInBackground(Integer... params) {
            return AlumnoController.getAlumnosByApoderado(params[0]);
        }

        @Override
        protected void onPostExecute(List<Alumno> alumnos) {
            super.onPostExecute(alumnos);
            alumnoAdapter = new AlumnoAdapter(alumnos,getFragmentManager());
            alum_recv_alumos.setAdapter(alumnoAdapter);

        }
    }


}
