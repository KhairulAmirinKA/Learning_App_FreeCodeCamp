package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LearnXML extends AppCompatActivity {

    private TextView txtHello;


    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_xml); //link dgn xml


        txtHello= findViewById(R.id.txtHello);
        //txtHello.setText("ggg");
        txtHello.setText(getText(R.string.hello));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater= getMenuInflater(); //same like find view by id

        inflater.inflate(R.menu.main_menu, menu);

        return true;


    }
}