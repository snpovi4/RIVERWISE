package com.example.riverwise;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import android.content.res.Resources;
import android.content.res.AssetManager;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DashboardActivity extends AppCompatActivity {
    CardView nextCard;
    TextView back,next,viewMAP;
    BarChart barChart1,barChart2,barChart3;
    PieChart pieChart1,pieChart2;
    ImageView imgVW;
    private boolean isImage1 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        nextCard=findViewById(R.id.nextPage);
        back=findViewById(R.id.back);
        next=findViewById(R.id.next);
        viewMAP=findViewById(R.id.viewmap);
        barChart1=findViewById(R.id.barChart1);
        barChart2=findViewById(R.id.barChart2);
        barChart3=findViewById(R.id.barChart3);
        pieChart1=findViewById(R.id.pieChart1);
        pieChart2=findViewById(R.id.pieChart2);
        imgVW=findViewById(R.id.img);
        imgVW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isImage1) {
                    imgVW.setImageResource(R.drawable.before);
                } else {
                    imgVW.setImageResource(R.drawable.after);
                }

                // Toggle the boolean flag
                isImage1 = !isImage1;
            }
        });
        showAlert();


        int[] incomeGroupsCount = new int[4];
        int[] ageGroupsCount = new int[3];
        int[] occupationGroupsCount= new int[6];
        int[] buildingGroupsCount = new int[2];
        int[] disabilityGroupsCount = new int[2];
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.csv_roumari_upazila));
            CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withSkipLines(1).build(); // Skip header line if needed

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming the "Income group" column is at index 6 (adjust the index as needed)
                String incomeGroup = nextRecord[6]; // Replace with the actual column index

                // Compare the income group string and update the array
                if ("<10000".equals(incomeGroup)) {
                    incomeGroupsCount[0]++;
                } else if ("10000-20000".equals(incomeGroup)) {
                    incomeGroupsCount[1]++;
                } else if ("20001-30000".equals(incomeGroup)) {
                    incomeGroupsCount[2]++;
                } else if ("30001-50000".equals(incomeGroup)) {
                    incomeGroupsCount[3]++;
                }
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.csv_roumari_upazila));
            CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withSkipLines(1).build(); // Skip header line if needed

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming the "Income group" column is at index 6 (adjust the index as needed)
                String ageGroup = nextRecord[4]; // Replace with the actual column index

                // Compare the income group string and update the array
                if ("0-14".equals(ageGroup)) {
                    ageGroupsCount[0]++;
                } else if ("15-59".equals(ageGroup)) {
                    ageGroupsCount[1]++;
                } else if ("59+".equals(ageGroup)) {
                    ageGroupsCount[2]++;
                }
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.csv_roumari_upazila));
            CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withSkipLines(1).build(); // Skip header line if needed

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming the "Income group" column is at index 6 (adjust the index as needed)
                String occupationGroup = nextRecord[7]; // Replace with the actual column index

                // Compare the income group string and update the array
                if ("Farming".equals(occupationGroup)) {
                    occupationGroupsCount[0]++;
                } else if ("Aquaculture".equals(occupationGroup)) {
                    occupationGroupsCount[1]++;
                } else if ("Business".equals(occupationGroup)) {
                    occupationGroupsCount[2]++;
                } else if ("Day labour".equals(occupationGroup)) {
                    occupationGroupsCount[3]++;
                }else if ("Service".equals(occupationGroup)) {
                    occupationGroupsCount[4]++;
                } else if ("Craft".equals(occupationGroup)) {
                    occupationGroupsCount[5]++;
                }
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.csv_roumari_upazila));
            CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withSkipLines(1).build(); // Skip header line if needed

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming the "Income group" column is at index 6 (adjust the index as needed)
                String buildingGroup = nextRecord[5]; // Replace with the actual column index

                // Compare the income group string and update the array
                if ("Pucca".equals(buildingGroup)) {
                    buildingGroupsCount[0]++;
                } else if ("Tinshed".equals(buildingGroup)) {
                    buildingGroupsCount[1]++;
                }
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.csv_roumari_upazila));
            CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withSkipLines(1).build(); // Skip header line if needed

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming the "Income group" column is at index 6 (adjust the index as needed)
                String disabilityGroup = nextRecord[8]; // Replace with the actual column index

                // Compare the income group string and update the array
                if ("No".equals(disabilityGroup)) {
                    disabilityGroupsCount[0]++;
                } else if ("Yes".equals(disabilityGroup)) {
                    disabilityGroupsCount[1]++;
                }
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        BarDataSet dataSet = new BarDataSet(Arrays.asList(
                new BarEntry(0, incomeGroupsCount[0]),
                new BarEntry(1, incomeGroupsCount[1]),
                new BarEntry(2, incomeGroupsCount[2]),
                new BarEntry(3, incomeGroupsCount[3])
        ), "Income Groups");

