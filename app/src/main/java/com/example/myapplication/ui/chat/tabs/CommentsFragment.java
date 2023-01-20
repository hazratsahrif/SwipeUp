package com.example.myapplication.ui.chat.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentCommentsBinding;
import com.example.myapplication.models.CommentItemData;

import java.util.ArrayList;

import com.example.myapplication.adapter.CommentTabAdapter;

public class CommentsFragment extends Fragment {
    FragmentCommentsBinding binding;
    RecyclerView recyclerView;
    ArrayList<CommentItemData> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCommentsBinding.inflate(inflater,container,false);
        recyclerView = binding.recyclerView;
        list= new ArrayList<>();
        list.add(new CommentItemData(R.drawable.avatar6,R.drawable.cover,"asideposes","2d","Wow, so wonderful \uD83D\uDE0D"));
        list.add(new CommentItemData(R.drawable.avatar5,R.drawable.cover_2_,"armholegetaway","3d","Looks like a heaven! Is your fluffy Max with you? \uD83D\uDC15"));
        list.add(new CommentItemData(R.drawable.avatar,R.drawable.cover,"appendageducktail","2d","I want to be here too \uD83D\uDE2D"));
        CommentTabAdapter adapter = new CommentTabAdapter(list,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}