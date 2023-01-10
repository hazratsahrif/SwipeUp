package adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.live.bottomtabs.RecentTab;
import com.example.myapplication.ui.search.tabs.HashTabFragment;
import com.example.myapplication.ui.search.tabs.SoundTabFragment;
import com.example.myapplication.ui.search.tabs.TopFragmentTab;
import com.example.myapplication.ui.search.tabs.UserTabFragment;
import com.example.myapplication.ui.search.tabs.VideoTabFragment;


public class GifPagerAdapter extends FragmentStateAdapter {


    public GifPagerAdapter(@NonNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new RecentTab();
        }
        else if(position==1){
            return new RecentTab();

        }
        else if(position==2){
            return new RecentTab();

        }
        return new RecentTab();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}