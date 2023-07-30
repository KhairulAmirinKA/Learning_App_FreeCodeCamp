package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Learn_MaterialDesign extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_material_design); //link dgn xml

        fab= findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Learn_MaterialDesign.this, "FAB clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
