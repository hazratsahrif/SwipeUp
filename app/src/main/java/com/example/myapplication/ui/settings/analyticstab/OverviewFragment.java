package com.example.myapplication.ui.settings.analyticstab;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentOverviewBinding;
import com.example.myapplication.models.BarChartItem;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.AnalyticsBarChartAdapter;


public class OverviewFragment extends Fragment {
    FragmentOverviewBinding binding;
    BarChart barChart;
    List<BarChartItem> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOverviewBinding.inflate(inflater,container,false);

        barChart = binding.idBarChart;

         setBarChart();
        setLineChart();

        list = new ArrayList<>();
        list.add(new BarChartItem("96.4k","Sep 20",188));
        list.add(new BarChartItem("6.4k","21",137));
        list.add(new BarChartItem("11.4k","22",112));
        list.add(new BarChartItem("36.4k","23",80));
        list.add(new BarChartItem("9.4k","24",160));
        list.add(new BarChartItem("9.4k","25",88));
        list.add(new BarChartItem("6.9k","26",164));
        AnalyticsBarChartAdapter adapter = new AnalyticsBarChartAdapter(list,getContext());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);


        return binding.getRoot();
    }

    private void setBarChart() {
        Description description = new Description();
        description.setText("");

        description.setText("");

        barChart.setDescription(description);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);
        barChart.setMinimumHeight(50);
        barChart.setNoDataTextColor(R.color.white);
        barChart.setDrawGridBackground(false);
        barChart.getAxisLeft().setAxisLineColor(ContextCompat.getColor(getContext(),R.color.white));
        barChart.getAxisRight().setAxisLineColor(ContextCompat.getColor(getContext(),R.color.white));
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setAxisLineColor(ContextCompat.getColor(getContext(),R.color.white));
        barChart.getXAxis().setAxisLineColor(ContextCompat.getColor(getContext(),R.color.white));
//        barChart.getXAxis().setTextColor(ContextCompat.getColor(getContext(),R.color.white));
        barChart.setNoDataTextColor(ContextCompat.getColor(getContext(),R.color.white));

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(20,40f));
        barEntries.add(new BarEntry(21,44f));
        barEntries.add(new BarEntry(22,30f));
        barEntries.add(new BarEntry(23,46f));
        barEntries.add(new BarEntry(24,36f));
        barEntries.add(new BarEntry(25,56f));
        barEntries.add(new BarEntry(26,26f));
        YAxis rightYAxis = barChart.getAxisRight();
        rightYAxis.setEnabled(false);

        BarDataSet barDataSet = new BarDataSet(barEntries,"");
        barDataSet.setValueTextColor(R.color.white);
        barDataSet.setColor(ContextCompat.getColor(getContext(),R.color.red));
        BarData data= new BarData(barDataSet);
        data.setBarWidth(0.7f);
        barChart.getLegend().setTextColor(ContextCompat.getColor(getContext(),R.color.white));
        barDataSet.setValueTextColor(ContextCompat.getColor(getContext(),R.color.white));
        barChart.setData(data);
        final ArrayList<String> months = new ArrayList<>();
        months.add("20");
        months.add("21");
        months.add("22");
        months.add("23");
        months.add("24");
        months.add("25");
        months.add("26");
        XAxis xAxis = barChart.getXAxis();
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(months));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getXAxis().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return months.get((int) value);
            }
        });
    }

    private void setLineChart() {
        LineChart lineChart = binding.lineChart;
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 5));
        entries.add(new Entry(1, 7));
        entries.add(new Entry(2, 10));
        entries.add(new Entry(3, 15));
        entries.add(new Entry(4, 13));
        entries.add(new Entry(5, 16));
        entries.add(new Entry(6, 19));
        LineDataSet lineDataSet = new LineDataSet(entries, "entries");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleColor(Color.WHITE);
        lineDataSet.setCircleColor(ContextCompat.getColor(getContext(),R.color.red));
        lineDataSet.setColor(ContextCompat.getColor(getContext(),R.color.red));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(true);
        lineDataSet.setDrawHighlightIndicators(false);
        lineChart.getAxisLeft().setEnabled(false);

        List<String> list = new ArrayList<>();
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.LTGRAY);
        xAxis.enableGridDashedLine(16, 12, 0);

        YAxis yAxis = lineChart.getAxisRight();
        yAxis.setDrawLabels(false);
        yAxis.setDrawAxisLine(false);
        yAxis.setDrawGridLines(false);
        yAxis.setSpaceTop(25);
        yAxis.setSpaceBottom(25);

        YAxis yAxisLeft = lineChart.getAxisLeft();
        yAxisLeft.setDrawLabels(false);
        yAxisLeft.setDrawAxisLine(false);
        yAxisLeft.setDrawGridLines(false);
        yAxis.setSpaceTop(25);
        yAxis.setSpaceBottom(25);
        Description description = new Description();
        description.setText("");

        lineChart.setDescription(description);
        lineChart.invalidate();
    }

}
