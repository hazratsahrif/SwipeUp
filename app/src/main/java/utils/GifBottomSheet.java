package utils;

import android.os.Bundle;

import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentGifBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;

import com.example.myapplication.adapter.GifPagerAdapter;


public class GifBottomSheet extends BottomSheetDialogFragment {

    FragmentGifBottomSheetBinding binding;
    TabLayout tabs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentGifBottomSheetBinding.inflate(inflater,container,false);
        GifPagerAdapter sectionsPagerAdapter = new GifPagerAdapter(getChildFragmentManager(),getLifecycle());
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = binding.tabs;

        tabs.addTab(tabs.newTab().setText("Recent"));
        tabs.addTab(tabs.newTab().setText("Stickers"));
        tabs.addTab(tabs.newTab().setText("GIF"));
        tabs.addTab(tabs.newTab().setText("Emoji"));
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabs.selectTab(tabs.getTabAt(position));
            }
        });
        return binding.getRoot();
    }

    @Override
    public int getTheme() {
        return R.style.GifAppBottomSheetDialogTheme;
    }

}