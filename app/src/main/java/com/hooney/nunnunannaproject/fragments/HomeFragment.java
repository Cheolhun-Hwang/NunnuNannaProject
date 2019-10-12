package com.hooney.nunnunannaproject.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.hooney.nunnunannaproject.R;
import com.hooney.nunnunannaproject.TestEyeActivity;
import com.hooney.nunnunannaproject.utils.DateUtil;
import com.hooney.nunnunannaproject.views.MainViewPager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private final int SIG_PERMISSION = 901;
    private static final int DP = 24;
    private String[] permissions = {
            Manifest.permission.CAMERA
    };

    private Button test_start;
    private View view;
    private ViewPager viewPager;
    private ArrayList<Integer> imageList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        initView();
        return view;
    }

    private void initView() {
        loadMainPage();
        ViewPager viewPager = view.findViewById(R.id.main_view_pager);
        viewPager.setClipToPadding(false);
        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new MainViewPager(getContext(), imageList));
    }

    private void loadMainPage() {
        imageList = new ArrayList();

        imageList.add(R.drawable.main_view_page_1);
        imageList.add(R.drawable.main_view_page_2);
        imageList.add(R.drawable.main_view_page_3);
        imageList.add(R.drawable.main_view_page_4);
        imageList.add(R.drawable.main_view_page_5);
        imageList.add(R.drawable.main_view_page_6);
    }

    private void init() {
        test_start = view.findViewById(R.id.test_start_btn);
        test_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermission()){
                    Intent intent = new Intent(getContext(), TestEyeActivity.class);
                    intent.putExtra("test_type", 0);
                    intent.putExtra("test_code", DateUtil.getCode());
                    startActivity(intent);
                }else{
                    commitPermission(SIG_PERMISSION);
                }
            }
        });
    }

    public boolean checkPermission(){
        boolean isAll = true;
        int permissionCheck = PackageManager.PERMISSION_GRANTED;

        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(getActivity(), permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                isAll = false;
                break;
            }
        }
        return isAll;
    }

    public void commitPermission(int SIG_PERMISSION){
        ActivityCompat.requestPermissions(getActivity(), permissions, SIG_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == SIG_PERMISSION){
            boolean isALL = true;
            for(int grant : grantResults){
                if(grant == PackageManager.PERMISSION_DENIED){
                    isALL = false;
                    break;
                }
            }

            if(!isALL){
                Toast.makeText(getActivity(), "모든 권한이 필요합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }



}
