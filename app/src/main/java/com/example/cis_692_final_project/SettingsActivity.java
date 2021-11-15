package com.example.cis_692_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cis_692_final_project.data.DatabaseManager;
import com.example.cis_692_final_project.data.Person;

public class SettingsActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    /**
     * Method to navigate to the Main (Summary) Screen
     *
     * TODO - connect with Discard Setting button
     */
    public void goToMain (View v) {
        this.finish();
    }

    /**
     * Method to navigate to the New Entry Screen
     */
    public void enterData (View v) {
        Intent myIntent = new Intent(this, NewEntryActivity.class);
        this.startActivity(myIntent);
    }

    /**
     * Method to navigate to the History Screen
     */
    public void viewHistory (View v) {
        Intent myIntent = new Intent( this, HistoryActivity.class);
        this.startActivity(myIntent);
    }

    public void addSettings(View v) {
        //retrieve input data from screen
        EditText startingWeightInputEditText = (EditText) findViewById(R.id.input_settings_current_weight);
        EditText startingDateInputEditText = (EditText) findViewById(R.id.input_settings_starting_date);
        EditText targetWeightInputEditText = (EditText) findViewById(R.id.input_settings_target_weight);
        EditText targetDateInputEditText = (EditText) findViewById(R.id.input_settings_target_date);
//        EditText genderSelectionEditText = (EditText) findViewById(R.id.myRadioGroup); // todo - determine how to get this value
        EditText heightInputEditText = (EditText) findViewById(R.id.input_settings_height);

        String startingWeightInputString = startingWeightInputEditText.getText().toString();
        String startingDateInputString = startingDateInputEditText.getText().toString();
        String targetWeightInputString = targetWeightInputEditText.getText().toString();
        String targetDateInputString = targetDateInputEditText.getText().toString();
//        String genderSelectionString //  todo - determine how to get this value
        String heightInputString = heightInputEditText.getText().toString();

        //add data to db
        try {
            float startingWeight = Float.parseFloat(startingWeightInputString);
            float targetWeight = Float.parseFloat(targetWeightInputString);

            Person person = new Person(0, startingWeight, startingDateInputString, targetWeight,
                    targetDateInputString, "NA", heightInputString);

            dbManager.insertPerson(person);
            Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this,"Settings NOT Saved", Toast.LENGTH_LONG).show();
        }
    }
}