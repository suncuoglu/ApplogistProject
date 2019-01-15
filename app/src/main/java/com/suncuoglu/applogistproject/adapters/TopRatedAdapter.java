package com.suncuoglu.applogistproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.suncuoglu.applogistproject.model.Movie;
import com.suncuoglu.applogistproject.R;
import java.util.ArrayList;

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.MyViewHolder> {
    Context mContext;
    ArrayList<Movie> adapter_list;

    public TopRatedAdapter(ArrayList<Movie> adapter_list, Context ctx) {
        this.adapter_list = adapter_list;
        this.mContext = ctx;
    }

    @NonNull
    @Override
    public TopRatedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rated_background, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedAdapter.MyViewHolder holder, final int position) {
        holder.image.setImageResource(R.drawable.tab_movies);
    }

    @Override
    public int getItemCount() {
        return adapter_list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);

        }
    }
}