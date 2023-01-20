package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ItemLayoutBinding;
import com.example.myapplication.databinding.LikeRowOneLayoutBinding;
import com.example.myapplication.models.AllTabItemOneData;
import com.example.myapplication.models.LikeModel;

import java.util.List;


public class LikesAdapter extends RecyclerView.Adapter{

    List list;
    Context context;

    public LikesAdapter(List<LikeModel> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        if (LikeModel.class.isInstance(list.get(position))) {
            return 0;
        }
        else return 1;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType==0){
            LikeRowOneLayoutBinding binding;
            binding = LikeRowOneLayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderOne(binding);
        }
        else {
            ItemLayoutBinding binding;
            binding = ItemLayoutBinding.inflate(inflater,parent,false);
            return  new ViewHolderTwo(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(this.getItemViewType(position)==0){
            ViewHolderOne holderOne= (ViewHolderOne) holder;
            LikeModel model = (LikeModel) list.get(position);
            if(model.isLive())
            {
                holderOne.binding.cvBorder.setStrokeColor(ContextCompat.getColor(context,R.color.red));
                holderOne.binding.liveLayout.setVisibility(View.VISIBLE);
            }
            else
            {
                holderOne.binding.cvBorder.setStrokeColor(ContextCompat.getColor(context,R.color.white));
                holderOne.binding.liveLayout.setVisibility(View.GONE);

            }
            holderOne.binding.avatar.setImageResource(model.getImgAvatar());
            holderOne.binding.coverImage.setImageResource(model.getCoverImage());
            holderOne.binding.tvLikeVideo.setText(model.getTvLike());
            holderOne.binding.tvFirstName.setText(model.getTvFirstName());
        }
        if(this.getItemViewType(position)==1){
            ViewHolderTwo holderTwo= (ViewHolderTwo) holder;
            AllTabItemOneData itemModel = (AllTabItemOneData) list.get(position);
            if (itemModel.isPrevDay()){
                holderTwo.binding.tvDay.setVisibility(View.VISIBLE);
            }
            else {
                holderTwo.binding.tvDay.setVisibility(View.GONE);
            }
            holderTwo.binding.avatar1.setImageResource(itemModel.getImgAvatar1());
            holderTwo.binding.avatar2.setImageResource(itemModel.getImgAvatar2());
            holderTwo.binding.avatar2.setVisibility(View.VISIBLE);
            holderTwo.binding.tvFirstName.setText(itemModel.getTvFirstName());
            holderTwo.binding.tvSecondName.setText(itemModel.getTvSecondName());
            holderTwo.binding.tvFirstName.setVisibility(View.VISIBLE);
            holderTwo.binding.tvLikeVideo.setText(itemModel.getTvLikeVideo());
            holderTwo.binding.coverImage.setImageResource(itemModel.getEventImage());
            holderTwo.binding.coverImage.setVisibility(View.VISIBLE);
            holderTwo.binding.tvAnd.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOne extends  RecyclerView.ViewHolder{
        LikeRowOneLayoutBinding binding;

        public ViewHolderOne(LikeRowOneLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    class ViewHolderTwo extends  RecyclerView.ViewHolder{

        ItemLayoutBinding binding;

        public ViewHolderTwo(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
