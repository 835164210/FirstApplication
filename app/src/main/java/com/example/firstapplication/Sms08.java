package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sms08 extends AppCompatActivity {
EditText smsMessage, smsPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms08);
        //get SMS text
        Intent caller = getIntent();
        String textSms = caller.getStringExtra("textSMS");
        Toast.makeText(this, getString(R.string.quote_is) + textSms, Toast.LENGTH_SHORT).show();
        //variables
        smsPhone = (EditText) findViewById(R.id.smsPhone);
        smsMessage = (EditText) findViewById(R.id.smsMessage);
        smsMessage.setText(textSms);


    }

    public void sendSMS(View view) {
        //Send a SMS
        try{
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("smsto:"));
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address", new String(smsPhone.getText().toString()));
            smsIntent.putExtra("sms_body",smsMessage.getText().toString());
            startActivity(Intent.createChooser(smsIntent, "Send sms via:"));
            Toast.makeText(this, R.string.action_success_sms, Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(this, R.string.action_sms_failed, Toast.LENGTH_SHORT).show();
        }
    }
    //Next Activity: Menu of options
    public void openActivity(View view) {
        Intent intent = new Intent(this, Menu03.class);
        startActivity(intent);
    }
}
