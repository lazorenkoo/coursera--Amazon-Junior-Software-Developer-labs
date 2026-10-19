package C3M4L1.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
            String[] words = line.split(",");
            Book bookCur = new Book(words[0],words[1],Integer.valueOf(words[2]));
            books.add(bookCur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {
        // TODO missing code
        keyword = keyword.toLowerCase();
        for (Book book : books) {
            if(book.getTitle().toLowerCase().contains(keyword)) {
                return book;
            }
            if(book.getAuthor().toLowerCase().contains(keyword)) {
                return book;
            }
            if(book.getPublicationYear()==Integer.parseInt(keyword)) {
                return book;
            }
        }
        return null;
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
