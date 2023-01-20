package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ProgressbarLayoutBinding;
import com.example.myapplication.models.ProgressItem;

import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ViewHolder> {
    ProgressbarLayoutBinding binding;
    List<ProgressItem> list;
    Context context;

    public ProgressAdapter(List<ProgressItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProgressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ProgressbarLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgressAdapter.ViewHolder holder, int position) {
        ProgressItem item = list.get(position);
        holder.binding.progressBar.setProgress(item.getProgressValue());
        holder.binding.tvProgressTitle.setText(item.getTvProgressTitle());
        holder.binding.tvPercentage.setText( Integer.toString(item.getProgressValue())+"%");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ProgressbarLayoutBinding binding;
        public ViewHolder(ProgressbarLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
