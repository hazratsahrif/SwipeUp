package com.example.myapplication.ui.chat.call;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentIncomingCallBinding;


public class IncomingCallFragment extends Fragment {
    FragmentIncomingCallBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIncomingCallBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}