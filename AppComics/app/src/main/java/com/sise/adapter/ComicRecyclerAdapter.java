package com.sise.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sise.appcomics.R;
import com.sise.model.Comic;

import java.util.List;

public class ComicRecyclerAdapter extends RecyclerView.Adapter<ComicRecyclerAdapter.ViewHolder> {
    private List<Comic> comicList;

    public ComicRecyclerAdapter(List<Comic>comicList){
        this.comicList=comicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_recycler,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comic comic =comicList.get(position);
        holder.row_img.setImageResource(comic.getImgComic());
        holder.row_titulo.setText(comic.getNomComic());
        holder.row_precio.setText(String.valueOf(comic.getPrecComic()));
    }


    @Override
    public int getItemCount() {
        return this.comicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView row_img;
        TextView row_titulo;
        TextView row_precio;
        public ViewHolder(View itemView) {
            super(itemView);
            row_img=(ImageView)itemView.findViewById(R.id.row_rcw_imagen);
            row_titulo=(TextView)itemView.findViewById(R.id.row_rcw_titulo);
            row_precio=(TextView)itemView.findViewById(R.id.row_rcw_precio);
        }
    }
}
