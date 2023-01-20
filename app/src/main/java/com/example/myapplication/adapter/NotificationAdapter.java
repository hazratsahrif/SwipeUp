package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.NotifiationLayoutOneBinding;
import com.example.myapplication.databinding.NotificationLayoutBinding;
import com.example.myapplication.databinding.SettingLayoutOneBinding;
import com.example.myapplication.databinding.SettingLayoutTwoBinding;
import com.example.myapplication.models.NotificationDataItem;
import com.example.myapplication.models.SettingItems;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter {

    List list;
    Context context;

    public NotificationAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(NotificationDataItem.class.isInstance(list.get(position))){
            return 1;
        }
        return  0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType==0){
            NotifiationLayoutOneBinding binding;
            binding = NotifiationLayoutOneBinding.inflate(inflater,parent,false);
            return  new ViewHolderOne(binding);
        }
        else {
            NotificationLayoutBinding binding;
            binding = NotificationLayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderTwo(binding);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (this.getItemViewType(position)==0){
            ViewHolderOne holderOne = (ViewHolderOne) holder;
            String string = (String) list.get(position);
            holderOne.binding.tvCatagory.setText(string);

        }
        else {
            ViewHolderTwo holdertwo = (ViewHolderTwo) holder;
            NotificationDataItem items = (NotificationDataItem) list.get(position);
            holdertwo.binding.switchTitle.setText(items.getTitle());

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder{
        NotifiationLayoutOneBinding binding;
        public ViewHolderOne(NotifiationLayoutOneBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    class ViewHolderTwo extends RecyclerView.ViewHolder{
        NotificationLayoutBinding binding;
        public ViewHolderTwo(NotificationLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
