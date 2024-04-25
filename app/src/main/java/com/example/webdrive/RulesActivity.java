package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {
    private final String[] texts = {
            "If you want to learn and insure your life to be a good driver, take this lesson and take the quiz.",
            "NEVER DRINK AND DRIVE",
            "ALWAYS WEAR SEAT BELT",
            "MAINTAIN A SAFE DISTANCE",
            "STAY AWAY FROM DISTRACTIONS AT ALL COSTS",
            "NEVER DISOBEY A RED LIGHT",
            "ALWAYS STICK TO THE SPEED LIMIT",
            "AVOID BEING DROWSY WHILE DRIVING",
            "KEEP AN EYE OUT FOR OTHER DRIVERS ON THE ROAD",
            "MAINTAIN YOUR VEHICLE ON A REGULAR BASIS"

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
                if (currentIndex == texts.length - 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(RulesActivity.this, Profile.class);
                            startActivity(intent);
                        }
                    }, 5000);
                }
            }
        });

    }
}