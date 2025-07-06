package service;

import entity.Book;
import exception.LibraryException;
import service.filter.BookFilter;
import repository.BookRepository;

import java.util.List;

public class LibraryReportGenerator {
    private final BookRepository bookRepository;

    public LibraryReportGenerator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String generateReport() {
        List<Book> books = bookRepository.getAllBooks();
        if (books.isEmpty()) {
            throw new LibraryException("No hay libros para generar el reporte.");
        }

        StringBuilder report = new StringBuilder("=== Reporte de Librería ===\n");

        for (Book book : books) {
            report.append(String.format(
                    "%s (%d) por %s [ISBN: %s] - %s\n",
                    book.getTitle(),
                    book.getPublicationYear(),
                    book.getAuthor(),
                    book.getIsbn(),
                    book.isAvailable() ? "Disponible" : "Prestado"
            ));
        }

        report.append("Total: ").append(books.size())
                .append(books.size() == 1 ? " libro\n" : " libros\n");

        return report.toString();
    }

    public String generateFilteredReport(BookFilter filter) {
        List<Book> allBooks = bookRepository.getAllBooks();
        List<? extends Book> filtered = filter.filter(allBooks);

        if (filtered.isEmpty()) {
            return "No hay libros que coincidan con el filtro: " + filter.getClass().getSimpleName();
        }

        StringBuilder report = new StringBuilder("=== Reporte Filtrado (")
                .append(filter.getClass().getSimpleName()).append(") ===\n");

        for (Book book : filtered) {
            report.append(String.format(
                    "%s (%d) por %s [ISBN: %s] - %s\n",
                    book.getTitle(),
                    book.getPublicationYear(),
                    book.getAuthor(),
                    book.getIsbn(),
                    book.isAvailable() ? "Disponible" : "Prestado"
            ));
        }

        report.append("Total: ").append(filtered.size())
                .append(filtered.size() == 1 ? " libro\n" : " libros\n");

        return report.toString();
    }
}
