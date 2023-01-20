package com.example.myapplication.ui.signup;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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
import com.example.myapplication.databinding.FragmentSetPasswordBinding;
import com.example.myapplication.ui.signin.SignInFragment;


public class SetPasswordFragment extends Fragment {
    FragmentSetPasswordBinding binding;
    String password="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSetPasswordBinding.inflate(inflater,container,false);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
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
                    binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
                    binding.etSearch.setBoxStrokeColor(ContextCompat.getColor(getContext(), R.color.red));
                    binding.checkbox.setChecked(false);
                    binding.checkbox2.setChecked(false);
                }
                else if (charSequence.toString().matches("[a-zA-Z0-9]*") && charSequence.toString().length()>=8){
                    binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
                    binding.checkbox.setChecked(true);
                    binding.checkbox2.setChecked(true);
                    binding.etSearch.setBoxStrokeColor(ContextCompat.getColor(getContext(), R.color.green));
                }
//                else if(charSequence.toString().length()>=8) {
//                    checkbox=true;
//                    binding.checkbox.setChecked(true);
//                    if(checkbox==true && checkbox2==true){
//                        binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
//                        binding.checkbox.setChecked(true);
//                        binding.checkbox2.setChecked(true);
//                    }
//
//                      else if(charSequence.toString().matches("[a-zA-Z0-9]*")){
//                        Toast.makeText(getContext(), "else if", Toast.LENGTH_SHORT).show();
//                           checkbox2=true;
//                           binding.checkbox2.setChecked(true);
//                        binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
//                       }
//                      else {
//                        binding.btnSignIn.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.hint_color));
//                        binding.checkbox.setChecked(true);
//                    }
//
//                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return binding.getRoot();
    }
}