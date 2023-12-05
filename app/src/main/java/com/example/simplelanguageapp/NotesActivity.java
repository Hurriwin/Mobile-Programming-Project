package com.example.simplelanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NotesActivity extends AppCompatActivity {

    private EditText editTextNote;
    private static final String NOTE_KEY = "note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        editTextNote = findViewById(R.id.editTextNote);
        Button buttonSaveNote = findViewById(R.id.buttonSaveNote);

        buttonSaveNote.setOnClickListener(v -> saveNote());
        loadNote();
    }

    private void saveNote() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyNotes", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NOTE_KEY, editTextNote.getText().toString());
        editor.apply();
    }

    private void loadNote() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyNotes", MODE_PRIVATE);
        String savedNote = sharedPreferences.getString(NOTE_KEY, "");
        editTextNote.setText(savedNote);
    }
}