package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LearnButton_Text extends AppCompatActivity implements View.OnClickListener {

    private TextView txtWelcome;
    private EditText edtTxtName;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_btn_txt); //link dgn xml

        Button btn= findViewById(R.id.btnHello);

        //method 1
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("button is working"); //check di logcat
//                TextView txtWelcome= findViewById(R.id.txtWelcome);
//
//                 txtWelcome.setText("saya cute");
//            }
//        });

        //method 2
        btn.setOnClickListener(this);


        //long click
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(LearnButton_Text.this, "this is a long press", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        //get by id
         edtTxtName= findViewById(R.id.edtTxtName);
         txtWelcome= findViewById(R.id.txtWelcome);
    }

    @Override
    public void onClick(View view) {   //method 2. only 1 method for multiple id
        if (view.getId() == R.id.btnHello) {
            System.out.println("Hello");

            //make toast
            Toast.makeText(this, "ini ialah toast", Toast.LENGTH_LONG).show();

            //setText
            txtWelcome.setText("Welcome "+ edtTxtName.getText().toString());
        }
    }

    //method 3
//    public void onHelloBtnClick(View view){
//        TextView txtWelcome= findViewById(R.id.txtWelcome);
//
//        txtWelcome.setText("saya cute");
//    }



}
