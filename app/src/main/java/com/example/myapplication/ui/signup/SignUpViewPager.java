package com.example.myapplication.ui.signup;

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
import com.example.myapplication.ui.signup.tabs.EmailTab;
import com.example.myapplication.ui.signup.tabs.PhoneTab;

public class SignUpViewPager extends FragmentStateAdapter {
    public SignUpViewPager(@NonNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new PhoneTab();
        }
        return new EmailTab();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}