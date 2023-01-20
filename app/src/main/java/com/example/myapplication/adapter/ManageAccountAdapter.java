package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ManageLayoutBinding;
import com.example.myapplication.models.ManageDataItem;

import java.util.ArrayList;


public class ManageAccountAdapter extends RecyclerView.Adapter<ManageAccountAdapter.ViewHolder> {
    ManageLayoutBinding binding;
    ArrayList<ManageDataItem> list;
    public ManageAccountAdapter(ArrayList<ManageDataItem> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ManageLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ManageDataItem model = list.get(position);
        holder.binding.icon.setImageResource(model.getIcon());
        holder.binding.tvTitle.setText(model.getTitle());
        holder.binding.tvSubTitle.setText(model.getSubtitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    ManageLayoutBinding binding;

    public ViewHolder(ManageLayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}

}
