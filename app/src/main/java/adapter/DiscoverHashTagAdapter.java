package adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.DiscoverHastagLayoutBinding;
import com.example.myapplication.databinding.TravelBinding;
import com.example.myapplication.models.TrendingTravelModel;

import java.util.ArrayList;

//
public class DiscoverHashTagAdapter extends RecyclerView.Adapter<DiscoverHashTagAdapter.ViewHolder> {
    DiscoverHastagLayoutBinding binding;
    ArrayList<TrendingTravelModel> list;

    public DiscoverHashTagAdapter(ArrayList<TrendingTravelModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DiscoverHastagLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.ivtravel.setImageResource(list.get(position).getIvtravel());
        holder.binding.tvtravel.setText(list.get(position).getTvtravel());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        DiscoverHastagLayoutBinding binding;

        public ViewHolder(@NonNull DiscoverHastagLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
