package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class next21trs extends AppCompatActivity {
    protected Button nextTo;
    private ImageView mImage1, mImage2, mImage3, mImage4, mImage5;

    private String imageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next21trs);
        nextTo = findViewById(R.id.nexTo);
        mImage1 = findViewById(R.id.imageView6);
        mImage2 = findViewById(R.id.imageView7);
        mImage3 = findViewById(R.id.imageView8);
        mImage4 = findViewById(R.id.imageView9);
        mImage5 = findViewById(R.id.imageView10);
        nextTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(next21trs.this, next2trs.class);
                startActivity(in);
            }
        });
        configureImages();
    }
    private void configureImages() {
        mImage1.setOnClickListener(view -> {
            imageName = "Name: Dangerous turns";
            configureDialogFragment();
        });
        mImage2.setOnClickListener(view -> {
            imageName = "Name: Slippery road";
            configureDialogFragment();
        });
        mImage3.setOnClickListener(view -> {
            imageName = "Name: Narrowing road";
            configureDialogFragment();
        });
        mImage4.setOnClickListener(view -> {
            imageName = "Name: Road works";
            configureDialogFragment();
        });
        mImage5.setOnClickListener(view ->{
            imageName = "Name: Rock fall";
            configureDialogFragment();
        });

    }private void configureDialogFragment() {
        String[] namesOfSings = getResources().getStringArray(R.array.names_of_sings);
        String[] descriptionOfSings = getResources().getStringArray(R.array.descriptions_of_sings);
        for (int i = 5; i < namesOfSings.length; i++) {
            if (!imageName.equals(namesOfSings[i])) {
                continue;
            }

            BlankFragment dialogFragment = new BlankFragment(imageName, descriptionOfSings[i]);
            dialogFragment.show(getSupportFragmentManager(), "DialogFragment");
            break;
        }
    }

}