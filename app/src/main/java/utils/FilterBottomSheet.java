package utils;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFilterBottomSheetBinding;
import com.example.myapplication.ui.filtertabs.FilterTabAdapter;
import com.example.myapplication.ui.search.SearchViewPagerAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;


public class FilterBottomSheet extends BottomSheetDialogFragment {
    FragmentFilterBottomSheetBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilterBottomSheetBinding.inflate(inflater,container,false);
        getTheme();
        FilterTabAdapter filterTabAdapter = new FilterTabAdapter(getChildFragmentManager(),getLifecycle());
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setAdapter(filterTabAdapter);
        TabLayout tabs = binding.tabs;
        tabs.addTab(tabs.newTab().setText("Portrait"));
        tabs.addTab(tabs.newTab().setText("Landscape"));
        tabs.addTab(tabs.newTab().setText("Food"));
        tabs.addTab(tabs.newTab().setText("Vibe"));
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
        return binding.getRoot();
    }
    @Override public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }
    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

    }
}