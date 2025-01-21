package com.example.anproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class communityActivity5 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner MYspinner;
    String select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community5);
        MYspinner=findViewById(R.id.spinID);

        ArrayAdapter<CharSequence> myAdapter=ArrayAdapter.createFromResource
                (this,R.array.spinnerValues, android.R.layout.simple_spinner_item);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        MYspinner.setAdapter(myAdapter);
        MYspinner.setOnItemSelectedListener(this);


    }

    public void btn(View view) {

        if (select.equals("Dhanmondi Community")) {
            Intent myintent= new Intent(this, dhanmondi.class);
            startActivity(myintent);

        } else if (select.equals("Mipur Community")) {
            Intent myintent= new Intent(this, mirpur.class);
            startActivity(myintent);
        }
        else if (select.equals("Uttara Community")) {
            Intent myintent= new Intent(this, uttora.class);
            startActivity(myintent);
        }
        else if (select.equals("Tongi Community")) {
            Intent myintent= new Intent(this, tongi.class);
            startActivity(myintent);
        }
        else {
            Toast.makeText(this, "Select an option first", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        select=adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}