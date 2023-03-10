package com.example.myapplication.ui.search;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentRecentSearchBinding;

import java.util.ArrayList;

import com.example.myapplication.adapter.RecentAdapter;


public class RecentSearchFragment extends Fragment {
    FragmentRecentSearchBinding binding;
    ArrayList<String> list;
    RecentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRecentSearchBinding.inflate(inflater,container,false);
        list = new ArrayList<>();

        list.add("memes");
        list.add("businessideas");
        list.add("fashionstyle");
        list.add("howto");
        list.add("travel");

        adapter = new RecentAdapter(list);
        binding.rvRecent.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.rvRecent.setHasFixedSize(true);
        binding.rvRecent.setAdapter(adapter);
        return binding.getRoot();
    }
}