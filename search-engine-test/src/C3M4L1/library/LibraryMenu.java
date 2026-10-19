package C3M4L1.library;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // TODO - missing code
            System.out.println("Library Menu");
            System.out.println("1. View All Books");
            System.out.println("2. Sort Books By Title");
            System.out.println("3. Sort Books By Author");
            System.out.println("4. Sort Books By Year");
            System.out.println("5. Search for a Book by keyword");
            System.out.println("6. Exit");
            String keyword = scanner.nextLine();

            switch (keyword) {
                case "1":
                    library.viewAllBooks();
                    break;
                case "2":
                    SortUtil.bubbleSort(library.getBooks(),Comparator.comparing(Book::getTitle));
                    library.viewAllBooks();
                    break;
                case "3":
                    SortUtil.insertionSort(library.getBooks(),Comparator.comparing(Book::getAuthor));
                    library.viewAllBooks();
                    break;
                case "4":
                    SortUtil.quickSort(library.getBooks(),Comparator.comparing(Book::getAuthor),0,library.getBooks().size()-1);
                    library.viewAllBooks();
                    break;
                case "5":
                    System.out.println("Input word for a search");
                    String search = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(search);
                    System.out.println(foundBook.toString());
                    break;
                case "6":
                    return;
            }
            System.out.println("Invalid input");
        }
    }

}
