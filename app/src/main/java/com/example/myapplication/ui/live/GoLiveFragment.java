package com.example.myapplication.ui.live;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentGoLivekBinding;
import com.example.myapplication.models.LiveMessageItem;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.LiveMessageAdapter;


public class GoLiveFragment extends Fragment {
    FragmentGoLivekBinding binding;
    List<LiveMessageItem> item;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGoLivekBinding.inflate(inflater,container,false);
        binding.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GoLiveFragment.this).navigate(R.id.action_goLiveFragment_to_liveShareBottomSheet);
            }
        });
        binding.btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GoLiveFragment.this).navigate(R.id.action_goLiveFragment_to_filterBottomSheet);
            }
        });
        binding.btnStoplive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GoLiveFragment.this).navigateUp();
            }
        });
        item= new ArrayList<>();
        item.add(new LiveMessageItem("snoopplow: ","So beautiful!"));
        item.add(new LiveMessageItem("snoopplow: ","So beautiful!"));
        item.add(new LiveMessageItem("snoopplow: ","So beautiful!"));
        item.add(new LiveMessageItem("stretchgray: ","Wow, love it! \uD83D\uDE0D:"));
        item.add(new LiveMessageItem("fuknowledge: ","Where’s your fluffy Max? \uD83D\uDE33:"));
        item.add(new LiveMessageItem("splinterlog: ","I wish I was there with you! \uD83D\uDE2D:"));

        LiveMessageAdapter adapter = new LiveMessageAdapter(item,getContext());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);

        binding.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GoLiveFragment.this).navigate(R.id.action_goLiveFragment_to_storyFragment);
            }
        });
        return binding.getRoot();
    }
}