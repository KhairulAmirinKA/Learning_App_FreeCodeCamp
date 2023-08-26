package LibraryProject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

        //transition
        //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        //enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //create adapter
        adapter= new BookRecViewAdapter(this, "allBooks");

        //book recycler view
        bookRecView= findViewById(R.id.alreadyRead_bookRecView);

        bookRecView.setAdapter(adapter); //set adapter

        //set layout. no of col =2
        bookRecView.setLayoutManager(new LinearLayoutManager(this));

        //create arraylist
        ArrayList<Book> bookArrayList= new ArrayList<>();


        adapter.setBookArrayList(Utils.getInstance().getAllBooks_List());






    } //onCreate


    //back button in the menu bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed(); //similar to back btn below
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //when user clicks Back btn
//    @Override
//    public void finish() {
//        super.finish();
//
//        //transition
//        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
//    }
}
