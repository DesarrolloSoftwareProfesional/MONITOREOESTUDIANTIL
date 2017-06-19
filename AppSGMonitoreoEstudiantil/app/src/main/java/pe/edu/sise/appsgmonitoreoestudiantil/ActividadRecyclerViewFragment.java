package pe.edu.sise.appsgmonitoreoestudiantil;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.sise.adapter.ActividadPendienteAdapter;
import pe.edu.sise.controller.ActividadController;
import pe.edu.sise.model.Actividad;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.SessionManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActividadRecyclerViewFragment extends Fragment {

    private static final String TAG = "ActividadRcVwFragment";

    // Variables - controles
    protected SwipeRefreshLayout act_recv_swref;
    protected RecyclerView act_recv_actividades;

    //Variables
    protected ActividadPendienteAdapter actividadPendienteAdapter;
    protected String paramIdApoderado;

    public ActividadRecyclerViewFragment() {
        // Required empty public constructor
    }

    public ActividadRecyclerViewFragment newInstance(String idApoderado) {
        ActividadRecyclerViewFragment fragment = new ActividadRecyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(Attributes.APOD_ID, idApoderado);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            paramIdApoderado = getArguments().getString(Attributes.APOD_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actividad_recycler_view, container, false);

        act_recv_swref = (SwipeRefreshLayout) view.findViewById(R.id.act_recv_swref);
        act_recv_actividades = (RecyclerView) view.findViewById(R.id.act_recv_actividades);

        act_recv_actividades.setHasFixedSize(true);
        act_recv_actividades.setLayoutManager(new LinearLayoutManager(this.getContext()));
        act_recv_actividades.setItemAnimator(new DefaultItemAnimator());

        act_recv_swref.setColorSchemeResources(R.color.colorPrimaryDark);

        //LLAMANDO METODO ASYCKTASK
        if(!"".equals(paramIdApoderado) && paramIdApoderado!=null){
            new ActividadesByApoderadoListAsyncTask().execute(Integer.valueOf(paramIdApoderado));
        }


        return view;
    }

    private class ActividadesByApoderadoListAsyncTask extends AsyncTask<Integer, Void, List<Actividad>> {
        @Override
        protected List<Actividad> doInBackground(Integer... params) {
            return ActividadController.getActividadesByApoderado(params[0]);
        }

        @Override
        protected void onPostExecute(List<Actividad> actividades) {
            super.onPostExecute(actividades);
            actividadPendienteAdapter = new ActividadPendienteAdapter(actividades, getFragmentManager());
            act_recv_actividades.setAdapter(actividadPendienteAdapter);

        }
    }

}
