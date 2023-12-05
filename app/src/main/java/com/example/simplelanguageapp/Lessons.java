package com.example.simplelanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lessons extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playNumbersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        TextView basicsText = findViewById(R.id.textViewBasics);
        TextView greetingsText = findViewById(R.id.textViewGreetings);
        TextView introducingText = findViewById(R.id.textViewIntroducingYourself);

        TextView numbersText = findViewById(R.id.textViewNumbers);
        TextView numbersLessonText = findViewById(R.id.textViewNumbersLesson);

        playNumbersButton = findViewById(R.id.buttonPlayNumbers);
        playNumbersButton.setVisibility(View.GONE);

        basicsText.setOnClickListener(v -> toggleVisibility(greetingsText));
        greetingsText.setOnClickListener(v -> toggleVisibility(introducingText));
        introducingText.setOnClickListener(v -> toggleVisibility(numbersText));

        numbersText.setOnClickListener(v -> {
            toggleVisibility(numbersLessonText);
            playNumbersButton.setVisibility(View.VISIBLE);
        });

        playNumbersButton.setOnClickListener(v -> playNumbersSound());
    }

    private void toggleVisibility(TextView textView) {
        if (textView.getVisibility() == View.VISIBLE) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void playNumbersSound() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.numbers);
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}