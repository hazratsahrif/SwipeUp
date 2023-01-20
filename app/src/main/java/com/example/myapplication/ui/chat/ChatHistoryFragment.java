package com.example.myapplication.ui.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentChatHistoryBinding;
import com.example.myapplication.models.ChatHistoryItemData;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.ChatHistoryAdapter;


public class ChatHistoryFragment extends Fragment implements ChatHistoryAdapter.OnClickListener {
    FragmentChatHistoryBinding binding;
    List<ChatHistoryItemData> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentChatHistoryBinding.inflate(inflater,container,false);
        list = new ArrayList<>();
        list.add(new ChatHistoryItemData(R.drawable.avatar,"James Mounter",
                "Late night in passing, mention it flip to her. Best friend, it's nothing, maybe it...",
                "5m","3",true,true,true
                ));
        list.add(new ChatHistoryItemData(R.drawable.avatar5,"Albert Williamson",
                "Ultrices rutrum mattis luctus mauris nulla. Elit tortor proin sed dictum id...",
                "5m","3",true,true,true
        ));
        list.add(new ChatHistoryItemData(R.drawable.avatar7,"James Mounter",
                "Late night in passing, mention it flip to her. Best friend, it's nothing, maybe it...",
                "2m","20",true,false,false
        ));
        list.add(new ChatHistoryItemData(R.drawable.avatar_4,"Serenity Williamson",
                "Vestibulum morbi mauris sed lectus. Id lectus in arcu netus lacus lacus vitae...",
                "5m","3",true,true,true
        ));
        list.add(new ChatHistoryItemData(R.drawable.avatar_4,"Jorge Richards",
                "Vel mi, condimentum arcu dui, turpis netus nibh. Ut non nisi nisl pretium am...",
                "3m","13",false,false,false
        ));
        list.add(new ChatHistoryItemData(R.drawable.avatar_4,"Brandie Murphy",
                "Diam, sed phasellus nibh vitae, et tristique amet urna. Augue lobortis nib...",
                "3m","13",false,false,false
        ));
        ChatHistoryAdapter adapter = new ChatHistoryAdapter(list,getContext(),this::onClick);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ChatHistoryFragment.this).navigate(R.id.action_chatHistoryFragment_to_addNewChatFragment);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });

//
        return binding.getRoot();
    }

    @Override
    public void onClick(boolean isClick) {
        NavHostFragment.findNavController(ChatHistoryFragment.this).navigate(R.id.action_chatHistoryFragment_to_chattingFragment);

    }
}