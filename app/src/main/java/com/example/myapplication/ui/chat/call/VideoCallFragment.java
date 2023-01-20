package com.example.myapplication.ui.chat.call;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentVideoCallBinding;


public class VideoCallFragment extends Fragment {
    FragmentVideoCallBinding binding;
    boolean isCliked=false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVideoCallBinding.inflate(inflater,container,false);

        binding.btnMinizex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(VideoCallFragment.this).navigate(R.id.action_videoCallFragment_to_chatHistoryFragment);
            }
        });
        binding.btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCliked= !isCliked;

                if(isCliked){
                    binding.btnVideo.setBackgroundResource(R.drawable.video_camer_slash);
                    binding.btnVideo.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(),R.color.base800)));
                    binding.btnVideoBack.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.white));
                }
                else {
                    binding.btnVideo.setBackgroundResource(R.drawable.videos_cam);
                    binding.btnVideo.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(),R.color.white)));
                    binding.btnVideoBack.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.white16));
                }



            }
        });
        return binding.getRoot();
    }
}