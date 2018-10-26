package com.huang.patrickh.javabeans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TFActivity extends AppCompatActivity {

    private TextView TFQuestion, scoreView;
    Button TButton, FButton;
    private ImageButton backBut;

    private boolean TFAnswer;
    private int TFScore = 0;
    private int TFNum = 0;

    int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tf);


        TFQuestion = findViewById(R.id.TFQuestion);
        TButton = findViewById(R.id.TButton);
        FButton = findViewById(R.id.FButton);
        backBut = findViewById(R.id.backBut);
        scoreView = findViewById(R.id.scoreView);

//       Get intent from previous activities (which module) and the total # of Beans the user has collected so far
        final Bundle bundle = getIntent().getExtras();
        final String moduleType = bundle.getString("Module");

//       Setting the question type
        final String questionType = "TF";
        totalScore += bundle.getInt("TotalScore",totalScore);

//       Updates the question
        nextTFQuestion(moduleType);

//        True button listener,while examining the question is true of false, if its true add a point/bean
        TButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TFAnswer){
                    TFScore+=20;
//                    update the score/bean board
                    updateScore(TFScore);
                }else{
                    TFScore-=10;
                    updateScore(TFScore);
                }

//              if the question reaches the end, it takes the user to the outcome page showing number of beans the user had collected
//              Also passing intents for module question type and scores so the intent does not get lost and crashes the app
                if(TFNum == QuizBank.getTFQuestionNum(moduleType)){
                    Intent i = new Intent(TFActivity.this, OutcomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore",TFScore);
                    bundle.putString("Module",moduleType);
                    bundle.putString("questionType",questionType);
                    bundle.putInt("TotalScore",totalScore);;
                    i.putExtras(bundle);
                    TFActivity.this.finish();
                    startActivity(i);
                }else {
                    nextTFQuestion(moduleType);
                }
            }
        });

//        False button listener,while examining the question is true of false, if its true add a point/bean and update score board
        FButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TFAnswer){
                    TFScore+=20;
//                    update the score/bean board
                    updateScore(TFScore);
                }else{
                    TFScore-=10;
                    updateScore(TFScore);
                }
//              if the question reaches the end, it takes the user to the outcome page showing number of beans the user had collected
//              Also passing intents for module question type and scores so the intent does not get lost and crashes the app
                if(TFNum == QuizBank.getTFQuestionNum(moduleType)){
                    Intent i = new Intent(TFActivity.this, OutcomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Module",moduleType);
                    bundle.putInt("finalScore",TFScore);
                    bundle.putString("questionType",questionType);
                    bundle.putInt("TotalScore",totalScore );;
                    i.putExtras(bundle);
                    TFActivity.this.finish();
                    startActivity(i);
                }else {
                    nextTFQuestion(moduleType);
                }
            }
        });

//        Take the user back to Tutorial activity while saving the bean user had collected (not from the current game)
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TFActivity.this, TutorialActivity.class);
                bundle.putInt("TotalScore",totalScore );;
                i.putExtras(bundle);
                TFActivity.this.finish();
                startActivity(i);
            }
        });

    }

    //  Refreshes the questions and answer according to module user had selected
    private void nextTFQuestion(String moduleType){
        TFQuestion.setText(QuizBank.getTFQuestion(moduleType,TFNum));
        TFAnswer = QuizBank.getTFAnswer(moduleType, TFNum);
        TFNum++;


    }
    //  Update the number view for the beans the user has won
    private void updateScore(int score){
        scoreView.setText("" + score);
    }
}



