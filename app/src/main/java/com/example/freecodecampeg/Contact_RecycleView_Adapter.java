package com.example.freecodecampeg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Contact_RecycleView_Adapter extends RecyclerView.Adapter<Contact_RecycleView_Adapter.ViewHolder> {

    //create array list
    private ArrayList<Contact> contacts= new ArrayList<>();

    private Context context;



    public Contact_RecycleView_Adapter(Context context) {
        this.context= context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.contacts_list_item, parent, false);

        ViewHolder holder= new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.txtName.setText(contacts.get(position).getName() );

        //onclick
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,
                        contacts.get(position).getName()+" selecgted",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    //setter- to modify from other class
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;

        notifyDataSetChanged(); //refresh item
    }

    //inner class
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName= itemView.findViewById(R.id.txtName3);
            parent= itemView.findViewById(R.id.parent);

        }
    }






}
