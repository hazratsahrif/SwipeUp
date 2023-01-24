package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        );


//                transparentStatusAndNavigation();
        setContentView(binding.getRoot());


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setItemIconTintList(null);
        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) binding.navView.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,16)
                        .setTopLeftCorner(CornerFamily.ROUNDED,16)
                        .build());


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.discoverFragment, R.id.navigation_add,R.id.chatFragment,R.id.userFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.swipeLiveFragment);
//                binding.navView.setVisibility(View.GONE);
            }
        });
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                if (navDestination.getId()==R.id.QRCodeFragment || navDestination.getId()==R.id.scanQRCodeFragment  || navDestination.getId()==R.id.reposrtFragment
                        || navDestination.getId()==R.id.goLiveFragment
                        || navDestination.getId()==R.id.liveFragment
                        || navDestination.getId()==R.id.liveShareBottomSheet
                        || navDestination.getId()==R.id.filterBottomSheet
                        || navDestination.getId()==R.id.signInFragment
                        || navDestination.getId()==R.id.storyFragment
                        || navDestination.getId()==R.id.gifBottomSheet
                        || navDestination.getId()==R.id.swipeLiveFragment
                        || navDestination.getId()==R.id.hashTagResult
                        || navDestination.getId()==R.id.musicTabResult
                        || navDestination.getId()==R.id.bookMarkFragment
                        || navDestination.getId()==R.id.userProfileFragment
                        || navDestination.getId()==R.id.chatHistoryFragment
                        || navDestination.getId()==R.id.addNewChatFragment
                        || navDestination.getId()==R.id.chattingFragment
                        || navDestination.getId()==R.id.callBottomSheet
                        || navDestination.getId()==R.id.callFragment
                        || navDestination.getId()==R.id.profileChatDetailsFragment
                        || navDestination.getId()==R.id.videoCallFragment
                        || navDestination.getId()==R.id.settingFragment
                        || navDestination.getId()==R.id.notificationFragment
                        || navDestination.getId()==R.id.analyticsFragment
                        || navDestination.getId()==R.id.contentFragment
                        || navDestination.getId()==R.id.privacyFragment
                        || navDestination.getId()==R.id.safetyFragment
                        || navDestination.getId()==R.id.languageFragment
                        || navDestination.getId()==R.id.helpCenterFragment
                        || navDestination.getId()==R.id.termsOfServiceFragment
                        || navDestination.getId()==R.id.manageAccountFragment
                        || navDestination.getId()==R.id.articleFragment
                        || navDestination.getId()==R.id.signUpFragment
                        || navDestination.getId()==R.id.chooseUserNameFragment
                        || navDestination.getId()==R.id.choosePageNameFragment
                        || navDestination.getId()==R.id.setNewPasswordFragment
                        || navDestination.getId()==R.id.setPasswordFragment
                        || navDestination.getId()==R.id.signUpOtpFragment
                        || navDestination.getId()==R.id.birthDayFragment
                        || navDestination.getId()==R.id.emailTab
                        || navDestination.getId()==R.id.phoneTab
                        || navDestination.getId()==R.id.otpVerificationFragment
                        || navDestination.getId()==R.id.shareBottomSheet



                ){
                    binding.navView.setVisibility(View.GONE);
                }
                else {
                    binding.navView.setVisibility(View.VISIBLE);
                }
            }
        });
        
    }

//    private void transparentStatusAndNavigation() {
//        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
//            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
//        }
//        if (Build.VERSION.SDK_INT >= 19) {
//            getWindow().getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//            );
//        }
//        if (Build.VERSION.SDK_INT >= 21) {
//            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//        }
//    }
//    private void setWindowFlag(final int bits, boolean on) {
//        Window win = getWindow();
//        WindowManager.LayoutParams winParams = win.getAttributes();
//        if (on) {
//            winParams.flags |= bits;
//        } else {
//            winParams.flags &= ~bits;
//        }
//        win.setAttributes(winParams);
//    }
}
