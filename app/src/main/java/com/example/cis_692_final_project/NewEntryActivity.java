package com.example.cis_692_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NewEntryActivity extends AppCompatActivity {

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
    }

    /**
     * Method to navigate to the Main (Summary) Screen
     */
    public void goBack (View v) {
        this.finish();
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

    /**
     * TODO - create method for saving entry to sqlite db
     *
     * TODO - create method for calculating new stats based on latest entry
     */
}
