package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RoadSignsActivity extends AppCompatActivity {
    String[] question_list = {"Driving license is granted",
            "How much will you be fined for driving without a license?",
            "The number of vehicles on the roads of the Republic of Armenia is defined",
            "8 * 5",};
    String[] choose_list = {"18 years old", "20 years old", "16 years old", "17 years old ",
            "30000", "40000", "25000", "20000",
            "left-hand traffic", "right-hand traffic", "Two of them", "Non of them",
            "40", "58", "50", "80"

    };
    String[] correct_list = {"18 years old", "20000", "right-hand traffic", "40"};
    TextView cpt_question, text_question;
    Button btn_choose1, btn_choose2, btn_choose3, btn_choose4, btn_next;
    int currentQuestion = 0;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_signs);
        text_question = findViewById(R.id.text_question);
        cpt_question = findViewById(R.id.cpt_question);
        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
        remplirData();
        btn_next.setOnClickListener(
                v -> {
                    if (isclickBtn) {
                        isclickBtn = false;
                        if (!valueChoose.equals(correct_list[currentQuestion])) {
                            Toast.makeText(RoadSignsActivity.this, "error", Toast.LENGTH_SHORT).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_error);
                        } else {
                            Toast.makeText(RoadSignsActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_correct);
                        }
                        new Handler().postDelayed(() -> {
                            if(currentQuestion != question_list.length - 1){
                                currentQuestion = currentQuestion + 1;
                                remplirData();
                                valueChoose = "";
                                btn_choose1.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
                                btn_choose2.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
                                btn_choose3.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
                                btn_choose4.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
                            }else{
                                Intent intent = new Intent(RoadSignsActivity.this, ResultActivity.class);
                                startActivity(intent);
                            }

                        }, 2000);


                    }else{
                        Toast.makeText(RoadSignsActivity.this, "You have to choose one", Toast.LENGTH_LONG).show();
                    }
                }
        );


    }

    void remplirData() {
        cpt_question.setText((currentQuestion + 1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);
        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion + 1]);
        btn_choose3.setText(choose_list[4 * currentQuestion + 2]);
        btn_choose4.setText(choose_list[4 * currentQuestion + 3]);
    }

    public void ClickChoose(View view) {
        btn_click = (Button) view;
        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose_diasbaled);
        }
        choiseBtn();

    }
    void choiseBtn(){
        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}