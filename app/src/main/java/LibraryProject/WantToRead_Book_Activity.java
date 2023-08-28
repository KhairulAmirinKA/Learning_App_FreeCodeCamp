package LibraryProject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.freecodecampeg.R;

public class WantToRead_Book_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_want_to_read_book);

        //back btn on the top
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //rec view
        RecyclerView recyclerView= findViewById(R.id.wantToRead_bookRecView);

        BookRecViewAdapter adapter= new BookRecViewAdapter(this, "wantToRead");

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        adapter.setBookArrayList( Utils.getInstance(this).getWantToReadBooks_List());
    }

    //handle back stack

    @Override
    public void onBackPressed() {

        Intent intent= new Intent(this, LibraryApp.class);

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