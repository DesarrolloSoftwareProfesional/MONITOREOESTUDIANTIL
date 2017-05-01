package pe.edu.sise.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.sise.appsgmonitoreoestudiantil.R;
import pe.edu.sise.model.Alumno;

/**
 * Created by ASUS on 25/03/2017.
 */

public class AlumnoLstActvAdapter extends RecyclerView.Adapter<AlumnoLstActvAdapter.AlumnoViewHolder> {

    private List<Alumno> items;


    public AlumnoLstActvAdapter(List<Alumno> items) {
        this.items = items;
    }


    static public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        //declarar nuestros elementos

        public TextView titulo;
        public TextView curso;
        public TextView profe;
        public TextView fecha;
        public TextView horainicio;
        public TextView horafin;


        public AlumnoViewHolder(View itemView) {
            super(itemView);


            titulo = (TextView) itemView.findViewById(R.id.alum_actv_tituloAct);
            curso = (TextView) itemView.findViewById(R.id.alum_actv_curso);
            profe = (TextView) itemView.findViewById(R.id.alum_actv_prof);
            fecha = (TextView) itemView.findViewById(R.id.alum_actv_fecha);
            horainicio = (TextView) itemView.findViewById(R.id.alum_actv_hini);
            horafin = (TextView) itemView.findViewById(R.id.alum_actv_hfin);
        }

    }


    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumnoact_card, parent, false);
        return new AlumnoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AlumnoViewHolder holder, int position) {

        Alumno alumno = items.get(position);

        holder.titulo.setText(alumno.getTipoAct());
        holder.curso.setText(alumno.getCurso());
        holder.profe.setText(alumno.getProfesor());
        holder.fecha.setText(alumno.getFecha());
        holder.horainicio.setText(alumno.getHora_ini());
        holder.horafin.setText(alumno.getHora_fin());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
