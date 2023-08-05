package LibraryProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freecodecampeg.R;

public class LIbraryApp extends AppCompatActivity {

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
                Intent intent= new Intent(LIbraryApp.this, AllBooks_Activity.class);
                startActivity(intent);
            }
        });









    }//oncreate

    //init views
    private void initViews() {

        btnAllBooks= findViewById(R.id.btnAllBooks);
        btnCurrentlyRead= findViewById(R.id.btnCurrentlyRead);
        btnAlreadyRead= findViewById(R.id.btnAlreadyRead);

        btnFavBook= findViewById(R.id.btnFavBook);

        btnWishList= findViewById(R.id.btnWishList);
        btnAbout= findViewById(R.id.btnWishList);

    }//endof initviews






}
