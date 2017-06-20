package pe.edu.sise.adapter;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.sise.appsgmonitoreoestudiantil.DetalleActividad;
import pe.edu.sise.appsgmonitoreoestudiantil.R;
import pe.edu.sise.model.Actividad;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.Colors;

/**
 * Created by Abel on 17/06/2017.
 */

public class ActividadPendienteAdapter extends RecyclerView.Adapter<ActividadPendienteAdapter.ViewHolder> {

    private List<Actividad> actividadList;
    private FragmentManager fragmentManager;

    public ActividadPendienteAdapter(List<Actividad> actividadList, FragmentManager fragmentManager) {
        this.actividadList = actividadList;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_actividad_pendiente, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Actividad actividad = actividadList.get(position);

        holder.act_row_imgv_color.setBackgroundColor(Colors.CUSTOM_COLORS[Integer.valueOf(actividad.getIdCurso())]);
        holder.act_row_tvi_nom_actividad.setText(actividad.getNomActividad());
        holder.act_row_tvi_det_actividad.setText(actividad.getNomCurso() + ": " + actividad.getDescrActividad());
        holder.act_row_tvi_fecha_prog.setText("Fecha: " + actividad.getFechaRealizacion() + " " + actividad.getHoraInicio());
        holder.act_row_tvi_nom_alumno.setText(actividad.getNomAlumno());

        holder.act_row_car_pendiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetalleActividad.class);
                intent.putExtra(Attributes.MSG_ID, actividad.getIdActividad());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (this.actividadList == null) ? 0 : this.actividadList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView act_row_imgv_color;
        public TextView act_row_tvi_nom_actividad;
        //public TextView act_row_tvi_nom_curso;
        public TextView act_row_tvi_det_actividad;
        public TextView act_row_tvi_fecha_prog;
        public CardView act_row_car_pendiente;
        public TextView act_row_tvi_nom_alumno;

        public ViewHolder(View view) {
            super(view);

            act_row_imgv_color = (ImageView) view.findViewById(R.id.act_row_imgv_color);
            act_row_tvi_nom_actividad = (TextView) view.findViewById(R.id.act_row_tvi_nom_actividad);
            act_row_tvi_det_actividad = (TextView) view.findViewById(R.id.act_row_tvi_det_actividad);
            //act_row_tvi_nom_curso = (TextView) view.findViewById(R.id.act_row_tvi_nom_curso);
            act_row_tvi_fecha_prog = (TextView) view.findViewById(R.id.act_row_tvi_fecha_prog);
            act_row_car_pendiente = (CardView) view.findViewById(R.id.act_row_car_pendiente);
            act_row_tvi_nom_alumno=(TextView)view.findViewById(R.id.act_row_tvi_nom_alumno);
        }
    }
}
