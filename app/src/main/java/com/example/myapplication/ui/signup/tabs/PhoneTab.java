package com.example.myapplication.ui.signup.tabs;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPhoneTabBinding;


public class PhoneTab extends Fragment {
    FragmentPhoneTabBinding binding;
    String password="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPhoneTabBinding.inflate(inflater,container,false);

        binding.editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    binding.cvBorder.setStrokeColor(ContextCompat.getColor(getContext(),R.color.red));
                    binding.divider.setDividerColor(ContextCompat.getColor(getContext(),R.color.red));
                }
                else {
                    binding.cvBorder.setStrokeColor(ContextCompat.getColor(getContext(),R.color.base100));
                    binding.divider.setDividerColor(ContextCompat.getColor(getContext(),R.color.base100));
                }
            }
        });
        binding.editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                password= charSequence.toString();
                if(password.isEmpty()){
                    binding.btnSignUp.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
                }
                else {
                    binding.btnSignUp.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PhoneTab.this).navigate(R.id.action_signUpFragment_to_signInFragment);
            }
        });
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editTextPassword.getText().toString().length()>7){
                    NavHostFragment.findNavController(PhoneTab.this).navigate(R.id.action_signUpFragment_to_signUpOtpFragment);

                }
                else {
                    Toast.makeText(getContext(), "Please enter a valid phone no", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return binding.getRoot();
    }
}