package LibraryProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.freecodecampeg.R;

public class AlreadyRead_Book_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_already_read_book);

        RecyclerView recyclerView= findViewById(R.id.alreadyRead_bookRecView);

        //use same rec view adapter
        BookRecViewAdapter adapter= new BookRecViewAdapter(this);

        //set adapter
        recyclerView.setAdapter(adapter);

        //layout
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        adapter.setBookArrayList(Utils.getAlreadyRead_Books_List());
        /*need to include Utils.getInstance in LibraryApp.java.
        otherwise, just use Utils.getInstance().getAlreadyRead_Books_List()
         */


    }//oncreate


    //select methods to override. CTRL O


    //back button is pressed
    @Override
    public void onBackPressed() {

        //navigate to the main activity when back btn is pressed
        Intent intent = new Intent(this, LIbraryApp.class);

        //at main activity, user will quit app when he clicks back btn
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}