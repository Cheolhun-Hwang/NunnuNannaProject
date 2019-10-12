package com.hooney.nunnunannaproject;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hooney.nunnunannaproject.App.MyApplication;
import com.hooney.nunnunannaproject.fragments.HomeFragment;
import com.hooney.nunnunannaproject.fragments.ResultFragment;
import com.hooney.nunnunannaproject.fragments.SettingFragment;
import com.hooney.nunnunannaproject.rooms.entity.ResultData;
import com.hooney.nunnunannaproject.rooms.viewmodel.ResultViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private FragmentManager manager;
    private Button homeBtn, resultBtn, settingBtn;
    private HomeFragment homeFragment;
    private ResultFragment resultFragment;
    private SettingFragment settingFragment;

    private int isTab;

    private ResultViewModel resultViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
        setTab(0);
        setDatabases();

        startIntro();
    }

    private void startIntro() {
        startActivity(new Intent(getApplicationContext(), IntroActivity.class));
    }

    private void setDatabases() {
        resultViewModel = ViewModelProviders.of(MainActivity.this).get(ResultViewModel.class);
        resultViewModel.getResults().observe(MainActivity.this, new Observer<List<ResultData>>() {
            @Override
            public void onChanged(@Nullable List<ResultData> notes) {
                MyApplication.allResultData = notes;

                if(MyApplication.allResultData != null){
                   if(MyApplication.allResultData.size() > 0){
                       for(ResultData item : MyApplication.allResultData){
                           Log.i(TAG, item.getCode()+" / " + item.getType() + " / " + item.getCnt());
                       }
                   }
                }
            }
        });
    }

    private void initView() {
        homeBtn = findViewById(R.id.main_tab_home);
        resultBtn = findViewById(R.id.main_tab_result);
        settingBtn = findViewById(R.id.main_tab_setting);
    }

    private void init() {
        isTab = 0;
        manager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        resultFragment = new ResultFragment();
        settingFragment = new SettingFragment();
    }

    public void onTabClick(View view){
        switch (view.getId()){
            case R.id.main_tab_home:
                if(isTab!=0){
                    setTab(0);
                    isTab = 0;
                }
                break;
            case R.id.main_tab_result:
                if(isTab!=1){
                    setTab(1);
                    isTab = 1;
                }
                break;
            case R.id.main_tab_setting:
                if(isTab!=2){
                    setTab(2);
                    isTab = 2;
                }
                break;

        }
    }

    private void setTab(int index) {
        if(index == 0){
            homeBtn.setTextColor(getColor(R.color.main_color));
            homeBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.main_color)));
            resultBtn.setTextColor(getColor(R.color.tab_unselect));
            resultBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.tab_unselect)));
            settingBtn.setTextColor(getColor(R.color.tab_unselect));
            settingBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.tab_unselect)));
            switchFragment(homeFragment);
        }else if(index == 1){
            homeBtn.setTextColor(getColor(R.color.tab_unselect));
            homeBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.tab_unselect)));
            resultBtn.setTextColor(getColor(R.color.main_color));
            resultBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.main_color)));
            settingBtn.setTextColor(getColor(R.color.tab_unselect));
            settingBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.tab_unselect)));
            switchFragment(resultFragment);
        }else if(index == 2 ){
            homeBtn.setTextColor(getColor(R.color.tab_unselect));
            homeBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.tab_unselect)));
            resultBtn.setTextColor(getColor(R.color.tab_unselect));
            resultBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.tab_unselect)));
            settingBtn.setTextColor(getColor(R.color.main_color));
            settingBtn.setCompoundDrawableTintList(ColorStateList.valueOf(getColor(R.color.main_color)));
            switchFragment(settingFragment);
        }
    }

    private void switchFragment(Fragment fragment) {
        manager.beginTransaction().replace(R.id.container, fragment).commit();
    }

}
