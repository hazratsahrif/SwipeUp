package utils;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSplashDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SplashDialogFragment extends BottomSheetDialogFragment {

    FragmentSplashDialogBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSplashDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override public int getTheme() {
        return R.style.CustomBottomSheetDialog;
    }
}