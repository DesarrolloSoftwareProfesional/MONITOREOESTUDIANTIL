package pe.edu.sise.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.sise.appsgmonitoreoestudiantil.R;
import pe.edu.sise.model.Actividad;

/**
 * Created by ASUS on 25/03/2017.
 */

public class AlumnoLstActvAdapter extends RecyclerView.Adapter<AlumnoLstActvAdapter.actividadViewHolder> {

    private List<Actividad> items;


    public AlumnoLstActvAdapter(List<Actividad> items) {
        this.items = items;
    }


    static public class actividadViewHolder extends RecyclerView.ViewHolder {

        //declarar nuestros elementos
        
        public TextView act_item_card_curso;
        public TextView act_item_card_nombre;
        public TextView act_item_card_detalle;
        public TextView act_item_card_fecha;
        public TextView act_item_card_hora;


        public actividadViewHolder(View itemView) {
            super(itemView);
            
            act_item_card_curso = (TextView) itemView.findViewById(R.id.act_item_card_curso);
            act_item_card_nombre = (TextView) itemView.findViewById(R.id.act_item_card_nombre);
            act_item_card_detalle = (TextView) itemView.findViewById(R.id.act_item_card_detalle);
            act_item_card_fecha = (TextView) itemView.findViewById(R.id.act_item_card_fecha);
            act_item_card_hora = (TextView) itemView.findViewById(R.id.act_item_card_hora);
        }

    }


    @Override
    public actividadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumnoact_card, parent, false);
        return new actividadViewHolder(v);
    }

    @Override
    public void onBindViewHolder(actividadViewHolder holder, int position) {

        Actividad actividad = items.get(position);

        holder.act_item_card_curso.setText(actividad.getNomCurso());
        holder.act_item_card_nombre.setText(actividad.getNomActividad());
        holder.act_item_card_detalle.setText(actividad.getDescrActividad());
        holder.act_item_card_fecha.setText(actividad.getFechaRealizacion());
        holder.act_item_card_hora.setText(actividad.getHoraInicio() + " a "+actividad.getHoraFin());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
