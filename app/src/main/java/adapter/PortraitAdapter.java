package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FiltersheetLayoutBinding;

import java.util.List;

import model.PortraitDataItem;

public class PortraitAdapter extends RecyclerView.Adapter<PortraitAdapter.ViewHolder> {
    int rowIndex= -1;

    FiltersheetLayoutBinding binding;
    List<PortraitDataItem> list;
    Context context;

    public PortraitAdapter(List<PortraitDataItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PortraitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = FiltersheetLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PortraitAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PortraitDataItem item = list.get(position);
        holder.binding.ivImage.setImageResource(item.getImage());
        holder.binding.tvTitle.setText(item.getTvTitle());
        if (rowIndex==position){
            holder.binding.cvBorder.setStrokeColor(ContextCompat.getColor(context, R.color.red));

        }
        else {
            holder.binding.cvBorder.setStrokeColor(Color.TRANSPARENT);
        }

        holder.binding.cvBorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rowIndex = position;
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FiltersheetLayoutBinding binding;
        public ViewHolder(FiltersheetLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
