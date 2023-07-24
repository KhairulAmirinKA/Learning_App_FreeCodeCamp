package com.example.freecodecampeg;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LearnListView extends AppCompatActivity {

    private ListView citiesList;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_listview); //link dgn xml


        citiesList= findViewById(R.id.citiesList);
        //add data
        ArrayList<String> cities= new ArrayList<>();
        cities.add("Zurich");
        cities.add("KB");
        cities.add("Bangkok");
        cities.add("Tokyo");
        cities.add("Madrid");

        //create adapter to fetch data
        ArrayAdapter<String> citiesAdapter= new ArrayAdapter<>(
                this,  //this refers to this file
                android.R.layout.simple_list_item_1,  //layout file
                cities
        );

        //pass the data to list view
        citiesList.setAdapter(citiesAdapter);

        //set action
        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(LearnListView.this,
                        cities.get(position)+" selected", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
