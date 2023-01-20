package com.example.myapplication.ui.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.EffectLayoutBinding;
import com.example.myapplication.databinding.FragmentBirthDayBinding;
import com.google.android.material.textfield.TextInputLayout;


public class BirthDayFragment extends Fragment {
    FragmentBirthDayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBirthDayBinding.inflate(inflater,container,false);
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()>=8){
                    binding.btnNext.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editText.getText().toString().length()>=8){
                    binding.btnNext.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.red));
                    NavHostFragment.findNavController(BirthDayFragment.this).navigate(R.id.action_birthDayFragment_to_setPasswordFragment);
                }
                else {
                    Toast.makeText(getContext(), "Please enter your birth date", Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });
        return binding.getRoot();
    }
}