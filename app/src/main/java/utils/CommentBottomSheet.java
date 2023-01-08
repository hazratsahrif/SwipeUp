package utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentCommentBottomSheetBinding;
import com.example.myapplication.models.BottomCommentDataModel;
import com.example.myapplication.models.CommentDataModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import adapter.CommentAdapter;
import adapter.EmojisAdapter;

public class CommentBottomSheet extends BottomSheetDialogFragment implements CommentAdapter.onLongPress {
    FragmentCommentBottomSheetBinding binding;

    List<CommentDataModel> childList;
    List<BottomCommentDataModel> list;
    List<String> emojiList;
    CommentAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCommentBottomSheetBinding.inflate(inflater,container,false);
//        View bottomSheet = binding.bottomsheet;
//        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
//        behavior.setPeekHeight(650);
        childList = new ArrayList<>();
        list = new ArrayList<>();
        emojiList = new ArrayList<>();
        emojiList.add("\uD83D\uDC4D");
        emojiList.add("\uD83D\uDC4E");
        emojiList.add("\uD83C\uDF89");
        emojiList.add("\uD83D\uDE0D");
        emojiList.add("\uD83C\uDF77");
        emojiList.add("\uD83D\uDE2E");
        emojiList.add("\uD83C\uDF89");
        emojiList.add("\uD83D\uDD25");
        emojiList.add("\uD83D\uDC4F");
        emojiList.add("\uD83D\uDE31");
        emojiList.add("\uD83D\uDCAF");
        emojiList.add("\uD83D\uDE25");

        EmojisAdapter emojiSAdapter = new EmojisAdapter(emojiList);
        binding.rvEmoji.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.rvEmoji.setHasFixedSize(true);
        binding.rvEmoji.setAdapter(emojiSAdapter);

        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });



        childList.add(new CommentDataModel("travelguru","2d","It’s a sectet :)",R.drawable.regular,true,false));
//        childList.add(new CommentDataModel("travelguru","2d","It’s a sectet :)",R.drawable.kris,true));
//        childList.add(new CommentDataModel("travelguru","2d","It’s a sectet :)",R.drawable.ann,false));
        list.add(new BottomCommentDataModel(childList,"travelguru","1w","In integer suspendisse ridiculus vulputate  tortor egestas",R.drawable.regular,true));
        list.add(new BottomCommentDataModel(childList,"travelguru","1w","In integer suspendisse ridiculus vulputate  tortor egestas",R.drawable.james,false));
        adapter = new CommentAdapter(list,getContext(),this::onPress);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.rv.setHasFixedSize(true);
        binding.rv.setAdapter(adapter);
        return binding.getRoot();
    }
    @Override public int getTheme() {
        return R.style.CustomBottomSheetDialog;
    }

    @Override
    public void onPress(boolean isClick) {
        NavHostFragment.findNavController(CommentBottomSheet.this).navigate(R.id.action_commentBottomSheet_to_copyDialogFragment);

    }
}