package com.example.mydrinkingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements GuestFragment.DialogListener {

    final String TAG = "MainActivity";
    // Login Activity
    EditText username;
    EditText password;
    Button loginButton, guestButton, quickTestButton;
    TextView createNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editUsernameId);
        password = findViewById(R.id.editPasswordId);

        loginButton = findViewById(R.id.loginButtonId); // Reference to floating action button
        quickTestButton = findViewById(R.id.quickTestId);
        guestButton = findViewById(R.id.guestButtonId);
        createNewAccount = findViewById(R.id.createAccountTextId);

        createNewAccount = (TextView) this.findViewById(R.id.createAccountId);

        // To do a quick test

        quickTestButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        // To create a new account

        createNewAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        // To log in as a guest

        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        // When we create a guest account, pop out window asks for age, weight, height and gender
                openDialog();
            }
        });

        // To log in as a user

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Give login information to the login
                // If the username and password match, we go to profile activity
                // If it does not, we send a toast that says invalid username or password

                // Go to profile activity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    public void openDialog() {
        GuestFragment guestFragment = new GuestFragment();
        guestFragment.show(getSupportFragmentManager(), "Guest Dialog");
    }
}