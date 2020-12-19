package com.chennupatibalu.mobileapplicationdevelopmentcourse.IntentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chennupatibalu.mobileapplicationdevelopmentcourse.R;

public class ValuePassingIntentExample extends AppCompatActivity {

    private EditText nameEditText,idEditText,cgpaEditText;
    private Button sendDataButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_passing_intent_example);

        nameEditText = findViewById(R.id.nameEditText);
        idEditText = findViewById(R.id.idNumberEditText);
        cgpaEditText = findViewById(R.id.cgpaEditText);
        sendDataButton = findViewById(R.id.sendDataButton);
    }

    public void sendData(View view) {
        Intent intent = new Intent(ValuePassingIntentExample.this,PassedValueResultedIntent.class);

        //Sending the data to other activity
        intent.putExtra("Name",nameEditText.getText().toString());
        intent.putExtra("Id",idEditText.getText().toString());
        intent.putExtra("CGPA",cgpaEditText.getText().toString());
        startActivity(intent);
        Toast.makeText(this, "Values passed to another Activity Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}