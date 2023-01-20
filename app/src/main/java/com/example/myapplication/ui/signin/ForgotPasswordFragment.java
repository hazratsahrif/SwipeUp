package com.example.myapplication.ui.signin;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentForgotPasswordBinding;


public class ForgotPasswordFragment extends Fragment {
    FragmentForgotPasswordBinding binding;
    String searchText="";
    ProgressBar spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentForgotPasswordBinding.inflate(inflater,container,false);
//        spinner.setVisibility(View.VISIBLE);

//        pinView.setTransformationMethod(new PasswordTransformationMethod());
//        myLayout.addView(pin);
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

                searchText= charSequence.toString();
                if(searchText.isEmpty()){
                    binding.btnResetPass.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));

                }
                else {
                    binding.btnResetPass.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(searchText.isEmpty()){
                    Toast.makeText(getContext(), "Please enter your password!", Toast.LENGTH_SHORT).show();
                }
                else {

                NavHostFragment.findNavController(ForgotPasswordFragment.this).navigate(R.id.action_forgotPasswordFragment_to_otpVerificationFragment);
                }
            }
        });
        return binding.getRoot();
    }
}