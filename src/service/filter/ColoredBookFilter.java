package service.filter;

import entity.Book;
import entity.PrintedBook;

import java.util.List;

public class ColoredBookFilter implements BookFilter{
    @Override
    public List<PrintedBook> filter(List<Book> books) {
        return books.stream()
                .filter(b -> b instanceof PrintedBook)
                .map(PrintedBook.class::cast)
                .filter(PrintedBook::isColored)
                .toList();
    }

    @Override
    public Book[] filter(Book[] books) {
        int count = 0;
        for (Book b : books) {
            if (b instanceof PrintedBook) {
                PrintedBook pb = (PrintedBook) b;
                if (pb.isColored()) {
                    count++;
                }
            }
        }

        PrintedBook[] filteredBooks = new PrintedBook[count];
        count = 0;

        for (Book b : books) {
            if (b instanceof PrintedBook) {
                PrintedBook pb = (PrintedBook) b;
                if (pb.isColored()) {
                    filteredBooks[count++] = pb;
                }
            }
        }

        return filteredBooks;
    }
}
