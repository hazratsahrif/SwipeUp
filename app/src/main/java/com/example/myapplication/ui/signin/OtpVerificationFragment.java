package com.example.myapplication.ui.signin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentOtpVerificationBinding;

public class OtpVerificationFragment extends Fragment {
    FragmentOtpVerificationBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOtpVerificationBinding.inflate(inflater,container,false);
        final PinView pinView = binding.firstPinView;
        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.setCursorVisible(true);
        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==4){
                    NavHostFragment.findNavController(OtpVerificationFragment.this).navigate(R.id.action_otpVerificationFragment_to_setNewPasswordFragment);
                    Toast.makeText(getContext(), "Enter all", Toast.LENGTH_SHORT).show();
                    pinView.setText("");
                }
                else {
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

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