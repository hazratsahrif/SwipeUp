package com.example.myapplication.ui.live;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSwipeLiveBinding;


public class SwipeLiveFragment extends Fragment {
    FragmentSwipeLiveBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSwipeLiveBinding.inflate(inflater,container,false);
        binding.viewFlipper.setDisplayedChild(0);
        binding.tvLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvLive.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                binding.tvStory.setTextColor(ContextCompat.getColor(getContext(), R.color.white56));
                binding.viewFlipper.setDisplayedChild(0);
            }
        });
        binding.tvStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvLive.setTextColor(ContextCompat.getColor(getContext(), R.color.white56));
                binding.tvStory.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                binding.viewFlipper.setDisplayedChild(1);
            }
        });

        return binding.getRoot();
    }
}