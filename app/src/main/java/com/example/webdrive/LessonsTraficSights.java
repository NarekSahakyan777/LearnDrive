package com.example.webdrive;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LessonsTraficSights extends AppCompatActivity {
    protected Button nextTo;
    private ImageView mImage1, mImage2, mImage3, mImage4, mImage5;

    private String imageName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_trafic_sights);
        nextTo = findViewById(R.id.nexTo);
        mImage1 = findViewById(R.id.imageView1);
        mImage2 = findViewById(R.id.imageView2);
        mImage3 = findViewById(R.id.imageView3);
        mImage4 = findViewById(R.id.imageView4);
        mImage5 = findViewById(R.id.imageView5);


        nextTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LessonsTraficSights.this, next21trs.class);
                startActivity(in);
            }
        });

        configureImages();
    }


    private void configureImages() {
        mImage1.setOnClickListener(view -> {
            imageName = "Name: Intersection with roundabout";
            configureDialogFragment();
        });
        mImage2.setOnClickListener(view -> {
            imageName = "Name: Lighting setup";
            configureDialogFragment();
        });
        mImage3.setOnClickListener(view -> {
            imageName = "Name: Steep descent";
            configureDialogFragment();
        });
        mImage4.setOnClickListener(view -> {
            imageName = "Name: Two way traffic";
            configureDialogFragment();
        });
        mImage5.setOnClickListener(view ->{
            imageName = "Name: Pedestrian crossing";
            configureDialogFragment();
        });

    }

    private void configureDialogFragment() {
        String[] namesOfSings = getResources().getStringArray(R.array.names_of_sings);
        String[] descriptionOfSings = getResources().getStringArray(R.array.descriptions_of_sings);
        for (int i = 0; i < namesOfSings.length; i++) {
            if (!imageName.equals(namesOfSings[i])) {
                continue;
            }

            BlankFragment dialogFragment = new BlankFragment(imageName, descriptionOfSings[i]);
            dialogFragment.show(getSupportFragmentManager(), "DialogFragment");
            break;
        }
    }
}