package com.example.webdrive;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RoadSignsActivity extends AppCompatActivity implements View.OnClickListener {
    public static String[] question = {
                "What sign is this? "
    };
    public static String[][] choices = {
            {"Pedestrian crossing", "Two way traffic", "Intersection with roundabout", "Main road"},
            {"Steep descent", "Two way traffic", "Maximum speed limit", "Lighting setup"},
            {"Intersection with roundabout", "Main road", "Steep descent", "Two way traffic"},
            {"End of settlement", "Two way traffic", "Pedestrian crossing", "Maximum speed limit"},
            {"Distance to object", "Non of them", "Main road", "Start of settlement"},
            {"Non of them", "Roundabout traffic", "Intersection with roundabout", "Maximum speed limit"},
            {"Main road", "Steep descent", "Distance to object", "Traffic is direct"},
            {"Distance to object", "Non of them", "Stopping is prohibited", "Residence beginning"},
            {"Hospital", "Residence beginning", "Traffic is direct", "Distance to object"},
            {"End of settlement", "Place of return", "Non of them", "Parking"},
            {"Intersection with secondary road", "Narrowing road", "Non of them", "Give way"},
            {"Two way traffic", "Entry is denied", "Traffic is prohibited", "Slippery road"},
            {"Road works", "Residence beginning", "Maximum speed limit", "End of Main road"},
            {"Give way", "Dangerous turns", "Steep descent", "Non of them"},
            {"Non of them", "Rock fall", "Road works", "Two way traffic"},
            {"Hospital", "Give way", "Maximum speed limit", "Main road"},
            {"Two way traffic", "Traffic is direct", "Place of return", "Dangerous turns"},
            {"Give way", "Narrowing road", "End of Main road", "Intersection with roundabout"},
            {"Steep descent", "Place of return", "Left turns are prohibited", "Right turns are prohibited"},
            {"Stopping is prohibited", "Non of them", "Traffic is prohibited", "Traffic is direct"}
    };
    public static String[] correctAnswers = {
            "Pedestrian crossing",
            "Lighting setup",
            "Steep descent",
            "Two way traffic",
            "Main road",
            "Roundabout traffic",
            "Distance to object",
            "Stopping is prohibited",
            "Residence beginning",
            "Non of them",
            "Intersection with secondary road",
            "Entry is denied",
            "Maximum speed limit",
            "Non of them",
            "Rock fall",
            "Give way",
            "Dangerous turns",
            "Narrowing road",
            "Right turns are prohibited",
            "Traffic is prohibited"
    };
    public static int[] questionImages = {
            R.drawable.trs5,
            R.drawable.trs2,
            R.drawable.trs3,
            R.drawable.trs4,
            R.drawable.trs21,
            R.drawable.trs32,
            R.drawable.trs44,
            R.drawable.trs25,
            R.drawable.trs34,
            R.drawable.trs43,
            R.drawable.trs22,
            R.drawable.trs23,
            R.drawable.trs24,
            R.drawable.trs42,
            R.drawable.trs291,
            R.drawable.trs37,
            R.drawable.trs26,
            R.drawable.trs28,
            R.drawable.trs39,
            R.drawable.trs38
    };
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    int score = 0;
    int totalQuestion = question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    public TextView questionCountTextView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_signs);


        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        questionCountTextView = findViewById(R.id.cpt_question);

        loadNewQuestion();
        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit) {
            if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                score++;
                if (selectedAnswer.equals(choices[currentQuestionIndex][0])) {
                    ansA.setBackgroundColor(Color.GREEN);
                }
                if (selectedAnswer.equals(choices[currentQuestionIndex][1])) {
                    ansB.setBackgroundColor(Color.GREEN);
                }
                if (selectedAnswer.equals(choices[currentQuestionIndex][2])) {
                    ansC.setBackgroundColor(Color.GREEN);
                }
                if (selectedAnswer.equals(choices[currentQuestionIndex][3])) {
                    ansD.setBackgroundColor(Color.GREEN);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionIndex++;
                        loadNewQuestion();
                    }
                }, 1000);
            } else {
                if (selectedAnswer.equals(choices[currentQuestionIndex][0])) {
                    ansA.setBackgroundColor(Color.RED);
                }
                if (selectedAnswer.equals(choices[currentQuestionIndex][1])) {
                    ansB.setBackgroundColor(Color.RED);
                }
                if (selectedAnswer.equals(choices[currentQuestionIndex][2])) {
                    ansC.setBackgroundColor(Color.RED);
                }
                if (selectedAnswer.equals(choices[currentQuestionIndex][3])) {
                    ansD.setBackgroundColor(Color.RED);
                }

                if (correctAnswers[currentQuestionIndex].equals(choices[currentQuestionIndex][0])) {
                    ansA.setBackgroundColor(Color.GREEN);
                }
                if (correctAnswers[currentQuestionIndex].equals(choices[currentQuestionIndex][1])) {
                    ansB.setBackgroundColor(Color.GREEN);
                }
                if (correctAnswers[currentQuestionIndex].equals(choices[currentQuestionIndex][2])) {
                    ansC.setBackgroundColor(Color.GREEN);
                }
                if (correctAnswers[currentQuestionIndex].equals(choices[currentQuestionIndex][3])) {
                    ansD.setBackgroundColor(Color.GREEN);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionIndex++;
                        loadNewQuestion();
                    }
                }, 1000);
            }
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLUE);
        }
    }

    void loadNewQuestion() {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
        if (currentQuestionIndex == correctAnswers.length) {
            finishQuiz();
            return;
        }
        ImageView questionImageView = findViewById(R.id.question_image);
        questionImageView.setImageResource(questionImages[currentQuestionIndex]);
        ansA.setText(choices[currentQuestionIndex][0]);
        ansB.setText(choices[currentQuestionIndex][1]);
        ansC.setText(choices[currentQuestionIndex][2]);
        ansD.setText(choices[currentQuestionIndex][3]);

        int currentQuestionNumber = currentQuestionIndex + 1;
        String questionCountText = currentQuestionNumber + "/" + correctAnswers.length;
        questionCountTextView.setText(questionCountText);
    }

    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus).setMessage("Score is " + score + " out of " + correctAnswers.length)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}