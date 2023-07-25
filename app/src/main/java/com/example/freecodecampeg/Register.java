package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.register); //link dgn xml
    }

    //for register
    public void onRegisterBtnClick(View view){
        TextView txtFirst= findViewById(R.id.txtFirstName);
        TextView txtLast= findViewById(R.id.txtLastName);
        TextView txtEmail= findViewById(R.id.txtEmail);

        EditText editFirstName= findViewById(R.id.editFirstName);
        EditText editLastName= findViewById(R.id.editLastName);
        EditText editEmail= findViewById(R.id.editEmail);

        //display on the screen
        txtFirst.setText("First name: "+ editFirstName.getText().toString());
        txtLast.setText("Last name: " + editLastName.getText().toString());
        txtEmail.setText("Email: "+ editEmail.getText().toString());

    }


}
