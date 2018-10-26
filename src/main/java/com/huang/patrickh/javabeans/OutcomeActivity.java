package com.huang.patrickh.javabeans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.plattysoft.leonids.ParticleSystem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class OutcomeActivity extends AppCompatActivity {

    TextView FinalScore;
    Button backBut, retryBut;
    ImageView bagBeans;

    int totalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome);

//        Get intents from previous activities
        final Bundle bundle = getIntent().getExtras();
//        Module type (Abstraction, encapsulation...)
        final String moduleType = bundle.getString("Module");
//        Question type (MCQ/True or false)
        final String questionType = bundle.getString("questionType");
//        # of Beans the User has collected from previous quiz
        final int score = bundle.getInt("finalScore");

//        Total # of Beans the User has collected the entire game
        totalScore = bundle.getInt("TotalScore",totalScore) + score;

        FinalScore = (TextView)findViewById(R.id.endScore);
        backBut = findViewById(R.id.backBut);
        retryBut = findViewById(R.id.retryBut);
        bagBeans = findViewById(R.id.imageView4);




//        Display different messages when user gets different scores
        if (score >= 4){
            FinalScore.setText("Excellent!! \nYou collected " + score + " Javabeans.");
        }else if(score ==3 ){
            FinalScore.setText("Good Job!! \nYou collected " + score + " Javabeans.");
        }else if(score ==2){
            FinalScore.setText("Better luck next time :( \n You only collected " + score + " Javabeans.");
        }else{
            FinalScore.setText(" You need to revise the modules! \n You collected " + score + "  Javabeans.");
            FinalScore.setTextSize(20);
            bagBeans.setImageResource(R.drawable.sadface);;
        }

//        Back button listener to take the user to the module page as well as saving the Beans the user had collected
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OutcomeActivity.this, ModuleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                OutcomeActivity.this.finish();
                startActivity(i);
            }
        });

//        Retry button to let user re-attempt the quiz, pass back intents such as module the user selected
        retryBut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionType.equals("TF")){
                    Intent i = new Intent(OutcomeActivity.this, TFActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Module",moduleType);
                    bundle.putInt("TotalScore",totalScore);
                    i.putExtras(bundle);
                    OutcomeActivity.this.finish();
                    startActivity(i);
                }else if(questionType.equals("MCQ")) {
                    Intent i = new Intent(OutcomeActivity.this, MCQActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Module", moduleType);
                    bundle.putInt("TotalScore",totalScore);
                    i.putExtras(bundle);
                    OutcomeActivity.this.finish();
                    startActivity(i);
                }

            }
        });
    }
}
