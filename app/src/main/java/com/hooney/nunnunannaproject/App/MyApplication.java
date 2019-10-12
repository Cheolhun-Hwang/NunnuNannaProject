package com.hooney.nunnunannaproject.App;

import android.app.Application;

import com.hooney.nunnunannaproject.rooms.entity.ResultData;

import java.util.List;

public class MyApplication extends Application {
    public static List<ResultData> allResultData;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
