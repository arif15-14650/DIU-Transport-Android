package com.example.anproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class regActivity extends AppCompatActivity {
    EditText id, pass;
    Button conbtn;
    TextView loginTextView;
    DatabaseReference rootDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        id = findViewById(R.id.idInp);
        pass = findViewById(R.id.passInp);
        conbtn = findViewById(R.id.conid);
        loginTextView = findViewById(R.id.login_text_view);
        rootDatabase = FirebaseDatabase.getInstance().getReference().child("UserCredentials");
        // Assuming that "UserCredentials" is the correct reference to match with the login activity

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(regActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void continuebtn(View view) {
        String sid = id.getText().toString();
        String password = pass.getText().toString();

        // Check if ID or password is empty
        if (TextUtils.isEmpty(sid) || TextUtils.isEmpty(password)) {
            // Show a message if ID or password is empty
            Toast.makeText(this, "Enter your ID and password", Toast.LENGTH_SHORT).show();
            return;
        }


        rootDatabase.child(sid).child("Password").setValue(password);

        Intent myIntent = new Intent(regActivity.this, MainActivity.class);
        startActivity(myIntent);
    }
}
