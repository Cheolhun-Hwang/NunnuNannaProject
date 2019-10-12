package com.hooney.nunnunannaproject.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hooney.nunnunannaproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EyeMatrixFragment extends Fragment {
    private View view;

    private TextView title;
    private TextView before_black;
    private TextView before_twink;

    private int now_cnt_black;
    private int now_cnt_twink;
    private int before_cnt_black;
    private int before_cnt_twink;

    private int [][] cntList;

    public EyeMatrixFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_eye_matrix, container, false);

        init();
        initView();
        return view;
    }

    private void initView() {
        title = view.findViewById(R.id.eye_title);
        title.setText(getArguments().getString("eye_title"));

        for(int index = 0 ; index<20;index++){
            for(int j = 0 ; j<20;j++){
                Log.d("Test", "cnt LIst : " + cntList[index][j] + "/ i,j : " + index+","+j);
                setMatrixColor(index, j, cntList[index][j]);
            }
        }
    }

    private void setMatrixColor(int x, int y, int cnt) {
        int id = R.id.grid_index_0_0;
        if(x == 0 && y == 0){id = R.id.grid_index_0_0;}
        else if(x == 0 && y == 1){id = R.id.grid_index_0_1;}
        else if(x == 0 && y == 2){id = R.id.grid_index_0_2;}
        else if(x == 0 && y == 3){id = R.id.grid_index_0_3;}
        else if(x == 0 && y == 4){id = R.id.grid_index_0_4;}
        else if(x == 0 && y == 5){id = R.id.grid_index_0_5;}
        else if(x == 0 && y == 6){id = R.id.grid_index_0_6;}
        else if(x == 0 && y == 7){id = R.id.grid_index_0_7;}
        else if(x == 0 && y == 8){id = R.id.grid_index_0_8;}
        else if(x == 0 && y == 9){id = R.id.grid_index_0_9;}
        else if(x == 0 && y == 10){id = R.id.grid_index_0_10;}
        else if(x == 0 && y == 11){id = R.id.grid_index_0_11;}
        else if(x == 0 && y == 12){id = R.id.grid_index_0_12;}
        else if(x == 0 && y == 13){id = R.id.grid_index_0_13;}
        else if(x == 0 && y == 14){id = R.id.grid_index_0_14;}
        else if(x == 0 && y == 15){id = R.id.grid_index_0_15;}
        else if(x == 0 && y == 16){id = R.id.grid_index_0_16;}
        else if(x == 0 && y == 17){id = R.id.grid_index_0_17;}
        else if(x == 0 && y == 18){id = R.id.grid_index_0_18;}
        else if(x == 0 && y == 19){id = R.id.grid_index_0_19;}
        else if(x == 1 && y == 0){id = R.id.grid_index_1_0;}
        else if(x == 1 && y == 1){id = R.id.grid_index_1_1;}
        else if(x == 1 && y == 2){id = R.id.grid_index_1_2;}
        else if(x == 1 && y == 3){id = R.id.grid_index_1_3;}
        else if(x == 1 && y == 4){id = R.id.grid_index_1_4;}
        else if(x == 1 && y == 5){id = R.id.grid_index_1_5;}
        else if(x == 1 && y == 6){id = R.id.grid_index_1_6;}
        else if(x == 1 && y == 7){id = R.id.grid_index_1_7;}
        else if(x == 1 && y == 8){id = R.id.grid_index_1_8;}
        else if(x == 1 && y == 9){id = R.id.grid_index_1_9;}
        else if(x == 1 && y == 10){id = R.id.grid_index_1_10;}
        else if(x == 1 && y == 11){id = R.id.grid_index_1_11;}
        else if(x == 1 && y == 12){id = R.id.grid_index_1_12;}
        else if(x == 1 && y == 13){id = R.id.grid_index_1_13;}
        else if(x == 1 && y == 14){id = R.id.grid_index_1_14;}
        else if(x == 1 && y == 15){id = R.id.grid_index_1_15;}
        else if(x == 1 && y == 16){id = R.id.grid_index_1_16;}
        else if(x == 1 && y == 17){id = R.id.grid_index_1_17;}
        else if(x == 1 && y == 18){id = R.id.grid_index_1_18;}
        else if(x == 1 && y == 19){id = R.id.grid_index_1_19;}
        else if(x == 2 && y == 0){id = R.id.grid_index_2_0;}
        else if(x == 2 && y == 1){id = R.id.grid_index_2_1;}
        else if(x == 2 && y == 2){id = R.id.grid_index_2_2;}
        else if(x == 2 && y == 3){id = R.id.grid_index_2_3;}
        else if(x == 2 && y == 4){id = R.id.grid_index_2_4;}
        else if(x == 2 && y == 5){id = R.id.grid_index_2_5;}
        else if(x == 2 && y == 6){id = R.id.grid_index_2_6;}
        else if(x == 2 && y == 7){id = R.id.grid_index_2_7;}
        else if(x == 2 && y == 8){id = R.id.grid_index_2_8;}
        else if(x == 2 && y == 9){id = R.id.grid_index_2_9;}
        else if(x == 2 && y == 10){id = R.id.grid_index_2_10;}
        else if(x == 2 && y == 11){id = R.id.grid_index_2_11;}
        else if(x == 2 && y == 12){id = R.id.grid_index_2_12;}
        else if(x == 2 && y == 13){id = R.id.grid_index_2_13;}
        else if(x == 2 && y == 14){id = R.id.grid_index_2_14;}
        else if(x == 2 && y == 15){id = R.id.grid_index_2_15;}
        else if(x == 2 && y == 16){id = R.id.grid_index_2_16;}
        else if(x == 2 && y == 17){id = R.id.grid_index_2_17;}
        else if(x == 2 && y == 18){id = R.id.grid_index_2_18;}
        else if(x == 2 && y == 19){id = R.id.grid_index_2_19;}
        else if(x == 3 && y == 0){id = R.id.grid_index_3_0;}
        else if(x == 3 && y == 1){id = R.id.grid_index_3_1;}
        else if(x == 3 && y == 2){id = R.id.grid_index_3_2;}
        else if(x == 3 && y == 3){id = R.id.grid_index_3_3;}
        else if(x == 3 && y == 4){id = R.id.grid_index_3_4;}
        else if(x == 3 && y == 5){id = R.id.grid_index_3_5;}
        else if(x == 3 && y == 6){id = R.id.grid_index_3_6;}
        else if(x == 3 && y == 7){id = R.id.grid_index_3_7;}
        else if(x == 3 && y == 8){id = R.id.grid_index_3_8;}
        else if(x == 3 && y == 9){id = R.id.grid_index_3_9;}
        else if(x == 3 && y == 10){id = R.id.grid_index_3_10;}
        else if(x == 3 && y == 11){id = R.id.grid_index_3_11;}
        else if(x == 3 && y == 12){id = R.id.grid_index_3_12;}
        else if(x == 3 && y == 13){id = R.id.grid_index_3_13;}
        else if(x == 3 && y == 14){id = R.id.grid_index_3_14;}
        else if(x == 3 && y == 15){id = R.id.grid_index_3_15;}
        else if(x == 3 && y == 16){id = R.id.grid_index_3_16;}
        else if(x == 3 && y == 17){id = R.id.grid_index_3_17;}
        else if(x == 3 && y == 18){id = R.id.grid_index_3_18;}
        else if(x == 3 && y == 19){id = R.id.grid_index_3_19;}
        else if(x == 4 && y == 0){id = R.id.grid_index_4_0;}
        else if(x == 4 && y == 1){id = R.id.grid_index_4_1;}
        else if(x == 4 && y == 2){id = R.id.grid_index_4_2;}
        else if(x == 4 && y == 3){id = R.id.grid_index_4_3;}
        else if(x == 4 && y == 4){id = R.id.grid_index_4_4;}
        else if(x == 4 && y == 5){id = R.id.grid_index_4_5;}
        else if(x == 4 && y == 6){id = R.id.grid_index_4_6;}
        else if(x == 4 && y == 7){id = R.id.grid_index_4_7;}
        else if(x == 4 && y == 8){id = R.id.grid_index_4_8;}
        else if(x == 4 && y == 9){id = R.id.grid_index_4_9;}
        else if(x == 4 && y == 10){id = R.id.grid_index_4_10;}
        else if(x == 4 && y == 11){id = R.id.grid_index_4_11;}
        else if(x == 4 && y == 12){id = R.id.grid_index_4_12;}
        else if(x == 4 && y == 13){id = R.id.grid_index_4_13;}
        else if(x == 4 && y == 14){id = R.id.grid_index_4_14;}
        else if(x == 4 && y == 15){id = R.id.grid_index_4_15;}
        else if(x == 4 && y == 16){id = R.id.grid_index_4_16;}
        else if(x == 4 && y == 17){id = R.id.grid_index_4_17;}
        else if(x == 4 && y == 18){id = R.id.grid_index_4_18;}
        else if(x == 4 && y == 19){id = R.id.grid_index_4_19;}
        else if(x == 5 && y == 0){id = R.id.grid_index_5_0;}
        else if(x == 5 && y == 1){id = R.id.grid_index_5_1;}
        else if(x == 5 && y == 2){id = R.id.grid_index_5_2;}
        else if(x == 5 && y == 3){id = R.id.grid_index_5_3;}
        else if(x == 5 && y == 4){id = R.id.grid_index_5_4;}
        else if(x == 5 && y == 5){id = R.id.grid_index_5_5;}
        else if(x == 5 && y == 6){id = R.id.grid_index_5_6;}
        else if(x == 5 && y == 7){id = R.id.grid_index_5_7;}
        else if(x == 5 && y == 8){id = R.id.grid_index_5_8;}
        else if(x == 5 && y == 9){id = R.id.grid_index_5_9;}
        else if(x == 5 && y == 10){id = R.id.grid_index_5_10;}
        else if(x == 5 && y == 11){id = R.id.grid_index_5_11;}
        else if(x == 5 && y == 12){id = R.id.grid_index_5_12;}
        else if(x == 5 && y == 13){id = R.id.grid_index_5_13;}
        else if(x == 5 && y == 14){id = R.id.grid_index_5_14;}
        else if(x == 5 && y == 15){id = R.id.grid_index_5_15;}
        else if(x == 5 && y == 16){id = R.id.grid_index_5_16;}
        else if(x == 5 && y == 17){id = R.id.grid_index_5_17;}
        else if(x == 5 && y == 18){id = R.id.grid_index_5_18;}
        else if(x == 5 && y == 19){id = R.id.grid_index_5_19;}
        else if(x == 6 && y == 0){id = R.id.grid_index_6_0;}
        else if(x == 6 && y == 1){id = R.id.grid_index_6_1;}
        else if(x == 6 && y == 2){id = R.id.grid_index_6_2;}
        else if(x == 6 && y == 3){id = R.id.grid_index_6_3;}
        else if(x == 6 && y == 4){id = R.id.grid_index_6_4;}
        else if(x == 6 && y == 5){id = R.id.grid_index_6_5;}
        else if(x == 6 && y == 6){id = R.id.grid_index_6_6;}
        else if(x == 6 && y == 7){id = R.id.grid_index_6_7;}
        else if(x == 6 && y == 8){id = R.id.grid_index_6_8;}
        else if(x == 6 && y == 9){id = R.id.grid_index_6_9;}
        else if(x == 6 && y == 10){id = R.id.grid_index_6_10;}
        else if(x == 6 && y == 11){id = R.id.grid_index_6_11;}
        else if(x == 6 && y == 12){id = R.id.grid_index_6_12;}
        else if(x == 6 && y == 13){id = R.id.grid_index_6_13;}
        else if(x == 6 && y == 14){id = R.id.grid_index_6_14;}
        else if(x == 6 && y == 15){id = R.id.grid_index_6_15;}
        else if(x == 6 && y == 16){id = R.id.grid_index_6_16;}
        else if(x == 6 && y == 17){id = R.id.grid_index_6_17;}
        else if(x == 6 && y == 18){id = R.id.grid_index_6_18;}
        else if(x == 6 && y == 19){id = R.id.grid_index_6_19;}
        else if(x == 7 && y == 0){id = R.id.grid_index_7_0;}
        else if(x == 7 && y == 1){id = R.id.grid_index_7_1;}
        else if(x == 7 && y == 2){id = R.id.grid_index_7_2;}
        else if(x == 7 && y == 3){id = R.id.grid_index_7_3;}
        else if(x == 7 && y == 4){id = R.id.grid_index_7_4;}
        else if(x == 7 && y == 5){id = R.id.grid_index_7_5;}
        else if(x == 7 && y == 6){id = R.id.grid_index_7_6;}
        else if(x == 7 && y == 7){id = R.id.grid_index_7_7;}
        else if(x == 7 && y == 8){id = R.id.grid_index_7_8;}
        else if(x == 7 && y == 9){id = R.id.grid_index_7_9;}
        else if(x == 7 && y == 10){id = R.id.grid_index_7_10;}
        else if(x == 7 && y == 11){id = R.id.grid_index_7_11;}
        else if(x == 7 && y == 12){id = R.id.grid_index_7_12;}
        else if(x == 7 && y == 13){id = R.id.grid_index_7_13;}
        else if(x == 7 && y == 14){id = R.id.grid_index_7_14;}
        else if(x == 7 && y == 15){id = R.id.grid_index_7_15;}
        else if(x == 7 && y == 16){id = R.id.grid_index_7_16;}
        else if(x == 7 && y == 17){id = R.id.grid_index_7_17;}
        else if(x == 7 && y == 18){id = R.id.grid_index_7_18;}
        else if(x == 7 && y == 19){id = R.id.grid_index_7_19;}
        else if(x == 8 && y == 0){id = R.id.grid_index_8_0;}
        else if(x == 8 && y == 1){id = R.id.grid_index_8_1;}
        else if(x == 8 && y == 2){id = R.id.grid_index_8_2;}
        else if(x == 8 && y == 3){id = R.id.grid_index_8_3;}
        else if(x == 8 && y == 4){id = R.id.grid_index_8_4;}
        else if(x == 8 && y == 5){id = R.id.grid_index_8_5;}
        else if(x == 8 && y == 6){id = R.id.grid_index_8_6;}
        else if(x == 8 && y == 7){id = R.id.grid_index_8_7;}
        else if(x == 8 && y == 8){id = R.id.grid_index_8_8;}
        else if(x == 8 && y == 9){id = R.id.grid_index_8_9;}
        else if(x == 8 && y == 10){id = R.id.grid_index_8_10;}
        else if(x == 8 && y == 11){id = R.id.grid_index_8_11;}
        else if(x == 8 && y == 12){id = R.id.grid_index_8_12;}
        else if(x == 8 && y == 13){id = R.id.grid_index_8_13;}
        else if(x == 8 && y == 14){id = R.id.grid_index_8_14;}
        else if(x == 8 && y == 15){id = R.id.grid_index_8_15;}
        else if(x == 8 && y == 16){id = R.id.grid_index_8_16;}
        else if(x == 8 && y == 17){id = R.id.grid_index_8_17;}
        else if(x == 8 && y == 18){id = R.id.grid_index_8_18;}
        else if(x == 8 && y == 19){id = R.id.grid_index_8_19;}
        else if(x == 9 && y == 0){id = R.id.grid_index_9_0;}
        else if(x == 9 && y == 1){id = R.id.grid_index_9_1;}
        else if(x == 9 && y == 2){id = R.id.grid_index_9_2;}
        else if(x == 9 && y == 3){id = R.id.grid_index_9_3;}
        else if(x == 9 && y == 4){id = R.id.grid_index_9_4;}
        else if(x == 9 && y == 5){id = R.id.grid_index_9_5;}
        else if(x == 9 && y == 6){id = R.id.grid_index_9_6;}
        else if(x == 9 && y == 7){id = R.id.grid_index_9_7;}
        else if(x == 9 && y == 8){id = R.id.grid_index_9_8;}
        else if(x == 9 && y == 9){id = R.id.grid_index_9_9;}
        else if(x == 9 && y == 10){id = R.id.grid_index_9_10;}
        else if(x == 9 && y == 11){id = R.id.grid_index_9_11;}
        else if(x == 9 && y == 12){id = R.id.grid_index_9_12;}
        else if(x == 9 && y == 13){id = R.id.grid_index_9_13;}
        else if(x == 9 && y == 14){id = R.id.grid_index_9_14;}
        else if(x == 9 && y == 15){id = R.id.grid_index_9_15;}
        else if(x == 9 && y == 16){id = R.id.grid_index_9_16;}
        else if(x == 9 && y == 17){id = R.id.grid_index_9_17;}
        else if(x == 9 && y == 18){id = R.id.grid_index_9_18;}
        else if(x == 9 && y == 19){id = R.id.grid_index_9_19;}
        else if(x == 10 && y == 0){id = R.id.grid_index_10_0;}
        else if(x == 10 && y == 1){id = R.id.grid_index_10_1;}
        else if(x == 10 && y == 2){id = R.id.grid_index_10_2;}
        else if(x == 10 && y == 3){id = R.id.grid_index_10_3;}
        else if(x == 10 && y == 4){id = R.id.grid_index_10_4;}
        else if(x == 10 && y == 5){id = R.id.grid_index_10_5;}
        else if(x == 10 && y == 6){id = R.id.grid_index_10_6;}
        else if(x == 10 && y == 7){id = R.id.grid_index_10_7;}
        else if(x == 10 && y == 8){id = R.id.grid_index_10_8;}
        else if(x == 10 && y == 9){id = R.id.grid_index_10_9;}
        else if(x == 10 && y == 10){id = R.id.grid_index_10_10;}
        else if(x == 10 && y == 11){id = R.id.grid_index_10_11;}
        else if(x == 10 && y == 12){id = R.id.grid_index_10_12;}
        else if(x == 10 && y == 13){id = R.id.grid_index_10_13;}
        else if(x == 10 && y == 14){id = R.id.grid_index_10_14;}
        else if(x == 10 && y == 15){id = R.id.grid_index_10_15;}
        else if(x == 10 && y == 16){id = R.id.grid_index_10_16;}
        else if(x == 10 && y == 17){id = R.id.grid_index_10_17;}
        else if(x == 10 && y == 18){id = R.id.grid_index_10_18;}
        else if(x == 10 && y == 19){id = R.id.grid_index_10_19;}
        else if(x == 11 && y == 0){id = R.id.grid_index_11_0;}
        else if(x == 11 && y == 1){id = R.id.grid_index_11_1;}
        else if(x == 11 && y == 2){id = R.id.grid_index_11_2;}
        else if(x == 11 && y == 3){id = R.id.grid_index_11_3;}
        else if(x == 11 && y == 4){id = R.id.grid_index_11_4;}
        else if(x == 11 && y == 5){id = R.id.grid_index_11_5;}
        else if(x == 11 && y == 6){id = R.id.grid_index_11_6;}
        else if(x == 11 && y == 7){id = R.id.grid_index_11_7;}
        else if(x == 11 && y == 8){id = R.id.grid_index_11_8;}
        else if(x == 11 && y == 9){id = R.id.grid_index_11_9;}
        else if(x == 11 && y == 10){id = R.id.grid_index_11_10;}
        else if(x == 11 && y == 11){id = R.id.grid_index_11_11;}
        else if(x == 11 && y == 12){id = R.id.grid_index_11_12;}
        else if(x == 11 && y == 13){id = R.id.grid_index_11_13;}
        else if(x == 11 && y == 14){id = R.id.grid_index_11_14;}
        else if(x == 11 && y == 15){id = R.id.grid_index_11_15;}
        else if(x == 11 && y == 16){id = R.id.grid_index_11_16;}
        else if(x == 11 && y == 17){id = R.id.grid_index_11_17;}
        else if(x == 11 && y == 18){id = R.id.grid_index_11_18;}
        else if(x == 11 && y == 19){id = R.id.grid_index_11_19;}
        else if(x == 12 && y == 0){id = R.id.grid_index_12_0;}
        else if(x == 12 && y == 1){id = R.id.grid_index_12_1;}
        else if(x == 12 && y == 2){id = R.id.grid_index_12_2;}
        else if(x == 12 && y == 3){id = R.id.grid_index_12_3;}
        else if(x == 12 && y == 4){id = R.id.grid_index_12_4;}
        else if(x == 12 && y == 5){id = R.id.grid_index_12_5;}
        else if(x == 12 && y == 6){id = R.id.grid_index_12_6;}
        else if(x == 12 && y == 7){id = R.id.grid_index_12_7;}
        else if(x == 12 && y == 8){id = R.id.grid_index_12_8;}
        else if(x == 12 && y == 9){id = R.id.grid_index_12_9;}
        else if(x == 12 && y == 10){id = R.id.grid_index_12_10;}
        else if(x == 12 && y == 11){id = R.id.grid_index_12_11;}
        else if(x == 12 && y == 12){id = R.id.grid_index_12_12;}
        else if(x == 12 && y == 13){id = R.id.grid_index_12_13;}
        else if(x == 12 && y == 14){id = R.id.grid_index_12_14;}
        else if(x == 12 && y == 15){id = R.id.grid_index_12_15;}
        else if(x == 12 && y == 16){id = R.id.grid_index_12_16;}
        else if(x == 12 && y == 17){id = R.id.grid_index_12_17;}
        else if(x == 12 && y == 18){id = R.id.grid_index_12_18;}
        else if(x == 12 && y == 19){id = R.id.grid_index_12_19;}
        else if(x == 13 && y == 0){id = R.id.grid_index_13_0;}
        else if(x == 13 && y == 1){id = R.id.grid_index_13_1;}
        else if(x == 13 && y == 2){id = R.id.grid_index_13_2;}
        else if(x == 13 && y == 3){id = R.id.grid_index_13_3;}
        else if(x == 13 && y == 4){id = R.id.grid_index_13_4;}
        else if(x == 13 && y == 5){id = R.id.grid_index_13_5;}
        else if(x == 13 && y == 6){id = R.id.grid_index_13_6;}
        else if(x == 13 && y == 7){id = R.id.grid_index_13_7;}
        else if(x == 13 && y == 8){id = R.id.grid_index_13_8;}
        else if(x == 13 && y == 9){id = R.id.grid_index_13_9;}
        else if(x == 13 && y == 10){id = R.id.grid_index_13_10;}
        else if(x == 13 && y == 11){id = R.id.grid_index_13_11;}
        else if(x == 13 && y == 12){id = R.id.grid_index_13_12;}
        else if(x == 13 && y == 13){id = R.id.grid_index_13_13;}
        else if(x == 13 && y == 14){id = R.id.grid_index_13_14;}
        else if(x == 13 && y == 15){id = R.id.grid_index_13_15;}
        else if(x == 13 && y == 16){id = R.id.grid_index_13_16;}
        else if(x == 13 && y == 17){id = R.id.grid_index_13_17;}
        else if(x == 13 && y == 18){id = R.id.grid_index_13_18;}
        else if(x == 13 && y == 19){id = R.id.grid_index_13_19;}
        else if(x == 14 && y == 0){id = R.id.grid_index_14_0;}
        else if(x == 14 && y == 1){id = R.id.grid_index_14_1;}
        else if(x == 14 && y == 2){id = R.id.grid_index_14_2;}
        else if(x == 14 && y == 3){id = R.id.grid_index_14_3;}
        else if(x == 14 && y == 4){id = R.id.grid_index_14_4;}
        else if(x == 14 && y == 5){id = R.id.grid_index_14_5;}
        else if(x == 14 && y == 6){id = R.id.grid_index_14_6;}
        else if(x == 14 && y == 7){id = R.id.grid_index_14_7;}
        else if(x == 14 && y == 8){id = R.id.grid_index_14_8;}
        else if(x == 14 && y == 9){id = R.id.grid_index_14_9;}
        else if(x == 14 && y == 10){id = R.id.grid_index_14_10;}
        else if(x == 14 && y == 11){id = R.id.grid_index_14_11;}
        else if(x == 14 && y == 12){id = R.id.grid_index_14_12;}
        else if(x == 14 && y == 13){id = R.id.grid_index_14_13;}
        else if(x == 14 && y == 14){id = R.id.grid_index_14_14;}
        else if(x == 14 && y == 15){id = R.id.grid_index_14_15;}
        else if(x == 14 && y == 16){id = R.id.grid_index_14_16;}
        else if(x == 14 && y == 17){id = R.id.grid_index_14_17;}
        else if(x == 14 && y == 18){id = R.id.grid_index_14_18;}
        else if(x == 14 && y == 19){id = R.id.grid_index_14_19;}
        else if(x == 15 && y == 0){id = R.id.grid_index_15_0;}
        else if(x == 15 && y == 1){id = R.id.grid_index_15_1;}
        else if(x == 15 && y == 2){id = R.id.grid_index_15_2;}
        else if(x == 15 && y == 3){id = R.id.grid_index_15_3;}
        else if(x == 15 && y == 4){id = R.id.grid_index_15_4;}
        else if(x == 15 && y == 5){id = R.id.grid_index_15_5;}
        else if(x == 15 && y == 6){id = R.id.grid_index_15_6;}
        else if(x == 15 && y == 7){id = R.id.grid_index_15_7;}
        else if(x == 15 && y == 8){id = R.id.grid_index_15_8;}
        else if(x == 15 && y == 9){id = R.id.grid_index_15_9;}
        else if(x == 15 && y == 10){id = R.id.grid_index_15_10;}
        else if(x == 15 && y == 11){id = R.id.grid_index_15_11;}
        else if(x == 15 && y == 12){id = R.id.grid_index_15_12;}
        else if(x == 15 && y == 13){id = R.id.grid_index_15_13;}
        else if(x == 15 && y == 14){id = R.id.grid_index_15_14;}
        else if(x == 15 && y == 15){id = R.id.grid_index_15_15;}
        else if(x == 15 && y == 16){id = R.id.grid_index_15_16;}
        else if(x == 15 && y == 17){id = R.id.grid_index_15_17;}
        else if(x == 15 && y == 18){id = R.id.grid_index_15_18;}
        else if(x == 15 && y == 19){id = R.id.grid_index_15_19;}
        else if(x == 16 && y == 0){id = R.id.grid_index_16_0;}
        else if(x == 16 && y == 1){id = R.id.grid_index_16_1;}
        else if(x == 16 && y == 2){id = R.id.grid_index_16_2;}
        else if(x == 16 && y == 3){id = R.id.grid_index_16_3;}
        else if(x == 16 && y == 4){id = R.id.grid_index_16_4;}
        else if(x == 16 && y == 5){id = R.id.grid_index_16_5;}
        else if(x == 16 && y == 6){id = R.id.grid_index_16_6;}
        else if(x == 16 && y == 7){id = R.id.grid_index_16_7;}
        else if(x == 16 && y == 8){id = R.id.grid_index_16_8;}
        else if(x == 16 && y == 9){id = R.id.grid_index_16_9;}
        else if(x == 16 && y == 10){id = R.id.grid_index_16_10;}
        else if(x == 16 && y == 11){id = R.id.grid_index_16_11;}
        else if(x == 16 && y == 12){id = R.id.grid_index_16_12;}
        else if(x == 16 && y == 13){id = R.id.grid_index_16_13;}
        else if(x == 16 && y == 14){id = R.id.grid_index_16_14;}
        else if(x == 16 && y == 15){id = R.id.grid_index_16_15;}
        else if(x == 16 && y == 16){id = R.id.grid_index_16_16;}
        else if(x == 16 && y == 17){id = R.id.grid_index_16_17;}
        else if(x == 16 && y == 18){id = R.id.grid_index_16_18;}
        else if(x == 16 && y == 19){id = R.id.grid_index_16_19;}
        else if(x == 17 && y == 0){id = R.id.grid_index_17_0;}
        else if(x == 17 && y == 1){id = R.id.grid_index_17_1;}
        else if(x == 17 && y == 2){id = R.id.grid_index_17_2;}
        else if(x == 17 && y == 3){id = R.id.grid_index_17_3;}
        else if(x == 17 && y == 4){id = R.id.grid_index_17_4;}
        else if(x == 17 && y == 5){id = R.id.grid_index_17_5;}
        else if(x == 17 && y == 6){id = R.id.grid_index_17_6;}
        else if(x == 17 && y == 7){id = R.id.grid_index_17_7;}
        else if(x == 17 && y == 8){id = R.id.grid_index_17_8;}
        else if(x == 17 && y == 9){id = R.id.grid_index_17_9;}
        else if(x == 17 && y == 10){id = R.id.grid_index_17_10;}
        else if(x == 17 && y == 11){id = R.id.grid_index_17_11;}
        else if(x == 17 && y == 12){id = R.id.grid_index_17_12;}
        else if(x == 17 && y == 13){id = R.id.grid_index_17_13;}
        else if(x == 17 && y == 14){id = R.id.grid_index_17_14;}
        else if(x == 17 && y == 15){id = R.id.grid_index_17_15;}
        else if(x == 17 && y == 16){id = R.id.grid_index_17_16;}
        else if(x == 17 && y == 17){id = R.id.grid_index_17_17;}
        else if(x == 17 && y == 18){id = R.id.grid_index_17_18;}
        else if(x == 17 && y == 19){id = R.id.grid_index_17_19;}
        else if(x == 18 && y == 0){id = R.id.grid_index_18_0;}
        else if(x == 18 && y == 1){id = R.id.grid_index_18_1;}
        else if(x == 18 && y == 2){id = R.id.grid_index_18_2;}
        else if(x == 18 && y == 3){id = R.id.grid_index_18_3;}
        else if(x == 18 && y == 4){id = R.id.grid_index_18_4;}
        else if(x == 18 && y == 5){id = R.id.grid_index_18_5;}
        else if(x == 18 && y == 6){id = R.id.grid_index_18_6;}
        else if(x == 18 && y == 7){id = R.id.grid_index_18_7;}
        else if(x == 18 && y == 8){id = R.id.grid_index_18_8;}
        else if(x == 18 && y == 9){id = R.id.grid_index_18_9;}
        else if(x == 18 && y == 10){id = R.id.grid_index_18_10;}
        else if(x == 18 && y == 11){id = R.id.grid_index_18_11;}
        else if(x == 18 && y == 12){id = R.id.grid_index_18_12;}
        else if(x == 18 && y == 13){id = R.id.grid_index_18_13;}
        else if(x == 18 && y == 14){id = R.id.grid_index_18_14;}
        else if(x == 18 && y == 15){id = R.id.grid_index_18_15;}
        else if(x == 18 && y == 16){id = R.id.grid_index_18_16;}
        else if(x == 18 && y == 17){id = R.id.grid_index_18_17;}
        else if(x == 18 && y == 18){id = R.id.grid_index_18_18;}
        else if(x == 18 && y == 19){id = R.id.grid_index_18_19;}
        else if(x == 19 && y == 0){id = R.id.grid_index_19_0;}
        else if(x == 19 && y == 1){id = R.id.grid_index_19_1;}
        else if(x == 19 && y == 2){id = R.id.grid_index_19_2;}
        else if(x == 19 && y == 3){id = R.id.grid_index_19_3;}
        else if(x == 19 && y == 4){id = R.id.grid_index_19_4;}
        else if(x == 19 && y == 5){id = R.id.grid_index_19_5;}
        else if(x == 19 && y == 6){id = R.id.grid_index_19_6;}
        else if(x == 19 && y == 7){id = R.id.grid_index_19_7;}
        else if(x == 19 && y == 8){id = R.id.grid_index_19_8;}
        else if(x == 19 && y == 9){id = R.id.grid_index_19_9;}
        else if(x == 19 && y == 10){id = R.id.grid_index_19_10;}
        else if(x == 19 && y == 11){id = R.id.grid_index_19_11;}
        else if(x == 19 && y == 12){id = R.id.grid_index_19_12;}
        else if(x == 19 && y == 13){id = R.id.grid_index_19_13;}
        else if(x == 19 && y == 14){id = R.id.grid_index_19_14;}
        else if(x == 19 && y == 15){id = R.id.grid_index_19_15;}
        else if(x == 19 && y == 16){id = R.id.grid_index_19_16;}
        else if(x == 19 && y == 17){id = R.id.grid_index_19_17;}
        else if(x == 19 && y == 18){id = R.id.grid_index_19_18;}
        else if(x == 19 && y == 19){id = R.id.grid_index_19_19;}

        if(cnt == 1){
            view.findViewById(id).setBackground(getResources().getDrawable(R.drawable.test_grid_black, null));
        }else if(cnt == 2){
            view.findViewById(id).setBackground(getResources().getDrawable(R.drawable.test_grid_twink, null));
        }else if(cnt == 3){
            view.findViewById(id).setBackground(getResources().getDrawable(R.drawable.test_grid_over, null));
        }
    }

    private void init() {
        /*
        bundle.putString("eye_black", type_2_res);
        bundle.putString("eye_twink", type_4_res);*/
        cntList = new int[20][20];
        now_cnt_black = 0;
        now_cnt_twink = 0;
        for(int i = 0 ; i<20;i++){
            for(int j = 0 ; j<20;j++){
                cntList[i][j] = 0;
            }
        }

        before_cnt_black = getArguments().getInt("b_eye_black");
        before_cnt_twink = getArguments().getInt("b_eye_twink");

        String eb = getArguments().getString("eye_black");
        String[] row = eb.split("&");
        for(int i = 0 ; i<row.length;i++){
            String[] col = row[i].split(",");
            for(int j = 0 ; j<col.length;j++){
                if(col[j].equals("1")){
                    now_cnt_black+=1;
                    cntList[i][j]+=1;
                }
            }
        }

        String et = getArguments().getString("eye_twink");

        String[] row2 = et.split("&");
        for(int index = 0 ; index<row2.length;index++){
            String[] col = row2[index].split(",");
            for(int j = 0 ; j<col.length;j++){
                if(col[j].equals("1") ){
                    now_cnt_twink+=1;
                    cntList[index][j]+=2;
                }
            }
        }
    }

}
