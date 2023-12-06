package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SMSActivity extends AppCompatActivity {

    Button sendButton;
    TextView noText;

    TextView messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        this.messageText = findViewById(R.id.message_text);
        this.noText = findViewById(R.id.no_text);

        this.sendButton = findViewById(R.id.send_button);

        this.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(String.valueOf(noText.getText()), String.valueOf(messageText.getText()));
            }
        });

    }

    private void sendMessage(String no, String message){
        if(ContextCompat.checkSelfPermission(SMSActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){

        }else {
            ActivityCompat.requestPermissions(SMSActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
        }

        String telNo = "+90" + no;

        SmsManager smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(telNo, null, message, null, null);


    }
}