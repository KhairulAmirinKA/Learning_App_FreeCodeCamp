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
        contacts.add(new Contact("Bradly cooper", "156121651", "https://www.biography.com/.image/t_share/MTE1ODA0OTcxNTEyODU4MTI1/bradley-cooper-547062-1-402.jpg"));
        contacts.add(new Contact("Saoirse Ronan", "5654646", "https://www.nova.ie/wp-content/uploads/2017/12/Ronan-1.png"));
        contacts.add(new Contact("Horobi Koln", "66666", "https://www.nova.ie/wp-content/uploads/2017/12/Ronan-1.png"));
        contacts.add(new Contact("Drave Vectifier", "78888", "https://www.nova.ie/wp-content/uploads/2017/12/Ronan-1.png"));

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
