package service.filter;

import entity.Book;

import java.util.List;

public interface BookFilter {
    List<Book> filter(List<Book> books);
    Book[] filter(Book[] books);
}
