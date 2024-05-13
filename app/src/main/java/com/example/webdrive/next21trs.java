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
    }
}