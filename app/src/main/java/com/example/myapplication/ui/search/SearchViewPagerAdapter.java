package com.example.myapplication.ui.search;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.search.tabs.HashTabFragment;
import com.example.myapplication.ui.search.tabs.SoundTabFragment;
import com.example.myapplication.ui.search.tabs.TopFragmentTab;
import com.example.myapplication.ui.search.tabs.UserTabFragment;
import com.example.myapplication.ui.search.tabs.VideoTabFragment;

public class SearchViewPagerAdapter extends FragmentStateAdapter {
    public SearchViewPagerAdapter(@NonNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new TopFragmentTab();
        }
        else if(position==1){
            return new VideoTabFragment();

        }
        else if(position==2){
            return new UserTabFragment();

        }
        else if(position==3){
            return new HashTabFragment();

        }
        return new SoundTabFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}