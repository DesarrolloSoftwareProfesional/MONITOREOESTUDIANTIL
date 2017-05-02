package pe.edu.sise.appsgmonitoreoestudiantil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.sise.adapter.AlumnoLstActvAdapter;
import pe.edu.sise.model.AlumnoTest;


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

        List<AlumnoTest> lista = new ArrayList<AlumnoTest>();

        //poblando data/
        lista.add(new AlumnoTest("EXAMEN", "Matematica", "Jhonatan", "18/05/16", "08:30am", "10:00am"));
        lista.add(new AlumnoTest("PRACTICA CALIFICADA", "Lenguaje", "Jhonatan", "20/05/16", "09:00am", "10:30am"));
        lista.add(new AlumnoTest("EXAMEN", "Caligrafia", "Jhonatan", "05/06/16", "08:30am", "10:00am"));
        lista.add(new AlumnoTest("EXAMEN", "Ciencia, Tecnologia y Ambiente", "Jhonatan", "18/06/16", "08:30am", "10:00am"));


        recyclerView = (RecyclerView) view.findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(false);

        //layoutmanager
        lmanager = new LinearLayoutManager(AlumnoLstActvFragment.this.getContext());
        recyclerView.setLayoutManager(lmanager);

        //adaptador

        adapter = new AlumnoLstActvAdapter(lista);
        recyclerView.setAdapter(adapter);

        return view;

    }

}
