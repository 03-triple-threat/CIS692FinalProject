package com.example.cis_692_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cis_692_final_project.data.DatabaseManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart() {
        super.onStart();
//        updateView();

    }

    @Override
    public void onRestart() {
        super.onRestart();
        updateView();
    }

    public void updateView() {

        try {
            System.out.println(dbManager.selectAllEntries());

            // update to grab the latest entry
            TextView currentWeightText = (TextView) findViewById(R.id.label_current_weight_number);
            currentWeightText.setText(String.valueOf((float) dbManager.selectAllEntries().get(dbManager.selectAllEntries().size() - 1).getInputWeight()).trim() + " lbs");

            // update the BMI calculation - todo: write this logic
//        TextView bmiCalcText = (TextView) findViewById(R.id.label_main_body_mass_index_number);
//        bmiCalcText.setText();

            // update the avg weekly loss - todo: work on logic for avg weekly weight loss
            TextView avgWeightLossTotalText = (TextView) findViewById(R.id.label_avg_weekly_weight_loss_number);
            avgWeightLossTotalText.setText(dbManager.getAverageWeightLossPerWeek() + " lbs");

            // update total weight lost
            TextView totalWeightLostText = (TextView) findViewById(R.id.label_total_weight_loss_number);
            totalWeightLostText.setText((((float) dbManager.selectAllEntries().get(dbManager.selectAllEntries().size() - 1).getInputWeight() - (float) dbManager.selectAllEntries().get(0).getInputWeight()) * -1) + " lbs");
        } catch (Exception e) {
            System.out.println("NO DB Exists");
        }
    }

    /**
     * Method to navigate to the New Entry Screen
     */
    public void enterData (View v) {
        Intent myIntent = new Intent(this, NewEntryActivity.class);
        this.startActivity(myIntent);
    }

    /**
     * Method to navigate to the Settings Screen
     */
    public void updateSettings (View v) {
        Intent myIntent = new Intent( this, SettingsActivity.class);
        this.startActivity(myIntent);
    }

    /**
     * Method to navigate to the History Screen
     */
    public void viewHistory (View v) {
        Intent myIntent = new Intent( this, HistoryActivity.class);
        this.startActivity(myIntent);
    }
}