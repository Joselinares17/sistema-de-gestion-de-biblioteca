package repository;

import entity.Book;
import exception.LibraryException;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBookRepository implements BookRepository {
    private static List<Book> books;

    public ArrayListBookRepository() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        if(isBookExists(book.getIsbn())) {
            throw new LibraryException("El libro ya existe.");
        }

        books.add(book);
    }

    @Override
    public void removeBook(String isbn) {
        if(!isBookExists(isbn)) {
            throw new LibraryException("El libro no existe.");
        }

        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new LibraryException("No se encontró ningún libro con el isbn: " + isbn));
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    private static boolean isBookExists(String isbn) {
        return books.stream().anyMatch(b -> b.getIsbn().equals(isbn));
    }
}
