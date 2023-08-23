package LibraryProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.freecodecampeg.R;

public class WantToRead_Book_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_want_to_read_book);

        //rec view
        RecyclerView recyclerView= findViewById(R.id.wantToRead_bookRecView);

        BookRecViewAdapter adapter= new BookRecViewAdapter(this, "wantToRead");

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        adapter.setBookArrayList( Utils.getWantToReadBooks_List());
    }

    //handle back stack

    @Override
    public void onBackPressed() {

        Intent intent= new Intent(this, LibraryApp.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}