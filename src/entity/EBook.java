package entity;

public class EBook extends Book{
    private double fileSize;
    private String fileFormat;
    public EBook(String isbn, String title, String author, int publicationYear, double fileSize,
                 String fileFormat) {
        super(isbn, title, author, publicationYear);
        setFileSize(fileSize);
        setFileFormat(fileFormat);
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        validateNumber((int) fileSize, "tamaño de archivo");
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        validateString(fileFormat, "formato de archivo");
        this.fileFormat = fileFormat;
    }

    @Override
    public void validateNumber(int value, String fieldName) {
        if(value < 0) throw new IllegalArgumentException("El campo " + fieldName + " es inválido.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "tamaño del archivo: " + this.fileSize + ", " +
                "formato del archivo: " + this.fileFormat + "\n";
    }
}
