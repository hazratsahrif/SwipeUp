package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.SoundBinding;
import com.example.myapplication.models.SoundModel;

import java.util.ArrayList;


public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.ViewHolder> {
    SoundBinding binding;
    ArrayList<SoundModel> list;
    Context context;
    OnClickListener onClickListener;


    public SoundAdapter(ArrayList<SoundModel> list, Context context, OnClickListener onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = SoundBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SoundModel model = list.get(position);
        holder.binding.ivBk.setBackground(context.getDrawable(model.getIvBk()));
        holder.binding.tvSound.setText(model.getTvSname());
        holder.binding.tvViews.setText(model.getTvStrack());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        SoundBinding binding;

        public ViewHolder(SoundBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
    public interface OnClickListener{
        void onClick(boolean isClick);
    }
}
