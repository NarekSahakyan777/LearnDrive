package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class next23trs extends AppCompatActivity {
    protected Button toNext;
    private ImageView mImage1, mImage2, mImage3, mImage4, mImage5;

    private String imageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next23trs);
        toNext = findViewById(R.id.nexTo2);
        mImage1 = findViewById(R.id.imageView16);
        mImage2 = findViewById(R.id.imageView17);
        mImage3 = findViewById(R.id.imageView18);
        mImage4 = findViewById(R.id.imageView19);
        mImage5 = findViewById(R.id.imageView20);
        toNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(next23trs.this, next3trs.class);
                startActivity(in);
            }
        });
        configureImages();

    }
    private void configureImages() {
        mImage1.setOnClickListener(view -> {
            imageName = "Name: End of Main road";
            configureDialogFragment();
        });
        mImage2.setOnClickListener(view -> {
            imageName = "Name: Give way";
            configureDialogFragment();
        });
        mImage3.setOnClickListener(view -> {
            imageName = "Name: Traffic is prohibited";
            configureDialogFragment();
        });
        mImage4.setOnClickListener(view -> {
            imageName = "Name: Right turns are prohibited";
            configureDialogFragment();
        });
        mImage5.setOnClickListener(view ->{
            imageName = "Name: Left turns are prohibited";
            configureDialogFragment();
        });
    }private void configureDialogFragment() {
        String[] namesOfSings = getResources().getStringArray(R.array.names_of_sings);
        String[] descriptionOfSings = getResources().getStringArray(R.array.descriptions_of_sings);
        for (int i = 15; i < namesOfSings.length; i++) {
            if (!imageName.equals(namesOfSings[i])) {
                continue;
            }

            BlankFragment dialogFragment = new BlankFragment(imageName, descriptionOfSings[i]);
            dialogFragment.show(getSupportFragmentManager(), "DialogFragment");
            break;
        }
    }
}