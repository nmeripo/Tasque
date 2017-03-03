package com.project.todolist.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;



        import com.github.mikephil.charting.charts.BarChart;
        import com.github.mikephil.charting.charts.HorizontalBarChart;
        import com.github.mikephil.charting.charts.PieChart;
        import com.github.mikephil.charting.data.BarData;
        import com.github.mikephil.charting.data.BarDataSet;
        import com.github.mikephil.charting.data.BarEntry;
        import com.github.mikephil.charting.data.Entry;
        import com.github.mikephil.charting.data.PieData;
        import com.github.mikephil.charting.data.PieDataSet;
        import com.github.mikephil.charting.utils.ColorTemplate;
import com.project.todolist.R;
import com.project.todolist.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Visual_graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visual_graph);

        BarChart barChart = (BarChart) findViewById(R.id.chart);

        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);

        DatabaseHelper database = DatabaseHelper.getInstance(this);
        LinkedHashMap<String,Integer> result =  database.getTasksThreeWeeks();
        //sunday


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(result.get("this_week_c"), 0));
        entries.add(new BarEntry(result.get("this_week"), 1));
        entries.add(new BarEntry(result.get("prevous_week_c"), 2));
        entries.add(new BarEntry(result.get("prevous_week"), 3));
        entries.add(new BarEntry(result.get("two_week_previous_c"), 4));
        entries.add(new BarEntry(result.get("two_week_previous"),5));
        BarDataSet dataset = new BarDataSet(entries, "#Tasks for last 3 weeks,c=completed,ic-incomplete");
        //BarDataSet dataset = new BarDataSet(entries, "#Tasks");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("w1-c");
        labels.add("ic");
        labels.add("w2-c");
        labels.add("ic");
        labels.add("w3-c");
        labels.add("ic");

        /* for create Grouped Bar chart
        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4f, 0));
        group1.add(new BarEntry(8f, 1));
        group1.add(new BarEntry(6f, 2));
        group1.add(new BarEntry(12f, 3));
        group1.add(new BarEntry(18f, 4));
        group1.add(new BarEntry(9f, 5));

        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(6f, 0));
        group2.add(new BarEntry(7f, 1));
        group2.add(new BarEntry(8f, 2));
        group2.add(new BarEntry(12f, 3));
        group2.add(new BarEntry(15f, 4));
        group2.add(new BarEntry(10f, 5));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Group 1");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(group2, "Group 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<BarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);
        */

        BarData data = new BarData(labels, dataset);
        // dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        barChart.setData(data);
        barChart.animateY(10000);

    }
}

