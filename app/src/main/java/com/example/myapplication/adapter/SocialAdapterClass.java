package com.example.myapplication.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.SocialLayoutBinding;

import java.util.ArrayList;

import model.SocialModel;


public class SocialAdapterClass extends RecyclerView.Adapter<SocialAdapterClass.ViewHolder> {


    SocialLayoutBinding binding;
    ArrayList<SocialModel> list;
    Context context;

    public SocialAdapterClass(ArrayList<SocialModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = SocialLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SocialModel item = list.get(position);
        holder.binding.ivIcon.setImageResource(item.getIvIcon());
        holder.binding.tvIconName.setText(item.getIconName());
        holder.binding.cvBackground.setCardBackgroundColor(item.getIconColor());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SocialLayoutBinding binding;
        public ViewHolder(SocialLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
