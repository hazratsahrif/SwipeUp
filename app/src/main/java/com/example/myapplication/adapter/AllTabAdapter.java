package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.AlltabItem2LayoutBinding;
import com.example.myapplication.databinding.ItemLayoutBinding;
import com.example.myapplication.databinding.LikeRowOneLayoutBinding;
import com.example.myapplication.models.AllTabItemOneData;
import com.example.myapplication.models.AllTabItemTwoData;
import com.example.myapplication.models.LikeModel;

import java.util.List;


public class AllTabAdapter extends RecyclerView.Adapter{

    List list;
    Context context;

    public AllTabAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (AllTabItemOneData.class.isInstance(list.get(position))) {
            return 0;
        }
        else return 1;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType==0){
            ItemLayoutBinding binding;
            binding = ItemLayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderOne(binding);
        }
        else {
            AlltabItem2LayoutBinding binding;
            binding = AlltabItem2LayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderTwo(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(this.getItemViewType(position)==0){
            ViewHolderOne holderOne= (ViewHolderOne) holder;
            AllTabItemOneData model = (AllTabItemOneData) list.get(position);
            holderOne.binding.avatar1.setImageResource(model.getImgAvatar1());
            holderOne.binding.avatar2.setImageResource(model.getImgAvatar2());
            holderOne.binding.coverImage.setImageResource(model.getEventImage());
            holderOne.binding.tvLikeVideo.setText(model.getTvLikeVideo());
            holderOne.binding.tvFirstName.setText(model.getTvFirstName());
            holderOne.binding.tvSecondName.setText(model.getTvSecondName());
        }
        if(this.getItemViewType(position)==1){

            ViewHolderTwo holderTwo= (ViewHolderTwo) holder;
            AllTabItemTwoData itemModel = (AllTabItemTwoData) list.get(position);
            if (itemModel.isPrevDays()){
                ((ViewHolderTwo) holder).binding.tvDay.setVisibility(View.VISIBLE);
            }
            else {
                ((ViewHolderTwo) holder).binding.tvDay.setVisibility(View.GONE);
            }
            holderTwo.binding.avatar1.setImageResource(itemModel.getImgAvatar());
            holderTwo.binding.tvFirstName.setText(itemModel.getTvFirstName());
            holderTwo.binding.tvLikeVideo.setText(itemModel.getTvLikeVideo());


//


        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOne extends  RecyclerView.ViewHolder{
        ItemLayoutBinding binding;

        public ViewHolderOne(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    class ViewHolderTwo extends  RecyclerView.ViewHolder{

        AlltabItem2LayoutBinding binding;

        public ViewHolderTwo(AlltabItem2LayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
