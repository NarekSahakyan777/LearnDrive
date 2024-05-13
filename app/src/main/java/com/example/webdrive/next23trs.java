package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class next23trs extends AppCompatActivity {
    protected Button toNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next23trs);
        toNext = findViewById(R.id.nexTo2);
        toNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(next23trs.this, next3trs.class);
                startActivity(in);
            }
        });
    }
}