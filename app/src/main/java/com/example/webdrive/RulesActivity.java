package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {
    private final String[] texts = {
            "If you want to learn and insure your life to be a good driver, take this lesson and take the quiz.",
            "Text 2",
            "Text 3"
    };
    private int currentIndex = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
         TextView textView = findViewById(R.id.textView);
        Button buttonNext = findViewById(R.id.buttonNext);
        textView.setText(texts[currentIndex]);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % texts.length;
                textView.setText(texts[currentIndex]);
            }
        });

    }
}