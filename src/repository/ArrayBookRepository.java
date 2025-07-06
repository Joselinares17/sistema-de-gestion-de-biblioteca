package repository;

import entity.Book;
import exception.LibraryException;

import java.util.ArrayList;
import java.util.List;

public class ArrayBookRepository implements BookRepository{
    private static Book[] books;
    private static int count;
    private static final int SIZE = 10;

    public ArrayBookRepository() {
        books = new Book[SIZE];
        count = 0;
    }

    @Override
    public void addBook(Book book) {
        if(count == SIZE) {
            throw new LibraryException("La capacidad del arreglo está llena");
        }
        if(isBookExists(book.getIsbn())) {
            throw new LibraryException("El libro ya existe.");
        }

        books[count++] = book;
    }

    @Override
    public void removeBook(String isbn) {
        if(count == 0) {
            throw new LibraryException("El arreglo está vacio.");
        }
        if (!isBookExists(isbn)) {
            throw new LibraryException("El libro no existe.");
        }

        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[count - 1] = null;
                count--;
                break;
            }
        }
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        if(count == 0) {
            throw new LibraryException("El arreglo está vacio.");
        }
        if (!isBookExists(isbn)) {
            throw new LibraryException("El libro no existe.");
        }

        for(Book book : books) {
            if(book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(books[i]);
        }
        return result;
    }

    private static boolean isBookExists(String isbn) {
        for (Book book : books) {
            if (book != null && isbn.equals(book.getIsbn())) {
                return true;
            }
        }
        return false;
    }
}
