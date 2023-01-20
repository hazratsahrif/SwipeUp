package com.example.myapplication.ui.chat.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LikeTabFragmentBinding;
import com.example.myapplication.models.AllTabItemOneData;
import com.example.myapplication.models.LikeModel;
import com.example.myapplication.ui.Add.AddViewModel;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.LikesAdapter;

public class LikesTab extends Fragment {
    LikeTabFragmentBinding binding;
    List list;
    LikesAdapter adpater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AddViewModel notificationsViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);
        binding = LikeTabFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        list = new ArrayList<>();
        list = new ArrayList<>();


        list.add(new LikeModel("armholegetaway","liked your video ・ 20m", R.drawable.cover,R.drawable.avatar_f ,false ));
        list.add(new LikeModel("armholegetaway","liked your video ・ 20m",R.drawable.cover_2_, R.drawable.avatar_g_ ,false));
        list.add(new LikeModel("armholegetaway","liked your video ・ 20m",R.drawable.cover, R.drawable.avatar   ,false ));
        list.add(new AllTabItemOneData(R.drawable.avatar_f,R.drawable.avatar_g_,"armholegetaway","mixtapenegative","liked your video ・ 20m",R.drawable.cover_2_,true));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adpater = new LikesAdapter(list,getContext());
        binding.recyclerView.setAdapter(adpater);

        return root;
    }

}