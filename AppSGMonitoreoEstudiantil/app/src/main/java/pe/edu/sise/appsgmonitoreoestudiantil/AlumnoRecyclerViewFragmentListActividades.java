package pe.edu.sise.appsgmonitoreoestudiantil;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlumnoRecyclerViewFragmentListActividades extends Fragment {


    //variables / controles
    protected SwipeRefreshLayout alum_recv_swref_lstAct;
    protected RecyclerView alum_recv_alumos_lstAct;

    //variables para llenar lista
        protected ArrayList<String> listaActv;
        protected ArrayAdapter<String> adapterLstAct;

    public AlumnoRecyclerViewFragmentListActividades() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alumno_recycler_view_fragment_list_actividades, container, false);
    }

    private SwipeRefreshLayout.OnRefreshListener alum_recv_swrefSetOnRefreshListene_lstAct(){

        return new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                },1000);

            }
        };
    }






}
