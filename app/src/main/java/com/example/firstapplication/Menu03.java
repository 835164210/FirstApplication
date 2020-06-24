package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu03 extends AppCompatActivity {
Button infob, someoneb, quotesb, profileb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu03);
        //variables
        infob = (Button) findViewById(R.id.infob);
        someoneb = (Button) findViewById(R.id.someoneb);
        quotesb = (Button) findViewById(R.id.quotesb);
        profileb = (Button) findViewById(R.id.profileb);
    }

    public void toGo(View view) {
    //Menu Map
        if (view.equals(infob)){
            //InfoP04
           Intent intent1 = new Intent(this, Info04.class);
           startActivity(intent1);
        }
        if (view.equals(someoneb)) {
            //Someone05
            Intent intent2 = new Intent(this, Someone05.class);
            startActivity(intent2);
        }
        if (view.equals(quotesb)) {
            //Quotes06
            Intent intent3 = new Intent(this, Quotes06.class);
            startActivity(intent3);
        }
        if (view.equals(profileb)){
            //Profile07
            Intent intent4 = new Intent(this, Profile07.class);
            startActivity(intent4);
        }


    }
}
