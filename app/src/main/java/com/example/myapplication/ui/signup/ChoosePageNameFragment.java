package com.example.myapplication.ui.signup;

import android.os.Bundle;

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
import com.example.myapplication.databinding.FragmentChoosePageNameBinding;


public class ChoosePageNameFragment extends Fragment {
    FragmentChoosePageNameBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChoosePageNameBinding.inflate(inflater,container,false);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()>=6){
                    binding.layoutAvailable.setVisibility(View.VISIBLE);

                    binding.tvInput.setBoxStrokeColor(ContextCompat.getColor(getContext(),R.color.green));
                    binding.btnNext.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.red));
                }
                else {
                    binding.layoutAvailable.setVisibility(View.GONE);
                    binding.tvInput.setBoxStrokeColor(ContextCompat.getColor(getContext(),R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editText.getText().toString().length()>=6){
                    NavHostFragment.findNavController(ChoosePageNameFragment.this).navigate(R.id.action_choosePageNameFragment_to_birthDayFragment);

                }
                else {
                    Toast.makeText(getContext(), "Enter correct name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }
}