package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {
    private final String[] texts = {
            "If you want to learn and insure your life to be a good driver, take this lesson and take the quiz.",
            "NEVER DRINK AND DRIVE",
            "ALWAYS WEAR SEAT BELT",
            "MAINTAIN A SAFE DISTANCE",
            "STAY AWAY FROM DISTRACTIONS AT ALL COSTS",
            "NEVER DISOBEY A RED LIGHT",
            "ALWAYS STICK TO THE SPEED LIMIT",
            "AVOID BEING DROWSY WHILE DRIVING",
            "KEEP AN EYE OUT FOR OTHER DRIVERS ON THE ROAD",
            "MAINTAIN YOUR VEHICLE ON A REGULAR BASIS"

    };
    private final String[] smallTexts = {
            "Learn Carefully",
            "Drinking and driving may look like fun but it is far more dangerous not just to self but for others too. Besides risking the lives of people on the road, co-passengers and self, being caught driving while inebriated can land you in big trouble with authorities.",
            "Don't call yourself a safe driver if you don't wear your seat belt around your chest and waist habitually. Driving a car with a seat belt not only ensures your safety but is also mandatory under the law.",
            "When driving a vehicle with new tires on a dry road surface, you need to allow a vehicle-to-vehicle distance of about 100 m at 100 km/h and 80 m at 80 km/h.",
            "Distractions while driving, such as chatting on cell phones, eating food, and so on, are extremely detrimental to our safety and that of others.",
            "It is one of the most common causes of car accidents. When you accept the risk of running a red light, another automobile will turn, resulting in some serious accidents.",
            "Youngsters in general enjoy speed, but this enjoyment might lead to an end of your life or lasting impairments.  Almost every year, overspeeding accounts for more than 45 percent of major crashes.",
            "If you really are feeling tired or sleepy, you must refrain from driving. It is just as risky as driving while intoxicated.",
            "Be attentive  situation and others by scanning your mirrors and side streets.",
            "Every car owner is always maintaining their vehicle, such as the brakes, engine oil, tyre pressure, engine, and so on."
    };
    private int currentIndex = 0;
    private int currentIndex2 = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
         TextView textView = findViewById(R.id.textView);
         TextView textView1 = findViewById(R.id.textView2);
        Button buttonNext = findViewById(R.id.buttonNext);
        textView.setText(texts[currentIndex]);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % texts.length;
                textView.setText(texts[currentIndex]);
                currentIndex2 = (currentIndex2 + 1) % smallTexts.length;
                textView1.setText(smallTexts[currentIndex2]);
                if (currentIndex == texts.length - 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(RulesActivity.this, Profile.class);
                            startActivity(intent);
                        }
                    }, 3000);
                }
            }
        });

    }
}