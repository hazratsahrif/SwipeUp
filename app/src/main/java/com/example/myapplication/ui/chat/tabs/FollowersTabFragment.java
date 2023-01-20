package com.example.myapplication.ui.chat.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFollowersTabBinding;
import com.example.myapplication.models.AllTabItemTwoData;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.AllTabAdapter;

public class FollowersTabFragment extends Fragment {
    FragmentFollowersTabBinding binding;
    List list;
    AllTabAdapter adpater;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFollowersTabBinding.inflate(inflater,container,false);
        list = new ArrayList<>();



        list.add(new AllTabItemTwoData(R.drawable.avatar_3,"asideposes","started following you ・ 1h",false));
        list.add(new AllTabItemTwoData(R.drawable.avatar_1,"asideposes","started following you ・ 1h",false));
        list.add(new AllTabItemTwoData(R.drawable.avatar5,"asideposes","started following you ・ 1h",true));
        list.add(new AllTabItemTwoData(R.drawable.avatar6,"asideposes","started following you ・ 1h",false));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adpater = new AllTabAdapter(list,getContext());
        binding.recyclerView.setAdapter(adpater);
        return binding.getRoot();
    }
}