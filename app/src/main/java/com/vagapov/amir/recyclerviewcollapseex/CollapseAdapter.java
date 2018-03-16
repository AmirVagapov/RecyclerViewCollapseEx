package com.vagapov.amir.recyclerviewcollapseex;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CollapseAdapter extends RecyclerView.Adapter<CollapseAdapter.CollapseViewHolder>{

    private ArrayList<Movie> movies;

    public CollapseAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public CollapseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_layout, parent, false);
        return new CollapseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CollapseViewHolder holder, final int position) {
        final Movie movie = movies.get(position);

        holder.bind(movie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean expanded = movie.isExpanded();
                movie.setExpanded(!expanded);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0: movies.size();
    }

    class CollapseViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout subItem;
        private TextView title;
        private TextView genre;
        private TextView year;


        public CollapseViewHolder(View itemView) {
            super(itemView);
            subItem = itemView.findViewById(R.id.sub_item);
            title = itemView.findViewById(R.id.item_title);
            genre = itemView.findViewById(R.id.sub_item_genre);
            year = itemView.findViewById(R.id.sub_item_year);
        }

        public void bind(Movie movie) {
            boolean expanded = movie.isExpanded();
            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
            title.setText(movie.getTitle());
            genre.setText("Gengre: " + movie.getGenre());
            year.setText("Year: " + movie.getYear());
        }
    }
}
