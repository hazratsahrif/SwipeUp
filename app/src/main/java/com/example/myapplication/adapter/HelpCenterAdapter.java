package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.HelpcenterLayoutBinding;

import java.util.List;


public class HelpCenterAdapter extends RecyclerView.Adapter<HelpCenterAdapter.ViewHolder> {
    HelpcenterLayoutBinding binding;
    List<String> list;
    public HelpCenterAdapter(List<String> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HelpcenterLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String model = list.get(position);
        holder.binding.tvItem.setText(model);

        holder.binding.tvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        if(position==0){
            holder.binding.tvCatagory.setText("Frequently Asked Questions");
        }
       else if(position==5){
            holder.binding.tvCatagory.setText("Select a topic");
        }

        else {
            holder.binding.tvCatagory.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    HelpcenterLayoutBinding binding;

    public ViewHolder(HelpcenterLayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}

}
