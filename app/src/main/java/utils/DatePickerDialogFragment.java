package utils;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDatePickerDialogBinding;

public class DatePickerDialogFragment extends DialogFragment {

    FragmentDatePickerDialogBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDatePickerDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}