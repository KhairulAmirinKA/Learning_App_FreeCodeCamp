package LibraryProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.freecodecampeg.R;

public class BookActivity extends AppCompatActivity {

    //const keys - for safety
    public static final String BOOK_ID_KEY= "bookId";

    private ImageView imgBook;

    private Button btnAddToCurrentlyReading,btnAddWantToRead, btnAddToAlreadyRead, btnAddToFavourites;

    private TextView txtBookName, txtAuthorName, txtPages ;
    private TextView nameText, authorText, pagesText, shortDescText, longDescText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_book);

        //init
        initViews();



//        String longDesc= "Every person who opens a new shop will be haunted.\nWhat is the reason " +
//                "of that mystery?\n" +
//                "Can they survive?";
//
//        Book book=  new Book(1, "Lengloi", "Maria", 500,
//                "https://cdn-shop.ookbee.com/Books/KarangBooks/2016/20161336/Thumbnails/Cover.jpg",
//                "A horror book", longDesc) ;

//TODO: get data from recycler view
        //get data safely ffrom recycler view
        Intent intent= getIntent();

        if (intent!= null){ //1st check

            int bookId= intent.getIntExtra(BOOK_ID_KEY, -1); //-1 if not found

            if (bookId != -1){ //2nd check
                Book incomingBook= Utils.getInstance().getBookById(bookId);

                if (incomingBook != null){ //3rd check
                    setData(incomingBook);
                }
            }//if bookId

        } //if intent





    }//onCreate

    private void setData(Book book) {

        txtBookName.setText( book.getName());
        txtPages.setText(String.valueOf(book.getPages()));
        txtAuthorName.setText(book.getAuthor());
        shortDescText.setText( book.getShortDesc());
        longDescText.setText( book.getLongDesc());

        //use glide
        Glide.with(this)
                .asBitmap()
                .load( book.getImageURL())
                .into(imgBook);
    } //setData

    private void initViews() {

        imgBook= findViewById(R.id.imgBook2);

        btnAddToCurrentlyReading= findViewById(R.id.btnAddToCurrentlyReading);
        btnAddWantToRead= findViewById(R.id.btnAddWantToRead);
        btnAddToAlreadyRead= findViewById(R.id.btnAddToAlreadyRead);
        btnAddToFavourites= findViewById(R.id.btnAddToFavourites);

        nameText= findViewById(R.id.nameText);
        txtBookName= findViewById(R.id.txtBookName2);
        authorText =findViewById(R.id.authorText2);
        txtAuthorName= findViewById(R.id.txtAuthorName);
        pagesText = findViewById(R.id.pagesText);
        txtPages= findViewById(R.id.txtPages);
        shortDescText= findViewById(R.id.shortDescText);
        longDescText= findViewById(R.id.longDescText);



    }//init view
}