package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class next3trs extends AppCompatActivity {
    protected Button toNextLast;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next3trs);
        toNextLast = findViewById(R.id.nexTo3);
        toNextLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(next3trs.this, next4trs.class);
                startActivity(in);
            }
        });
    }
}