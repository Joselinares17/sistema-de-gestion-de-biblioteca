package service.filter;

import entity.Book;

import java.util.List;

public class AuthorBookFilter implements BookFilter {
    private String author;

    public AuthorBookFilter(String author) {
        this.author = author;
    }

    @Override
    public List<Book> filter(List<Book> books) {
        return books.stream()
                .filter(b -> b.getAuthor().equals(this.author))
                .toList();
    }

    @Override
    public Book[] filter(Book[] books) {
        int counter = 0;
        for (Book book : books) {
            if(book.getIsbn().equals(this.author)) {
                counter++;
            }
        }

        Book[] filteredBooks = new Book[counter];
        counter = 0;

        for (Book book : books) {
            if(book.getIsbn().equals(this.author)) {
                filteredBooks[counter++] = book;
            }
        }
        return filteredBooks;
    }
}
