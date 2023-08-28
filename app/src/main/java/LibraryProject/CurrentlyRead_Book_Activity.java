package LibraryProject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.freecodecampeg.R;

public class CurrentlyRead_Book_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_currently_read_book);

        //back btn on top
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //recyler view
        RecyclerView recyclerView= findViewById(R.id.currentlyRead_bookRecView);

        BookRecViewAdapter adapter= new BookRecViewAdapter(this, "currentlyRead");

        //set adapter
        recyclerView.setAdapter(adapter);

        //layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBookArrayList(Utils.getInstance(this).getCurrentlyReadingBooks_List());
        /*need to include Utils.getInstance in LibraryApp.java.
        otherwise, just use Utils.getInstance().getAlreadyRead_Books_List()
         */

    }//onCreate

    @Override
    public void onBackPressed() {

        //back btn will redirect to the main page
        Intent intent= new Intent(this, LibraryApp.class);

        //at main activity, user will quit app when he clicks back btn
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}