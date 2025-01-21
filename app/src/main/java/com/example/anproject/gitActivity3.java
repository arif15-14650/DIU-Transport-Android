package com.example.anproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class gitActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mySpinner;
    String option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git3);

        mySpinner=findViewById(R.id.spinnerID);

        ArrayAdapter<CharSequence> myAdapter=ArrayAdapter.createFromResource
                (this,R.array.stringValues, android.R.layout.simple_spinner_item);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        option=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void gobtn(View view) {
        if (option.equals("Transport Authority")) {
            Intent myintent= new Intent(this, taActivity.class);
            startActivity(myintent);

        } else if (option.equals("University Authority")) {
            Intent myintent= new Intent(this, uaActivity.class);
            startActivity(myintent);
        } else {
            Toast.makeText(this, "Select an option first", Toast.LENGTH_SHORT).show();
        }
    }
}