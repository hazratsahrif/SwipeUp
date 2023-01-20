package com.example.myapplication.ui.settings;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.search.tabs.SoundTabFragment;
import com.example.myapplication.ui.search.tabs.TopFragmentTab;
import com.example.myapplication.ui.search.tabs.UserTabFragment;
import com.example.myapplication.ui.search.tabs.VideoTabFragment;
import com.example.myapplication.ui.search.tabs.hashtag.HashTabFragment;
import com.example.myapplication.ui.settings.analyticstab.AnalyticsFollowerFragment;
import com.example.myapplication.ui.settings.analyticstab.ContentFragment;
import com.example.myapplication.ui.settings.analyticstab.OverviewFragment;

public class AnalyticsPageAdapter extends FragmentStateAdapter {
    public AnalyticsPageAdapter(@NonNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new OverviewFragment();
        }
        else if(position==1){
            return new ContentFragment();

        }

        return new AnalyticsFollowerFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}