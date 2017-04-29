package pe.edu.sise.appsgmonitoreoestudiantil;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.adapter.AlumnoAdapter;
import pe.edu.sise.model.Alumno;


public class AlumnoRecyclerViewFragment extends Fragment {

    // Variables - controles
    protected SwipeRefreshLayout alum_recv_swref;
    protected RecyclerView alum_recv_alumos;

    //Variables
    protected AlumnoAdapter alumnoAdapter;
    protected List<Alumno> alumnoList;


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
        alumnoAdapter = new AlumnoAdapter(cargarListaTest(),getFragmentManager());
        alum_recv_alumos.setAdapter(alumnoAdapter);

        //Listener
        alum_recv_swref.setOnRefreshListener(alum_recv_swrefSetOnRefreshListene());

        alum_recv_swref.setColorSchemeResources(R.color.colorPrimaryDark);

        return view;
    }

    private SwipeRefreshLayout.OnRefreshListener alum_recv_swrefSetOnRefreshListene(){

        return new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            alumnoAdapter = new AlumnoAdapter(cargarListaTest(),getFragmentManager());
                            alum_recv_alumos.setAdapter(alumnoAdapter);
                            alum_recv_swref.setRefreshing(false);
                        }
                    },1000);
            }
        };
    }



    //metodos para test

    private List<Alumno> cargarListaTest(){
        List<Alumno> list =new ArrayList<>();

        list.add(new Alumno("J. Abel","Palomino Rojas",2,2017));
        list.add(new Alumno("Ronald","Fabian Garcia",6,2017));
        list.add(new Alumno("Jhonatan","Aruhanca Vilca",3,2017));
        list.add(new Alumno("Maria","Diaz Luna",5,2017));
        list.add(new Alumno("Cristina","Fernandez Loayza",2,2017));
        list.add(new Alumno("Fernanda","Lima Rojas",5,2017));

        return list;
    }
}
