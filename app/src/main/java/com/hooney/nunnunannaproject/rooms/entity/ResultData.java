package com.hooney.nunnunannaproject.rooms.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "result_table")
public class ResultData {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "code")
    private String code;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "type")
    private int type;
    @ColumnInfo(name = "result")
    private String result;
    @ColumnInfo(name = "cnt")
    private int cnt;

    public ResultData() {
        this.code = "";
        this.date = "";
        this.type = -1;
        this.result = "";
        this.cnt = -1;
    }

    public ResultData(int id, String code, String date, int type, String result, int cnt) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.type = type;
        this.result = result;
        this.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
