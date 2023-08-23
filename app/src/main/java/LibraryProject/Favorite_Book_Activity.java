package LibraryProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.freecodecampeg.R;

public class Favorite_Book_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_favorite_book);

        RecyclerView recyclerView= findViewById(R.id.favorite_bookRecView);

        BookRecViewAdapter adapter= new BookRecViewAdapter(this, "favoriteBook");

        //set adapter
        recyclerView.setAdapter(adapter);

        //set layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBookArrayList(Utils.getFavoriteBooks_List());
         /*need to include Utils.getInstance in LibraryApp.java.
        otherwise, just use Utils.getInstance().getAlreadyRead_Books_List()
         */

    }//onCreate

    @Override
    public void onBackPressed() {

        //navigate to the main activity when back btn is pressed
        Intent intent = new Intent(this, LibraryApp.class);

        //at main activity, user will quit app when he clicks back btn
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}