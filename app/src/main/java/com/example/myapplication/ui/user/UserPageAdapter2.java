package com.example.myapplication.ui.user;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.search.tabs.VideoTabFragment;

public class UserPageAdapter2 extends FragmentStateAdapter {


    public UserPageAdapter2(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {


        if (position==0){
            return new VideoTabFragment();
        }

        else if(position==1){
            return new VideoTabFragment();

        }
        return new VideoTabFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}