package com.ncsoft.myfirstapp.utils;

import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.ncsoft.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skwangh on 2015-12-04.
 */
public class MpChartUtils {

    private static List<LineDataSet> dummyDataSetList;
    private static List<String> dummyXVals;

    static {
        dummyDataSetList = new ArrayList<LineDataSet>();
        dummyXVals = new ArrayList<String>();

        for (int i = 0 ; i < 300 ; i++) {
            dummyXVals.add(i + "");
        }

        String BASE_TASK = "com.ncsoft.platform.noti.worker.merge.service.SimpleMergeService.saveSimpleMerge(NotiDto,NotiRequest)_";
        //String BASE_TASK = "abcde_";
        for (int i = 0 ; i < 100 ; i ++) {
            String taskName = BASE_TASK + i;
            List<Entry> yValList = new ArrayList<Entry>();
            for (int j = 0 ; j < 300 ; j++) {
                Entry entry = new Entry((float)Math.sin(3.14 / 180 * j) + i, j);
                yValList.add(entry);
            }
            LineDataSet lineDataSet = new LineDataSet(yValList, taskName);
            lineDataSet.setColor(Color.BLACK);
            lineDataSet.setLineWidth(0.5f);
            lineDataSet.setDrawValues(false);
            lineDataSet.setDrawCircleHole(false);
            lineDataSet.setDrawCircles(false);
            lineDataSet.setDrawCubic(false);
            dummyDataSetList.add(lineDataSet);
        }

    }

    public static LineData getDummyData(int startIndex) {
        List<LineDataSet> lineDataSetList = new ArrayList<LineDataSet>();
        if (startIndex >= 0 && startIndex < dummyDataSetList.size()) {
            for (int i = startIndex ; i < dummyDataSetList.size() ; i++) {
                LineDataSet lineDataSet = dummyDataSetList.get(i);
                lineDataSet.setColor(Color.RED);
                lineDataSet.setLineWidth(0.5f);
                lineDataSetList.add(lineDataSet);
                if (lineDataSetList.size() >= 10) {
                    break;
                }
            }
        }

        return new LineData(dummyXVals, lineDataSetList);
    }
}
