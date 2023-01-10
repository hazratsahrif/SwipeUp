package com.example.myapplication.ui.live;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLiveStoryBinding;

public class LiveStoryFragment extends Fragment {
    FragmentLiveStoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLiveStoryBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}