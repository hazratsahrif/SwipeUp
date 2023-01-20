package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.BarchartLayoutBinding;
import com.example.myapplication.models.BarChartItem;

import java.util.List;


public class AnalyticsBarChartAdapter extends RecyclerView.Adapter<AnalyticsBarChartAdapter.ViewHolder> {
    BarchartLayoutBinding binding;
    List<BarChartItem> list;
    Context context;
    int row_index=-1;
    public AnalyticsBarChartAdapter(List<BarChartItem> list,Context context) {
        this.list = list;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = BarchartLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        BarChartItem model = list.get(position);
        holder.binding.tvDate.setText(model.getTvDate());
        holder.binding.tvHeader.setText(model.getTvHeader());
//        holder.binding.cvProgress.setMinimumHeight(model.getCvProgress());
        ViewGroup.LayoutParams params = holder.binding.cvProgress.getLayoutParams();
        params.width=58;
        params.height=model.getCvProgress();
        holder.binding.cvProgress.setLayoutParams(params);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        if(row_index==position){
            holder.binding.viewLayout.setVisibility(View.VISIBLE);
            holder.binding.progressBack.setColorFilter(ContextCompat.getColor(context, R.color.red700));
            holder.binding.tvHeader.setVisibility(View.VISIBLE);
            holder.binding.tvDate.setTextColor(ContextCompat.getColor(context, R.color.base900));
        }
        else {
            holder.binding.viewLayout.setVisibility(View.GONE);
            holder.binding.progressBack.setColorFilter(ContextCompat.getColor(context, R.color.red));
            holder.binding.tvHeader.setVisibility(View.GONE);
            holder.binding.tvDate.setTextColor(ContextCompat.getColor(context, R.color.base500));
        }
        holder.binding.cvProgress.setOnClickListener(new View.OnClickListener() {
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
    BarchartLayoutBinding binding;

    public ViewHolder(BarchartLayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}

}
