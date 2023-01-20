package com.example.myapplication.ui.settings.analyticstab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentContentBinding;
import com.example.myapplication.models.TrendingTravelModel;

import java.util.ArrayList;

import com.example.myapplication.adapter.TopVideosAdapter;
import com.example.myapplication.adapter.TrendingTravelAdapter;


public class ContentFragment extends Fragment {
    FragmentContentBinding binding;

    ArrayList<TrendingTravelModel> list;
    ArrayList<TrendingTravelModel> list2;
    LinearLayoutManager linearLayoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContentBinding.inflate(inflater,container,false);
         list = new ArrayList<>();
         list2 = new ArrayList<>();
         list.add(new TrendingTravelModel(R.drawable.card_3,"132.8K"));
         list.add(new TrendingTravelModel(R.drawable.card_5,"132.8K"));
         list2.add(new TrendingTravelModel(R.drawable.card_5,"132.8K"));
         list2.add(new TrendingTravelModel(R.drawable.card_5,"132.8K"));
         list2.add(new TrendingTravelModel(R.drawable.card_3,"132.8K"));
         list2.add(new TrendingTravelModel(R.drawable.card_4,"132.8K"));
         list2.add(new TrendingTravelModel(R.drawable.card_5,"132.8K"));
         list2.add(new TrendingTravelModel(R.drawable.card_5,"132.8K"));

         TrendingTravelAdapter adapter = new TrendingTravelAdapter(list);
         binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
         binding.recyclerView.setHasFixedSize(true);
         binding.recyclerView.setAdapter(adapter);

        TopVideosAdapter topVideosAdapter = new TopVideosAdapter(list2);
        binding.recyclerView2.setLayoutManager(new GridLayoutManager(getContext(),3, LinearLayoutManager.VERTICAL,false));
//        binding.recyclerView2.addItemDecoration(new GridSpacingItemDecoration(3, 0, false));
        binding.recyclerView2.setHasFixedSize(true);
        binding.recyclerView2.setAdapter(topVideosAdapter);
       binding.recyclerView2.suppressLayout(true);


        return binding.getRoot();
    }


}