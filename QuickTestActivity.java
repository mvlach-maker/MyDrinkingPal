package com.example.mydrinkingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuickTestActivity extends AppCompatActivity {

    // To do a quick breathalyzer test with a result
    // Tells us if we are fit to drive or not

    // No input of drinks
    // No projections

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_test);
    }
}