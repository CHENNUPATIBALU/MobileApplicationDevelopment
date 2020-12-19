package com.chennupatibalu.mobileapplicationdevelopmentcourse.IntentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chennupatibalu.mobileapplicationdevelopmentcourse.R;

public class PassedValueResultedIntent extends AppCompatActivity {

    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passed_value_resulted_intent);

        resultTextView = findViewById(R.id.resultTextView);

        //Retrieving the data passed by the intent
        String name = getIntent().getStringExtra("Name");
        String id = getIntent().getStringExtra("Id");
        String cgpa = getIntent().getStringExtra("CGPA");

        String result = "Name: "+name+"\n"+"Id: "+id+"\n"+"CGPA: "+cgpa;
        resultTextView.setText(result);
    }
}