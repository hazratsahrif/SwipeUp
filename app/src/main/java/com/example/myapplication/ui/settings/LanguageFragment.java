package com.example.myapplication.ui.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentLanguageBinding;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.LanguageAdapter;

public class LanguageFragment extends Fragment {
    FragmentLanguageBinding binding;
    List<String> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLanguageBinding.inflate(inflater,container,false);
        list = new ArrayList<>();

        list.add("System Default");
        list.add("English");
        list.add("Hindi");
        list.add("Russian");
        list.add("Ukrainian");
        list.add("Deutsch");
        LanguageAdapter adapter = new LanguageAdapter(list);
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