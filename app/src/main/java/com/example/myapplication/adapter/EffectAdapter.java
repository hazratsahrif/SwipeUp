package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.EffectLayoutBinding;
import com.example.myapplication.models.EffcetDataItem;

import java.util.ArrayList;


public class EffectAdapter extends RecyclerView.Adapter<EffectAdapter.ViewHolder> {
    EffectLayoutBinding binding;
    ArrayList<EffcetDataItem> list;
    Context context;



    public EffectAdapter(ArrayList<EffcetDataItem> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = EffectLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EffcetDataItem model = list.get(position);
        holder.binding.ivCard.setImageResource(model.getIvCard());
        holder.binding.tvViews.setText(model.getTvViews());
        holder.binding.tvEffect.setText(model.getTvEffect());
        holder.binding.tvSubEffect.setText(model.getTcSubEffect());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        EffectLayoutBinding binding;

        public ViewHolder(EffectLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
    public interface OnClickListener{
        void onClick(boolean isClick);
    }
}
