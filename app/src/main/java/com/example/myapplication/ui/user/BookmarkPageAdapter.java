package com.example.myapplication.ui.user;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.search.tabs.SoundTabFragment;
import com.example.myapplication.ui.search.tabs.UserTabFragment;
import com.example.myapplication.ui.search.tabs.VideoTabFragment;
import com.example.myapplication.ui.search.tabs.hashtag.HashTabFragment;

public class BookmarkPageAdapter extends FragmentStateAdapter {


    public BookmarkPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {


        if (position==0){
            return new VideoTabFragment();
        }

        else if(position==1){
            return new HashTabFragment();

        }
        else if(position==2){
            return new SoundTabFragment();

        }
        return new EffectTabFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}