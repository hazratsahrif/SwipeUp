package com.example.myapplication.ui.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentNotificationBinding;
import com.example.myapplication.models.NotificationDataItem;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.NotificationAdapter;


public class NotificationFragment extends Fragment {

    FragmentNotificationBinding binding;
    List list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater,container,false);
        list = new ArrayList<>();

        list.add("Interactions");

        list.add(new NotificationDataItem("Likes"));
        list.add(new NotificationDataItem("Comments"));
        list.add(new NotificationDataItem("New followers"));
        list.add(new NotificationDataItem("Mentions"));
        list.add("Messages");
        list.add(new NotificationDataItem("Direct messages"));
        list.add("Video updates");
        list.add(new NotificationDataItem("Videos from accounts you follow"));
        list.add(new NotificationDataItem("Video suggestions"));
        list.add("Live");
        list.add(new NotificationDataItem("Livestreams from accounts you follow"));
        list.add(new NotificationDataItem("Recommended broadcasts"));
        list.add("Other");
        list.add(new NotificationDataItem("Customized updates and more"));

        NotificationAdapter adapter = new NotificationAdapter(list,getContext());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
         binding.recyclerView.setHasFixedSize(true);
         binding.recyclerView.setAdapter(adapter);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });
        return binding.getRoot();
    }
}