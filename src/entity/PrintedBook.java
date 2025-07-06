package entity;

public class PrintedBook extends Book {
    private String coverType;
    private boolean isColored;
    public PrintedBook(String isbn, String title, String author, int publicationYear, boolean available,
                       String coverType, boolean isColored) {
        super(isbn, title, author, publicationYear, available);
        setCoverType(coverType);
        setColored(isColored);
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        validateString(coverType, "tipo de tapa");
        this.coverType = coverType;
    }

    public boolean isColored() {
        return isColored;
    }

    public void setColored(boolean colored) {
        isColored = colored;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tipo de tapa: " + this.coverType + ", " +
                "coloreado: " + this.isColored + "\n";
    }
}
