package com.example.myapplication.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ParentCommentLayoutBinding;
import com.example.myapplication.models.CommentDataModel;

import java.util.List;

public class NestedCommentAdapter extends RecyclerView.Adapter<NestedCommentAdapter.ViewModel>{

    ParentCommentLayoutBinding binding;
    List<CommentDataModel> itemList;

    Context context;
    boolean isClicked =false;

    public NestedCommentAdapter(List<CommentDataModel> itemList, Context context) {
        this.itemList = itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ParentCommentLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewModel(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        CommentDataModel model = itemList.get(position);

//
//        holder.binding.imAvatar.setImageResource(model.getIvAvatar());
//        holder.binding.tvMessage.setText(model.getTvMessage());
//        holder.binding.tvDay.setText(model.getTvDay());
//        holder.binding.tvUserName.setText(model.getTvUserName());
//        holder.binding.ivHeart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                isClicked = !isClicked;
//                if(isClicked){
//                    holder.binding.ivHeart.setImageResource(R.drawable.heart___small);
//                    holder.binding.ivHeart.setImageTintList(ColorStateList.valueOf(context.getColor(R.color.red)));
//                }
//                else {
//                    holder.binding.ivHeart.setImageResource(R.drawable.heart);
//                    holder.binding.ivHeart.setImageTintList(null);
//                }
//
//            }
//        });
//        if(model.isCreator()){
//            holder.binding.tvCreator.setVisibility(View.VISIBLE);
//        }
//        else {
//            holder.binding.cvBorder.setStrokeWidth(0);
//            holder.binding.tvCreator.setVisibility(View.GONE);
//        }
//
        holder.binding.imAvatar.setImageResource(model.getIvAvatar());
        holder.binding.tvMessage.setText(model.getTvMessage());
        holder.binding.tvDay.setText(model.getTvDay());
        holder.binding.tvUserName.setText(model.getTvUserName());
//        String text = "<font color=#000000>"+holder.binding.tvMessage.getText()+"</font> <font color=#6C7989>Reply</font>";
//        holder.binding.tvMessage.setText(Html.fromHtml(text));

        boolean isExpandable = model.isExpandable();

        holder.binding.ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked = !isClicked;
                if(isClicked){
                    holder.binding.ivHeart.setImageResource(R.drawable.heart___small);
                    holder.binding.ivHeart.setImageTintList(ColorStateList.valueOf(context.getColor(R.color.red)));
                }
                else {
                    holder.binding.ivHeart.setImageResource(R.drawable.heart);
                    holder.binding.ivHeart.setImageTintList(null);
                }

            }
        });

        if(model.isCreator()){
            holder.binding.tvCreator.setVisibility(View.VISIBLE);
        }
        else {
            holder.binding.cvBorder.setStrokeWidth(0);
            holder.binding.tvCreator.setVisibility(View.GONE);
        }
        holder.binding.expandedLayout.setVisibility(isExpandable ? View.VISIBLE: View.GONE);
        if(isExpandable){
            holder.binding.expandLayout.setVisibility(View.GONE);
            holder.binding.tvView.setCompoundDrawablesWithIntrinsicBounds(null,null,context.getResources().getDrawable(R.drawable.chevron_up),null);
        }
        else {
            holder.binding.tvView.setCompoundDrawablesWithIntrinsicBounds(null,null,context.getResources().getDrawable(R.drawable.chevron_down),null);
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return false;
            }
        });

        holder.binding.tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setExpandable(!model.isExpandable());
//                chidlList= model.getList();
//                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        ParentCommentLayoutBinding binding;
        public ViewModel(@NonNull ParentCommentLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
