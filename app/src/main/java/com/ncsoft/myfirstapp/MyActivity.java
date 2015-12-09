package com.ncsoft.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.LineDataSet;
import com.ncsoft.myfirstapp.listview.LegendAdapter;
import com.ncsoft.myfirstapp.utils.MpChartUtils;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activiry);

        mChart = (LineChart) findViewById(R.id.view_chart);

        mChart.setTouchEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);

        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getAxisRight().setEnabled(false);
        mChart.getXAxis().setDrawGridLines(false);
        mChart.getXAxis().setDrawAxisLine(false);

        
        Legend legend = mChart.getLegend();
        legend.setEnabled(false);

        mChart.setData(MpChartUtils.getDummyData(0));
        mChart.invalidate();

        setListView();

    }

    private void setListView() {
        ListView listView = (ListView) findViewById(R.id.view_list);

        List<LineDataSet> dataSetList = mChart.getData().getDataSets();

        LegendAdapter legendAdapter = new LegendAdapter(dataSetList);

        listView.setAdapter(legendAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_search:
                System.out.println("it hing~");
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
