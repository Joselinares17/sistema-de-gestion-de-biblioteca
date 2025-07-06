package service;

import entity.Book;
import exception.LibraryException;
import repository.BookRepository;

public class LoanManager {
    private final BookRepository repository;

    public LoanManager(BookRepository repository) {
        this.repository = repository;
    }

    public void loanBook(String isbn) {
        Book book = repository.findBookByIsbn(isbn);
        if(!book.isAvailable()) {
            throw new LibraryException("El libro " + book.getTitle() + " no está disponible.");
        }

        book.setAvailable(false);
    }

    public void returnBook(String isbn) {
        Book book = repository.findBookByIsbn(isbn);

        book.setAvailable(true);
    }
}
