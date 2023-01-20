package com.example.myapplication.ui.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddNewChatBinding;
import com.example.myapplication.models.SearchChatItem;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.SearchChatAdapter;


public class AddNewChatFragment extends Fragment {
    FragmentAddNewChatBinding binding;
    List list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddNewChatBinding.inflate(inflater,container,false);
        list = new ArrayList();
        list.add("A");
        list.add(new SearchChatItem(R.drawable.avatar,"asideposes","Jacob Jones"));
        list.add(new SearchChatItem(R.drawable.avatar_4,"asideposes","Jacob Jones"));
        list.add("B");
        list.add(new SearchChatItem(R.drawable.avatar7,"bneadgenes","Eleanor Pena"));
        list.add(new SearchChatItem(R.drawable.avatar5,"bermonpetted","Courtney Henry"));
        list.add(new SearchChatItem(R.drawable.avatar,"bcalliondismay","bcalliondismay"));
        list.add("C");
        list.add(new SearchChatItem(R.drawable.avatar_1,"canarylarruped","Devon Lane"));
        list.add(new SearchChatItem(R.drawable.avatar_f,"cupermanprompter","Jerome Bell"));
        list.add(new SearchChatItem(R.drawable.avatar6,"covertonecallisto","Floyd Miles"));
        SearchChatAdapter adapter = new SearchChatAdapter(list,getContext());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AddNewChatFragment.this).navigateUp();
            }
        });
        return binding.getRoot();

    }
}