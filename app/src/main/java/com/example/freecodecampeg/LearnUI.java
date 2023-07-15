package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LearnUI extends AppCompatActivity {
    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_ui); //link dgn xml

        Button btn= findViewById(R.id.btnHello);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("button is working"); //check di logcat
                TextView txtWelcome= findViewById(R.id.txtWelcome);

                 txtWelcome.setText("saya cute");
            }
        });


    }

//    public void onHelloBtnClick(View view){
//        TextView txtWelcome= findViewById(R.id.txtWelcome);
//
//        txtWelcome.setText("saya cute");
//    }


}
