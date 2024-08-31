
import java.util.HashMap;

public class Book {

    private final byte ID;
    private String _title;
    private float _price;
    private BookStatus _status;

    private static HashMap<Byte, Book> _books = new HashMap<>();
    private static byte _count;

    public byte getID() {
        return ID;
    }

    public Book() {
        this.ID = 0;

    }

    public Book(String title, float price) {
        _count++;
        this.ID = _count;
        this._title = title;
        this._price = price;
        this._status = BookStatus.IsExist;

    }

    public static Book createBook() {
        System.out.println("Enter Title of book");
        String title = System.console().readLine();
        System.out.println("Enter Price of Book");
        float price = Float.parseFloat(System.console().readLine());
        return new Book(title, price);
    }

    public static void addBookById(Byte id, Book book) {
        _books.put(id, book);
    }

    public void readBookById() {
        System.out.println("Enter Id of Book: ");
        byte bookId = Byte.parseByte(System.console().readLine());

        Book book = _books.get(bookId);
        if (book != null) {
            System.out.println("Title Book :" + book._title);
            System.out.println("Price Book :" + book._price);
            System.err.println("Status Book :" + book._status);
        } else {
            System.out.println("Not Found");
        }

    }

    public static Book setBookById(byte bookId) {

        Book book = _books.get(bookId);

        return book;

    }

    public static boolean checkExist(byte bookId) {
        Book book = _books.get(bookId);
        if (book != null) {
            if (book._status == BookStatus.IsExist) {
                book._status = BookStatus.Loaned;
                System.out.println("Done :)");
                return true;
            } else {
                System.err.println("Book Loaned Before");
                return false;

            }
        } else {
            System.out.println("There is no book!!!");
            return false;
        }
    }

    public static boolean checkNotExist(byte bookId) {
        Book book = _books.get(bookId);
        if (book != null) {
            if (book._status == BookStatus.Loaned) {
                book._status = BookStatus.IsExist;
                System.out.println("Done :)");
                return true;
            } else {
                System.err.println("Book is in Library");
                return false;

            }
        } else {
            System.out.println("There is no book!!!");
            return false;
        }
    }

    public void updateBookById() {
        System.out.println("Enter Id of Book: ");
        byte bookId = Byte.parseByte(System.console().readLine());

        Book book = _books.get(bookId);
        if (book != null) {

            // System.out.println("Enter Title Book : ");
            // book._title = System.console().readLine();
            System.out.println("Enter Price Book : ");
            book._price = Float.parseFloat(System.console().readLine());
        } else {
            System.out.println("Not Found");
        }
    }

    public void removeBookById() {
        System.out.println("Enter Id of Book: ");
        byte bookId = Byte.parseByte(System.console().readLine());
        boolean IsExist = false;
        IsExist = _books.containsKey(bookId);
        if (IsExist) {
            _books.remove(bookId);
        } else {
            System.out.println("Not Found");
        }
    }

    public boolean isExist() {
        return this._status == BookStatus.IsExist;
    }

    public void toLoaning() {
        this._status = BookStatus.Loaned;
        System.out.println("Book Loaned");
    }
}
