package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.SettingLayoutOneBinding;
import com.example.myapplication.databinding.SettingLayoutTwoBinding;
import com.example.myapplication.models.SettingItems;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter {

    List list;
    Context context;
    int index_row=-1;
    OnClickListener onClickListener;

    public SettingsAdapter(List list, Context context, OnClickListener onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if(SettingItems.class.isInstance(list.get(position))){
            return 1;
        }
        return  0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType==0){
            SettingLayoutOneBinding binding;
            binding = SettingLayoutOneBinding.inflate(inflater,parent,false);
            return  new ViewHolderOne(binding);
        }
        else {
            SettingLayoutTwoBinding binding;
            binding = SettingLayoutTwoBinding.inflate(inflater,parent,false);
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
            SettingItems items = (SettingItems) list.get(position);
            holdertwo.binding.tvSetting.setText(items.getTittle());
            holdertwo.binding.tvSetting.setCompoundDrawablesWithIntrinsicBounds(items.getIcon(),0,0,0);

            if(items.getTittle()=="Copyright Policy"){
                holdertwo.binding.divider.setVisibility(View.VISIBLE);
//                holdertwo.binding.divider.setDividerColor(ContextCompat.getColor(context,R.color.base100));
            }
            else {
                holdertwo.binding.divider.setVisibility(View.GONE);
            }

            if(items.getTittle()==("Add Account") ||  items.getTittle()=="Log Out"){

                holdertwo.binding.tvSetting.setCompoundDrawableTintList(ColorStateList.valueOf(ContextCompat.getColor(context,R.color.red)));
                holdertwo.binding.tvSetting.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context,R.color.red)));
            }
            else {
                holdertwo.binding.tvSetting.setCompoundDrawableTintList(ColorStateList.valueOf(ContextCompat.getColor(context,R.color.black)));
                holdertwo.binding.tvSetting.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context,R.color.base500)));
            }

            holdertwo.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();
                    onClickListener.onClick(position);
                }
            });


        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder{
        SettingLayoutOneBinding binding;
        public ViewHolderOne(SettingLayoutOneBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    class ViewHolderTwo extends RecyclerView.ViewHolder{
        SettingLayoutTwoBinding binding;
        public ViewHolderTwo(SettingLayoutTwoBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    public interface OnClickListener{
        void onClick(int id);
    }
}
