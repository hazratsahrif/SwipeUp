package utils;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentCallBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CallBottomSheet extends BottomSheetDialogFragment {
    FragmentCallBottomSheetBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCallBottomSheetBinding.inflate(inflater,container,false);
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CallBottomSheet.this).navigate(R.id.action_callBottomSheet_to_callFragment);
            }
        });
        binding.btnVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CallBottomSheet.this).navigate(R.id.action_callBottomSheet_to_videoCallFragment);
            }
        });
        return binding.getRoot();
    }

    @Override
    public int getTheme() {
        return R.style.GifAppBottomSheetDialogTheme;
    }
}