package service;

import service.filter.BookFilter;
import repository.BookRepository;

public class LibraryGeneratorReport {
    private final BookRepository repository;

    public LibraryGeneratorReport(BookRepository repository) {
        this.repository = repository;
    }

    public String generateReport() {
        return null;
    }

    public String generateFilteredReport(BookFilter filter) {
        return null;
    }
}
