package com.example.freecodecampeg;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LearnLayout extends AppCompatActivity {

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout); //link dgn xml
    }
}
