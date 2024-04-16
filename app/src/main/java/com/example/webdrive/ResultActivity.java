package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView score;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        score = findViewById(R.id.score);
        int scoree = getIntent().getIntExtra("Result",0);
        score.setText("Score: " + scoree);
        findViewById(R.id.backTo).setOnClickListener(
                restart->{
                    Intent in = new Intent(ResultActivity.this, Profile.class);
                    startActivity(in);
                    finish();
                }
        );
    }
}