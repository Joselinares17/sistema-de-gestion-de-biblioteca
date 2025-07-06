package entity;

public abstract class Book implements Validator{
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public Book(String isbn, String title, String author, int publicationYear, boolean available) {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setPublicationYear(publicationYear);
        setAvailable(available);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        validateString(isbn, "isbn");
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateString(title, "título");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        validateString(author, "autor");
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        validateNumber(publicationYear, "año de publicación");
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void validateNumber(int value, String fieldName) {
        if(publicationYear < 0 || publicationYear > 2025) {
            throw new IllegalArgumentException("El campo " + fieldName + " es inválido.");
        }
    }

    @Override
    public String toString() {
        return "isbn: " + this.isbn + ", " +
                "título: " + this.title + ", " +
                "autor: " + this.author + ", " +
                "año de publicación: " + this.publicationYear + ", " +
                "disponible: " + this.available + ", ";
    }
}
