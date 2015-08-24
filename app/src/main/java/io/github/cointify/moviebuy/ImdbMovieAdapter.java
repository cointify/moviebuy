package io.github.cointify.moviebuy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieAdapter extends RecyclerView.Adapter<ImdbMovieAdapter.ViewHolder> {

    private List<ImdbMovie> movies = new ArrayList<>();

    public ImdbMovieAdapter(List<ImdbMovie> movies) {
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.imageView.getContext()).load(movies.get(position).getPosterPath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.movie_poster);
        }
    }
}
