package com.hooney.nunnunannaproject.rooms.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.hooney.nunnunannaproject.rooms.entity.ResultData;

import java.util.List;

@Dao
public interface ResultDao {
    @Query("SELECT * FROM result_table")
    LiveData<List<ResultData>> getAllResult();

    @Insert
    void insert(ResultData data);

    @Delete
    void delete(ResultData data);
}
