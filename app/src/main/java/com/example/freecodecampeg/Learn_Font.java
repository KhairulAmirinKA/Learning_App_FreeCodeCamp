package com.example.freecodecampeg;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Learn_Font extends AppCompatActivity {

    private Button btnChangeFont;
    private TextView txtHello;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_font); //link dgn xml

        txtHello= findViewById(R.id.txtHello4);
        btnChangeFont= findViewById(R.id.btnChangeFont);

        //get font
        Typeface typeface= ResourcesCompat.getFont(this, R.font.bauh);

        btnChangeFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHello.setTypeface(typeface); //change font
            }
        });







    }
}
