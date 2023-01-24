package com.example.myapplication.ui.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDiscoverBinding;

public class DiscoverFragment extends Fragment {
    FragmentDiscoverBinding binding;
    TextWatcher textWatcher;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDiscoverBinding.inflate(inflater,container,false);
        binding.editText.clearFocus();
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.addRule(RelativeLayout.END_OF, binding.btnBack.getId());
        binding.btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                binding.editText.setText("");
//                binding.viewFlipper.setDisplayedChild(0);
//                binding.appBar.setElevation(2);
//                params1.addRule(RelativeLayout.START_OF, binding.btnScan.getId());
//                binding.edInput.setLayoutParams(params1);
//                binding.btnBack.setVisibility(View.GONE);
//                binding.btnSearch.setVisibility(View.GONE);
//                binding.btnScan.setVisibility(View.VISIBLE);
////                hideSoftKeyboard(requireActivity(), view);
//                binding.editText.clearFocus();
                Navigation.findNavController(view).navigate(R.id.action_discoverFragment_to_QRCodeFragment);
            }
        });
        textWatcher= new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String value=charSequence.toString();

                if (value.isEmpty()) {
                    Toast.makeText(getContext(), "focus", Toast.LENGTH_SHORT).show();
                    binding.viewFlipper.setDisplayedChild(1);
                    binding.appBar.setElevation(2);
                    binding.viewFlipper.setDisplayedChild(1);
                    binding.edInput.setLayoutParams(params1);
                    binding.btnBack.setVisibility(View.VISIBLE);
                    binding.btnSearch.setVisibility(View.VISIBLE);
                    binding.btnScan.setVisibility(View.GONE);
                }
                else {
                    binding.viewFlipper.setDisplayedChild(2);
                    binding.appBar.setElevation(0);
                    binding.viewFlipper.setDisplayedChild(2);
                    binding.edInput.setLayoutParams(params1);
                    binding.btnBack.setVisibility(View.VISIBLE);
                    binding.btnSearch.setVisibility(View.VISIBLE);
                    binding.btnScan.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };


        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText("");
                binding.viewFlipper.setDisplayedChild(0);
                binding.appBar.setElevation(2);
                params1.addRule(RelativeLayout.START_OF, binding.btnScan.getId());
                binding.edInput.setLayoutParams(params1);
                binding.btnBack.setVisibility(View.GONE);
                binding.btnSearch.setVisibility(View.GONE);
                binding.btnScan.setVisibility(View.VISIBLE);
//                hideSoftKeyboard(requireActivity(), view);
                binding.editText.clearFocus();
            }
        });

        binding.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    binding.viewFlipper.setDisplayedChild(1);
                    binding.appBar.setElevation(2);
                    params1.addRule(RelativeLayout.START_OF, binding.btnSearch.getId());
                    binding.edInput.setLayoutParams(params1);
                    binding.btnBack.setVisibility(View.VISIBLE);
                    binding.btnSearch.setVisibility(View.VISIBLE);
                    binding.btnScan.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "focused", Toast.LENGTH_SHORT).show();

                }
                else if(binding.editText.getText().toString().length()>0){
                    binding.viewFlipper.setDisplayedChild(2);
                    binding.appBar.setElevation(0);
                    binding.viewFlipper.setDisplayedChild(2);
                    binding.edInput.setLayoutParams(params1);
                    binding.btnBack.setVisibility(View.VISIBLE);
                    binding.btnSearch.setVisibility(View.VISIBLE);
                    binding.btnScan.setVisibility(View.GONE);

                }
                else {
                    binding.viewFlipper.setDisplayedChild(0);
                }
            }
        });

        return binding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();
        binding.editText.addTextChangedListener(textWatcher);
    }
    //    public static void hideSoftKeyboard (Activity activity, View view)
//    {
//        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
//    }

}