// Customize the appearance of the chart
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS); // You can customize colors here
        dataSet.setValueTextSize(12f);

// Create a BarData object and add the dataSet
        BarData barData = new BarData(dataSet);

// Set the data to your barChart1
        barChart1.setData(barData);

        YAxis leftYAxis = barChart1.getAxisLeft();
        leftYAxis.setDrawLabels(true); // Show labels on the left Y-axis
        leftYAxis.setDrawAxisLine(true);

        YAxis rightYAxis = barChart1.getAxisRight();
        rightYAxis.setDrawLabels(false); // Hide labels on the right Y-axis
        rightYAxis.setDrawAxisLine(false);

        ValueFormatter valueFormatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if (value == 0) {
                    return "<10k";
                } else if (value == 1) {
                    return "<20k";
                } else if (value == 2) {
                    return "<30k";
                } else if (value == 3) {
                    return "<50k";
                } else {
                    return "";
                }
            }
        };

        XAxis xAxis = barChart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

// Define the xLabels array
        String[] xLabels = {"<10k", "10k-20k", "20k-30k", "30k-50k"};

        xAxis.setValueFormatter(new IndexAxisValueFormatter(xLabels));
        xAxis.setGranularity(1f); // To avoid decimal values on the x-axis

// Set the custom value formatter for the data set
        dataSet.setValueFormatter(valueFormatter);
        barChart1.getDescription().setEnabled(false);
// Refresh the chart to update the display
        barChart1.invalidate();
        //
        // Create a BarDataSet for occupation groups
        BarDataSet occupationDataSet = new BarDataSet(Arrays.asList(
                new BarEntry(0, occupationGroupsCount[0]),
                new BarEntry(1, occupationGroupsCount[1]),
                new BarEntry(2, occupationGroupsCount[2]),
                new BarEntry(3, occupationGroupsCount[3]),
                new BarEntry(4, occupationGroupsCount[4]),
                new BarEntry(5, occupationGroupsCount[5])
        ), "Occupation Groups");

// Customize the appearance of the chart
        occupationDataSet.setColors(ColorTemplate.MATERIAL_COLORS); // You can customize colors here
        occupationDataSet.setValueTextSize(12f);

// Create a BarData object and add the dataSet
        BarData occupationBarData = new BarData(occupationDataSet);

// Set the data to your barChart2
        barChart2.setData(occupationBarData);

        YAxis leftYAxis2 = barChart2.getAxisLeft();
        leftYAxis2.setDrawLabels(true); // Show labels on the left Y-axis
        leftYAxis2.setDrawAxisLine(true);

        YAxis rightYAxis2 = barChart2.getAxisRight();
        rightYAxis2.setDrawLabels(false); // Hide labels on the right Y-axis
        rightYAxis2.setDrawAxisLine(false);

        ValueFormatter occupationValueFormatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if (value == 0) {
                    return "Farming";
                } else if (value == 1) {
                    return "Aquaculture";
                } else if (value == 2) {
                    return "Business";
                } else if (value == 3) {
                    return "Day labour";
                } else if (value == 4) {
                    return "Service";
                } else if (value == 5) {
                    return "Craft";
                } else {
                    return "";
                }
            }
        };

        XAxis xAxis2 = barChart2.getXAxis();
        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);

// Define the xLabels array
        String[] occupationLabels = {"Farming", "Aquaculture", "Business", "Day labour", "Service", "Craft"};

        xAxis2.setValueFormatter(new IndexAxisValueFormatter(occupationLabels));
        xAxis2.setGranularity(1f); // To avoid decimal values on the x-axis

// Set the custom value formatter for the data set
        occupationDataSet.setValueFormatter(occupationValueFormatter);
        barChart2.getDescription().setEnabled(false); // Remove description label

// Refresh the chart to update the display
        barChart2.invalidate();

        BarDataSet disabilityDataSet = new BarDataSet(Arrays.asList(
                new BarEntry(0, disabilityGroupsCount[0]),
                new BarEntry(1, disabilityGroupsCount[1])
        ), "Disability Groups");

// Customize the appearance of the chart
        disabilityDataSet.setColors(ColorTemplate.MATERIAL_COLORS); // You can customize colors here
        disabilityDataSet.setValueTextSize(12f);

// Create a BarData object and add the dataSet
        BarData disabilityBarData = new BarData(disabilityDataSet);

// Set the data to your barChart3
        barChart3.setData(disabilityBarData);

        YAxis leftYAxis3 = barChart3.getAxisLeft();
        leftYAxis3.setDrawLabels(true); // Show labels on the left Y-axis
        leftYAxis3.setDrawAxisLine(true);

        YAxis rightYAxis3 = barChart3.getAxisRight();
        rightYAxis3.setDrawLabels(false); // Hide labels on the right Y-axis
        rightYAxis3.setDrawAxisLine(false);

        ValueFormatter disabilityValueFormatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if (value == 0) {
                    return "No";
                } else if (value == 1) {
                    return "Yes";
                } else {
                    return "";
                }
            }
        };

        XAxis xAxis3 = barChart3.getXAxis();
        xAxis3.setPosition(XAxis.XAxisPosition.BOTTOM);

