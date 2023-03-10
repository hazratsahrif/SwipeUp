package com.example.myapplication.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentReposrtBinding;

import java.util.ArrayList;

import com.example.myapplication.adapter.ReportAdpater;


public class ReportFragment extends Fragment {

    FragmentReposrtBinding binding;
    ArrayList<String> textList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReposrtBinding.inflate(inflater,container,false);
        textList = new ArrayList<>();


        textList.add("Misleading information");
        textList.add("Dangerous organizations and individuals");
        textList.add("Illegal activities and regulated goods");
        textList.add("Violent and graphic content");
        textList.add("Animal cruelty");
        textList.add("Suicide, self-harm, and dangerous acts");
        textList.add("Hate speech");
        textList.add("Harassment or bullying");
        textList.add("Pornography and nudity");
        textList.add("Minor safety");
        textList.add("Spam");
        textList.add("Intellectual property infringement");
        textList.add("Other");
        ReportAdpater reportAdpater = new ReportAdpater(textList,getContext());
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setHasFixedSize(true);
        binding.rv.setAdapter(reportAdpater);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ReportFragment.this).navigateUp();
            }
        });

        return binding.getRoot();
    }
}