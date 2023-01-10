package com.example.myapplication.ui.sginin;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSignInBinding;


public class SignInFragment extends Fragment {
    FragmentSignInBinding binding;
    String searchText="", password="";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater,container,false);
        binding.editTextPassword.setTransformationMethod(new PasswordTransformationMethod());
        binding.editTextPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                searchText= charSequence.toString();
                if(searchText.isEmpty() || password.isEmpty()){
                    binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
                }
                else {
                    binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                password= charSequence.toString();
                if(searchText.isEmpty() || password.isEmpty()){
                    binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
                }
                else {
                    binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(searchText.isEmpty() || password.isEmpty()){
                    Toast.makeText(getContext(), "Please enter valid credentials", Toast.LENGTH_SHORT).show();

                }
                else {
                    NavHostFragment.findNavController(SignInFragment.this).navigate(R.id.action_signInFragment_to_navigation_home);

                }
            }
        });
        return binding.getRoot();
    }
}