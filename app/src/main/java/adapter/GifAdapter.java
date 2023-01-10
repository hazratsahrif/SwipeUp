package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.AccountBinding;
import com.example.myapplication.databinding.GifLayoutBinding;
import com.example.myapplication.models.AccountModel;

import java.util.ArrayList;
import java.util.List;


public class GifAdapter extends RecyclerView.Adapter<GifAdapter.ViewHolder> {
    GifLayoutBinding binding;
    List<Integer> list;
    public GifAdapter(List<Integer> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = GifLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer model = list.get(position);
        holder.binding.ivImage.setImageResource(model);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    GifLayoutBinding binding;

    public ViewHolder(GifLayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}

}
