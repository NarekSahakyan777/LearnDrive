package com.example.webdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RoadSignsActivity extends AppCompatActivity {
    String[] question_list = {"5 * 5", "6 * 5", "7 * 5", "8 * 5",};
    String[] choose_list = {"10", "20", "25", "50",
            "50", "40", "20", "30",
            "25", "30", "40", "35",
            "40", "5", "50", "80"

    };
    String[] correct_list = {"25", "30", "35", "40"};
    TextView cpt_question, text_question;
    Button btn_choose1, btn_choose2, btn_choose3, btn_choose4, btn_next;
    int currentQuestion = 0;
    boolean isclickBtn = false;
    String valueChoose = "";
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
        remplirData();
        btn_next.setOnClickListener(
                v -> {
                    if(isclickBtn){
                        if(!valueChoose.equals(correct_list[currentQuestion])){
                            Toast.makeText(RoadSignsActivity.this,"error", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(RoadSignsActivity.this,"correct", Toast.LENGTH_LONG).show();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                currentQuestion = currentQuestion + 1;
                                remplirData();
                                isclickBtn = false;
                                valueChoose = "";
                            }
                        }, 2000);
                        btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                        btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                        btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                        btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);

                    }
                }
        );


    }
    void remplirData(){
        cpt_question.setText((currentQuestion + 1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);
        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion + 1]);
        btn_choose3.setText(choose_list[4 * currentQuestion + 2]);
        btn_choose4.setText(choose_list[4 * currentQuestion + 3]);
    }

    public void ClickChoose(View view) {
        if(!isclickBtn){
            Button btn_click  = (Button)view;
            btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
            isclickBtn = true;
            valueChoose = btn_click.getText().toString();
        }

    }
}