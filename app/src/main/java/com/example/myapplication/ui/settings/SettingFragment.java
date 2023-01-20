package com.example.myapplication.ui.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSettingBinding;
import com.example.myapplication.models.SettingItems;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.SettingsAdapter;

public class SettingFragment extends Fragment implements SettingsAdapter.OnClickListener {
    FragmentSettingBinding binding;
    List<Integer> iconList;
    List list;

    List<Integer> actionID;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSettingBinding.inflate(inflater,container,false);
        iconList=new ArrayList<>();
        actionID=new ArrayList<>();
        init();
        list=new ArrayList<>();

        list.add("Account");
        list.add(new SettingItems(iconList.get(0),"Manage Account"));
        list.add(new SettingItems(iconList.get(1),"Privacy"));
        list.add(new SettingItems(iconList.get(2),"Safety"));
        list.add(new SettingItems(iconList.get(3),"Wallet"));
        list.add(new SettingItems(iconList.get(4),"Analytics"));
        list.add(new SettingItems(iconList.get(5),"Share Profile"));
        list.add("General");
        list.add(new SettingItems(iconList.get(6),"Notifications"));
        list.add(new SettingItems(iconList.get(7),"Language"));
        list.add("Support");
        list.add(new SettingItems(iconList.get(8),"Report a Problem"));
        list.add(new SettingItems(iconList.get(9),"Help Center"));
        list.add("About");
        list.add(new SettingItems(iconList.get(10),"Terms of Use"));
        list.add(new SettingItems(iconList.get(11),"Privacy Policy"));
        list.add(new SettingItems(iconList.get(12),"Copyright Policy"));
        list.add(new SettingItems(iconList.get(13),"Add Account"));
        list.add(new SettingItems(iconList.get(14),"Log Out"));
        SettingsAdapter adapter = new SettingsAdapter(list,getContext(),this::onClick);
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

    private void init() {
        iconList.add(R.drawable.profile);
        iconList.add(R.drawable.lock);
        iconList.add(R.drawable.shield___check);
        iconList.add(R.drawable.wallet);
        iconList.add(R.drawable.barchart);
        iconList.add(R.drawable.share);
        iconList.add(R.drawable.bell);
        iconList.add(R.drawable.globe);
        iconList.add(R.drawable.bug);
        iconList.add(R.drawable.lifebuoy);
        iconList.add(R.drawable.file___agreement);
        iconList.add(R.drawable.file___text);
        iconList.add(R.drawable.copyright);
        iconList.add(R.drawable.plus___larger);
        iconList.add(R.drawable.sign_out);

        actionID.add(null);
        actionID.add(R.id.action_settingFragment_to_manageAccountFragment);
        actionID.add(R.id.action_settingFragment_to_privacyFragment);
        actionID.add(R.id.action_settingFragment_to_safetyFragment);
        actionID.add(null);
        actionID.add(R.id.action_settingFragment_to_analyticsFragment);
        actionID.add(null);
        actionID.add(null);
        actionID.add(R.id.action_settingFragment_to_notificationFragment);
        actionID.add(R.id.action_settingFragment_to_languageFragment);
        actionID.add(null);
        actionID.add(null);
        actionID.add(R.id.action_settingFragment_to_helpCenterFragment);
        actionID.add(null);
        actionID.add(R.id.action_settingFragment_to_termsOfServiceFragment);
        actionID.add(null);
        actionID.add(R.id.action_settingFragment_to_articleFragment);
        actionID.add(null);
        actionID.add(null);
    }


    @Override
    public void onClick(int id) {
        if(actionID.get(id)==null){
            // exception
        }
        else {
            NavHostFragment.findNavController(SettingFragment.this).navigate(actionID.get(id));
        }

    }
}