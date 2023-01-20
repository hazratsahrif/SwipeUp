package com.example.myapplication.ui.user;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.chat.tabs.AllTabsFragmnet;
import com.example.myapplication.ui.chat.tabs.CommentsFragment;
import com.example.myapplication.ui.chat.tabs.FollowersTabFragment;
import com.example.myapplication.ui.chat.tabs.LikesTab;
import com.example.myapplication.ui.chat.tabs.MentionTabFragment;
import com.example.myapplication.ui.chat.tabs.SwipeUpTabFragment;
import com.example.myapplication.ui.search.tabs.VideoTabFragment;

public class UserPageAdapter extends FragmentStateAdapter {


    public UserPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
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
        return 2;
    }
}