package com.example.myapplication.ui.chat.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMentionTabBinding;
import com.example.myapplication.models.LikeModel;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.LikesAdapter;


public class MentionTabFragment extends Fragment {
    FragmentMentionTabBinding binding;
    List list;
    LikesAdapter adpater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMentionTabBinding.inflate(inflater,container,false);
        list = new ArrayList<>();
        list = new ArrayList<>();


        list.add(new LikeModel("armholegetaway","liked your video ・ 20m", R.drawable.cover,R.drawable.avatar_f ,false ));
        list.add(new LikeModel("armholegetaway","liked your video ・ 20m",R.drawable.cover_2_, R.drawable.avatar_g_ ,false));
        list.add(new LikeModel("armholegetaway","liked your video ・ 20m",R.drawable.cover, R.drawable.avatar,false));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adpater = new LikesAdapter(list,getContext());
        binding.recyclerView.setAdapter(adpater);
        return binding.getRoot();
    }
}