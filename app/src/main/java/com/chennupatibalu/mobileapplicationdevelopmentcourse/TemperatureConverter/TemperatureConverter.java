package com.chennupatibalu.mobileapplicationdevelopmentcourse.TemperatureConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chennupatibalu.mobileapplicationdevelopmentcourse.R;

public class TemperatureConverter extends AppCompatActivity {

    EditText celsiusEditText;
    TextView temperatureTextView;
    Button celsiusConvertButton,fahrenheitConvertButton;

    double fahrenheit,celsius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        celsiusEditText = findViewById(R.id.celsiusEditText);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        celsiusConvertButton = findViewById(R.id.celsiusConvertButton);
        fahrenheitConvertButton = findViewById(R.id.fahrenheitConvertButton);

        //onClickListener for Button
        fahrenheitConvertButton.setOnClickListener(view -> {
            celsiusToFahrenheit();
            Toast.makeText(TemperatureConverter.this, "Converted Successfully", Toast.LENGTH_SHORT).show();
        });
        celsiusConvertButton.setOnClickListener(view -> {
            fahrenheitToCelsius();
            Toast.makeText(TemperatureConverter.this, "Converted Successfully", Toast.LENGTH_SHORT).show();
        });

    }
    protected void fahrenheitToCelsius()
    {
        double input = Double.parseDouble(celsiusEditText.getText().toString());
        celsius = 5/9*(input-32);        //Formula for converting ℉  to ℃ is F = 5/9*(F-32)
        temperatureTextView.setText("Temperature in Celsius: "+celsius);
    }
    protected void celsiusToFahrenheit()
    {
        double input = Double.parseDouble(celsiusEditText.getText().toString());
        fahrenheit = (input*9/5)+32;        //Formula for converting ℃ to ℉ is F = (9/5)*C+32
        temperatureTextView.setText("Temperature in Fahrenheit: "+fahrenheit);
    }
}