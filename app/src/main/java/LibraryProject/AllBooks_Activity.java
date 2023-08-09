package LibraryProject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freecodecampeg.R;

import java.util.ArrayList;

public class AllBooks_Activity extends AppCompatActivity {

    private RecyclerView bookRecView;
    private BookRecViewAdapter adapter;

    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_all_books); //link dgn xml

        //create adapter
        adapter= new BookRecViewAdapter(this);

        //book recycler view
        bookRecView= findViewById(R.id.bookRecView);

        bookRecView.setAdapter(adapter); //set adapter

        //set layout. no of col =2
        bookRecView.setLayoutManager(new LinearLayoutManager(this));

        //create arraylist
        ArrayList<Book> bookArrayList= new ArrayList<>();

        bookArrayList.add(
                new Book(1, "Lengloi", "Maria", 500,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2016/20161336/Thumbnails/Cover.jpg",
                        "A horror book", "Long Desc") );

        bookArrayList.add(
                new Book(2, "Town Mall", "Hasrudi Jawawi", 800,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2017/20170310072714/Thumbnails/Cover.jpg",
                        "The mall is haunted", "this book is not very scary")   );

        adapter.setBookArrayList(bookArrayList);






    }


}
