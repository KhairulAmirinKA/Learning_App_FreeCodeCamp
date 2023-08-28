package LibraryProject;

import static LibraryProject.BookActivity.BOOK_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;
import com.example.freecodecampeg.R;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {

    private ArrayList<Book> bookArrayList= new ArrayList<>();
    private Context mContext;

    private String parentActivity;


    //constructor
    public BookRecViewAdapter(Context mContext, String parentActivity) {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
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

                Intent intent= new Intent(mContext, BookActivity.class); //when clicked, the details of the book will be displayed

                //BOOK_ID_KEY = bookId. in the BookActivity.java
                intent.putExtra(BOOK_ID_KEY, bookArrayList.get(position).getId() );

                mContext.startActivity(intent);
            }
        });

        //set text
        holder.txtAuthor.setText( bookArrayList.get(position).getAuthor() );
        holder.txtShortDesc.setText( bookArrayList.get(position).getShortDesc() );


        //if expanded
        if (bookArrayList.get(position).isExpanded() ){

            //add transition
            TransitionManager.beginDelayedTransition(holder.library_parent);

            //change visibility
            holder.expandedRel_Layout.setVisibility(View.VISIBLE);
            holder.btnDownArrow.setVisibility(View.GONE); //hide down button

            //no need delete btn if the activity shows the all books
            if (parentActivity.equals("allBooks")){
                holder.btnDelete.setVisibility(View.GONE);
            }

            //the activity of alreadyRead
            else if (parentActivity.equals("alreadyRead")){

                //btnDelete is visible
                holder.btnDelete.setVisibility(View.VISIBLE);

                //name of the removed book
                String bookName= bookArrayList.get(position).getName();
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder= new AlertDialog.Builder(mContext);

                        //confirmation message
                        builder.setMessage("Are you sure want to delete "+ bookName+" ?");

                        //yes
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (Utils.getInstance(mContext).removeFrom_AlreadyRead( bookArrayList.get(position) ) ){

                                    Toast.makeText(mContext, bookName+" removed", Toast.LENGTH_SHORT).show();

                                    notifyDataSetChanged();
                                }//if removed
                            }//onclick yes
                        }); //positive message

                        //negative message
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //no need to write anything here
                            }
                        }); //endOf negative btn

                        //show the builder
                        builder.create().show();

                    }//onClick the btnDelete
                });

            }//elseIf alreadyRead


            //dealing with want to read
            else if (parentActivity.equals("wantToRead")){

                //btnDelete is visible
                holder.btnDelete.setVisibility(View.VISIBLE);

                //name of the removed book
                String bookName= bookArrayList.get(position).getName();

                //set onclick listener on the btnDelete
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder= new AlertDialog.Builder(mContext);

                        builder.setMessage("Are you sure to delete "+ bookName+" ?");

                        //yes
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override //clicks yes
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (Utils.getInstance(mContext).removeFrom_WantToRead( bookArrayList.get(position) ) ){

                                    Toast.makeText(mContext, bookName+" removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } //if removed

                                else {
                                    Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }); //set positive btn

                        //no
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //no changes to the app
                            }
                        });

                        //create
                        builder.create().show();
                    }
                }); //onclick the btnDelte



            }//endOf wantToRead


            //dealing with currently read
            else if (parentActivity.equals("currentlyRead")){

                //set visible
                holder.btnDelete.setVisibility(View.VISIBLE);

                //name of the removed book
                String bookName= bookArrayList.get(position).getName();

                //set onclick
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder= new AlertDialog.Builder(mContext);

                        builder.setMessage("Are you sure want to delete "+ bookName+" ?");

                        //yes
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (Utils.getInstance(mContext).removeFrom_CurrentlyRead(bookArrayList.get(position)) ){

                                    Toast.makeText(mContext, bookName+" removed", Toast.LENGTH_SHORT).show();

                                    notifyDataSetChanged();

                                }// if removed
                            }
                        }); //positive btn

                        //no
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //no changes to the app
                            }
                        }); //negative btn

                         //create
                        builder.create().show();

                    }
                }); //onclick the btnDelete

            }//endOf currently read


            //refers to favorite books
            else{

                //set visible
                holder.btnDelete.setVisibility(View.VISIBLE);

                //name of the removed book
                String bookName= bookArrayList.get(position).getName();

                //clicks the btnDelete
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder= new AlertDialog.Builder(mContext);

                        //confirmation message
                        builder.setMessage("Are you sure want to delete "+ bookName+" ?");

                        //yes
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (Utils.getInstance(mContext).removeFrom_FavoriteBook(bookArrayList.get(position) ) ){

                                    Toast.makeText(mContext, bookName+" removed", Toast.LENGTH_SHORT).show();

                                    notifyDataSetChanged();
                                }//if removed
                            }
                        }); //positive btn

                        //no
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //no changes happen
                            }
                        }); //negative message

                        //create
                        builder.create().show();



                }
                });
            } //endOf remove from favourite

        }//if expanded


        else {
            TransitionManager.beginDelayedTransition(holder.library_parent);

            holder.expandedRel_Layout.setVisibility(View.GONE);
            holder.btnDownArrow.setVisibility(View.VISIBLE);
        }


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

        //arrow
        private ImageView btnDownArrow, btnUpArrow;

        //rel layout
        private RelativeLayout expandedRel_Layout;

        //text view
        private TextView txtAuthor, txtShortDesc;

        //delete option
        private TextView btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //init
            library_parent = itemView.findViewById(R.id.library_parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtBookName = itemView.findViewById(R.id.txtBookName);

            btnDownArrow= itemView.findViewById(R.id.btnDownArrow);
            btnUpArrow= itemView.findViewById(R.id.btnUpArrow);

            expandedRel_Layout = itemView.findViewById(R.id.expandedRel_Layout);
            txtShortDesc= itemView.findViewById(R.id.txtShortDesc);
            txtAuthor= itemView.findViewById(R.id.txtAuthor);

            btnDelete= itemView.findViewById(R.id.btnDelete);

            //onclick listener
            btnDownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book= bookArrayList.get( getAdapterPosition() );
                    book.setExpanded(!book.isExpanded() );
                    notifyItemChanged( getAdapterPosition() );
                }
            });

            //onclick for btn up
            btnUpArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book= bookArrayList.get( getAdapterPosition() );
                    book.setExpanded(!book.isExpanded() );
                    notifyItemChanged( getAdapterPosition() );
                }
            });

        }
    }




}
