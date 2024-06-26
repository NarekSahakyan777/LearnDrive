package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class next4trs extends AppCompatActivity {
    protected Button goTo,backToCategories;
    private ImageView mImage1, mImage2, mImage3, mImage4;

    private String imageName;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next4trs);
        backToCategories = findViewById(R.id.backToCategories);
        mImage1 = findViewById(R.id.imageView26);
        mImage2 = findViewById(R.id.imageView27);
        mImage3 = findViewById(R.id.imageView28);
        mImage4 = findViewById(R.id.imageView29);


        backToCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to = new Intent(next4trs.this, Profile.class);
                startActivity(to);
            }
        });
        configureImages();

    }
    private void configureImages() {
        mImage1.setOnClickListener(view -> {
            imageName = "Name: Place of return";
            configureDialogFragment();
        });
        mImage2.setOnClickListener(view -> {
            imageName = "Name: Parking";
            configureDialogFragment();
        });
        mImage3.setOnClickListener(view -> {
            imageName = "Name: Hospital";
            configureDialogFragment();
        });
        mImage4.setOnClickListener(view -> {
            imageName = "Name: Distance to object";
            configureDialogFragment();
        });
    }private void configureDialogFragment() {
        String[] namesOfSings = getResources().getStringArray(R.array.names_of_sings);
        String[] descriptionOfSings = getResources().getStringArray(R.array.descriptions_of_sings);
        for (int i = 25; i < namesOfSings.length; i++) {
            if (!imageName.equals(namesOfSings[i])) {
                continue;
            }

            BlankFragment dialogFragment = new BlankFragment(imageName, descriptionOfSings[i]);
            dialogFragment.show(getSupportFragmentManager(), "DialogFragment");
            break;
        }
    }
}