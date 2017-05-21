package pe.edu.sise.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.sise.appsgmonitoreoestudiantil.R;
import pe.edu.sise.model.Curso;
import pe.edu.sise.utils.Colors;

/**
 * Created by Abel on 9/05/2017.
 */

public class CursoAdapter extends ArrayAdapter<Curso> {

    List<Curso> cursoList;

    public CursoAdapter(Context context, List<Curso> cursoList) {
        super(context, -1, cursoList);
        this.cursoList = cursoList;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Curso curso=cursoList.get(position);
        ItemRowCurso rowCurso;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_curso_list, parent, false);
            rowCurso = new ItemRowCurso();

            rowCurso.row_curso_tvi_curso = (TextView) convertView.findViewById(R.id.row_curso_tvi_curso);
            rowCurso.row_curso_imgv_color = (ImageView) convertView.findViewById(R.id.row_curso_imgv_color);

            convertView.setTag(rowCurso);
        } else {
            rowCurso = (ItemRowCurso) convertView.getTag();
        }

        rowCurso.row_curso_tvi_curso.setText(curso.getNomCurso());
        rowCurso.row_curso_imgv_color.setBackgroundColor(Colors.CUSTOM_COLORS[position]);

        return convertView;
    }

    private class ItemRowCurso {
        public ImageView row_curso_imgv_color;
        public TextView row_curso_tvi_curso;
    }
}
