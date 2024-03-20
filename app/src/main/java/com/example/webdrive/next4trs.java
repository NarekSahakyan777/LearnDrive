package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class next4trs extends AppCompatActivity {
    protected Button goTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next4trs);
        goTo = findViewById(R.id.goToRoadSignsActivity);
        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(next4trs.this, RoadSignsActivity.class);
                startActivity(in);
            }
        });
    }
}