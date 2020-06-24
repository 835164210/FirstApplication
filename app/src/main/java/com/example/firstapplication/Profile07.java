package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile07 extends AppCompatActivity {
TextView namelast, ctext, btext, myDream, myReason, dueto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile07);
        namelast = (TextView) findViewById(R.id.namelast);
        ctext = (TextView) findViewById(R.id.ctext);
        btext = (TextView) findViewById(R.id.btext);
        myDream = (TextView) findViewById(R.id.myDream);
        myReason = (TextView) findViewById(R.id.myReason);
        dueto = (TextView) findViewById(R.id.dueto);

        displayInfo();



    }

    public void displayInfo(){
        //Get values
        SharedPreferences npreferences = getSharedPreferences("WHO", MODE_PRIVATE);
        String name = npreferences.getString("name","");
        String lastname = npreferences.getString("lname","");
        String dream = npreferences.getString("dream","");
        String motivation = npreferences.getString("motivation","");
        String dated = npreferences.getString("when","No date");
        int bloodp = npreferences.getInt("bloodt",0);
        int chinese = npreferences.getInt("yearb",0);
        //Set TextViews texts
        namelast.setText(name + " " + lastname);
        myDream.setText(dream);
        myReason.setText(motivation);
        dueto.setText(getString(R.string.due_to)+ dated);

        //Blood Type
        switch (bloodp) {
            case 0:
                //Type A
                btext.setText("A");
                break;
            case 1:
                //Type B
                btext.setText("B");
                break;
            case 2:
                //Type AB
                btext.setText("AB");
                break;
            case 3:
                //Type O
                btext.setText("O");
                break;
        }

        //Chinese Zodiac
        switch (chinese) {
            case 0:
                //Monkey
                ctext.setText(R.string.chinese1);
                break;

            case 1:
                //Rooster
                ctext.setText(R.string.chinese2);
                break;
            case 2:
                //Dog
                ctext.setText(R.string.chinese3);
                break;
            case 3:
                //Pig
                ctext.setText(R.string.chinese4);
                break;
            case 4:
                //Rat
                ctext.setText(R.string.chinese5);
                break;
            case 5:
                //Ox
                ctext.setText(R.string.chinese6);
                break;
            case 6:
                //Tiger
                ctext.setText(R.string.chinese7);
                break;
            case 7:
                //Rabbit
                ctext.setText(R.string.chinese8);
                break;
            case 8:
                //Dragon
                ctext.setText(R.string.chinese9);
                break;
            case 9:
                //Snake
                ctext.setText(R.string.chinese10);
                break;
            case 10:
                //Horse
                ctext.setText(R.string.chinese11);
                break;
            case 11:
                //Sheep
                ctext.setText(R.string.chinese12);
                break;

        }



    }
    //Next Activity: Menu of options
    public void openActivity(View view) {
        Intent intent = new Intent(this, Menu03.class);
        startActivity(intent);
    }
}
