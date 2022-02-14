package com.example.lucazap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtMobile, txtMessage;
    Button btnSend, BtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMobile = findViewById(R.id.MobileNO);
        txtMessage = findViewById(R.id.Message);
        btnSend = findViewById(R.id.sendSms);
        BtnCancel = findViewById(R.id.Cancel);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS,
                Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = txtMessage.getText().toString();
                String mobile = txtMobile.getText().toString();

                if (mobile != null)
                {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(mobile, null, msg, null, null);

                    Toast.makeText(MainActivity.this, "Message Sent Successfully!", Toast.LENGTH_LONG).show();
                }
                else
                {Toast.makeText(MainActivity.this, "Message sending failed...", Toast.LENGTH_LONG).show();
            }
        }
        });

    }
}