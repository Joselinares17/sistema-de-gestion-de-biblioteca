package service.filter;

import entity.Book;

import java.util.List;

public class IsbnBookFilter implements BookFilter {
    private String isbn;

    public IsbnBookFilter(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public List<Book> filter(List<Book> books) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(this.isbn))
                .toList();
    }

    @Override
    public Book[] filter(Book[] books) {
        int counter = 0;
        for (Book book : books) {
            if(book.getIsbn().equals(this.isbn)) {
                counter++;
            }
        }

        Book[] filteredBooks = new Book[counter];
        counter = 0;

        for (Book book : books) {
            if(book.getIsbn().equals(this.isbn)) {
                filteredBooks[counter++] = book;
            }
        }
        return filteredBooks;
    }
}
