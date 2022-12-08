package com.example.project01_clone.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{
    LayoutInflater inflater;
    Context context;

    public ViewAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_view1, parent, false);
        ViewHolder h = new ViewHolder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_view;
        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_view = v.findViewById(R.id.imgv_view);
        }
    }
}
