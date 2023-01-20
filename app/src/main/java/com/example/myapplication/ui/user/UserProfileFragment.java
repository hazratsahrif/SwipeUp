package com.example.myapplication.ui.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentUserProfileBinding;
import com.google.android.material.tabs.TabLayout;


public class UserProfileFragment extends Fragment {
    FragmentUserProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserProfileBinding.inflate(inflater,container,false);
        UserPageAdapter userPageAdapter = new UserPageAdapter(getChildFragmentManager(),getLifecycle());
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setAdapter(userPageAdapter);
        TabLayout tabs = binding.tabs;
        tabs.addTab(tabs.newTab().setIcon(R.drawable.video___vertical));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.heart_tab));
//        tabs.addTab(tabs.newTab().setIcon(R.drawable.lock));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabs.selectTab(tabs.getTabAt(position));
            }
        });
        binding.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UserProfileFragment.this).navigate(R.id.action_userProfileFragment_to_shareBottomSheet);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UserProfileFragment.this).navigateUp();
            }
        });
        return binding.getRoot();
    }
}