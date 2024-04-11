package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewCorrect, textViewIncorrect;
    Button backTo;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewCorrect = findViewById(R.id.textViewCorrect);
        textViewIncorrect = findViewById(R.id.textViewIncorrect);
        backTo = findViewById(R.id.backTo);

        int correctCount = getIntent().getIntExtra("correctCount", 0);
        int incorrectCount = getIntent().getIntExtra("incorrectCount", 0);

        textViewCorrect.setText("Correct Answers: " + correctCount);
        textViewIncorrect.setText("Incorrect Answers: " + incorrectCount);
        backTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to = new Intent(ResultActivity.this, Profile.class);
                startActivity(to);
            }
        });
    }
}