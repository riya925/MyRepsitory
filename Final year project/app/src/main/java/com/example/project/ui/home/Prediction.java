package com.example.project.ui.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Prediction extends AppCompatActivity {

    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        pieChart=findViewById(R.id.pieChart);

        getEntries();

        pieDataSet=new PieDataSet(pieEntries,"Profit VS Loss");
        pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(20f);
    }

    private void getEntries()
    {
        pieEntries=new ArrayList<>();
        pieEntries.add(new PieEntry(1f,2));
        pieEntries.add(new PieEntry(4f,5));
        pieEntries.add(new PieEntry(2f,7));
        pieEntries.add(new PieEntry(9f,4));
        pieEntries.add(new PieEntry(7f,9));
        pieEntries.add(new PieEntry(9f,8));

    }
}