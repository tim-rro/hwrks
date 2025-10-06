package hw.BookCatalog;

public class EBook extends Book{
    private double fileSizeMB;
    private String format;

    public EBook(String author, String title, int year, double fileSizeMB, String format) {
        super(author, title, year);
        this.fileSizeMB=fileSizeMB;
        this.format=format;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Size (MB): " + fileSizeMB + ", File format: " + format;
    }
}
