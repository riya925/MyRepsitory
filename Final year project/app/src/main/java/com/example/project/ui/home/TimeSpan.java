package com.example.project.ui.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class TimeSpan extends AppCompatActivity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_span);

        barChart=findViewById(R.id.barchart);

        getEntries();

        barDataSet=new BarDataSet(barEntries,"Data Set");
        barData=new BarData(barDataSet);
        barChart.setData(barData);

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(20f);
    }

    private void getEntries()
    {
        barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1f,2));
        barEntries.add(new BarEntry(4f,5));
        barEntries.add(new BarEntry(2f,7));
        barEntries.add(new BarEntry(9f,4));
        barEntries.add(new BarEntry(7f,9));
        barEntries.add(new BarEntry(9f,8));
    }
}