// Define the xLabels array
        String[] disabilityLabels = {"No", "Yes"};

        xAxis3.setValueFormatter(new IndexAxisValueFormatter(disabilityLabels));
        xAxis3.setGranularity(1f); // To avoid decimal values on the x-axis

// Set the custom value formatter for the data set
        disabilityDataSet.setValueFormatter(disabilityValueFormatter);
        barChart3.getDescription().setEnabled(false); // Remove description label

// Refresh the chart to update the display
        barChart3.invalidate();
        //
        // Calculate the total count of age groups
        int totalAgeCount = ageGroupsCount[0] + ageGroupsCount[1] + ageGroupsCount[2];

// Calculate the percentage values
        float ageGroup0_14Percentage = (ageGroupsCount[0] * 100f) / totalAgeCount;
        float ageGroup15_59Percentage = (ageGroupsCount[1] * 100f) / totalAgeCount;
        float ageGroup59PlusPercentage = (ageGroupsCount[2] * 100f) / totalAgeCount;

// Create a list of PieEntries for age groups with percentages
        ArrayList<PieEntry> ageGroupsEntriesPercentage = new ArrayList<>();
        ageGroupsEntriesPercentage.add(new PieEntry(ageGroup0_14Percentage, "0-14"));
        ageGroupsEntriesPercentage.add(new PieEntry(ageGroup15_59Percentage, "15-59"));
        ageGroupsEntriesPercentage.add(new PieEntry(ageGroup59PlusPercentage, "59+"));

// Create a PieDataSet for age groups
        PieDataSet ageGroupsDataSetPercentage = new PieDataSet(ageGroupsEntriesPercentage, "Age Groups ( % )");

// Customize the appearance of the PieDataSet
        ageGroupsDataSetPercentage.setColors(ColorTemplate.MATERIAL_COLORS); // You can customize colors here
        ageGroupsDataSetPercentage.setValueTextSize(12f);
        ageGroupsDataSetPercentage.setValueFormatter(new PercentFormatter(pieChart1));

// Create a PieData object and add the PieDataSet
        PieData ageGroupsDataPercentage = new PieData(ageGroupsDataSetPercentage);

// Set the data to your pieChart1
        pieChart1.setData(ageGroupsDataPercentage);
        pieChart1.getDescription().setEnabled(false); // Remove description label

// Refresh the chart to update the display
        pieChart1.invalidate();

        // Calculate the total count of building groups
        int totalBuildingCount = buildingGroupsCount[0] + buildingGroupsCount[1];

// Calculate the percentage values
        float puccaPercentage = (buildingGroupsCount[0] * 100f) / totalBuildingCount;
        float tinshedPercentage = (buildingGroupsCount[1] * 100f) / totalBuildingCount;

// Create a list of PieEntries for building groups with percentages
        ArrayList<PieEntry> buildingGroupsEntries = new ArrayList<>();
        buildingGroupsEntries.add(new PieEntry(puccaPercentage, "Pucca"));
        buildingGroupsEntries.add(new PieEntry(tinshedPercentage, "Tinshed"));

// Create a PieDataSet for building groups
        PieDataSet buildingGroupsDataSet = new PieDataSet(buildingGroupsEntries, " Building Groups ( % )");

// Customize the appearance of the PieDataSet
        buildingGroupsDataSet.setColors(ColorTemplate.MATERIAL_COLORS); // You can customize colors here
        buildingGroupsDataSet.setValueTextSize(12f);
        buildingGroupsDataSet.setValueFormatter(new PercentFormatter(pieChart2));

// Create a PieData object and add the PieDataSet
        PieData buildingGroupsData = new PieData(buildingGroupsDataSet);

// Set the data to your pieChart2
        pieChart2.setData(buildingGroupsData);
        pieChart2.getDescription().setEnabled(false); // Remove description label

// Refresh the chart to update the display
        pieChart2.invalidate();

        viewMAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.EXTRA_PDF_FILE, "https://openstreet-map.vercel.app/");
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,informationActivity.class));
            }
        });
        nextCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,informationActivity.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Welcome to our Flood Susceptibility Mapping App! Our INSIGHTS section offers valuable demographic data, enabling targeted disaster response. Explore income, occupation, building type, disability, and age group info. Empower disaster mitigation and resilience efforts with informed beneficiary selection and driven decisions.");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog when the "Okay" button is clicked
                dialog.dismiss();
            }
        });

        // Create and show the dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}