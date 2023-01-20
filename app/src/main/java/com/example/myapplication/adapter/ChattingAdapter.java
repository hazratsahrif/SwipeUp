package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ChatingRow1LayoutBinding;
import com.example.myapplication.databinding.ChatingRow2LayoutBinding;
import com.example.myapplication.databinding.ChatingRow3LayoutBinding;
import com.example.myapplication.databinding.ChatingRow4LayoutBinding;
import com.example.myapplication.databinding.ChatingRow5LayoutBinding;
import com.example.myapplication.models.ChatRow1Item;
import com.example.myapplication.models.ChatRow2Item;
import com.example.myapplication.models.ChatRow3Item;
import com.example.myapplication.models.ChatRow4Item;
import com.example.myapplication.models.ChatRow5Item;
import com.example.myapplication.models.LikeModel;

import java.util.List;

public class ChattingAdapter extends RecyclerView.Adapter {
    List list;
    Context context;

    public ChattingAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (ChatRow1Item.class.isInstance(list.get(position))){
          return 0;
        }
        else if(ChatRow2Item.class.isInstance(list.get(position))){
            return 1;
        }
        else if(ChatRow3Item.class.isInstance(list.get(position))){
            return 2;
        }
        else if(ChatRow4Item.class.isInstance(list.get(position))){
            return 3;
        }
//        else if(ChatRow5Item.class.isInstance(list.get(position))){
//            return 4;
//        }
        return 4;
//            return super.getItemViewType(position);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType==0){
            ChatingRow1LayoutBinding binding;
            binding = ChatingRow1LayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderOne(binding);
        }
        else if(viewType==1){
            ChatingRow2LayoutBinding binding;
            binding = ChatingRow2LayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderTwo(binding);
        }
        else if(viewType==2){
            ChatingRow3LayoutBinding binding;
            binding = ChatingRow3LayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderThree(binding);
        }
        else if(viewType==3){
            ChatingRow4LayoutBinding binding;
            binding = ChatingRow4LayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderFour(binding);
        }
        else {
            ChatingRow5LayoutBinding binding;
            binding = ChatingRow5LayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderFive(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (this.getItemViewType(position)==0){
            ViewHolderOne holderOne = (ViewHolderOne) holder;
//            ChatRow1Item text =(ChatRow1Item) list.get(position);
//            holderOne.binding.tvToday.setText(text.getToday());

        }
        else if (this.getItemViewType(position)==1){

            ViewHolderTwo holderTwo = (ViewHolderTwo) holder;
//            String string = (String) list.get(position);
//            holderTwo.binding.tvMessage.setText("string");

        }
        else if (this.getItemViewType(position)==2){
            ViewHolderThree holderThree = (ViewHolderThree) holder;
//            String string =(String) list.get(position);
//            holderThree.binding.tvMessagef.setText(string);

        }
        else if (this.getItemViewType(position)==3){
            ViewHolderFour  holderFour= (ViewHolderFour) holder;
//            int string =(int) list.get(position);
//            holderFour.binding.image.setImageResource(string);

        }
        else {
            ViewHolderFive  holderFive= (ViewHolderFive) holder;
//            String string =(String) list.get(position);
//            holderFive.binding.time.setText(string);


        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolderOne extends RecyclerView.ViewHolder{

        ChatingRow1LayoutBinding binding;
        public ViewHolderOne(ChatingRow1LayoutBinding binding) {
            super(binding.getRoot());
        }
    }
    class ViewHolderTwo extends RecyclerView.ViewHolder{

        ChatingRow2LayoutBinding binding;
        public ViewHolderTwo(ChatingRow2LayoutBinding binding) {
            super(binding.getRoot());
        }
    }
    class ViewHolderThree extends RecyclerView.ViewHolder{

        ChatingRow3LayoutBinding binding;
        public ViewHolderThree(ChatingRow3LayoutBinding binding) {
            super(binding.getRoot());
        }
    }
    class ViewHolderFour extends RecyclerView.ViewHolder{

        ChatingRow4LayoutBinding binding;
        public ViewHolderFour(ChatingRow4LayoutBinding binding) {
            super(binding.getRoot());
        }
    }
    class ViewHolderFive extends RecyclerView.ViewHolder{

        ChatingRow5LayoutBinding binding;
        public ViewHolderFive(ChatingRow5LayoutBinding binding) {
            super(binding.getRoot());
        }
    }
}
