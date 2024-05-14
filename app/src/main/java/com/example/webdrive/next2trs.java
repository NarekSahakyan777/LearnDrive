package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class next2trs extends AppCompatActivity {
    protected Button toNext;
    private ImageView mImage1, mImage2, mImage3, mImage4, mImage5;

    private String imageName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2trs);
        toNext = findViewById(R.id.nexTo2);
        mImage1 = findViewById(R.id.imageView11);
        mImage2 = findViewById(R.id.imageView12);
        mImage3 = findViewById(R.id.imageView13);
        mImage4 = findViewById(R.id.imageView14);
        mImage5 = findViewById(R.id.imageView15);
        toNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(next2trs.this, next23trs.class);
                startActivity(in);
            }
        });
        configureImages();

    }
    private void configureImages() {
        mImage1.setOnClickListener(view -> {
            imageName = "Name: Main road";
            configureDialogFragment();
        });
        mImage2.setOnClickListener(view -> {
            imageName = "Name: Intersection with secondary road";
            configureDialogFragment();
        });
        mImage3.setOnClickListener(view -> {
            imageName = "Name: Entry is denied";
            configureDialogFragment();
        });
        mImage4.setOnClickListener(view -> {
            imageName = "Name: Maximum speed limit";
            configureDialogFragment();
        });
        mImage5.setOnClickListener(view ->{
            imageName = "Name: Stopping is prohibited";
            configureDialogFragment();
        });
    }private void configureDialogFragment() {
        String[] namesOfSings = getResources().getStringArray(R.array.names_of_sings);
        String[] descriptionOfSings = getResources().getStringArray(R.array.descriptions_of_sings);
        for (int i = 10; i < namesOfSings.length; i++) {
            if (!imageName.equals(namesOfSings[i])) {
                continue;
            }

            BlankFragment dialogFragment = new BlankFragment(imageName, descriptionOfSings[i]);
            dialogFragment.show(getSupportFragmentManager(), "DialogFragment");
            break;
        }
    }
}