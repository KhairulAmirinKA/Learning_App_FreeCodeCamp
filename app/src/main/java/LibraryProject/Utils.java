package LibraryProject;

//quite similar to database
//create singleton

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    //const
    private static final String ALL_BOOKS_KEY= "all_books";

    private static Utils instance;
    
    //sharedPreferences
    private SharedPreferences sharedPreferences;

    //arrayList
    private static ArrayList<Book> allBooks_List;
    private static ArrayList<Book> alreadyRead_Books_List;
    private static ArrayList<Book> wantToReadBooks_List;
    private static ArrayList<Book> currentlyReadingBooks_List;
    private static ArrayList<Book> favoriteBooks_List;

    private Utils(Context context) { //constructor
        
        sharedPreferences= context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        //all books
        if (getAllBooks_List() == null){

            init_BookData(); //init if the data is null
        }

        //already read
        if (alreadyRead_Books_List == null){
            alreadyRead_Books_List= new ArrayList<>();
        }

        //want to read
        if (wantToReadBooks_List == null){
            wantToReadBooks_List= new ArrayList<>();
        }

        //currently reading
        if (currentlyReadingBooks_List == null){
            currentlyReadingBooks_List= new ArrayList<>();
        }

        //favorite book
        if (favoriteBooks_List== null){
            favoriteBooks_List= new ArrayList<>();
        }
    }

    //set data
    private void init_BookData() {

        //TODO: add initial data
        
        ArrayList<Book> books= new ArrayList<>();
        
        books.add(
                new Book(1, "Lengloi", "Maria", 500,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2016/20161336/Thumbnails/Cover.jpg",
                        "A horror book", "Long Desc") );

        books.add(
                new Book(2, "Town Mall", "Hasrudi Jawawi", 800,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2017/20170310072714/Thumbnails/Cover.jpg",
                        "The mall is haunted", "this book is not very scary")   );

        books.add(
                new Book(3, "Barongan", "Naim Tamdjis", 400,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2021/2021018/Thumbnails/Cover.jpg",
                        "The mask is haunted", "LOve this book")  );

        books.add(
                new Book(4, "Kakak Kemboja", "Naim Tamdjis", 330,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2017/20170331025438/Thumbnails/Cover.jpg",
                        "A mysterious companion", "Story line is well written")   );

        //editor
        SharedPreferences.Editor editor= sharedPreferences.edit();

        //gson
        Gson gson= new Gson();

        editor.putString(ALL_BOOKS_KEY, gson.toJson(books)  );

        editor.commit();


    }


    //get instance
    public static Utils getInstance(Context context) {

        if (instance!= null){
            return instance;
        }

        else {
            instance = new Utils(context);
            return instance;
        }
    }

    //getters
    public ArrayList<Book> getAllBooks_List() {

        Gson gson= new Gson();

        Type type = new TypeToken< ArrayList<Book>>(){}.getType();

        ArrayList<Book> books= gson.fromJson(sharedPreferences
                .getString(ALL_BOOKS_KEY, null),
                type);

        return books;
    }

    public static ArrayList<Book> getAlreadyRead_Books_List() {
        return alreadyRead_Books_List;
    }

    public static ArrayList<Book> getWantToReadBooks_List() {
        return wantToReadBooks_List;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks_List() {
        return currentlyReadingBooks_List;
    }

    public static ArrayList<Book> getFavoriteBooks_List() {
        return favoriteBooks_List;
    }

    //get book by id
    public Book getBookById(int id){

        for (Book book: allBooks_List){
            if (book.getId()== id){
                return book;
            }
        }

        return null;
    }

    /**
     * add book to the list
     * @param book
     * @return
     */
    //add to the already read list
    public boolean addTo_AlreadyRead(Book book){
        return alreadyRead_Books_List.add(book);
    }


    //add to the want to read list
    public boolean addTo_WantToRead(Book book){
        return wantToReadBooks_List.add(book);
    }

    //add to the currently read list
    public boolean addTo_CurrentlyRead(Book book){
        return currentlyReadingBooks_List.add(book);
    }

    //add to the favorite list
    public boolean addTo_Favorite(Book book){
        return favoriteBooks_List.add(book);
    }

    /**
     * Remove book from list
     */
    //remove from alreadyRead
    public boolean removeFrom_AlreadyRead(Book book){
        return alreadyRead_Books_List.remove(book);
    }

    //remove from want to read
    public boolean removeFrom_WantToRead(Book book){
        return wantToReadBooks_List.remove(book);
    }

    //remove from currently read
    public boolean removeFrom_CurrentlyRead(Book book){
        return currentlyReadingBooks_List.remove(book);
    }

    //remove from favorite book
    public boolean removeFrom_FavoriteBook(Book book){
        return favoriteBooks_List.remove(book);
    }


}
