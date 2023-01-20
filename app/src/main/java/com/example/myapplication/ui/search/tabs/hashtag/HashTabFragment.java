package com.example.myapplication.ui.search.tabs.hashtag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHashTabBinding;
import com.example.myapplication.models.HashtagDataModel;

import java.util.ArrayList;

import com.example.myapplication.adapter.HashtagAdpater;


public class HashTabFragment extends Fragment implements HashtagAdpater.OnClickListener {
    FragmentHashTabBinding binding;
    ArrayList<HashtagDataModel> list;
    HashtagAdpater hashtagAdpater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHashTabBinding.inflate(inflater,container,false);
        list= new ArrayList<>();


        list.add(new HashtagDataModel("travel","2.4M Videos"));
        list.add(new HashtagDataModel("traveldiaries","2.35M Videos"));
        list.add(new HashtagDataModel("worldtravel","300.8k Videos"));
        list.add(new HashtagDataModel("holidaytravel","2.4M Videos"));
        list.add(new HashtagDataModel("traveldiaries","2.35M Videos"));
        list.add(new HashtagDataModel("travellife","2.19M Videos"));
        list.add(new HashtagDataModel("weekendtravel","23.4M Videos"));
        list.add(new HashtagDataModel("traveldiaries","2.35M Videos"));
        list.add(new HashtagDataModel("travellife","2.19M Videos"));
        list.add(new HashtagDataModel("traveling","200M Videos"));
        list.add(new HashtagDataModel("traveldiaries","500.3k Videos"));



        hashtagAdpater = new HashtagAdpater(getContext(),list,this::onClick);
        binding.rvHashtag.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.rvHashtag.setHasFixedSize(true);
        binding.rvHashtag.setAdapter(hashtagAdpater);

        return binding.getRoot();
    }

    @Override
    public void onClick(boolean isClick) {
        NavHostFragment.findNavController(HashTabFragment.this).navigate(R.id.action_searchItemFragment_to_hashTagResult);

    }
}