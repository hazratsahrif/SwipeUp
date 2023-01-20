package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.databinding.StoryFooterLayoutBinding;
import java.util.List;


public class StoryFooterAdapter extends RecyclerView.Adapter<StoryFooterAdapter.ViewHolder> {
    StoryFooterLayoutBinding binding;
    List<String> list;
    OnMessageButtonClick onMessageButtonClick;
    Context context;
    boolean isVisible;
    public StoryFooterAdapter(List<String> list,OnMessageButtonClick onMessageButtonClick,Context context,boolean isVisible) {
        this.list = list;
        this.onMessageButtonClick=onMessageButtonClick;
        this.context=context;
        this.isVisible=isVisible;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = StoryFooterLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String string = list.get(position);
        holder.binding.ivEmoji.setText(string);
        if (position==0 && isVisible==false){
            binding.firstLayout.setVisibility(View.VISIBLE);
        }
        else if(position==0 && isVisible){
            binding.firstLayout.setVisibility(View.GONE);
        }
        else
        {
            binding.firstLayout.setVisibility(View.GONE);
        }
        holder.binding.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMessageButtonClick.onClick(false,false,true);
            }
        });
        holder.binding.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMessageButtonClick.onClick(false,true,false);
            }
        });
        holder.binding.btnSay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isVisible=true;
                notifyItemChanged(0);
                onMessageButtonClick.onClick(true,false,false);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    StoryFooterLayoutBinding binding;

    public ViewHolder(StoryFooterLayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}
public interface OnMessageButtonClick{
        void onClick(boolean isFlag, boolean isSharedClick,boolean isMoreClick);
}

}
