package com.example.myapplication.ui.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentEffectTabBinding;
import com.example.myapplication.models.EffcetDataItem;

import java.util.ArrayList;

import com.example.myapplication.adapter.EffectAdapter;


public class EffectTabFragment extends Fragment {
 FragmentEffectTabBinding binding;
    ArrayList<EffcetDataItem> slist;
    EffectAdapter soundAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEffectTabBinding.inflate(inflater,container,false);
        slist= new ArrayList<>();

        slist.add(new EffcetDataItem(R.drawable.effect, "Green Screen", "Effect Assistant","2.4M"));
        slist.add(new EffcetDataItem(R.drawable.effect_1, "Green Screen Video", "Effect Assistant","2.4M"));
        slist.add(new EffcetDataItem(R.drawable.effect_2, "Face Zoom", "Effect Assistant","2.4M"));
        slist.add(new EffcetDataItem(R.drawable.effect_3, "Earthquake", "Effect Assistant","2.4M"));
        slist.add(new EffcetDataItem(R.drawable.effect_4, "In Love", "Effect Assistant","2.4M"));
        slist.add(new EffcetDataItem(R.drawable.effect_5, "Long Face", "Effect Assistant","2.4M"));





        soundAdapter = new EffectAdapter(slist,getContext());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(soundAdapter);
        return binding.getRoot();
    }
}