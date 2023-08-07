package LibraryProject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.freecodecampeg.R;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {

    private ArrayList<Book> bookArrayList= new ArrayList<>();
    private Context mContext;

    //constructor
    public BookRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //setter for arrayList
    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.library_list_item_book, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d("RecyclerView", "onBindViewHolder called");

        holder.txtBookName.setText( bookArrayList.get(position).getName()  );

        //glide
        Glide.with(mContext)
                .asBitmap()
                .load( bookArrayList.get(position).getImageURL() )
                .into(holder.imgBook);

        //click event
        holder.library_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,
                        bookArrayList.get(position).getName()+" selected",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    //view holder class
    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView library_parent;
        private ImageView imgBook;
        private TextView txtBookName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //init
            library_parent = itemView.findViewById(R.id.library_parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtBookName = itemView.findViewById(R.id.txtBookName);

        }
    }




}
