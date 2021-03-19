package mx.lania.mvvmpeliculas.UI.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import java.util.ArrayList;

import mx.lania.mvvmpeliculas.POJOS.PeliculaPOJO;
import mx.lania.mvvmpeliculas.R;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.PeliculasViewHolder> {
    private ArrayList<PeliculaPOJO> data;
    private Context context;

    public AdapterRecyclerView(ArrayList<PeliculaPOJO> data, Context context) {
        this.data = data;
        this.context = context.getApplicationContext();
    }

    @Override
    public AdapterRecyclerView.PeliculasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdapterRecyclerView.PeliculasViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_peliculas, parent, false));
    }

    @Override
    public void onBindViewHolder(AdapterRecyclerView.PeliculasViewHolder holder, int position) {
        PeliculaPOJO peliculaPOJO = data.get(position);
        holder.tvTituloPelicula.setText(peliculaPOJO.getTituloPelicula());
        holder.itemView.setTag(peliculaPOJO);

        Glide.with(context)
                .load(peliculaPOJO.getPoster())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageViewPelicula);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PeliculasViewHolder extends RecyclerView.ViewHolder {
        TextView tvTituloPelicula;
        ImageView imageViewPelicula;

        public PeliculasViewHolder(View itemView) {
            super(itemView);
            tvTituloPelicula = itemView.findViewById(R.id.tvTituloPelicula);
            imageViewPelicula = itemView.findViewById(R.id.imageViewPelicula);
        }
    }
}
