package com.example.freecodecampeg;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

public class Learn_Snackbars extends AppCompatActivity {

    private ConstraintLayout parent;
    private Button btnShowSnackbar;

    //card view
    private MaterialCardView cardView;


    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_snackbars); //link dgn xml

        parent= findViewById(R.id.parent);
        btnShowSnackbar= findViewById(R.id.showSnackBtn);

        btnShowSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar();
            }
        });


        //card view
        cardView= findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Learn_Snackbars.this, "Card clicked", Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void showSnackBar(){
        Snackbar.make(parent, "This is a snackbar", Snackbar.LENGTH_SHORT)

                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {   //when user clicks the Retry
                        Toast.makeText(Learn_Snackbars.this, "Retry clicked", Toast.LENGTH_SHORT).show();
                    }
                })

                .setActionTextColor(getResources().getColor(R.color.orange)) //color Retry

                .setTextColor(Color.YELLOW) //color for message

                .show();
    }




}
