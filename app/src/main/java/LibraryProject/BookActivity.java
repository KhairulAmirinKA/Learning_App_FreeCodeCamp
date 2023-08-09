package LibraryProject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.freecodecampeg.R;

public class BookActivity extends AppCompatActivity {

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

        //TODO: get data from recycler view
        Book book=  new Book(1, "Lengloi", "Maria", 500,
                "https://cdn-shop.ookbee.com/Books/KarangBooks/2016/20161336/Thumbnails/Cover.jpg",
                "A horror book", "Long Desc") ;

        setData(book);



    }

    private void setData(Book book) {

        txtBookName.setText( book.getName());
        txtPages.setText(String.valueOf(book.getPages()));
        txtAuthorName.setText(book.getAuthor());
        shortDescText.setText( book.getShortDesc());

        //use glide
        Glide.with(this)
                .asBitmap()
                .load( book.getImageURL())
                .into(imgBook);
    }

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



    }
}