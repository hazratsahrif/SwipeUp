package com.example.myapplication.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentProfileBinding;
import com.google.android.material.shape.CornerFamily;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false);
//        float radius = getResources().getDimension(R.dimen.default_corner_radius);
        binding.ivBack.setShapeAppearanceModel(binding.ivBack.getShapeAppearanceModel()
                .toBuilder()
                .setTopRightCorner(CornerFamily.ROUNDED,16)
                .setBottomLeftCorner(CornerFamily.ROUNDED,16)
                .build());
        View view = binding.getRoot();
        return view;
    }
}