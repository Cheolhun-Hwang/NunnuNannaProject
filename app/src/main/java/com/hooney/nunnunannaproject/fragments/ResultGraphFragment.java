package com.hooney.nunnunannaproject.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.hooney.nunnunannaproject.App.MyApplication;
import com.hooney.nunnunannaproject.R;
import com.hooney.nunnunannaproject.rooms.entity.ResultData;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ResultGraphFragment extends Fragment {
    private LineChart chart;
    private View view;
    private int eye_type;

    public ResultGraphFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_result_graph, container, false);
        init();
        initChart();

        return view;
    }

    private void init() {
        eye_type = getArguments().getInt("eye_type");
    }

    private void initChart() {
        chart = view.findViewById(R.id.chart1);
        chart.setBackgroundColor(Color.WHITE);
        chart.setDrawGridBackground(false);

        final ArrayList<String> x_label = new ArrayList<>();
        ArrayList<Integer> y_dark = new ArrayList<>();
        ArrayList<Integer> y_twink = new ArrayList<>();

        x_label.add(" ");
        y_dark.add(0);
        y_twink.add(0);

        HashMap<String, Integer[]> map = new HashMap<>();
        for(ResultData item : MyApplication.allResultData){
            map.put(item.getCode(), new Integer[]{0, 0});
        }

        if(eye_type == 0){
            //오른쪽 눈 0 2
            for(ResultData item : MyApplication.allResultData){
                if(item.getType() == 0){
                    map.get(item.getCode())[0] = item.getCnt();
                    String[] s_d = item.getDate().split(" ");
                    x_label.add(s_d[0].substring(5, 10).replace("-", "."));
                }else if(item.getType() == 2){
                    map.get(item.getCode())[1] = item.getCnt();
                }
            }
        }else{
            //왼쪽 눈 1 3
            for(ResultData item : MyApplication.allResultData){
                if(item.getType() == 1){
                    String[] s_d = item.getDate().split(" ");
                    x_label.add(s_d[0].substring(5, 10).replace("-", "."));
                    map.get(item.getCode())[0] = item.getCnt();
                }else if(item.getType() == 3){
                    map.get(item.getCode())[1] = item.getCnt();
                }
            }
        }

        for(String key : map.keySet()){
            y_dark.add(map.get(key)[0]);
            y_twink.add(map.get(key)[1]);
        }

        Log.d("Graph", "X_label : " + x_label.size());
        Log.d("Graph", "Y_BLACK : " + y_dark.size());
        Log.d("Graph", "Y_TWINK : " + y_twink.size());

        LineData chartData = new LineData();

        // First
        List<Entry> entries = new ArrayList<>();
        for(int index = 0 ; index < x_label.size() ; index++){
            entries.add(new Entry((index), y_dark.get(index)));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "어두운 영역");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(4);
        lineDataSet.setCircleColor(Color.parseColor("#FD871A"));
        lineDataSet.setCircleHoleColor(Color.parseColor("#FD871A"));
        lineDataSet.setColor(Color.parseColor("#FD871A"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);
        chartData.addDataSet(lineDataSet);

        //2
        List<Entry> entries2 = new ArrayList<>();
        for(int index = 0 ; index < x_label.size() ; index++){
            entries2.add(new Entry((index), y_twink.get(index)));
        }
        LineDataSet lineDataSet2 = new LineDataSet(entries2, "휘어진 영역");
        lineDataSet2.setLineWidth(2);
        lineDataSet2.setCircleRadius(4);
        lineDataSet2.setCircleColor(Color.parseColor("#FDC31A"));
        lineDataSet2.setCircleHoleColor(Color.parseColor("#FDC31A"));
        lineDataSet2.setColor(Color.parseColor("#FDC31A"));
        lineDataSet2.setDrawCircleHole(true);
        lineDataSet2.setDrawCircles(true);
        lineDataSet2.setDrawHorizontalHighlightIndicator(false);
        lineDataSet2.setDrawHighlightIndicators(false);
        lineDataSet2.setDrawValues(false);
        chartData.addDataSet(lineDataSet2);

        chart.setData(chartData);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 24, 0);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return x_label.get((int)value);
            }
        });


        YAxis yLAxis = chart.getAxisLeft();
        yLAxis.setTextColor(Color.BLACK);
        YAxis yRAxis = chart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);
        Description description = new Description();
        description.setText("");
        chart.setDoubleTapToZoomEnabled(false);
        chart.setDescription(description);
        chart.animateY(1000);
        chart.invalidate();

    }
}
