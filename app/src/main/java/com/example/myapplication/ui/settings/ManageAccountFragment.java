package com.example.myapplication.ui.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentManageAccountBinding;
import com.example.myapplication.models.ManageDataItem;

import java.util.ArrayList;

import com.example.myapplication.adapter.ManageAccountAdapter;

public class ManageAccountFragment extends Fragment {
    FragmentManageAccountBinding binding;
    ArrayList<ManageDataItem> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentManageAccountBinding.inflate(inflater,container,false);
        list = new ArrayList<>();
        list.add(new ManageDataItem(R.drawable.phone,"+380******999","Phone Number"));
        list.add(new ManageDataItem(R.drawable.email,"a***i@gmail.com","Email Address"));
        list.add(new ManageDataItem(R.drawable.lock,"************","Password"));
        list.add(new ManageDataItem(R.drawable.globe_2,"Phone Number","Region"));
        ManageAccountAdapter adapter = new ManageAccountAdapter(list);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ManageAccountFragment.this).navigateUp();
            }
        });


        return binding.getRoot();
    }
}