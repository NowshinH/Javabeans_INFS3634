package com.huang.patrickh.javabeans;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TutorialActivity extends AppCompatActivity {

    TextView moduleView;
    Button conceptBut, mcqBut, tfBut;
    ImageButton mcqInfo, tfInfo, backBut;
    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        conceptBut = findViewById(R.id.conceptBut);
        mcqBut = findViewById(R.id.mcqBut);
        tfBut = findViewById(R.id.tfBut);
        moduleView = findViewById(R.id.moduleView);
        backBut = findViewById(R.id.backBut);
        mcqInfo = findViewById(R.id.mcqInfo);
        tfInfo = findViewById(R.id.tfInfo);


//        get intent from the previous activities such as which module the user had selected
        Bundle bundle = getIntent().getExtras();
        final String moduleType = bundle.getString("Module");

//        updates the total # of beans the user has collected
        totalScore += bundle.getInt("TotalScore",totalScore);

//        show different module text according to the intent (String) passed in from previous activity (APIE)
        moduleView.setText(moduleType);


//        Button that takes the user to the concept and definition page and passing necessary intents/information
        conceptBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorialActivity.this, ConceptsDefinitions.class);
                Bundle bundle = new Bundle();
                bundle.putString("Module", moduleType);
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                TutorialActivity.this.finish();
                startActivity(i);
            }
        });


//        Button that takes the user to the MCQ game while passing necessary intents/information
        mcqBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorialActivity.this, MCQActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Module",moduleType);
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                TutorialActivity.this.finish();
                startActivity(i);
            }
        });

//        Button that shows MCQ game rules (pop up page)
        mcqInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TutorialActivity.this);
                View view = getLayoutInflater().inflate(R.layout.mcq_info,null);
                TextView tfinfoText = view.findViewById(R.id.mcqinfoText);
                ImageButton tfinfoExit = (ImageButton) view.findViewById(R.id.mcqinfoExit);

                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();

                tfinfoExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.hide();
                    }
                });

            }
        });


//        Button that takes the user to the True or false game while passing necessary intents/information
        tfBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorialActivity.this, TFActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Module",moduleType);
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                TutorialActivity.this.finish();
                startActivity(i);
            }
        });


//        Button that shows True or false game rules (pop up page)
        tfInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TutorialActivity.this);
                View view = getLayoutInflater().inflate(R.layout.tf_info,null);
                TextView tfinfoText = view.findViewById(R.id.tfinfoText);
                ImageButton tfinfoExit = (ImageButton) view.findViewById(R.id.tfinfoExit);

                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();

                tfinfoExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.hide();
                    }
                });



            }
        });

//        Back button to take the user back to previous page while saving necessary informations
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TutorialActivity.this.finish();
                Bundle bundle = new Bundle();
                bundle.putInt("TotalScore",totalScore);
                startActivity(new Intent(TutorialActivity.this,ModuleActivity.class));
            }
        });


    }
}
