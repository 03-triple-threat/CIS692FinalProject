package com.example.cis_692_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cis_692_final_project.data.DatabaseManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

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
        updateView();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        updateView();
    }

    public void updateView() {

        System.out.println(dbManager.selectAll());

        // update to grab the latest entry
        TextView currentWeightText = (TextView) findViewById(R.id.label_current_weight_number);
        currentWeightText.setText(String.valueOf((float) dbManager.selectAll().get(dbManager.selectAll().size()-1).getInputWeight()).trim() + " lbs");

        // update the BMI calculation - todo: write this logic
//        TextView bmiCalcText = (TextView) findViewById(R.id.label_main_body_mass_index_number);
//        bmiCalcText.setText();

        // update the avg weekly loss - todo: work on logic for avg weekly weight loss
        TextView avgWeightLossTotalText = (TextView) findViewById(R.id.label_avg_weekly_weight_loss_number);
        avgWeightLossTotalText.setText( dbManager.getAverage() + " lbs");

        // update total weight lost
        TextView totalWeightLostText = (TextView) findViewById(R.id.label_total_weight_loss_number);
        totalWeightLostText.setText((((float) dbManager.selectAll().get(dbManager.selectAll().size()-1).getInputWeight() - (float) dbManager.selectAll().get(0).getInputWeight()) * -1) + " lbs");
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