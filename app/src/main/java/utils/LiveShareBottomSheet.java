package utils;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLiveShareBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import adapter.ActionAdapterClass;
import adapter.ProfileAdapterClass;
import adapter.SocialAdapterClass;
import model.ActionModel;
import model.ProfileClass;
import model.SocialModel;

public class LiveShareBottomSheet extends BottomSheetDialogFragment {
    FragmentLiveShareBottomSheetBinding binding;
    ArrayList<ProfileClass> itemClasses ;
    ArrayList<SocialModel> socialItem;

    RecyclerView rvProfile, rvSocial;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLiveShareBottomSheetBinding.inflate(inflater,container,false);
        rvProfile= binding.rvProfile;
        rvSocial= binding.rvSocial;

        itemClasses = new ArrayList<>();
        socialItem = new ArrayList<>();
        setData();
        setAdapter();
        return binding.getRoot();
    }
    @Override public int getTheme() {
        return R.style.CustomBottomSheetDialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void setAdapter() {
        rvProfile.setHasFixedSize(true);
        rvProfile.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        ProfileAdapterClass adapterClass = new ProfileAdapterClass(itemClasses,getContext());
        rvProfile.setAdapter(adapterClass);

        SocialAdapterClass socialAdapterClass = new SocialAdapterClass(socialItem,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        manager.setStackFromEnd(true);
        rvSocial.setLayoutManager(manager);
        rvSocial.setAdapter(socialAdapterClass);

    }

    private void setData() {

        itemClasses.add(new ProfileClass("Annette Black",R.drawable.regular_4));
        itemClasses.add(new ProfileClass("Annette Black",R.drawable.regular));
        itemClasses.add(new ProfileClass("Annette Black",R.drawable.regular_2));
        itemClasses.add(new ProfileClass("Annette Black",R.drawable.regular_3));
        itemClasses.add(new ProfileClass("Annette Black",R.drawable.regular));
        itemClasses.add(new ProfileClass("Annette Black",R.drawable.regular_5));

        socialItem.add(new SocialModel(ContextCompat.getColor(getContext(),R.color.red),R.drawable.union,"Copy link"));
        socialItem.add(new SocialModel(ContextCompat.getColor(getContext(),R.color.color_telegram),R.drawable.frame,"Telegram "));
        socialItem.add(new SocialModel(ContextCompat.getColor(getContext(),R.color.color_viber),R.drawable.viber,"Viber"));
        socialItem.add(new SocialModel(ContextCompat.getColor(getContext(),R.color.fb_color),R.drawable.fb,"Facebook"));
        socialItem.add(new SocialModel(ContextCompat.getColor(getContext(),R.color.sms_color),R.drawable.sms,"Sms"));
        socialItem.add(new SocialModel(ContextCompat.getColor(getContext(),R.color.twitter_color),R.drawable.twitter_2,"Twitter"));
    }
}