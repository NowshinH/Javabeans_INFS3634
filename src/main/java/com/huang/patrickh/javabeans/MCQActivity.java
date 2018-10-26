package com.huang.patrickh.javabeans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MCQActivity extends AppCompatActivity {


    private TextView mcQuestion, mcqExp, scoreView;
    private Button mcqBut1, mcqBut2, mcqBut3, mcqBut4;
    private ImageButton nextBut, quitBut;

    private String mcqAnswer;
    private int mcqScore = 0;
    private int mcqNum = 0;

    int totalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);

//       Get Intent/information from the last activity (Module, and the # of Beans user had collected so far

        Bundle bundle = getIntent().getExtras();
        final String moduleType = bundle.getString("Module");
        final String questionType = "MCQ";
        final QuizBank quizBank = new QuizBank();

        totalScore += bundle.getInt("TotalScore",totalScore);


        mcQuestion = findViewById(R.id.mcQuestion);
        scoreView = findViewById(R.id.scoreView);
        mcqExp = findViewById(R.id.mcqExp);
        mcqBut1 = findViewById(R.id.mcqBut1);
        mcqBut2 = findViewById(R.id.mcqBut2);
        mcqBut3 = findViewById(R.id.mcqBut3);
        mcqBut4 = findViewById(R.id.mcqBut4);
        quitBut = findViewById(R.id.quitBut);
        nextBut = findViewById(R.id.nextBut);

//      Display questions according to the module user has chosen
        nextMCQuestion(quizBank, moduleType);


//        On click listener for each option, if the user gets it right, they earn 50 beans,
//        if they get it wrong they lose 10 beans. Score board refreshes
//        set other buttons to un-clickable so they cant cheat
        mcqBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcqBut1.getText() == mcqAnswer){
                    mcqScore = mcqScore + 50;
                    scoreView.setText(mcqScore);
                    correctMsg();
                }else {
                    mcqScore -= 10;
                    updateScore(mcqScore);
                    showExplanation(quizBank, moduleType);
                }
                mcqBut4.setEnabled(false);
                mcqBut2.setEnabled(false);
                mcqBut3.setEnabled(false);

            }
        });

        mcqBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcqBut2.getText() == mcqAnswer){
                    mcqScore = mcqScore + 50;
                    updateScore(mcqScore);
                    correctMsg();
                }else {
                    mcqScore -= 10;
                    updateScore(mcqScore);
                    showExplanation(quizBank, moduleType);
                }
                mcqBut1.setEnabled(false);
                mcqBut4.setEnabled(false);
                mcqBut3.setEnabled(false);

            }
        });

        mcqBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcqBut3.getText() == mcqAnswer){
                    mcqScore = mcqScore + 50;
                    updateScore(mcqScore);
                    correctMsg();
                }else {
                    mcqScore -= 10;
                    updateScore(mcqScore);
                    showExplanation(quizBank, moduleType);
                }
                mcqBut1.setEnabled(false);
                mcqBut2.setEnabled(false);
                mcqBut4.setEnabled(false);

            }
        });

        mcqBut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcqBut4.getText() == mcqAnswer){
                    mcqScore = mcqScore + 50;
                    updateScore(mcqScore);
                    correctMsg();
                }else {
                    mcqScore -= 10;
                    updateScore(mcqScore);
                    showExplanation(quizBank, moduleType);

                }
                mcqBut1.setEnabled(false);
                mcqBut2.setEnabled(false);
                mcqBut3.setEnabled(false);

            }
        });


//        takes user to the next question, if it reaches the end of the array,
//        it takes the user to the outcome page as well as passing information needed for it
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mcqNum == QuizBank.getMCQuestionNum(moduleType)){
                    Intent i = new Intent(MCQActivity.this, OutcomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore",mcqScore);
                    bundle.putString("Module",moduleType);
                    bundle.putString("questionType",questionType);
                    bundle.putInt("TotalScore",totalScore);;
                    i.putExtras(bundle);
                    MCQActivity.this.finish();
                    startActivity(i);
                }else {
                    nextMCQuestion(quizBank, moduleType);
                }
            }
        });


//      When quit button clicked, it takes you back to the modules page
        quitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MCQActivity.this,ModuleActivity.class));
            }
        });


    }


    //  Method that returns the explanation for my an answer is incorrect and identifies the correct answer.
    private void showExplanation(QuizBank quizBank, String moduleType){
        mcqExp.setText(quizBank.getMCExp(moduleType, mcqNum-1));
    }

    //  Method for displaying message when user gets the correct answer.
    private void correctMsg(){
        mcqExp.setText("You got it right!");
    }


///    update the question and options as well as refreshes the buttons
    private void nextMCQuestion(QuizBank quizBank, String moduleType){
        mcqBut1.setEnabled(true);
        mcqBut2.setEnabled(true);
        mcqBut3.setEnabled(true);
        mcqBut4.setEnabled(true);
        mcQuestion.setText(quizBank.getMCQuestion(moduleType, mcqNum));
        mcqBut1.setText(quizBank.getMCOption1(moduleType, mcqNum));
        mcqBut2.setText(quizBank.getMCOption2(moduleType, mcqNum));
        mcqBut3.setText(quizBank.getMCOption3(moduleType, mcqNum));
        mcqBut4.setText(quizBank.getMCOption4(moduleType, mcqNum));
        mcqAnswer = quizBank.getMCAnswer(moduleType, mcqNum);
        mcqExp.setText("");
        mcqNum++;
    }

    //  Method for updating the score board on module page, based on the number of correct answers.
    private void updateScore(int score){
        scoreView.setText("" + mcqScore);
    }




}
