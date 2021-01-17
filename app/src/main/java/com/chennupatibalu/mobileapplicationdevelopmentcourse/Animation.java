package com.chennupatibalu.mobileapplicationdevelopmentcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.chennupatibalu.mobileapplicationdevelopmentcourse.TemperatureConverter.TemperatureConverter;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Animation extends AppCompatActivity {

    private TextView animateTV;
    Spinner spinner;
    Button animateButton;
    ArrayAdapter<String> arrayAdapter;
    String[] activities;
    boolean isSelected = false;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        animateTV = findViewById(R.id.animateTextView);
        spinner = findViewById(R.id.animationActivitySpinner);
        animateButton = findViewById(R.id.animateButton);


        activities = new String[]{"Fade In","Fade In Up","Fade In Down","Fade In Left","Fade In Right",
                "Fade Out","Fade Out Up","Fade Out Down","Fade Out Left","Fade Out Right",
                "Slide In Up","Slide In Down","Slide In Left","Slide In Right",
                "Slide Out Up","Slide Out Down","Slide Out Left","Slide Out Right"
        };
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
        animateButton.setOnClickListener(view -> {
            switch (arrayAdapter.getItem(a))
            {
                case "Fade In": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeIn();
                    break;
                case "Fade In Up": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeInUp();
                    break;
                case "Fade In Down": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeInDown();
                    break;
                case "Fade In Left": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeInLeft();
                    break;
                case "Fade In Right": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeInRight();
                    break;
                case "Fade Out": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeOut();
                    break;
                case "Fade Out Up": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeOutUp();
                    break;
                case "Fade Out Down": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeOutDown();
                    break;
                case "Fade Out Left": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeOutLeft();
                    break;
                case "Fade Out Right": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    fadeOutRight();
                    break;
                case "Slide In Up": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideInUp();
                    break;
                case "Slide In Down": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideInDown();
                    break;
                case "Slide In Left": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideInLeft();
                    break;
                case "Slide In Right": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideInRight();
                    break;
                case "Slide Out Up": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideOutUp();
                    break;
                case "Slide Out Down": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideOutDown();
                    break;
                case "Slide Out Left": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideOutLeft();
                    break;
                case "Slide Out Right": Toast.makeText(Animation.this, arrayAdapter.getItem(a), Toast.LENGTH_SHORT).show();
                    slideOutRight();
                    break;
                default:
                    Toast.makeText(Animation.this, "No animation selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fadeIn() { YoYo.with(Techniques.FadeIn).duration(500).repeat(1).playOn(animateTV); }
    public void fadeInUp() { YoYo.with(Techniques.FadeInUp).duration(500).repeat(1).playOn(animateTV); }
    public void fadeInDown() { YoYo.with(Techniques.FadeInDown).duration(500).repeat(1).playOn(animateTV); }
    public void fadeInLeft() { YoYo.with(Techniques.FadeInLeft).duration(500).repeat(1).playOn(animateTV); }
    public void fadeInRight() { YoYo.with(Techniques.FadeInRight).duration(500).repeat(1).playOn(animateTV); }

    public void fadeOut() { YoYo.with(Techniques.FadeOut).duration(500).repeat(1).playOn(animateTV); }
    public void fadeOutUp() { YoYo.with(Techniques.FadeOutUp).duration(500).repeat(1).playOn(animateTV); }
    public void fadeOutDown() { YoYo.with(Techniques.FadeOutDown).duration(500).repeat(1).playOn(animateTV); }
    public void fadeOutLeft() { YoYo.with(Techniques.FadeOutLeft).duration(500).repeat(1).playOn(animateTV); }
    public void fadeOutRight() { YoYo.with(Techniques.FadeOutRight).duration(500).repeat(1).playOn(animateTV); }

    public void slideInUp() { YoYo.with(Techniques.SlideInUp).duration(500).repeat(1).playOn(animateTV); }
    public void slideInDown() { YoYo.with(Techniques.SlideInDown).duration(500).repeat(1).playOn(animateTV); }
    public void slideInLeft() { YoYo.with(Techniques.SlideInLeft).duration(500).repeat(1).playOn(animateTV); }
    public void slideInRight() { YoYo.with(Techniques.SlideInRight).duration(500).repeat(1).playOn(animateTV); }

    public void slideOutUp(){ YoYo.with(Techniques.SlideOutUp).duration(500).repeat(1).playOn(animateTV);}
    public void slideOutDown(){ YoYo.with(Techniques.SlideOutDown).duration(500).repeat(1).playOn(animateTV);}
    public void slideOutLeft(){ YoYo.with(Techniques.SlideOutLeft).duration(500).repeat(1).playOn(animateTV);}
    public void slideOutRight(){ YoYo.with(Techniques.SlideOutRight).duration(500).repeat(1).playOn(animateTV);}
}