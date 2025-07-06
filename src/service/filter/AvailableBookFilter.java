package service.filter;

import entity.Book;

import java.util.List;

public class AvailableBookFilter implements BookFilter {
    @Override
    public List<Book> filter(List<Book> books) {
        return books.stream()
                .filter(Book::isAvailable)
                .toList();
    }

    @Override
    public Book[] filter(Book[] books) {
        int counter = 0;
        for (Book book : books) {
            if(book.isAvailable()) {
                counter++;
            }
        }

        Book[] filteredBooks = new Book[counter];
        counter = 0;

        for (Book book : books) {
            if(book.isAvailable()) {
                filteredBooks[counter++] = book;
            }
        }
        return filteredBooks;
    }
}
