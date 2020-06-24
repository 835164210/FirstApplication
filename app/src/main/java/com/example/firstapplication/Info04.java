package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Info04 extends AppCompatActivity {
TextView btype, bdes, csign, cdes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info04);
        btype = (TextView) findViewById(R.id.btype);
        bdes = (TextView) findViewById(R.id.bdes);
        csign = (TextView) findViewById(R.id.csign);
        cdes = (TextView) findViewById(R.id.cdes);
        display();
    }

    public void display(){
        SharedPreferences npreferences = getSharedPreferences("WHO", MODE_PRIVATE);
        int bloodp = npreferences.getInt("bloodt",0);
        int chinese = npreferences.getInt("yearb",0);


        //Information to display based on user's data
        //Blood Type
        switch (bloodp) {
            case 0:
                //Type A
                btype.setText(R.string.aBlood_label);
                bdes.setText(R.string.bloodA_des);
                break;
            case 1:
                //Type B
                btype.setText(R.string.bBlood_label);
                bdes.setText(R.string.bloodB_des);
                break;
            case 2:
                //Type AB
                btype.setText(R.string.abBlood_label);
                bdes.setText(R.string.bloodAB_des);
                break;
            case 3:
                //Type O
                btype.setText(R.string.oBlood_label);
                bdes.setText(R.string.bloodO_des);
                break;
        }

        //Chinese Zodiac
        switch (chinese) {
            case 0:
                //Monkey
                csign.setText(R.string.chinese1);
                cdes.setText(R.string.cdes1);
                break;

            case 1:
                //Rooster
                csign.setText(R.string.chinese2);
                cdes.setText(R.string.cdes2);
                break;
            case 2:
                //Dog
                csign.setText(R.string.chinese3);
                cdes.setText(R.string.cdes3);
                break;
            case 3:
                //Pig
                csign.setText(R.string.chinese4);
                cdes.setText(R.string.cdes4);
                break;
            case 4:
                //Rat
                csign.setText(R.string.chinese5);
                cdes.setText(R.string.cdes5);
                break;
            case 5:
                //Ox
                csign.setText(R.string.chinese6);
                cdes.setText(R.string.cdes6);
                break;
            case 6:
                //Tiger
                csign.setText(R.string.chinese7);
                cdes.setText(R.string.cdes7);
                break;
            case 7:
                //Rabbit
                csign.setText(R.string.chinese8);
                cdes.setText(R.string.cdes8);
                break;
            case 8:
                //Dragon
                csign.setText(R.string.chinese9);
                cdes.setText(R.string.cdes9);
                break;
            case 9:
                //Snake
                csign.setText(R.string.chinese10);
                cdes.setText(R.string.cdes10);
                break;
            case 10:
                //Horse
                csign.setText(R.string.chinese11);
                cdes.setText(R.string.cdes11);
                break;
            case 11:
                //Sheep
                csign.setText(R.string.chinese12);
                cdes.setText(R.string.cdes12);
                break;

        }


    }
    //Next activity
    public void openActivity(View view) {
        Intent intent = new Intent(this, Menu03.class);
        startActivity(intent);
    }
}
