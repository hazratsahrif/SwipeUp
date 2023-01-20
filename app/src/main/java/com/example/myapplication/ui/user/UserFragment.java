package com.example.myapplication.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentUserBinding;
import com.example.myapplication.ui.search.SearchViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class UserFragment extends Fragment {
    FragmentUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(inflater,container,false);
        UserPageAdapter2 userPageAdapter = new UserPageAdapter2(getChildFragmentManager(),getLifecycle());
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setAdapter(userPageAdapter);
        TabLayout tabs = binding.tabs;
        tabs.addTab(tabs.newTab().setIcon(R.drawable.video___vertical));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.heart_tab));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.lock));
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
                NavHostFragment.findNavController(UserFragment.this).navigate(R.id.action_userFragment_to_liveShareBottomSheet);

            }
        });
        binding.btnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UserFragment.this).navigate(R.id.action_userFragment_to_bookMarkFragment);

            }
        });

        return binding.getRoot();
    }
}