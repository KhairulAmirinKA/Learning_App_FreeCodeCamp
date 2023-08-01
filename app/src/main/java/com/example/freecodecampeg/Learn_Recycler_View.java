package com.example.freecodecampeg;

//checks :
// contact_RecycleView_Adapter.java
//Contact.java
//contacts_list_item.xml
//learn recyclerview.xml

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Learn_Recycler_View extends AppCompatActivity {

    private RecyclerView contactsRecyclerView;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_recyclerview); //link dgn xml


        contactsRecyclerView= findViewById(R.id.contactsRecyclerView);

        ArrayList<Contact> contacts= new ArrayList<>();
        contacts.add(new Contact("Kimberly Song", "156121651", "https://i.pinimg.com/1200x/25/ac/8c/25ac8c3e626dd6404601534178ffef21.jpg"));
        contacts.add(new Contact("Alicia", "5654646", "https://i.pinimg.com/236x/28/fc/86/28fc869183ef1daa32eb401d845642c6.jpg"));
        contacts.add(new Contact("Shinobu Kocho", "66666", "https://i.pinimg.com/736x/24/17/56/241756be0756d2f79baef294c9f607df.jpg"));
        contacts.add(new Contact("Aoi Kanzaki", "78888", "https://static.wikia.nocookie.net/kimetsu-no-yaiba/images/6/63/Aoi_anime_design.png"));

        //create adapter
        Contact_RecycleView_Adapter adapter= new Contact_RecycleView_Adapter(this);
        adapter.setContacts(contacts); //store the contacts into array list

        //set adapter
        contactsRecyclerView.setAdapter(adapter);

        //contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //2. change to horizontal
//        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(
//                this, LinearLayoutManager.HORIZONTAL, false));

        //3. border
        contactsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));







    }
}
