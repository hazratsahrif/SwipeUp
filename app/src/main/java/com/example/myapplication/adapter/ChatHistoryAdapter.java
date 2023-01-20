package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ChatHistoryLayoutBinding;
import com.example.myapplication.models.ChatHistoryItemData;
import com.zerobranch.layout.SwipeLayout;

import java.util.List;


public class ChatHistoryAdapter extends RecyclerView.Adapter<ChatHistoryAdapter.ViewHolder> {
    ChatHistoryLayoutBinding binding;
    List<ChatHistoryItemData> list;
    Context context;
    OnClickListener onClickListener;

    public ChatHistoryAdapter(List<ChatHistoryItemData> list, Context context, OnClickListener onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ChatHistoryLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ChatHistoryItemData model = list.get(position);
        holder.binding.avatar.setImageResource(model.getAvatar());
        holder.binding.tvName.setText(model.getTvName());
        holder.binding.tvMessage.setText(model.getTvMessage());
        holder.binding.tvTime.setText(model.getTvTime());
        holder.binding.tvCount.setText(model.getTvMessageCount());
        holder.binding.dragItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(onClickListener!=null){
                    onClickListener.onClick(true);
                }
            }
        });

        if(model.isLive() && model.isVerified()){
            holder.binding.cvBorder.setStrokeColor(ContextCompat.getColor(context, R.color.red));
            holder.binding.liveLayout.setVisibility(View.VISIBLE);
            holder.binding.iconVerified.getRoot().setVisibility(View.VISIBLE);
        }
       else if(model.isStatus()){
            holder.binding.cvBorder.setStrokeColor(ContextCompat.getColor(context, R.color.red));
            holder.binding.liveLayout.setVisibility(View.GONE);
            holder.binding.iconVerified.getRoot().setVisibility(View.GONE);
        }
       else {
            holder.binding.cvBorder.setStrokeColor(ContextCompat.getColor(context, R.color.white));
            holder.binding.liveLayout.setVisibility(View.GONE);
            holder.binding.iconVerified.getRoot().setVisibility(View.GONE);
        }

        holder.binding.swipeLayout.setOnActionsListener(new SwipeLayout.SwipeActionsListener() {
            @Override
            public void onOpen(int direction, boolean isContinuous) {
                if (direction == SwipeLayout.RIGHT) {
                    // was executed swipe to the right
                } else if (direction == SwipeLayout.LEFT) {
                    // was executed swipe to the left
                    holder.binding.delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            list.remove(position);
                            notifyDataSetChanged();
                        }
                    });

                }
            }

            @Override
            public void onClose() {
                // the main view has returned to the default state
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    ChatHistoryLayoutBinding binding;

    public ViewHolder(ChatHistoryLayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}
public interface OnClickListener{
        void onClick(boolean isClick);
}

}
