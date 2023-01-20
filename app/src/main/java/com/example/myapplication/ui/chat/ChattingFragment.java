package com.example.myapplication.ui.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentChatingBinding;
import com.example.myapplication.models.ChatRow1Item;
import com.example.myapplication.models.ChatRow2Item;
import com.example.myapplication.models.ChatRow3Item;
import com.example.myapplication.models.ChatRow4Item;
import com.example.myapplication.models.ChatRow5Item;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.ChattingAdapter;


public class ChattingFragment extends Fragment {
    FragmentChatingBinding binding;
    ChattingAdapter adapter;
    List list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatingBinding.inflate(inflater,container,false);
        list = new ArrayList<>();
        list.add(new ChatRow1Item("Today"));
        list.add(new ChatRow2Item("Leo risus scelerisque proin nisl dolor montes. Tellus diam faucibus dictum sapien donec"));
        list.add(new ChatRow3Item("Morbi vulputate faucibus risus, iaculis gravida a sit velit ipsu"));
        list.add(new ChatRow3Item("Nibh laoreet vehicula ipsum orci nibh augue. Lorem odio et"));
        list.add(new ChatRow4Item(R.drawable.cover_2_));
        list.add(new ChatRow5Item("0:32"));
        adapter = new ChattingAdapter(list,getContext());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ChattingFragment.this).navigateUp();
            }
        });
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ChattingFragment.this).navigate(R.id.action_chattingFragment_to_callBottomSheet);
            }
        });
        binding.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ChattingFragment.this).navigate(R.id.action_chattingFragment_to_profileChatDetailsFragment);
            }
        });
        binding.btbLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ChattingFragment.this).navigate(R.id.action_chattingFragment_to_settingFragment);

            }
        });

        return binding.getRoot();
    }
}