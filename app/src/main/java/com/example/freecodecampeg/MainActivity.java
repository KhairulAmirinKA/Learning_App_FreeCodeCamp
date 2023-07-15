package com.example.freecodecampeg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //link dgn xml
        //setContentView(R.layout.register);

        //TODO: belajar




    }

    public void onBtnClick(View view){

        TextView txtHello= findViewById(R.id.txtMessage);
        //txtHello.setText("insya-Allah boleh");

        EditText editTxtName= findViewById(R.id.editFirstName);
        String name= editTxtName.getText().toString();
        txtHello.setText("Hello "+name);


    }


}