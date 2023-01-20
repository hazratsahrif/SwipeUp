package com.example.myapplication.ui.chat.tabs;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAllTabsFragmnetBinding;
import com.example.myapplication.models.AllTabItemOneData;
import com.example.myapplication.models.AllTabItemTwoData;
import com.example.myapplication.ui.Add.AddViewModel;
import java.util.ArrayList;

import com.example.myapplication.adapter.AllTabAdapter;

public class AllTabsFragmnet extends Fragment {
    FragmentAllTabsFragmnetBinding binding;
    ArrayList list;
    AllTabAdapter adpater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AddViewModel notificationsViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);
        binding = FragmentAllTabsFragmnetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        list = new ArrayList<>();
        list.add(new AllTabItemOneData(R.drawable.avatar_f,R.drawable.avatar_g_,"armholegetaway","mixtapenegative","liked your video ・ 20m",R.drawable.cover,false));
        list.add(new AllTabItemOneData(R.drawable.avatar,R.drawable.avatar_1,"appendageducktail","sermonpetted","liked your video ・ 1h",R.drawable.cover_1_,false));
        list.add(new AllTabItemTwoData(R.drawable.avatar_3,"asideposes","started following you ・ 1h",false));
        list.add(new AllTabItemTwoData(R.drawable.avatar_1,"appendageducktail","started following you ・ 1h",false));
        list.add(new AllTabItemTwoData(R.drawable.avatar5,"appendageducktail","started following you ・ 1h",true));

        list.add(new AllTabItemOneData(R.drawable.avatar6,R.drawable.avatar_4,"asideposes, kneadgenes","16 more","liked your video ・ 12h",R.drawable.cover_2_,false));

        list.add(new AllTabItemTwoData(R.drawable.avatar6,"sermonpetted","started following you ・ 1h",false));
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adpater = new AllTabAdapter(list,getContext());
        binding.rv.setAdapter(adpater);
        return root;
    }

}