package com.example.myapplication.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.databinding.FriendsLayoutBinding;

import java.util.ArrayList;

import model.ProfileClass;

public class ProfileAdapterClass extends RecyclerView.Adapter<ProfileAdapterClass.ViewHolder> {


    FriendsLayoutBinding binding;
    ArrayList<ProfileClass> list;
    Context context;

    public ProfileAdapterClass(ArrayList<ProfileClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileAdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = FriendsLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapterClass.ViewHolder holder, int position) {
        holder.binding.ivUser.setImageResource(list.get(position).getUserImage());
        holder.binding.tvUserName.setText(list.get(position).getUserName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FriendsLayoutBinding binding;
        public ViewHolder(FriendsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
