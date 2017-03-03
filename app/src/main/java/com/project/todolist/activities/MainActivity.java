package com.project.todolist.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.project.todolist.R;
import com.project.todolist.adapters.ReminderAdapter;
import com.project.todolist.adapters.ViewPageAdapter;
import com.project.todolist.database.DatabaseHelper;
import com.project.todolist.predictive_analysis.frequent_tasks;
import com.project.todolist.predictive_analysis.stopword_removal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ReminderAdapter.RecyclerListener {

    @BindView(R.id.tabs) PagerSlidingTabStrip pagerSlidingTabStrip;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.fab_button) FloatingActionButton floatingActionButton;

    private boolean fabIsHidden = false;
    private PopupWindow mPopupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(null);
        }

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        pagerSlidingTabStrip.setViewPager(viewPager);
        int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        viewPager.setPageMargin(pageMargin);

    }

    /*public void onShowPopupWindow(View v) {
        Log.d("step1","step1");
        PopupWindow popup = new PopupWindow(MainActivity.this);
        View layout = getLayoutInflater().inflate(R.layout.popup_wind, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        //set field variables to database data
        ImageButton closeButton = (ImageButton) layout.findViewById(R.id.ib_close);
        *//*TextView tv1 = (TextView) layout.findViewById(R.id.sunday);
        TextView tv2 = (TextView) layout.findViewById(R.id.monday);
        TextView tv3 = (TextView) layout.findViewById(R.id.tuesday);
        TextView tv4 = (TextView) layout.findViewById(R.id.wednesday);
        TextView tv5 = (TextView) layout.findViewById(R.id.thursday);
        TextView tv6 = (TextView) layout.findViewById(R.id.friday);
        TextView tv7 = (TextView) layout.findViewById(R.id.saturday);

        DatabaseHelper database = DatabaseHelper.getInstance(MainActivity.this);
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
        tv7.setText("Saturday Tasks: "+s7);*//*

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();
            }
        });
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(v);
    }*/

    @OnClick(R.id.sug_btn)
    public void sugClicked(){
        Intent intent = new Intent(this,popup_window.class);
        startActivity(intent);
    }

    @OnClick(R.id.fab_button)
    public void fabClicked() {
        Intent intent = new Intent(this, CreateEditActivity.class);
        startActivity(intent);
    }

    @Override
    public void hideFab() {
        floatingActionButton.hide();
        fabIsHidden = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fabIsHidden) {
            floatingActionButton.show();
            fabIsHidden = false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent preferenceIntent = new Intent(this, PreferenceActivity.class);
                startActivity(preferenceIntent);
                return true;
            case R.id.action_about:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                return true;
            case R.id.action_signout:
                Intent aboutSignout = new Intent(this, SignInActivity.class);
                startActivity(aboutSignout);
                break;
            case R.id.auto_bright:
                Intent autoBright = new Intent(this,BrightnessToggle.class);
                startActivity(autoBright);
                break;
            case R.id.visual_graphs:
                Intent visualgraph = new Intent(this,Visual_graph.class);
                startActivity(visualgraph);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}