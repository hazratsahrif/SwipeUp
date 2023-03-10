package com.example.myapplication.ui.search.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentUserTabBinding;
import com.example.myapplication.models.UserModel;

import java.util.ArrayList;

import com.example.myapplication.adapter.UserAdapter;


public class UserTabFragment extends Fragment {
    FragmentUserTabBinding binding;
    ArrayList<UserModel> list;
    UserAdapter userAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserTabBinding.inflate(inflater,container,false);
        list= new ArrayList<>();

        list.add(new UserModel(R.drawable.james, "Jerome Bell", "@catchablesadly"));
        list.add(new UserModel(R.drawable.ann, "Annette Black", "@unstylishhelper"));
        list.add(new UserModel(R.drawable.jones, "Jones Black", "@talllegato"));
        list.add(new UserModel(R.drawable.jenny, "Jenny Wilson", "@stagnanttrolley"));
        list.add(new UserModel(R.drawable.kris, "Kristian Watson", "@unstylishhelper"));
        list.add(new UserModel(R.drawable.avatar, "Cody Black", "@talllegato"));
        list.add(new UserModel(R.drawable.avatar5, "Annette Black", "@grindingascertain"));
        list.add(new UserModel(R.drawable.avatar_1, "Floyd Miles", "@mixtapenegative"));

        userAdapter = new UserAdapter(list);
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.rvUsers.setHasFixedSize(true);
        binding.rvUsers.setAdapter(userAdapter);

        return binding.getRoot();
    }
}