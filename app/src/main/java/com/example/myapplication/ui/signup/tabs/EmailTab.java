package com.example.myapplication.ui.signup.tabs;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentEmailTabBinding;
import com.example.myapplication.ui.signin.SignInFragment;

public class EmailTab extends Fragment {
    FragmentEmailTabBinding binding;
    String searchText="";
    boolean isValid=false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmailTabBinding.inflate(inflater,container,false);
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                searchText= charSequence.toString();
                if(searchText.isEmpty()){
                    binding.btnSignUp.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
                }
                else {
                     isValid =isValidEmail(charSequence);
                    if (isValid) {
                        binding.btnSignUp.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
                    } else {
                        binding.btnSignUp.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EmailTab.this).navigate(R.id.action_signUpFragment_to_signInFragment);
            }
        });
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid){
                NavHostFragment.findNavController(EmailTab.this).navigate(R.id.action_signUpFragment_to_signUpOtpFragment);

                }
                else {
                    Toast.makeText(getContext(), "Please enter a valid email", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return binding.getRoot();
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}