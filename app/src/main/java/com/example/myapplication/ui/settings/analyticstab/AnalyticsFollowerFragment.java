package com.example.myapplication.ui.settings.analyticstab;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.RangeColors;
import com.anychart.anychart.ValueDataEntry;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ProgressAdapter;
import com.example.myapplication.databinding.FragmentAnalyticsBinding;
import com.example.myapplication.databinding.FragmentAnalyticsFollowerBinding;
import com.example.myapplication.models.ProgressItem;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsFollowerFragment extends Fragment {
    FragmentAnalyticsFollowerBinding binding;

    List<ProgressItem> items ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnalyticsFollowerBinding.inflate(inflater,container,false);

        AnyChartView anyChartView =  binding.anyChartView;
        Pie pie = AnyChart.pie();
        RangeColors palette = new RangeColors();
        palette.setItems("#FF5B71","#D30E28");
        palette.setCount(2.0);
        pie.setPalette(palette);
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Male", 30000));
        data.add(new ValueDataEntry("Female", 12000));
        pie.explodeSlices(false);
        pie.setCredits("jaj");
        pie.setCredits(false);
        pie.setExplode(2.5);
        pie.setContainer("con1");
        pie.setCredits(true);
        pie.setCredits("");
        pie.setPalette(RangeColors.class.getName());
        pie.data(data);
        pie.getData().find("");
        anyChartView.setChart(pie);
        showPieChart();

        setProgressBar();

        return binding.getRoot();
    }

    private void setProgressBar() {
        items= new ArrayList<>();

        items.add(new ProgressItem("India","20",40));
        items.add(new ProgressItem("United States","20",30));
        items.add(new ProgressItem("Canada","20",10));
        items.add(new ProgressItem("United Kindom","20",10));
        items.add(new ProgressItem("Ukraine","20",10));
        ProgressAdapter adapter = new ProgressAdapter(items,getContext());
        binding.recyclerViewProgress.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.recyclerViewProgress.setHasFixedSize(true);
        binding.recyclerViewProgress.setAdapter(adapter);
        ViewCompat.setNestedScrollingEnabled(binding.recyclerViewProgress, false);
    }

    private void showPieChart(){

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        String label = "type";

        //initializing data
        Map<String, Integer> typeAmountMap = new HashMap<>();
        typeAmountMap.put("Male",40);
        typeAmountMap.put("Female",60);

        //initializing colors for the entries
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#FF5B71"));
        colors.add(Color.parseColor("#D30E28"));

        //input data and fit data into pie chart entry
        for(String type: typeAmountMap.keySet()){
            pieEntries.add(new PieEntry(typeAmountMap.get(type).floatValue(), type));
        }

        //collecting the entries with label name
        PieDataSet pieDataSet = new PieDataSet(pieEntries,label);
        //setting text size of the value
        pieDataSet.setValueTextSize(12f);

        ValueFormatter va = pieDataSet.getValueFormatter();


        //providing color list for coloring different entries
        pieDataSet.setColors(colors);
//        pieDataSet.setDrawValues(false);
        //grouping the data set from entry to chart
        PieData pieData = new PieData(pieDataSet);
        //showing the value of the entries, default true if not set
//        pieData.setDrawValues(false);

        Description des = binding.pieChartView.getDescription();
        des.setEnabled(false);
        pieDataSet.setValueTextColor(ContextCompat.getColor(getContext(),R.color.white));
        Legend leg = binding.pieChartView.getLegend();
        leg.setEnabled(false);
        binding.pieChartView.setDescription(null);
        binding.pieChartView.setDrawHoleEnabled(false);
        binding.pieChartView.setDrawSliceText(false); // To remove slice text
        binding.pieChartView.setDrawMarkers(false); // To remove markers when click
        binding.pieChartView.setDrawEntryLabels(false);
        binding.pieChartView.setDrawEntryLabels(false);
        binding.pieChartView.setUsePercentValues(true);
        binding.pieChartView.animateY(1400, Easing.EaseInBack);
        binding.tvFemale.setText( Float.toString(pieEntries.get(0).getValue())+"%");
        binding.tvMale.setText( Float.toString(pieEntries.get(1).getValue())+"%");

        binding.pieChartView.setNoDataTextColor(ContextCompat.getColor(getContext(),R.color.white));
        binding.pieChartView.setEntryLabelColor(ContextCompat.getColor(getContext(),R.color.white));
        binding.pieChartView.setCenterTextColor(ContextCompat.getColor(getContext(),R.color.white));

        binding.pieChartView.setData(pieData);
        binding.pieChartView.invalidate();
    }
}