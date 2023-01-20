package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.LanguageLayoutBinding;

import java.util.List;


public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {
    LanguageLayoutBinding binding;
    List<String> list;
    int row_index=0;
    public LanguageAdapter(List<String> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = LanguageLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String string = list.get(position);
        holder.binding.checkbox.setText(string);
        if (row_index==position){
            holder.binding.checkbox.setChecked(true);
        }
        else {
            holder.binding.checkbox.setChecked(false);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    LanguageLayoutBinding binding;

    public ViewHolder(LanguageLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}

}
