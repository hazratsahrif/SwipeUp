package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.HashtagLayoutBinding;
import com.example.myapplication.models.HashtagDataModel;

import java.util.ArrayList;


public class HashtagAdpater extends RecyclerView.Adapter<HashtagAdpater.ViewHolder> {

    HashtagLayoutBinding binding;
    Context context;
    ArrayList<HashtagDataModel> list;
    OnClickListener onClickListener;

    public HashtagAdpater(Context context, ArrayList<HashtagDataModel> list, OnClickListener onClickListener) {
        this.context = context;
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HashtagLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashtagDataModel model = list.get(position);

        holder.binding.tvTravel.setText(model.getTvTravel());
        holder.binding.tvViews.setText(model.getTvViews());
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
        HashtagLayoutBinding binding;
        public ViewHolder(HashtagLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    public interface OnClickListener{
        void onClick(boolean isClick);
    }
}
