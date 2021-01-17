package com.chennupatibalu.mobileapplicationdevelopmentcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.chennupatibalu.mobileapplicationdevelopmentcourse.IntentExample.ValuePassingIntentExample;
import com.chennupatibalu.mobileapplicationdevelopmentcourse.IntentExample.WebsiteActivity;
import com.chennupatibalu.mobileapplicationdevelopmentcourse.SQLite.SqliteDemo;
import com.chennupatibalu.mobileapplicationdevelopmentcourse.TemperatureConverter.TemperatureConverter;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button goButton;
    ArrayAdapter<String> arrayAdapter;
    String[] activities;
    boolean isSelected = false;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.activitySpinner);
        goButton = findViewById(R.id.goButton);


        activities = new String[]{"Temperature Converter","Website Intent","Value Passing Intent","Animation","SQLite Demo"};
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,activities);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a = i;
                isSelected = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        goButton.setOnClickListener(view -> {
            if(arrayAdapter.getItem(a).equals(activities[0]) && isSelected)
            {
                Toast.makeText(MainActivity.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, TemperatureConverter.class));
            }
            if(arrayAdapter.getItem(a).equals(activities[1]) && isSelected)
            {
                Toast.makeText(MainActivity.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, WebsiteActivity.class));
            }
            if(arrayAdapter.getItem(a).equals(activities[2]) && isSelected)
            {
                Toast.makeText(MainActivity.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ValuePassingIntentExample.class));
            }
            if(arrayAdapter.getItem(a).equals(activities[3]) && isSelected)
            {
                Toast.makeText(MainActivity.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Animation.class));
            }
            if(arrayAdapter.getItem(a).equals(activities[4]) && isSelected)
            {
                Toast.makeText(MainActivity.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SqliteDemo.class));
            }
        });
    }
}