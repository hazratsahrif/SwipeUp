package com.example.myapplication.ui.search.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSoundTabBinding;
import com.example.myapplication.models.SoundModel;

import java.util.ArrayList;

import com.example.myapplication.adapter.SoundAdapter;


public class SoundTabFragment extends Fragment implements SoundAdapter.OnClickListener {
    FragmentSoundTabBinding binding;
    ArrayList<SoundModel> slist;
    SoundAdapter soundAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSoundTabBinding.inflate(inflater,container,false);
        slist= new ArrayList<>();

        slist.add(new SoundModel(R.drawable.playback, "Travel Time", "Vivamus Lectus"));
        slist.add(new SoundModel(R.drawable.plazback2, "Travel Story", "Orci Eget"));
        slist.add(new SoundModel(R.drawable.playback, "Travel Time", "Vivamus Lectus"));
        slist.add(new SoundModel(R.drawable.plazback2, "Travel Story", "Orci Eget"));
        slist.add(new SoundModel(R.drawable.playback, "Travel Time", "Vivamus Lectus"));
        slist.add(new SoundModel(R.drawable.plazback2, "Travel Story", "Orci Eget"));
        slist.add(new SoundModel(R.drawable.playback, "Travel Time", "Vivamus Lectus"));
        slist.add(new SoundModel(R.drawable.plazback2, "Travel Story", "Orci Eget"));
        slist.add(new SoundModel(R.drawable.playback, "Travel Time", "Vivamus Lectus"));


        soundAdapter = new SoundAdapter(slist,  getContext(),this );
        binding.rvStab.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.rvStab.setHasFixedSize(true);
        binding.rvStab.setAdapter(soundAdapter);


        return binding.getRoot();

    }

    @Override
    public void onClick(boolean isClick) {
        NavHostFragment.findNavController(SoundTabFragment.this).navigate(R.id.action_searchItemFragment_to_musicTabResult);

    }
}