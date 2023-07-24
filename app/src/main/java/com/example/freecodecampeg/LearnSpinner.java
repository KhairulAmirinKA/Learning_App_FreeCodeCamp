package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LearnSpinner extends AppCompatActivity {

    private Spinner studentSpinner;


    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_spinner); //link dgn xml

        //spinner
        studentSpinner= findViewById(R.id.studentSpinner);

        ArrayList<String> students= new ArrayList<>();
        String[] names={"Ali", "Alicia", "Anya", "Moon", "Kim"};

        for (String name: names)
         students.add(name);

        //create adapter to fetch data
        ArrayAdapter<String> studentAdapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                students
        );

        //give data
        studentSpinner.setAdapter(studentAdapter);

        //listener
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(LearnSpinner.this,
                        students.get(position)+" selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //alternative other than use array list
       // displayMessageOnClick(studentSpinner);









    }

    public void displayMessageOnClick(Spinner studentSpinner){

                studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(LearnSpinner.this,
                        studentSpinner.getSelectedItem().toString()+" selected",
                        Toast.LENGTH_SHORT).show();
            }

            //getSelectedItem() refers to the entries in xml file (array in strings.xml)

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
