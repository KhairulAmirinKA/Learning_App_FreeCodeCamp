package LibraryProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.freecodecampeg.R;

import java.util.ArrayList;

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

                    //handle already read books
                    handleAlreadyRead(incomingBook);

                    //handle want to read
                    handleWantToRead(incomingBook);

                    //TODO: handle currently reading
                    handleCurrentlyReadingBooks(incomingBook);

//                    //TODO: handle favorite books
                    handleFavoriteBooks(incomingBook);

                }
            }//if bookId

        } //if intent





    }//onCreate

    private void handleFavoriteBooks(final Book book) {

        ArrayList<Book> favoriteBooks= Utils.getInstance().getFavoriteBooks_List();

        boolean exist_in_favoriteBooks= false; //check whether the book is in the list

        //traverse
        for (Book b: favoriteBooks){
            if (b.getId() == book.getId()){
                exist_in_favoriteBooks= true;
            }
        }//for

        //if already exist, disable the btn
        if (exist_in_favoriteBooks){

            //disable the btn
            btnAddToFavourites.setEnabled(false);
        }

        else {
            btnAddToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (Utils.getInstance().addTo_Favorite(book)){

                        Toast.makeText(BookActivity.this, "Added", Toast.LENGTH_SHORT).show();

                        //navigate to the favorite book activity
                        Intent intent= new Intent(BookActivity.this, Favorite_Book_Activity.class);
                        startActivity(intent);
                    }//if

                    else {
                        Toast.makeText(BookActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(final Book book) {

        ArrayList<Book> currentlyReadBooks= Utils.getInstance().getCurrentlyReadingBooks_List();

        boolean exist_in_currentlyReadBooks= false; //check whether the book is in the list

        //traverse
        for (Book b: currentlyReadBooks){
            if (b.getId()== book.getId()){
                exist_in_currentlyReadBooks= true;
            }
        }

        //if already exist, disable btn
        if (exist_in_currentlyReadBooks){
            btnAddToCurrentlyReading.setEnabled(false); //disable
        }

        else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (Utils.getInstance().addTo_CurrentlyRead(book)){

                        Toast.makeText(BookActivity.this, "Added", Toast.LENGTH_SHORT).show();

                        //navigate to the want to read activity
                        Intent intent= new Intent(BookActivity.this, CurrentlyRead_Book_Activity.class);
                        startActivity(intent);

                    }//if

                    else {
                        Toast.makeText(BookActivity.this, "Failed to add", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

    //want to read
    private void handleWantToRead(final Book book) {

        ArrayList<Book> wantToReadBooks= Utils.getInstance().getWantToReadBooks_List();

        boolean exist_In_WantToReadBooks= false; //check whether the book is in the list

        for (Book b: wantToReadBooks){
            if (b.getId() == book.getId()){
                exist_In_WantToReadBooks= true;
            }
        }//for

        //the book is already in the list, disable the btn
        if (exist_In_WantToReadBooks){

            //disable btn
            btnAddWantToRead.setEnabled(false);
        }


        else {
            btnAddWantToRead.setOnClickListener(new View.OnClickListener() { //onclick the btn
                @Override
                public void onClick(View view) {

                    //when the book is added
                    if (Utils.getInstance().addTo_WantToRead(book)){

                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();

                        //navigate to the want to read activity
                        Intent intent= new Intent(BookActivity.this, WantToRead_Book_Activity.class);
                        startActivity(intent);
                    }

                    else {
                        Toast.makeText(BookActivity.this, "cannot add", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }// handle want to read activity


    /**
     * Enable and disable button
     * Add book to the AlreadyReadBook ArrayList
     * @param book
     */
    private void handleAlreadyRead(Book book) {

        ArrayList<Book> alreadyReadBooks= Utils.getInstance().getAlreadyRead_Books_List();

        //check whether the book is already read
        boolean exist_In_alreadyReadBooks= false;

        //traverse
        for (Book b: alreadyReadBooks){

            if (b.getId() == book.getId() ){
                exist_In_alreadyReadBooks= true; //books already exists in alreadyReadBooks
            }
        }

        //disable button
        if (exist_In_alreadyReadBooks){
            //cannot add to the already read books as it is already in there
            btnAddToAlreadyRead.setEnabled(false);
        }

        else { //add event to the button

            //add to the already read list
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (Utils.getInstance().addTo_AlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();

                        //TODO:navigate to other activity
                        Intent intent= new Intent(BookActivity.this, AlreadyRead_Book_Activity.class);
                        startActivity(intent);

                    }

                    else {
                        Toast.makeText(BookActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }//handle already read


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