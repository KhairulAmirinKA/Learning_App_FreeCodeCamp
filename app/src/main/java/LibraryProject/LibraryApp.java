package LibraryProject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freecodecampeg.R;

public class LibraryApp extends AppCompatActivity {

    private Button btnAllBooks, btnCurrentlyRead, btnWishList, btnFavBook, btnAbout, btnAlreadyRead;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_layout); //link dgn xml

        //init
        initViews();

        //onclick the allbooks
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //AllBooks_Activity is the destination when user clicks the button
                Intent intent= new Intent(LibraryApp.this, AllBooks_Activity.class);
                startActivity(intent);
            }
        });

        //onclick the alreadyRead button
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //navigate to AlreadyReadBook Activity
                Intent intent= new Intent(LibraryApp.this, AlreadyRead_Book_Activity.class);
                startActivity(intent);
            }
        });


        //onclick currently read btn
        btnCurrentlyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //navigate to currentlyRead Book Activity
                Intent intent= new Intent(LibraryApp.this, CurrentlyRead_Book_Activity.class);
                startActivity(intent);
            }
        });


        //onclick the favorite btn
        btnFavBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //navigate to fav Book Activity
                Intent intent= new Intent(LibraryApp.this, Favorite_Book_Activity.class);
                startActivity(intent);
            }
        });

        //onclick the wishlist
        btnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //navigate to want to read Book Activity
                Intent intent= new Intent(LibraryApp.this, WantToRead_Book_Activity.class);
                startActivity(intent);
            }
        });


        //clicks the about btn
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder= new AlertDialog.Builder(LibraryApp.this);

                //set title
                builder.setTitle(getString(R.string.app_name));

                //set message
                builder.setMessage("Designed by Khairul Amirin\n" +
                        "Check website of Buku Prima for more interesting books");

                //negative btn
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nothing to show
                    }
                }); //-ve

                //positive btn
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //TODO: show the website
                        Intent intent= new Intent(LibraryApp.this, Website_Activity.class);

                        intent.putExtra("url", "https://google.com"); //go to Website_Activity.java

                        startActivity(intent);
                    }
                }); //visit the website


                //create
                builder.create().show();



            }
        });

        //get instance
         /*need to include Utils.getInstance in LibraryApp.java.
        otherwise, just use Utils.getInstance().getAlreadyRead_Books_List()
         */
        Utils.getInstance();









    }//oncreate

    //init views
    private void initViews() {

        btnAllBooks= findViewById(R.id.btnAllBooks);
        btnCurrentlyRead= findViewById(R.id.btnCurrentlyRead);
        btnAlreadyRead= findViewById(R.id.btnAlreadyRead);

        btnFavBook= findViewById(R.id.btnFavBook);

        btnWishList= findViewById(R.id.btnWishList);
        btnAbout= findViewById(R.id.btnAbout);

    }//endof initviews






}
