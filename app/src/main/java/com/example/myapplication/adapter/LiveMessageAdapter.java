package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.LiveMessageLayoutBinding;
import com.example.myapplication.models.LiveMessageItem;

import java.util.List;


public class LiveMessageAdapter extends RecyclerView.Adapter<LiveMessageAdapter.ViewHolder> {
    List<LiveMessageItem> item;
    Context context;
    LiveMessageLayoutBinding binding;

    public LiveMessageAdapter(List<LiveMessageItem> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       binding = LiveMessageLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LiveMessageItem model = item.get(position);
        holder.binding.tvName.setText(model.getTvName());
        holder.binding.tvComment.setText(model.getTvMessage());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LiveMessageLayoutBinding binding;
        public ViewHolder(LiveMessageLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
