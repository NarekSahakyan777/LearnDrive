package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class next3trs extends AppCompatActivity {
    protected Button toNextLast;
    private ImageView mImage1, mImage2, mImage3, mImage4, mImage5;

    private String imageName;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next3trs);
        toNextLast = findViewById(R.id.nexTo3);
        mImage1 = findViewById(R.id.imageView21);
        mImage2 = findViewById(R.id.imageView22);
        mImage3 = findViewById(R.id.imageView23);
        mImage4 = findViewById(R.id.imageView24);
        mImage5 = findViewById(R.id.imageView25);

        toNextLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(next3trs.this, next4trs.class);
                startActivity(in);
            }
        });
        configureImages();

    }
    private void configureImages() {
        mImage1.setOnClickListener(view -> {
            imageName = "Name: Traffic is direct";
            configureDialogFragment();
        });
        mImage2.setOnClickListener(view -> {
            imageName = "Name: Roundabout traffic";
            configureDialogFragment();
        });
        mImage3.setOnClickListener(view -> {
            imageName = "Name: Pedestrian crossing";
            configureDialogFragment();
        });
        mImage4.setOnClickListener(view -> {
            imageName = "Name: Residence beginning";
            configureDialogFragment();
        });
        mImage5.setOnClickListener(view ->{
            imageName = "Name: End of settlement";
            configureDialogFragment();
        });
    }private void configureDialogFragment() {
        String[] namesOfSings = getResources().getStringArray(R.array.names_of_sings);
        String[] descriptionOfSings = getResources().getStringArray(R.array.descriptions_of_sings);
        for (int i = 20; i < namesOfSings.length; i++) {
            if (!imageName.equals(namesOfSings[i])) {
                continue;
            }

            BlankFragment dialogFragment = new BlankFragment(imageName, descriptionOfSings[i]);
            dialogFragment.show(getSupportFragmentManager(), "DialogFragment");
            break;
        }
    }
}