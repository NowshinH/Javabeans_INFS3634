package com.huang.patrickh.javabeans;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class ConceptsDefinitions extends AppCompatActivity {

    /*This class has been created to contain a brief overview of the concepts and definitions within each of the four modules */
    //Refer to strings.xml for the textual content on this page (references included in string.xml)

    private LinearLayout cd, acd, pcd, icd, ecd;
    int totalScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concepts_definitions);

        Bundle bundle = getIntent().getExtras();
        final String moduleType = bundle.getString("Module");
        totalScore += bundle.getInt("TotalScore",totalScore);
        bundle.putInt("TotalScore",totalScore);

        acd = findViewById(R.id.acd);
        pcd = findViewById(R.id.pcd);
        icd = findViewById(R.id.icd);
        ecd = findViewById(R.id.ecd);
        cd = findViewById(R.id.cd);

        nextCD(moduleType);

    }
// Returns the linear layout containing the concepts and definitions for the module selected by the user
    private void nextCD(String moduleType){
        if(moduleType.equals("Abstraction")){
            acd.setVisibility(acd.VISIBLE);
        } else if(moduleType.equals("Polymorphism")){
            pcd.setVisibility(pcd.VISIBLE);
        }else if(moduleType.equals("Inheritance")){
            icd.setVisibility(icd.VISIBLE);
        }else if(moduleType.equals("Encapsulation")){
            ecd.setVisibility(ecd.VISIBLE);
        }

    }
}
