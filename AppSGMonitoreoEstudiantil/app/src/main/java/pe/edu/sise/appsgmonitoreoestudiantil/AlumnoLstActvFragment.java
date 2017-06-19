package pe.edu.sise.appsgmonitoreoestudiantil;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.adapter.AlumnoLstActvAdapter;
import pe.edu.sise.controller.ActividadController;
import pe.edu.sise.model.Actividad;
import pe.edu.sise.model.AlumnoTest;
import pe.edu.sise.utils.Attributes;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlumnoLstActvFragment extends Fragment {


    private RecyclerView recyclerView;
    private LayoutManager lmanager;
    private Adapter adapter;



    public AlumnoLstActvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //
        View view =  inflater.inflate(R.layout.fragment_alumno_lst_actv, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(false);

        //layoutmanager
        lmanager = new LinearLayoutManager(AlumnoLstActvFragment.this.getContext());
        recyclerView.setLayoutManager(lmanager);

        if(getActivity().getIntent().getExtras()!=null){
            String gpoAcademico = getActivity().getIntent().getExtras().getString(Attributes.ACT_GPO_ACADEMICO);
            Log.d("id",gpoAcademico);
            new ActividadListAsyncTask().execute(gpoAcademico);
        }

        return view;

    }

    private class ActividadListAsyncTask extends AsyncTask<String,Void,List<Actividad>>{
        @Override
        protected List<Actividad> doInBackground(String... params) {
            return ActividadController.getActividadesByGpoAcademico(params[0]);
        }

        @Override
        protected void onPostExecute(List<Actividad> actividads) {
            super.onPostExecute(actividads);

            //adaptador

        adapter = new AlumnoLstActvAdapter(actividads);
        recyclerView.setAdapter(adapter);
        }
    }

}
