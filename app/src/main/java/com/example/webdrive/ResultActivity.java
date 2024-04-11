package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewCorrect, textViewIncorrect;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewCorrect = findViewById(R.id.textViewCorrect);
        textViewIncorrect = findViewById(R.id.textViewIncorrect);

        int correctCount = getIntent().getIntExtra("correctCount", 0);
        int incorrectCount = getIntent().getIntExtra("incorrectCount", 0);

        textViewCorrect.setText("Correct Answers: " + correctCount);
        textViewIncorrect.setText("Incorrect Answers: " + incorrectCount);
    }
}