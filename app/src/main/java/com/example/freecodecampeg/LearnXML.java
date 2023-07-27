package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //select item

        int id= item.getItemId();

        if (id== R.id.settingsMenu){
            Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id==R.id.alarmMenu){
            Toast.makeText(this, "Alarm selected", Toast.LENGTH_SHORT).show();
            return true;
        }


        else{
        return super.onOptionsItemSelected(item); }

    }
}