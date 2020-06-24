package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Form01 extends AppCompatActivity {
    Button button01;
    EditText name, lastname;
    Spinner bloodS;
    NumberPicker yearb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form01);

        //variables
        name = (EditText) findViewById(R.id.name);
        lastname = (EditText) findViewById(R.id.lastname);
        button01 = (Button) findViewById(R.id.button01);

        int year = Calendar.getInstance().get(Calendar.YEAR); //NumberPicker - Chinese Zodiac
        yearb = (NumberPicker) findViewById(R.id.yearpick);
        yearb.setMinValue(year - 100); //min current year - 100
        yearb.setMaxValue(year - 5);   //max current year - 5

        bloodS = (Spinner) findViewById(R.id.blood_select); //Spinner - Blood Type
        ArrayAdapter<CharSequence> adapterBlood = ArrayAdapter.createFromResource(this,R.array.bloodType,android.R.layout.simple_spinner_item);
        bloodS.setAdapter(adapterBlood);
        //method used to verify if the required fields are empty
        name.addTextChangedListener(formWho);
        lastname.addTextChangedListener(formWho);


    }

    //Validate form. The information won't be sent unless all the required fields are filled
    private TextWatcher formWho = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        String sname = name.getText().toString().trim();
        String slastname = lastname.getText().toString().trim();
        //if name input and last name input aren't empty, enable button
        button01.setEnabled(!sname.isEmpty() && !slastname.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void saveForm01(View view){

        int chinese;
        int positionb = bloodS.getSelectedItemPosition();
        int valuey = yearb.getValue();
        //formula to calculate chinese zodiac based on given year of birth
        chinese = valuey % 12; //remainder

        //Saving values - Form 01
        SharedPreferences preferences = getSharedPreferences("WHO", Context.MODE_PRIVATE); //check later
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", this.name.getText().toString());
        editor.putString("lname", this.lastname.getText().toString());
        editor.putInt("bloodt", positionb);
        editor.putInt("yearb", chinese);
        editor.commit();

        //Show message
        Toast.makeText(this, getString(R.string.saved_details), Toast.LENGTH_SHORT).show();
        //Next Activity: Form 02
        Intent intent = new Intent(this, Form02.class);
        startActivity(intent);
        finish(); //no return

    }
}
