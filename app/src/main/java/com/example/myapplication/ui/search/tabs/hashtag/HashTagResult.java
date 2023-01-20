package com.example.myapplication.ui.search.tabs.hashtag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHashTagResultBinding;
import com.example.myapplication.models.TrendingTravelModel;

import java.util.ArrayList;

import com.example.myapplication.adapter.TopVideosAdapter;
import utils.GridSpacingItemDecoration;

public class HashTagResult extends Fragment {
    FragmentHashTagResultBinding binding;
    ArrayList<TrendingTravelModel> list;
    TopVideosAdapter topVideosAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHashTagResultBinding.inflate(inflater,container,false);
        list= new ArrayList<>();



        list.add(new TrendingTravelModel(R.drawable.cover_1_,"2.8k"));
        list.add(new TrendingTravelModel(R.drawable.cover_1_,"298.1k"));
        list.add(new TrendingTravelModel(R.drawable.cover_1_,"67.5k"));
        list.add(new TrendingTravelModel(R.drawable.cover_1_,"22.4k"));
        list.add(new TrendingTravelModel(R.drawable.cover_2_,"987.9k"));
        list.add(new TrendingTravelModel(R.drawable.card_11,"987.9k"));
        list.add(new TrendingTravelModel(R.drawable.card_1,"987.9k"));
        list.add(new TrendingTravelModel(R.drawable.card_2,"987.9k"));
        list.add(new TrendingTravelModel(R.drawable.card_3,"987.9k"));
        list.add(new TrendingTravelModel(R.drawable.card_4,"987.9k"));
        list.add(new TrendingTravelModel(R.drawable.card_5,"987.9k"));

        topVideosAdapter = new TopVideosAdapter(list);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3, LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 0, false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(topVideosAdapter);
        binding.btnBcak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HashTagResult.this).navigateUp();
            }
        });
        return binding.getRoot();
    }
}