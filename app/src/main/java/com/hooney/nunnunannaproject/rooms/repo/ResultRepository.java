package com.hooney.nunnunannaproject.rooms.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.hooney.nunnunannaproject.rooms.entity.ResultData;
import com.hooney.nunnunannaproject.rooms.dao.MainDatabase;
import com.hooney.nunnunannaproject.rooms.dao.ResultDao;

import java.util.List;

public class ResultRepository {
    private ResultDao resultDao;
    private LiveData<List<ResultData>> allResults;

    public ResultRepository(Application application){
        MainDatabase database = MainDatabase.getInstance(application);
        this.resultDao = database.resultDao();
        this.allResults = this.resultDao.getAllResult();
    }

    public void insert(ResultData data){
        new InsertNoteAsycTask(resultDao).execute(data);      //AsyncTask 실행
    }

    public void delete(ResultData data){
        new DeleteNoteAsycTask(resultDao).execute(data);
    }

    public LiveData<List<ResultData>> getAllResults(){
        return this.allResults;
    }

    private static class InsertNoteAsycTask extends AsyncTask<ResultData, Void, Void> {
        private ResultDao noteDao;
        private InsertNoteAsycTask(ResultDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(ResultData... notes) {  //여러개의 배열이긴 하지만
            noteDao.insert(notes[0]);                   //이번에는 하나만 받기 때문에.
            return null;
        }
    }

    private static class DeleteNoteAsycTask extends AsyncTask<ResultData, Void, Void>{
        private ResultDao noteDao;
        private DeleteNoteAsycTask(ResultDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(ResultData... notes) {  //여러개의 배열이긴 하지만
            noteDao.delete(notes[0]);                   //이번에는 하나만 받기 때문에.
            return null;
        }
    }
}
