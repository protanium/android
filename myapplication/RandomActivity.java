package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    TextView quantityText;
    TextView maxText;
    TextView minText;
    Button okButton;

    LinearLayout itemContainer;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        this.quantityText = findViewById(R.id.quantitiy_text);
        this.maxText = findViewById(R.id.max_text);
        this.minText = findViewById(R.id.min_text);

        this.okButton = findViewById(R.id.ok_button);
        this.okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list(String.valueOf(quantityText.getText()),
                        String.valueOf(maxText.getText()), String.valueOf(minText.getText()));
            }
        });

        this.itemContainer = findViewById(R.id.item_container);

    }

    private void list(String quantity, String maxValue, String minValue){
        int quantityI;
        int maxValueI;
        int minValueI;

        try{
            quantityI = Integer.parseInt(quantity);
            maxValueI = Integer.parseInt(maxValue);
            minValueI = Integer.parseInt(minValue);
        }catch (NumberFormatException e){
            return;
        }
        this.itemContainer.removeAllViews();

        this.random = new Random();

        int i = 0;
        while(i < quantityI){
            int max = this.random.nextInt(maxValueI/2) + minValueI;
            int min = this.random.nextInt(max-minValueI) + minValueI;

            int value = this.random.nextInt(max-min) + min;
            int percent = value*100/max;

            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(0,15,0,0);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView titleText = new TextView(this);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams2.setMargins(0,0,0,5);
            titleText.setText(String.valueOf(value) + " = " + "%" + String.valueOf(percent));
            titleText.setGravity(Gravity.CENTER);

            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

            TextView minTextElement = new TextView(this);
            minTextElement.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1f
            ));
            minTextElement.setGravity(Gravity.CENTER);
            minTextElement.setText(String.valueOf(min));

            ProgressBar progressBar = new ProgressBar(this, null,
                    android.R.attr.progressBarStyleHorizontal);
            progressBar.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    3f
            ));
            progressBar.setProgress(50);

            TextView maxTextElement = new TextView(this);
            maxTextElement.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1f
            ));
            maxTextElement.setGravity(Gravity.CENTER);
            maxTextElement.setText(String.valueOf(max));

            linearLayout2.addView(minTextElement);
            linearLayout2.addView(progressBar);
            linearLayout2.addView(maxTextElement);

            linearLayout.addView(titleText);
            linearLayout.addView(linearLayout2);

            this.itemContainer.addView(linearLayout);

            i++;
        }

    }

}