package com.example.anproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class LoginActivity extends AppCompatActivity {

    EditText idInput, passInput;
    Button loginButton;
    TextView registerTextView;
    DatabaseReference rootDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idInput = findViewById(R.id.id);
        passInput = findViewById(R.id.pass);
        loginButton = findViewById(R.id.loginid);
        registerTextView = findViewById(R.id.register_text_view);

        rootDatabase = FirebaseDatabase.getInstance().getReference().child("UserCredentials");

        // Set the OnClickListener for the loginButton
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginbtn();
            }
        });

        // Set the OnClickListener for the registerTextView
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(LoginActivity.this, regActivity.class);
                startActivity(myIntent);
            }
        });
    }
    private void loginbtn() {
        final String enteredId = idInput.getText().toString();
        final String enteredPassword = passInput.getText().toString();

        if (enteredId.isEmpty() || enteredPassword.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please enter both Student ID and Password", Toast.LENGTH_SHORT).show();
            return; // Exit the method if either ID or password is empty
        }

        rootDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(enteredId).exists()) {
                    String storedPassword = dataSnapshot.child(enteredId).child("Password").getValue(String.class);

                    if (enteredPassword.equals(storedPassword)) {
                        // Login successful
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Optional: Close the login activity
                    } else {
                        // Password is incorrect
                        Toast.makeText(LoginActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // ID does not exist
                    Toast.makeText(LoginActivity.this, "Student ID does not exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
