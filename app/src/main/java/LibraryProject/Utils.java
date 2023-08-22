package LibraryProject;

//quite similar to database
//create singleton

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    //arrayList
    private static ArrayList<Book> allBooks_List;
    private static ArrayList<Book> alreadyRead_Books_List;
    private static ArrayList<Book> wantToReadBooks_List;
    private static ArrayList<Book> currentlyReadingBooks_List;
    private static ArrayList<Book> favoriteBooks_List;

    private Utils() { //constructor

        //all books
        if (allBooks_List == null){
            allBooks_List= new ArrayList<>();

            init_BookData();
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
        allBooks_List.add(
                new Book(1, "Lengloi", "Maria", 500,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2016/20161336/Thumbnails/Cover.jpg",
                        "A horror book", "Long Desc") );

        allBooks_List.add(
                new Book(2, "Town Mall", "Hasrudi Jawawi", 800,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2017/20170310072714/Thumbnails/Cover.jpg",
                        "The mall is haunted", "this book is not very scary")   );

        allBooks_List.add(
                new Book(3, "Barongan", "Naim Tamdjis", 400,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2021/2021018/Thumbnails/Cover.jpg",
                        "The mask is haunted", "LOve this book")  );

        allBooks_List.add(
                new Book(4, "Kakak Kemboja", "Naim Tamdjis", 330,
                        "https://cdn-shop.ookbee.com/Books/KarangBooks/2017/20170331025438/Thumbnails/Cover.jpg",
                        "A mysterious companion", "Story line is well written")   );
    }


    //get instance
    public static Utils getInstance() {

        if (instance!= null){
            return instance;
        }

        else {
            instance = new Utils();
            return instance;
        }
    }

    //getters
    public static ArrayList<Book> getAllBooks_List() {
        return allBooks_List;
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
}
