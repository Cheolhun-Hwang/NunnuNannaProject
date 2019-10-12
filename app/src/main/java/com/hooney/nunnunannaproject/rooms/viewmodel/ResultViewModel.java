package com.hooney.nunnunannaproject.rooms.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hooney.nunnunannaproject.rooms.dao.ResultDao;
import com.hooney.nunnunannaproject.rooms.entity.ResultData;
import com.hooney.nunnunannaproject.rooms.repo.ResultRepository;

import java.util.List;

public class ResultViewModel extends AndroidViewModel {
    private ResultRepository repository;
    private LiveData<List<ResultData>> allResults;

    public ResultViewModel(@NonNull Application application) {
        super(application);
        repository = new ResultRepository(application);
        allResults = repository.getAllResults();
    }

    public void insert(ResultData note){
        repository.insert(note);
    }

    public void delete(ResultData note){
        repository.delete(note);
    }

    public LiveData<List<ResultData>> getResults(){
        return allResults;
    }

}
