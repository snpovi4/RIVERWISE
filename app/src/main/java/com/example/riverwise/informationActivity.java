package com.example.riverwise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;

public class informationActivity extends AppCompatActivity {
    TextView back,totalsrvr;
    CardView HighRisk,LowRisk,SemiRisk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        int totalRowCount = 0; // Initialize a counter for the total rows

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.csv_roumari_upazila));
            CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withSkipLines(1).build(); // Skip header line

            while (csvReader.readNext() != null) {
                // Increment the total row count for each row in the CSV
                totalRowCount++;
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        back=findViewById(R.id.backINs);
        HighRisk=findViewById(R.id.highrisk);
        LowRisk=findViewById(R.id.lowrisk);
        SemiRisk=findViewById(R.id.semirisk);
        totalsrvr=findViewById(R.id.totalsrvr);
        if(totalRowCount>0){
            totalsrvr.setText(String.valueOf(totalRowCount));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        HighRisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(informationActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.EXTRA_PDF_FILE, "https://drive.google.com/file/d/1uLVpqbgcwHPKeyTIGaKFtUGtCkqvnuA7/view");
                startActivity(intent);
            }
        });
        LowRisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(informationActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.EXTRA_PDF_FILE, "https://drive.google.com/file/d/1KcqQiLn78DWuDoRlHsJC-2ZHHxFDVrev/view");
                startActivity(intent);
                //Toast.makeText(informationActivity.this,"No Data Available Yet",Toast.LENGTH_SHORT).show();
            }
        });
        SemiRisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(informationActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.EXTRA_PDF_FILE, "https://drive.google.com/file/d/1XrumblmBoDA3ILPKZuH5mR2PfWhLTsMr/view");
                startActivity(intent);
                //Toast.makeText(informationActivity.this,"No Data Available Yet",Toast.LENGTH_SHORT).show();
            }
        });
    }
}