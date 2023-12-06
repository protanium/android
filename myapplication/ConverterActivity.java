package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConverterActivity extends AppCompatActivity {

    Spinner decimalSpinner;
    List<String> decimalOptions;
    Spinner byteSpinner;
    List<String> byteOptions;

    Button decimalButton;

    TextView decimalText;

    TextView decimalResult;


    Button byteButton;
    TextView byteText;
    TextView byteResult;

    Button celsiusButton;
    TextView celsiusText;
    TextView celsiusResult;

    RadioButton celsiusRadioFahrenayt;
    RadioButton celsiusRadioKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        this.decimalSpinner = findViewById(R.id.decimal_spinner);
        this.decimalOptions = new ArrayList<>();
        decimalOptions.add("ikilik");
        decimalOptions.add("sekizlik");
        decimalOptions.add("onaltılık");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, decimalOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.decimalSpinner.setAdapter(adapter);

        this.byteSpinner = findViewById(R.id.byte_spinner);
        this.byteOptions = new ArrayList<>();
        this.byteOptions.add("kilobyte");
        this.byteOptions.add("kibibyte");
        this.byteOptions.add("bit");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, byteOptions);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.byteSpinner.setAdapter(adapter2);


        this.decimalText = findViewById(R.id.decimal_text);
        this.decimalResult = findViewById(R.id.decimal_result);
        this.decimalButton = findViewById(R.id.decimal_button);

        this.decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateDecimal(String.valueOf(decimalText.getText()));
            }
        });

        this.byteText = findViewById(R.id.byte_text);
        this.byteResult = findViewById(R.id.byte_result);
        this.byteButton = findViewById(R.id.byte_button);

        this.byteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcuateByte(String.valueOf(byteText.getText()));
            }
        });

        this.celsiusText = findViewById(R.id.celsius_text);
        this.celsiusResult = findViewById(R.id.celsius_result);
        this.celsiusRadioFahrenayt = findViewById(R.id.celsius_radio_fahrenayt);
        this.celsiusRadioKelvin = findViewById(R.id.celsius_radio_kelvin);
        this.celsiusButton = findViewById(R.id.celsius_button);

        this.celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCelsius(String.valueOf(celsiusText.getText()));
            }
        });

    }

    private void calculateDecimal(String decimal){
        int decimalI;
        try{
            decimalI = Integer.parseInt(decimal);
        }catch (NumberFormatException e){
            return;
        }

        String selectedItem = this.decimalSpinner.getSelectedItem().toString();

        if(selectedItem.equals("ikilik"))
            this.decimalResult.setText(Integer.toBinaryString(decimalI));
        else if(selectedItem.equals("sekizlik"))
            this.decimalResult.setText(Integer.toOctalString(decimalI));
        else
            this.decimalResult.setText(Integer.toHexString(decimalI));

    }

    private void calcuateByte(String bytes){
        int bytesI;
        try{
            bytesI = Integer.parseInt(bytes);
        }catch (NumberFormatException e){
            return;
        }

        String selectedItem = this.byteSpinner.getSelectedItem().toString();

        if(selectedItem.equals("kilobyte"))
            this.byteResult.setText(String.valueOf(bytesI/1000f));
        else if(selectedItem.equals("bit"))
            this.byteResult.setText(String.valueOf(bytesI*8));
        else
            this.byteResult.setText(String.valueOf(bytesI/1024f));


    }

    private void calculateCelsius(String celsius){
        float celsiusF;
        try{
            celsiusF = Float.parseFloat(celsius);
        }catch (NumberFormatException e){
            return;
        }

        if(this.celsiusRadioKelvin.isChecked()){
            this.celsiusResult.setText(String.valueOf(celsiusF+273.15f));
        }
        else if(this.celsiusRadioFahrenayt.isChecked())
            this.celsiusResult.setText(String.valueOf(celsiusF*1.8f+32));


    }
}