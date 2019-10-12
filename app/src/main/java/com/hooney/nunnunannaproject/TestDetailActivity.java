package com.hooney.nunnunannaproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.hooney.nunnunannaproject.App.MyApplication;
import com.hooney.nunnunannaproject.R;
import com.hooney.nunnunannaproject.lists.ResultDetailList;
import com.hooney.nunnunannaproject.rooms.entity.ResultData;

import java.util.ArrayList;

public class TestDetailActivity extends AppCompatActivity {
    private ArrayList<String> titles;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_detail);

        setBar(getSupportActionBar());
        init();
        initView();
    }

    private void initView() {
        ResultDetailList adapter = new ResultDetailList(titles);
        adapter.setOnClickViewListener(new ResultDetailList.onClickViewListener() {
            @Override
            public void onClicked(View view, String title) {
                Intent intent = new Intent(getApplicationContext(), TestGapMatrixActivity.class);
                intent.putExtra("test_code", title);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.detail_list);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        this.titles = new ArrayList<>();

        for(ResultData item : MyApplication.allResultData){
            if(!titles.contains(item.getCode())){
                titles.add(item.getCode());
            }
        }
    }

    private void setBar(ActionBar bar) {
        bar.setTitle("검사결과 자세히보기");
    }
}
