package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button randomButton;

    Button converterButton;

    Button smsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.randomButton = findViewById(R.id.random_button);

        this.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RandomActivity.class);
                startActivity(i);
            }
        });

        this.converterButton = findViewById(R.id.converter_button);

        this.converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConverterActivity.class);
                startActivity(i);
            }
        });

        this.smsButton = findViewById(R.id.sms_button);

        this.smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SMSActivity.class);
                startActivity(i);
            }
        });



    }
}