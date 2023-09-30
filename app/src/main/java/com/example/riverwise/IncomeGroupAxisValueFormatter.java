package com.example.riverwise;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class IncomeGroupAxisValueFormatter extends ValueFormatter implements IAxisValueFormatter {

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        // Assuming value corresponds to index 0, 1, 2, or 3 in the incomeGroupsCount array
        switch ((int) value) {
            case 0:
                return "<10000";
            case 1:
                return "10000-20000";
            case 2:
                return "20001-30000";
            case 3:
                return "30001-50000";
            default:
                return "";
        }
    }
}

