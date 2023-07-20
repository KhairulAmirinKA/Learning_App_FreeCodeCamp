package com.example.freecodecampeg;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Learn_Radio_Checkbox extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxMatrix, checkBoxJoker;

    private RadioGroup rgMaritalStatus;

    private ProgressBar progressBar;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_radio_checkbox); //link dgn xml


        checkBoxHarry= findViewById(R.id.checkboxHarry);
        checkBoxJoker= findViewById(R.id.checkBoxJoker);
        checkBoxMatrix= findViewById(R.id.checkboxMatrix);

        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){ //if checked
                    Toast.makeText(Learn_Radio_Checkbox.this, "Already watched Harry Potter", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(Learn_Radio_Checkbox.this, "Please watch", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //radio group
        rgMaritalStatus= findViewById(R.id.rgMaritalStatus);

        int checkedBtn= rgMaritalStatus.getCheckedRadioButtonId();

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (checkedId== R.id.rbMarried){ //cannot use switch
                    Toast.makeText(Learn_Radio_Checkbox.this, "Married", Toast.LENGTH_SHORT).show();
                }

                else if (checkedId == R.id.rbSingle){
                    Toast.makeText(Learn_Radio_Checkbox.this, "Single", Toast.LENGTH_SHORT).show();

                    //change visibility of progress bar
                    //progressBar.setVisibility(View.VISIBLE);
                }

                else if (checkedId == R.id.rbInRel){
                    Toast.makeText(Learn_Radio_Checkbox.this, "In a Relationship", Toast.LENGTH_SHORT).show();

                    //change visibility of progress bar
                    //progressBar.setVisibility(View.GONE);
                }


            }
        });


        //progress bar
        progressBar= findViewById(R.id.progressBar);

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i<10; i++){
                    progressBar.incrementProgressBy(10); //increase by 10
                    SystemClock.sleep(500); //after increment, sleep
                }
            }
        });

        thread.start();



    }
}
