package com.example.myapplication.ui.live;
import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentStoryBinding;


import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.StoryFooterAdapter;
import jp.shts.android.storiesprogressview.StoriesProgressView;

public class StoryFragment extends Fragment implements StoriesProgressView.StoriesListener, StoryFooterAdapter.OnMessageButtonClick{

    private static final int PROGRESS_COUNT = 4;
    StoriesProgressView storiesProgressView;
    FragmentStoryBinding binding;
     List<Integer> myList;
     List<String> emojiList;
     boolean isVisible=false;
     int next=-1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStoryBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        myList = new ArrayList<>();
        myList.add(R.drawable.pic33);
        myList.add(R.drawable.rectangle);
        myList.add(R.drawable.scanback);
        myList.add(R.drawable.story_back);

        storiesProgressView = binding.stories;
        storiesProgressView.setStoriesCount(PROGRESS_COUNT); // <- set stories
        storiesProgressView.setStoryDuration(3200L);
        storiesProgressView.startStories();
        storiesProgressView.setStoriesListener(this);

        emojiList= new ArrayList<>();
        emojiList.add("\uD83D\uDC4D");
        emojiList.add("\uD83D\uDC4E");
        emojiList.add("\uD83D\uDE0D");
        emojiList.add("\uD83D\uDE0D");
        emojiList.add("\uD83D\uDE2E");
        emojiList.add("\uD83C\uDF89");
        emojiList.add("\uD83D\uDD25");
        emojiList.add("\uD83D\uDC4F");

        setAdapter();
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StoryFragment.this).navigateUp();
            }
        });

        return  view;
    }



    private void setAdapter() {
        StoryFooterAdapter adapter = new StoryFooterAdapter(emojiList,this::onClick,getContext(),isVisible);

        binding.rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.rv.setHasFixedSize(true);
        binding.rv.setAdapter(adapter);

    }
    @Override
    public void onClick(boolean isFlag,boolean isSharedClick,boolean isMoreClick) {

        if(isFlag){
            setKeyBoard();
        }
        if(isSharedClick){
            NavHostFragment.findNavController(StoryFragment.this).navigate(R.id.action_storyFragment_to_liveShareBottomSheet);

        }
        if(isMoreClick){
            NavHostFragment.findNavController(StoryFragment.this).navigate(R.id.action_storyFragment_to_gifBottomSheet);

        }
    }

    private void setKeyBoard() {
        binding.footer.setVisibility(View.VISIBLE);
        binding.etMessage.setFocusableInTouchMode(true);
        binding.etMessage.setFocusable(true);
        binding.etMessage.requestFocus();
        binding.etMessage.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    // Your action on done
                    binding.footer.setVisibility(View.GONE);
                    InputMethodManager mgr = (InputMethodManager)
                     getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    mgr.hideSoftInputFromWindow(binding.etMessage.getWindowToken(),0);
                    binding.etMessage.setFocusableInTouchMode(false);
                    binding.etMessage.setFocusable(false);
                    binding.etMessage.requestFocus();
                    binding.footer.setVisibility(View.GONE);
                    binding.etMessage.setText("");
                    isVisible=false;
                    StoryFooterAdapter adapter = new StoryFooterAdapter(emojiList,StoryFragment.this::onClick,getContext(),isVisible);
                    adapter.notifyDataSetChanged();
                    binding.rv.setAdapter(adapter);
                    return true;
                }
                return false;
            }
        });
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(binding.etMessage, InputMethodManager.SHOW_IMPLICIT);
    }

    @Override
    public void onNext() {
        next++;
        binding.layout.setBackground(ContextCompat.getDrawable(getContext(),myList.get(next)));
    }

    @Override
    public void onPrev() {
        next--;
        binding.layout.setBackground(ContextCompat.getDrawable(getContext(),myList.get(next)));

    }

    @Override
    public void onComplete() {

    }
}