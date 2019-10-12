package com.hooney.nunnunannaproject.rooms.dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.hooney.nunnunannaproject.rooms.entity.ResultData;

@Database(entities = {ResultData.class}, version = 1)
public abstract class MainDatabase extends RoomDatabase {
    private static MainDatabase instance;
    public abstract ResultDao resultDao();

    public static synchronized MainDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MainDatabase.class, "main_database")
                    .fallbackToDestructiveMigration()   //Crash Check.
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //데이터 테이블 처음 생길 때 한번
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            //데이터 테이블 연결 될 때마다
            super.onOpen(db);
        }
    };
}
