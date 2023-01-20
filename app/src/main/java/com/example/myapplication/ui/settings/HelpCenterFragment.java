package com.example.myapplication.ui.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentHelpCenterBinding;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.HelpCenterAdapter;


public class HelpCenterFragment extends Fragment {
    FragmentHelpCenterBinding binding;
    List<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHelpCenterBinding.inflate(inflater,container,false);
        list = new ArrayList<>();
        list.add("How to delete posted videous");
        list.add("This number is already registered");
        list.add("Messaging is no longer available");
        list.add("I want to grow my account");
        list.add("I want to grow my account");
        list.add("Suggestion");
        list.add("Account and Profile");
        list.add("Feed / Search / Share");
        list.add("Video and Sound");
        list.add("Notification and Message");
        list.add("Live / Payment / Rewards");
        list.add("Crashing / Not Responding / Lagging / Other");
        HelpCenterAdapter adapter = new HelpCenterAdapter(list);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });


        return binding.getRoot();
    }
}