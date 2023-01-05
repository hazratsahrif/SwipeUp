package com.example.myapplication.ui.search;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.FragmentQRCodeBinding;

public class QRCodeFragment extends Fragment {
    FragmentQRCodeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQRCodeBinding.inflate(inflater, container, false);


        binding.btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(QRCodeFragment.this,ScanQRCodeActivity.class));
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_QRCodeFragment_to_scanQRCodeFragment);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(QRCodeFragment.this).navigateUp();
            }
        });

        return  binding.getRoot();
    }
}