package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
Button profile, main;

Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //variables
        main = (Button) findViewById(R.id.mainb);
        profile = (Button) findViewById(R.id.profileb);
        profile.setVisibility(View.INVISIBLE);
        display();
    }

    //display button if user's data found
    public void display() {
        //If we have stored information from this user, show profile button
        SharedPreferences npreferences = getSharedPreferences("WHO", MODE_PRIVATE);
        if(npreferences.contains(("name"))){
           profile.setVisibility(View.VISIBLE);
        }
    }

    //open activity according to the button clicked
    public void openActivity(View view) {

        if(view.equals(main)){
            //Chosen option: go to Form 01
            Intent intent = new Intent(this, Form01.class);
            startActivity(intent);
        }

        if(view.equals(profile)){
            //Chosen option: go to my Profile
            Intent intent = new Intent(this, Profile07.class);
            startActivity(intent);
        }

    }



}
