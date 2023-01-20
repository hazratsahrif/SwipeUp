package com.example.myapplication.ui.filtertabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPortraitTabBinding;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.PortraitAdapter;
import model.PortraitDataItem;

public class PortraitTab extends Fragment {
    FragmentPortraitTabBinding binding;
    RecyclerView recyclerView;
    List<PortraitDataItem> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPortraitTabBinding.inflate(inflater,container,false);
        recyclerView = binding.recyclerview;
        list= new ArrayList<>();
        list.add(new PortraitDataItem(R.drawable.original_1,"Normal",false));
        list.add(new PortraitDataItem(R.drawable.filter_2,"A1",false));
        list.add(new PortraitDataItem(R.drawable.filter2,"A2",false));
        list.add(new PortraitDataItem(R.drawable.filter3,"A3",false));
        list.add(new PortraitDataItem(R.drawable.filter4,"A4",false));
        list.add(new PortraitDataItem(R.drawable.filter5,"A5",false));
        list.add(new PortraitDataItem(R.drawable.filter6,"A6",false));
        list.add(new PortraitDataItem(R.drawable.filter7,"A7",false));
        PortraitAdapter adapter = new PortraitAdapter(list,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}