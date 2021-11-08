package com.example.cis_692_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cis_692_final_project.data.DatabaseManager;
import com.example.cis_692_final_project.data.NewEntry;

public class NewEntryActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
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
     * Method for adding entry to sqlite db
     */
    public void addEntry( View v) {
        //Retrieves input data
        EditText weightEntryNumberEditText = (EditText) findViewById(R.id.input_new_entry_weight);
        EditText weightEntryDateEditText = (EditText) findViewById(R.id.input_new_entry_date);
//        EditText avgWeightLossTotalText = (EditText) findViewById(R.id.label_avg_weekly_weight_loss_number);
        String weightEntryNumber = weightEntryNumberEditText.getText().toString();
        String weightEntryDate = weightEntryDateEditText.getText().toString();

        //add data to db
        try {
            float weightEntry = Float.parseFloat(weightEntryNumber);
            NewEntry entry = new NewEntry(0, weightEntry, weightEntryDate);
            dbManager.insert(entry);
            Toast.makeText(this, "Entry Added", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Entry NOT Added", Toast.LENGTH_LONG).show();
        }

        //clear data
        weightEntryNumberEditText.setText("");
        weightEntryDateEditText.setText("");

        //update stats for summary screen
//        avgWeightLossTotalText.setText((int) dbManager.getAverage());
//        avgWeightLossTotalText.setText("THIS UPDATED!");
    }



    /**
     *
     * TODO - create method for calculating new stats based on latest entry
     */
}
