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
    private static final String ALREADY_READ_BOOKS_KEY="already_read_books";
    private static final String WANT_TO_READ_BOOKS_KEY="want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS_KEY="currently_reading_books";
    private static final String FAVORITE_BOOKS_KEY="favorite_books";


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

        //editor
        SharedPreferences.Editor editor= sharedPreferences.edit();

        //gson
        Gson gson= new Gson();

        //already read
        if (getAlreadyRead_Books_List() == null){

            editor.putString(ALREADY_READ_BOOKS_KEY,
                    gson.toJson( new ArrayList<Book>()  )   );

            editor.commit();

        }

        //want to read
        if (getWantToReadBooks_List() == null){

            editor.putString(WANT_TO_READ_BOOKS_KEY,
                    gson.toJson( new ArrayList<Book>()));

            editor.commit();
        }

        //currently reading
        if (getCurrentlyReadingBooks_List() == null){

            editor.putString(CURRENTLY_READING_BOOKS_KEY,
                    gson.toJson( new ArrayList<Book>()));

            editor.commit();

        }

        //favorite book
        if (getFavoriteBooks_List()== null){
            editor.putString(FAVORITE_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));

            editor.commit();
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

    public ArrayList<Book> getAlreadyRead_Books_List() {

        Gson gson= new Gson();

        Type type= new TypeToken<ArrayList<Book>>(){}.getType();

        ArrayList<Book> books= gson.fromJson(sharedPreferences
                .getString(ALREADY_READ_BOOKS_KEY, null), //null is default value
                type);

        return books;
    }

    public ArrayList<Book> getWantToReadBooks_List() {

        Gson gson= new Gson();

        Type type= new TypeToken< ArrayList<Book>>(){}.getType();

        ArrayList<Book> books= gson.fromJson(sharedPreferences
                .getString(WANT_TO_READ_BOOKS_KEY, null),
                type);

        return books;
    }

    public ArrayList<Book> getCurrentlyReadingBooks_List() {

        Gson gson= new Gson();

        Type type= new TypeToken< ArrayList<Book>>(){}.getType();

        ArrayList<Book> books= gson.fromJson(sharedPreferences
                .getString(CURRENTLY_READING_BOOKS_KEY , null),
                type);

        return books;
    }

    public  ArrayList<Book> getFavoriteBooks_List() {

        Gson gson= new Gson();

        Type type= new TypeToken< ArrayList<Book>>(){}.getType();

        ArrayList<Book> books= gson.fromJson(sharedPreferences
                .getString(FAVORITE_BOOKS_KEY, null),
                type);

        return books ;
    }

    //get book from shared preferences by id
    public Book getBookById(int id){

        ArrayList<Book> books_from_sharedPreferences= getAllBooks_List();

        if (books_from_sharedPreferences != null){

            for (Book book: books_from_sharedPreferences){
                if (book.getId()== id){
                    return book;
                }
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

        ArrayList<Book> alreadyReadBooks_List= getAlreadyRead_Books_List();

        if (alreadyReadBooks_List!= null){

            if (alreadyReadBooks_List.add(book)){ //add to the array list

                Gson gson= new Gson();

                SharedPreferences.Editor editor= sharedPreferences.edit();

                //removes the old entry for the already read books from shared preferences.
                editor.remove(ALREADY_READ_BOOKS_KEY);

                //adds the updated list of already read books as a JSON string to the shared preferences.
                editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(alreadyReadBooks_List));

                //This commits the changes made to the shared preferences.
                editor.commit();

                return true;
            }
        }

        return false;
    }


    //add to the want to read list
    public boolean addTo_WantToRead(Book book){

        ArrayList<Book> wantToReadBooks_List= getWantToReadBooks_List();

        if (wantToReadBooks_List!= null){

            if (wantToReadBooks_List.add(book)){

                Gson gson= new Gson();

                SharedPreferences.Editor editor= sharedPreferences.edit();

                //remove old entry
                editor.remove(WANT_TO_READ_BOOKS_KEY);

                //update entry
                editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(wantToReadBooks_List));

                editor.commit();

                return true;
            }
        }
        return false;
    }

    //add to the currently read list
    public boolean addTo_CurrentlyRead(Book book){

        ArrayList<Book> currentlyReadBooks_List= getCurrentlyReadingBooks_List();

        if (currentlyReadBooks_List != null){

            //add to the array list
            if (currentlyReadBooks_List.add(book)){

                Gson gson= new Gson();

                SharedPreferences.Editor editor= sharedPreferences.edit();

                editor.remove(CURRENTLY_READING_BOOKS_KEY);

                editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(currentlyReadBooks_List));

                return true;
            }
        }

        return false;
    }

    //add to the favorite list
    public boolean addTo_Favorite(Book book){

        ArrayList<Book> favoriteBooks_List= getFavoriteBooks_List();

        if (favoriteBooks_List!= null){

            //add to the array list
            if (favoriteBooks_List.add(book)){

                Gson gson= new Gson();

                SharedPreferences.Editor editor= sharedPreferences.edit();

                editor.remove(FAVORITE_BOOKS_KEY);

                editor.putString(FAVORITE_BOOKS_KEY, gson.toJson(favoriteBooks_List));

                return true;
            }
        }
        return false;
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
