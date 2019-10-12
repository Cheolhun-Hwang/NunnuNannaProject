package com.hooney.nunnunannaproject.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.hooney.nunnunannaproject.App.MyApplication;
import com.hooney.nunnunannaproject.R;
import com.hooney.nunnunannaproject.TestDetailActivity;
import com.hooney.nunnunannaproject.rooms.entity.ResultData;

import java.util.ArrayList;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private View view;
    private FragmentManager manager;
    private TabLayout tabLayout;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_result, container, false);
        init();
        initView();
        makeAlert();
        return view;
    }

    private void makeAlert() {
        ArrayList<String> key = new ArrayList<>();
        for(ResultData item : MyApplication.allResultData){
            if(!key.contains(item)){
                key.add(item.getCode());
            }
        }

        int b_1_r_b = 0;
        int b_2_r_b = 0;
        int b_3_r_b = 0;

        int b_1_l_b = 0;
        int b_2_l_b = 0;
        int b_3_l_b = 0;

        int b_1_r_t = 0;
        int b_2_r_t = 0;
        int b_3_r_t = 0;

        int b_1_l_t = 0;
        int b_2_l_t = 0;
        int b_3_l_t = 0;

        int cnt = 0;
        for(int index = key.size()-1;index> -1 ; index--){
            String code = key.get(index);
            for(ResultData item : MyApplication.allResultData){
                if(code.equals(item.getCode())){
                    if(item.getType() == 0){
                        if(cnt ==0){
                            b_1_l_b = item.getCnt();
                        }else if(cnt == 1){
                            b_2_l_b = item.getCnt();
                        }else if(cnt == 1){
                            b_3_l_b = item.getCnt();
                        }
                    }else if(item.getType() == 1){
                        if(cnt ==0){
                            b_1_r_b = item.getCnt();
                        }else if(cnt == 1){
                            b_2_r_b = item.getCnt();
                        }else if(cnt == 1){
                            b_3_r_b = item.getCnt();
                        }
                    }else if(item.getType() == 2){
                        if(cnt ==0){
                            b_1_r_t = item.getCnt();
                        }else if(cnt == 1){
                            b_2_r_t = item.getCnt();
                        }else if(cnt == 1){
                            b_3_r_t = item.getCnt();
                        }
                    }else if(item.getType() == 3){
                        if(cnt ==0){
                            b_1_l_t = item.getCnt();
                        }else if(cnt == 1){
                            b_2_l_t = item.getCnt();
                        }else if(cnt == 1){
                            b_3_l_t = item.getCnt();
                        }
                    }
                }
            }
            cnt += 1;
            if(cnt == 3){
                break;
            }
        }

        if( (((b_2_r_b-b_1_r_b) * (b_3_r_b-b_2_r_b)) > 3) ||
                (((b_2_l_b-b_1_l_b) * (b_3_l_b-b_2_l_b)) > 3) ||
                (((b_2_r_t-b_1_r_t) * (b_3_r_t-b_2_r_t)) > 3) ||
                (((b_2_l_t-b_1_l_t) * (b_3_l_t-b_2_l_t)) > 3)){
            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
            alert.setTitle("최근 3주 검사간 주의상태");
            alert.setMessage("최근 3회 검사에서\n증가 수치를 보이고 있습니다.\n가까운 시일 내에\n안과에 내원해 주세요.");
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }

    }

    private void init() {
        tabLayout = view.findViewById(R.id.result_tab_layout);
        manager = getActivity().getSupportFragmentManager();

        ResultGraphFragment fragment = new ResultGraphFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("eye_type", 0);
        fragment.setArguments(bundle);
        manager.beginTransaction().replace(R.id.result_fragment, fragment).commit();
    }

    private void initView() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ResultGraphFragment fragment = new ResultGraphFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("eye_type", tab.getPosition());
                fragment.setArguments(bundle);
                manager.beginTransaction().replace(R.id.result_fragment, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        view.findViewById(R.id.test_detail_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TestDetailActivity.class));
            }
        });
    }

}
