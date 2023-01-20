package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.AddNewChatLayoutBinding;
import com.example.myapplication.databinding.AlphabaticChatRowBinding;
import com.example.myapplication.models.SearchChatItem;

import java.util.List;

public class SearchChatAdapter extends RecyclerView.Adapter {
    List list;
    Context context;

    public SearchChatAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(SearchChatItem.class.isInstance(list.get(position))){
            return 1;
        }
        else {
            return 0;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType==0){
            AlphabaticChatRowBinding binding;
            binding= AlphabaticChatRowBinding.inflate(inflater,parent,false);
            return  new ViewHolderOne(binding);

        }
        else {
            AddNewChatLayoutBinding binding;
            binding= AddNewChatLayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderTwo(binding);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(this.getItemViewType(position)==0){
            ViewHolderOne holderOne = (ViewHolderOne) holder;
            String text= (String) list.get(position);
            holderOne.binding.tvAlpha.setText(text);
        }
        else {
            ViewHolderTwo holderTwo = (ViewHolderTwo) holder;
            SearchChatItem item= (SearchChatItem) list.get(position);
            holderTwo.binding.avatar.setImageResource(item.getAvatar());
            holderTwo.binding.tvFName.setText(item.getTvFName());
            holderTwo.binding.tvLName.setText(item.getTvLName());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
     class ViewHolderOne extends RecyclerView.ViewHolder{
         AlphabaticChatRowBinding binding;


         public ViewHolderOne(AlphabaticChatRowBinding binding) {
             super(binding.getRoot());
             this.binding = binding;
         }
     }
     class ViewHolderTwo extends RecyclerView.ViewHolder{
   AddNewChatLayoutBinding binding;

         public ViewHolderTwo(AddNewChatLayoutBinding binding) {
             super(binding.getRoot());
             this.binding=binding;
         }
     }

}
