package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Quotes06 extends AppCompatActivity {
    ViewFlipper flipperQuotes;
    ImageButton bquote1, bquote2, bquote3;
    TextView quote1, quote2, quote3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes06);
        //variables
        bquote1 = (ImageButton) findViewById(R.id.bquote1);
        bquote2 = (ImageButton) findViewById(R.id.bquote2);
        bquote3 = (ImageButton) findViewById(R.id.bquote3);
        quote1 = (TextView) findViewById(R.id.quote1);
        quote2 = (TextView) findViewById(R.id.quote2);
        quote3 = (TextView) findViewById(R.id.quote3);

        flipperQuotes = (ViewFlipper) findViewById(R.id.viewFlipper_quote);
        //Auto Slide
        flipperQuotes.setFlipInterval(9000);
        flipperQuotes.startFlipping();
    }
    //Previous Slide
    public void previousView(View view) {
        flipperQuotes.showPrevious();
    }
    //Next Slide
    public void nextView(View view) {
        flipperQuotes.showNext();
    }

   //If the user's want to send quote as a message
    public void smsAction(View view) {
        //Identify chosen quote
        String messageText="hello";

        if(view.equals(bquote1)){
            messageText = quote1.getText().toString();
        }

        if(view.equals(bquote2)){
            messageText = quote2.getText().toString();
        }

        if(view.equals(bquote3)){
            messageText = quote3.getText().toString();

        }

        Intent intent = new Intent(this, Sms08.class);
        intent.putExtra("textSMS", messageText);
        startActivity(intent);

    }
    //Next Activity: Menu of options
    public void openActivity(View view) {
        Intent intent = new Intent(this, Menu03.class);
        startActivity(intent);
    }
}
