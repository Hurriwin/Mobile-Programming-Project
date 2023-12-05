package com.example.simplelanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Button lessonsButton = findViewById(R.id.buttonLessons);
        lessonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Lessons activity
                Intent intent = new Intent(HomeScreenActivity.this, Lessons.class);
                startActivity(intent);
            }
        });

        Button settingsButton = findViewById(R.id.buttonSettings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Settings activity
                Intent intent = new Intent(HomeScreenActivity.this, Settings.class);
                startActivity(intent);
            }
        });

        Button notesButton = findViewById(R.id.buttonNotes);
        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Notes activity
                Intent intent = new Intent(HomeScreenActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });

        Button countriesButton = findViewById(R.id.buttonCountries);
        countriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, CountriesActivity.class);
                startActivity(intent);
            }
        });
    }

}