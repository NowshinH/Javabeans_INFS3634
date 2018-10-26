package com.huang.patrickh.javabeans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ModuleActivity extends AppCompatActivity {


    Button abstractBut, polymorBut, inheriBut, encapBut, videoBut;
    TextView totalView, scoreView ;
    ImageView imageView2;
    ImageButton play;
    int totalScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        abstractBut = (Button) findViewById(R.id.abstractBut);
        polymorBut = (Button) findViewById(R.id.polymorBut);
        inheriBut = (Button) findViewById(R.id.inheriBut);
        encapBut = (Button) findViewById(R.id.encapBut);
        videoBut = findViewById(R.id.videoBut);
        totalView = findViewById(R.id.totalView);
        scoreView = findViewById(R.id.scoreView);
        imageView2 = findViewById(R.id.imageView2);
        play = findViewById(R.id.play);

        final String ABSTRACTION = "Abstraction";
        final String ENCAPSULATION = "Encapsulation";
        final String INHERITANCE = "Inheritance";
        final String POLYMORPHISM = "Polymorphism";


//      Get intent from previous activities
        Bundle bundle = getIntent().getExtras();
//        Check if the intent is null to avoid crashing the app
        if(bundle != null){
            totalScore += bundle.getInt("TotalScore");
            scoreView.setText(""+totalScore);
        }



//        On click listener for the abtraction module and passing intents such as the module type and total score(beans) to the next activity
        abstractBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModuleActivity.this, TutorialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Module",ABSTRACTION);
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                ModuleActivity.this.finish();
                startActivity(i);
            }
        });

//        Listener for the encapsulation module and passing intents such as the module type and total score(beans) to the next activity
        encapBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModuleActivity.this, TutorialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Module",ENCAPSULATION);
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                ModuleActivity.this.finish();
                startActivity(i);
            }
        });

//        Listener for the inheritance module and passing intents such as the module type and total score(beans) to the next activity
        inheriBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModuleActivity.this, TutorialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Module",INHERITANCE);
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                ModuleActivity.this.finish();
                startActivity(i);
            }
        });

//        Listener for the polymorphism module and passing intents such as the module type and total score(beans) to the next activity
        polymorBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModuleActivity.this, TutorialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Module",POLYMORPHISM);
                bundle.putInt("TotalScore",totalScore);
                i.putExtras(bundle);
                ModuleActivity.this.finish();
                startActivity(i);
            }
        });


//        Button to take the user to the YouTube Playlist
        videoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModuleActivity.this,PlaylistActivity.class));
            }
        });

//        ImageButton to take the user to the YouTube Playlist
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModuleActivity.this,PlaylistActivity.class));
            }
        });

    }
}
