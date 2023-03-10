package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.databinding.TrendingstoriesBinding;
import com.example.myapplication.models.TrendingStoryModel;

import java.util.ArrayList;


public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    TrendingstoriesBinding binding;
    Context context;
    ArrayList<TrendingStoryModel> item;

    public TrendingAdapter(ArrayList<TrendingStoryModel> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = TrendingstoriesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TrendingStoryModel model = item.get(position);
        holder.binding.ivBack.setImageResource(model.getIvBack());
        holder.binding.ivAvatar.setImageResource(model.getIvAvatar());
        holder.binding.tvUserName.setText(model.getTvUserName());
        if(position==0){
        holder.binding.cvCreate.setVisibility(View.VISIBLE);
        }
        else {
            holder.binding.cvCreate.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TrendingstoriesBinding binding;
        public ViewHolder(TrendingstoriesBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
