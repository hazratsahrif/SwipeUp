package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.CommentLayoutBinding;
import com.example.myapplication.models.CommentItemData;

import java.util.ArrayList;


public class CommentTabAdapter extends RecyclerView.Adapter<CommentTabAdapter.ViewHolder> {
    CommentLayoutBinding binding;
    ArrayList<CommentItemData> list;
    Context context;
   boolean isClicked = false;
    public CommentTabAdapter(ArrayList<CommentItemData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CommentLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommentItemData model = list.get(position);
        holder.binding.avatar1.setImageResource(model.getAvatar());
        holder.binding.coverImage.setImageResource(model.getImgCover());
        holder.binding.tvComment.setText(model.getTvComment());
        holder.binding.tvTime.setText(model.getTvDay());
        holder.binding.tvFirstName.setText(model.getTvFName());






        holder.binding.btnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked = !isClicked;
                if(isClicked){

                    holder.binding.btnHeart.setColorFilter(ContextCompat.getColor(context,R.color.red));

                }
                else {
                    holder.binding.btnHeart.setColorFilter(ContextCompat.getColor(context,R.color.gray_base200));
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    CommentLayoutBinding binding;

    public ViewHolder(CommentLayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}

}
