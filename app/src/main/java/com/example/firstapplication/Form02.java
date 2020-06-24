package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Form02 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Button button02, datew;
    EditText dream, motivation;
    Spinner categoryd;
    String currentDateString, dateSelected = "No date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form02);
        //variables
        button02 = (Button) findViewById(R.id.button02);
        dream = (EditText) findViewById(R.id.dream);
        motivation = (EditText) findViewById(R.id.motivation);

        categoryd = (Spinner) findViewById(R.id.category_dream); //Spinner - Industry of their dream
        ArrayAdapter<CharSequence> adapterBlood = ArrayAdapter.createFromResource(this,R.array.industryDream,android.R.layout.simple_spinner_item);
        categoryd.setAdapter(adapterBlood);

        datew = (Button) findViewById(R.id.date_when); //Goal planning
        datew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        dream.addTextChangedListener(formWhat);
        motivation.addTextChangedListener(formWhat);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        //Estimated time to accomplish the user's dream - when field
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        currentDateString = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(c.getTime());
        datew.setText(currentDateString);
        dateSelected = currentDateString;
    }

    //Validate form. The information won't be sent unless all the required fields are filled
    private TextWatcher formWhat = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String sdream = dream.getText().toString().trim();
            String smotivation = motivation.getText().toString().trim();
            //if dream input and motivation input aren't empty, enable button
            button02.setEnabled(!sdream.isEmpty() && !smotivation.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void saveForm02(View view){
        int positiond = categoryd.getSelectedItemPosition();
        String datepicked = dateSelected;

        //Save values- Form 02
        SharedPreferences preferences = getSharedPreferences("WHO", Context.MODE_PRIVATE); //check later
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString("dream", this.dream.getText().toString());
        editor.putString("motivation", this.motivation.getText().toString());
        editor.putInt("categoryd", positiond);
        editor.putString("when", datepicked);
        editor.commit();

        //Show message
        Toast.makeText(this, getString(R.string.saved_details), Toast.LENGTH_SHORT).show();
        //Next Activity: Menu of options
        Intent intent = new Intent(this, Menu03.class);
        startActivity(intent);
        finish();//no return

    }
}
