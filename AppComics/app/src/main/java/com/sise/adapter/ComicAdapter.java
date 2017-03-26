package com.sise.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sise.appcomics.R;
import com.sise.model.Comic;

import java.util.List;

public class ComicAdapter extends ArrayAdapter<Comic> {
    private List<Comic> comicList;
    public ComicAdapter(Context context, List<Comic> comicList) {
        super(context,-1,comicList);
        this.comicList=comicList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comic comic =comicList.get(position);
        Holder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.row_item_comics,parent,false);
            holder=new Holder();
            holder.row_img=(ImageView)convertView.findViewById(R.id.row_imagen);
            holder.row_titulo=(TextView)convertView.findViewById(R.id.row_titulo);
            holder.row_precio=(TextView)convertView.findViewById(R.id.row_precio);
            convertView.setTag(holder);
        }else {
            holder=(Holder)convertView.getTag();
        }
        holder.row_img.setImageResource(comic.getImgComic());
        holder.row_titulo.setText(comic.getNomComic());
        holder.row_precio.setText(String.valueOf(comic.getPrecComic()));

        return convertView;
    }

    private class Holder{
        ImageView row_img;
        TextView row_titulo;
        TextView row_precio;
    }
}
