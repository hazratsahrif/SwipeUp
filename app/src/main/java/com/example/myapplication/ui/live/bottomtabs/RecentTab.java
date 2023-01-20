package com.example.myapplication.ui.live.bottomtabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentRecentTabBinding;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.GifAdapter;


public class RecentTab extends Fragment {
    FragmentRecentTabBinding binding;
    List<Integer> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRecentTabBinding.inflate(inflater,container,false);
        list = new ArrayList<>();
        list.add(R.drawable.image);
        list.add(R.drawable.image_1);
        list.add(R.drawable.image_2);
        list.add(R.drawable.image_3);
        list.add(R.drawable.image_4);
        list.add(R.drawable.image_5);
        list.add(R.drawable.image_6);
        list.add(R.drawable.image_7);
        list.add(R.drawable.image_8);
        list.add(R.drawable.image_9);
        list.add(R.drawable.image_10);
        list.add(R.drawable.image_11);
        list.add(R.drawable.image_12);
        list.add(R.drawable.image_13);
        list.add(R.drawable.image_14);

        GifAdapter adapter = new GifAdapter(list);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),5));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);




        return binding.getRoot();
    }
}