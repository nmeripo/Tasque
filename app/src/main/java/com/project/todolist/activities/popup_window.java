package com.project.todolist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.todolist.R;
import com.project.todolist.database.DatabaseHelper;
import com.project.todolist.predictive_analysis.frequent_tasks;
import com.project.todolist.predictive_analysis.stopword_removal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;


public class popup_window extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_wind);
        ImageButton closeButton = (ImageButton) findViewById(R.id.ib_close);
        TextView tv1 = (TextView) findViewById(R.id.sunday);
        TextView tv2 = (TextView) findViewById(R.id.monday);
        TextView tv3 = (TextView) findViewById(R.id.tuesday);
        TextView tv4 = (TextView) findViewById(R.id.wednesday);
        TextView tv5 = (TextView) findViewById(R.id.thursday);
        TextView tv6 = (TextView) findViewById(R.id.friday);
        TextView tv7 = (TextView) findViewById(R.id.saturday);

        DatabaseHelper database = DatabaseHelper.getInstance(this);
        LinkedHashMap<String,ArrayList<String>> result =  database.getMostFrequentTasks();
        //sunday
        ArrayList<String> sr_s = result.get("Sunday");
        Iterator<String> i = sr_s.iterator();
        StringBuffer sun = new StringBuffer();
        while (i.hasNext()) {
            sun.append(i.next());
            sun.append(" ");
        }
        ArrayList<String> a_s = new frequent_tasks().computing_resultset(new stopword_removal().removeStopwords(sun.toString()));
        String s1 = "";
        for(String s : a_s)
            s1 += s+" ";
        tv1.setText("Sunday Tasks: "+s1);
        //monday
        ArrayList<String> sr_m = result.get("Monday");
        Iterator<String> i1 = sr_m.iterator();
        StringBuffer mon = new StringBuffer();
        while (i1.hasNext()) {
            mon.append(i1.next());
            mon.append(" ");
        }
        ArrayList<String> a_m = new frequent_tasks().computing_resultset(new stopword_removal().removeStopwords(mon.toString()));
        String s2 = "";
        for(String s : a_m)
            s2 += s+" ";
        tv2.setText("Monday Tasks: "+s2);
        //tuesday
        ArrayList<String> sr_t = result.get("Tuesday");
        Iterator<String> i2 = sr_t.iterator();
        StringBuffer tue = new StringBuffer();
        while (i2.hasNext()) {
            tue.append(i2.next());
            tue.append(" ");
        }
        ArrayList<String> a_t = new frequent_tasks().computing_resultset(new stopword_removal().removeStopwords(tue.toString()));
        String s3 = "";
        for(String s : a_t)
            s3 += s+" ";
        tv3.setText("Tuesday Tasks: "+s3);
        //wednesday
        ArrayList<String> sr_w = result.get("Wednesday");
        Iterator<String> i3 = sr_w.iterator();
        StringBuffer wed = new StringBuffer();
        while (i3.hasNext()) {
            wed.append(i3.next());
            wed.append(" ");
        }
        ArrayList<String> a_w = new frequent_tasks().computing_resultset(new stopword_removal().removeStopwords(wed.toString()));
        String s4 = "";
        for(String s : a_w)
            s4 += s+" ";
        tv4.setText("Wednesday Tasks: "+s4);
        //thursday
        ArrayList<String> sr_th = result.get("Thursday");
        Iterator<String> i4 = sr_th.iterator();
        StringBuffer thu = new StringBuffer();
        while (i4.hasNext()) {
            thu.append(i4.next());
            thu.append(" ");
        }
        ArrayList<String> a_th = new frequent_tasks().computing_resultset(new stopword_removal().removeStopwords(thu.toString()));
        String s5 = "";
        for(String s : a_th)
            s5 += s+" ";
        tv5.setText("Thursday Tasks: "+s5);
        //friday
        ArrayList<String> sr_f = result.get("Friday");
        Iterator<String> i5 = sr_f.iterator();
        StringBuffer fri = new StringBuffer();
        while (i5.hasNext()) {
            fri.append(i5.next());
            fri.append(" ");
        }
        ArrayList<String> a_f = new frequent_tasks().computing_resultset(new stopword_removal().removeStopwords(fri.toString()));
        String s6 = "";
        for(String s : a_f)
            s6 += s+" ";
        tv6.setText("Friday Tasks: "+s6);
        //Saturday
        ArrayList<String> sr_sa = result.get("Saturday");
        Iterator<String> i6 = sr_sa.iterator();
        StringBuffer sat = new StringBuffer();
        while (i6.hasNext()) {
            sat.append(i6.next());
            sat.append(" ");
        }
        ArrayList<String> a_sa = new frequent_tasks().computing_resultset(new stopword_removal().removeStopwords(sat.toString()));
        String s7 = "";
        for(String s : a_sa)
            s7 += s+" ";
        tv7.setText("Saturday Tasks: "+s7);

        /*closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });*/

    }
}


