package com.huang.patrickh.javabeans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button startBut;
    int totalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBut = (Button) findViewById(R.id.startBut);

//        This gets the score/beans from Outcome page if the user had finished MCQ or True or False question


//      On click listener for the start button,
        startBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ModuleActivity.class));
            }
        });




    }
}
