package com.hooney.nunnunannaproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.hooney.nunnunannaproject.App.MyApplication;
import com.hooney.nunnunannaproject.fragments.EyeMatrixFragment;
import com.hooney.nunnunannaproject.rooms.entity.ResultData;

public class TestGapMatrixActivity extends AppCompatActivity {
    private String code;
    private String beforeCode;

    private EyeMatrixFragment right, left;
    private FragmentManager manager;

    private String type_1_res;
    private String type_2_res;
    private String type_3_res;
    private String type_4_res;

    private int before_type_1_cnt, before_type_2_cnt, before_type_3_cnt, before_type_4_cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gap_matrix);

        code = getIntent().getStringExtra("test_code");

        setBar(getSupportActionBar());
        init();

        initView();
    }

    private void initView() {
//        Log.d("Bundle", "eye_black : " + type_1_res);
//        Log.d("Bundle", "eye_twink : " + type_3_res);
//        Log.d("Bundle", "eye_black : " + type_2_res);
//        Log.d("Bundle", "eye_twink : " + type_4_res);
//        Log.d("Bundle", "b_eye_black : " + before_type_1_cnt);
//        Log.d("Bundle", "b_eye_twink : " + before_type_3_cnt);
//        Log.d("Bundle", "b_eye_black : " + before_type_2_cnt);
//        Log.d("Bundle", "b_eye_twink : " + before_type_4_cnt);
        right = new EyeMatrixFragment();
        Bundle bundle = new Bundle();
        bundle.putString("eye_title", "오른쪽 눈");
        bundle.putString("eye_black", type_1_res);
        bundle.putString("eye_twink", type_3_res);
        bundle.putInt("b_eye_black", before_type_1_cnt);
        bundle.putInt("b_eye_twink", before_type_3_cnt);
        right.setArguments(bundle);

        left = new EyeMatrixFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("eye_title", "왼쪽 눈");
        bundle2.putString("eye_black", type_2_res);
        bundle2.putString("eye_twink", type_4_res);
        bundle2.putInt("b_eye_black", before_type_2_cnt);
        bundle2.putInt("b_eye_twink", before_type_4_cnt);
        left.setArguments(bundle2);

        manager.beginTransaction().replace(R.id.frame_right_eye, right).commit();
        manager.beginTransaction().replace(R.id.frame_left_eye, left).commit();
    }

    private void init() {
        manager = getSupportFragmentManager();
        beforeCode = "None";
        type_1_res = "";
        type_2_res = "";
        type_3_res = "";
        type_4_res = "";

        for (int index = 0 ; index < MyApplication.allResultData.size(); index++){
            ResultData item = MyApplication.allResultData.get(index);
            if(item.getCode().equals(code) ){
                if(item.getType() == 0 ){
                    type_1_res = item.getResult();
                    if(index != 0){
                        beforeCode = MyApplication.allResultData.get(index-1).getCode();
                    }
                }else if(item.getType() == 1 ){
                    type_2_res = item.getResult();
                }else if(item.getType() == 2 ){
                    type_3_res = item.getResult();
                }else if(item.getType() == 3 ){
                    type_4_res = item.getResult();
                }
            }
        }



       if(beforeCode!= "None"){
           for (int index = 0 ; index < MyApplication.allResultData.size(); index++){
               ResultData item = MyApplication.allResultData.get(index);

               if(item.getCode() == beforeCode){
                   if(item.getType() == 0 ){
                       before_type_1_cnt = item.getCnt();
                   }else if(item.getType() == 1 ){
                       before_type_2_cnt = item.getCnt();
                   }else if(item.getType() == 2 ){
                       before_type_3_cnt = item.getCnt();
                   }else if(item.getType() == 3 ){
                       before_type_4_cnt = item.getCnt();
                   }
               }
           }
       }
    }

    private void setBar(ActionBar bar) {
        String year = code.substring(0, 4);
        String month = code.substring(4, 6);
        String day = code.substring(6,8);
        bar.setTitle(year+"."+month+"."+day);
    }
}
